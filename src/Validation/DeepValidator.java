package Validation;

import org.antlr.runtime.tree.Tree;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class DeepValidator extends Validator {

    protected HashMap<String, Function> functions;

    @Override
    public void validate(Tree tree) throws Exception {
        this.functions = new HashMap<String, Function>();

        this.validateAllTree(tree);
        this.endValidation();
    }

    protected void endValidation() {};

    protected void validateAllTree(Tree tree) {
        for (int i = 0; i < tree.getChildCount(); i++) {
            String functionName = tree.getChild(i).getChild(0).getText();
            Function function = new Function(functionName);
            this.functions.put(functionName, function);
            function.outputInd = this.parseFunctionDefinition(tree.getChild(i).getChild(0).getChild(0), function);
        }

        for (int i = 0; i < tree.getChildCount(); i++) {
            String functionName = tree.getChild(i).getChild(0).getText();
            this.validateFunction(tree.getChild(i).getChild(0).getChild(0), functions.get(functionName));
        }
    }

    protected int parseFunctionDefinition(Tree tree, Function function) {
        int outputInd = 1;

        // INPUTS
        if(tree.getChild(0).getText().equals("INPUT")) {
            for (int i = 0; i < tree.getChild(0).getChildCount(); i++) {
                function.args.put(tree.getChild(0).getChild(i).getText(), null);
            }
            outputInd = 2;
        }

        // OUTPUTS
        for (int i = 0; i < tree.getChild(outputInd).getChildCount(); i++) {
            function.returnType.put(tree.getChild(outputInd).getChild(i).getText(), null);
            function.outputOrder.add(tree.getChild(outputInd).getChild(i).getText());
        }

        return outputInd;
    }

    protected void validateFunction(Tree tree, Function function){
        // COMMANDS
        for(int i = 0; i < tree.getChild(function.outputInd-1).getChildCount(); i++) {
            this.validateCommand(tree.getChild(function.outputInd-1).getChild(i), function);
        }
    }

    protected void validateCommand(Tree tree, Function function){
        if(tree.getChildCount() == 0) return;

        switch (tree.getText()) {
            case "IF":
                this.vIF(tree, function);
                break;
            case "FOR":
                this.vFOR(tree, function);
                break;
            case "WHILE":
                this.vWHILE(tree, function);
                break;
            case "ASSIGN":
                this.vASSIGN(tree, function);
                break;
            case "FOREACH":
                this.vFOREACH(tree, function);
                break;
        }
    }

    private void vASSIGN(Tree tree, Function function){
        if(tree.getChildCount() != 2) return;
        this.validateASSIGN(tree, function);

        if (tree.getChild(0).getChildCount() >= 1 && tree.getChild(1).getChildCount() == 1 && tree.getChild(1).getChild(0).getChild(0).getText().equals("FUNCTIONCALL")) {
            String functionName = tree.getChild(1).getChild(0).getChild(0).getChild(0).getText();
            for (int i = 0; i < tree.getChild(0).getChildCount(); i++) {
                VariableBinding variableBinding = new VariableBinding(tree.getChild(1).getChild(0).getChild(0));
                if(functions.containsKey(functionName)){
                    if(functions.get(functionName).outputOrder.size() <= i) variableBinding.functionCallVar = functions.get(functionName).outputOrder.get(i);
                }
                if(function.returnType.containsKey(tree.getChild(0).getChild(i).getText())) function.returnType.put(tree.getChild(0).getChild(i).getText(), variableBinding);
                else function.context.variables.put(tree.getChild(0).getChild(i).getText(), variableBinding);
            }
            return;
        }

        for (int i = 0; i < tree.getChild(0).getChildCount(); i++) {
            VariableBinding variableBinding;
            if(i >= tree.getChild(1).getChildCount()) variableBinding = new VariableBinding(null);
            else {
                variableBinding = new VariableBinding(tree.getChild(1).getChild(i));
                if (variableBinding.value.getText().equals("FUNCTIONCALL") && functions.containsKey(variableBinding.value.getChild(0).getText())) {
                    variableBinding.functionCallVar = functions.get(variableBinding.value.getChild(0).getText()).outputOrder.get(0);
                }
            }
            if(function.returnType.containsKey(tree.getChild(0).getChild(i).getText())) function.returnType.put(tree.getChild(0).getChild(i).getText(), variableBinding);
            else function.context.variables.put(tree.getChild(0).getChild(i).getText(), variableBinding);
        }
    }

    protected abstract void validateASSIGN(Tree tree, Function function);

    private void vIF(Tree tree, Function function){
        if(tree.getChildCount() == 0) return;

        for (int i = 0; i < tree.getChild(1).getChildCount(); i++) {
            this.validateCommand(tree.getChild(1).getChild(i), function);
        }
        if(tree.getChildCount() == 3) {
            for (int i = 0; i < tree.getChild(2).getChildCount(); i++) {
                this.validateCommand(tree.getChild(2).getChild(i), function);
            }
        }

        this.validateIF(tree, function);
    }

    protected abstract void validateIF(Tree tree, Function function);

    private void vFOR(Tree tree, Function function){
        if(tree.getChildCount() == 0) return;

        for (int i = 0; i < tree.getChild(1).getChildCount(); i++) {
            this.validateCommand(tree.getChild(1).getChild(i), function);
        }

        this.validateFOR(tree, function);
    }

    protected abstract void validateFOR(Tree tree, Function function);

    private void vWHILE(Tree tree, Function function) {
        if(tree.getChildCount() == 0) return;

        for (int i = 0; i < tree.getChild(1).getChildCount(); i++) {
            this.validateCommand(tree.getChild(1).getChild(i), function);
        }

        this.validateWHILE(tree, function);
    }

    protected abstract void validateWHILE(Tree tree, Function function);

    private void vFOREACH(Tree tree, Function function) {
        if(tree.getChildCount() == 0) return;

        for (int i = 0; i < tree.getChild(2).getChildCount(); i++) {
            this.validateCommand(tree.getChild(2).getChild(i), function);
        }

        this.validateFOREACH(tree, function);
    }

    protected abstract void validateFOREACH(Tree tree, Function function);
}



class Context{
    public HashMap<String, VariableBinding> variables;

    public Context() {
        this.variables = new HashMap<>();
    }

    public Context(Context context) {
        this.variables = new HashMap<>(context.variables);
    }
}

class VariableBinding{
    public Tree value;
    public String functionCallVar;

    public VariableBinding(Tree value, String functionCallVar) {
        this.value = value;
        this.functionCallVar = functionCallVar;
    }

    public VariableBinding(Tree value) {
        this.value = value;
        this.functionCallVar = "";
    }
}

class Function{
    public String functionName;
    public HashMap<String, VariableBinding> args;
    public HashMap<String, VariableBinding> returnType;
    public ArrayList<String> outputOrder;
    public Context context;
    public int outputInd;

    public Function(String functionName) {
        this.functionName = functionName;
        this.args = new HashMap<>();
        this.returnType = new HashMap<>();
        this.outputOrder = new ArrayList<>();
        this.context = new Context();
    }
}