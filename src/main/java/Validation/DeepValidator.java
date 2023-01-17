package Validation;

import org.antlr.runtime.tree.Tree;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class DeepValidator extends Validator {

    protected HashMap<String, Function> functions;

    @Override
    public void validate(Tree tree, HashMap<String, Function> functions) throws Exception {
        this.functions = functions;

        this.validateAllTree(tree);
        this.endValidation();
    }

    protected void endValidation() {};

    protected void validateAllTree(Tree tree) {
        for (int i = 0; i < tree.getChildCount(); i++) {
            String functionName = tree.getChild(i).getChild(0).getText();
            Function function = this.functions.get(functionName);
            this.validateFUNCTION(tree.getChild(i), function);
        }

        for (int i = 0; i < tree.getChildCount(); i++) {
            String functionName = tree.getChild(i).getChild(0).getText();
            this.validateFunction(tree.getChild(i).getChild(0).getChild(0), this.functions.get(functionName));
            this.endValidationFunction(tree.getChild(i).getChild(0).getChild(0), this.functions.get(functionName));
        }
    }

    protected abstract void validateFUNCTION(Tree tree, Function function);

    protected void endValidationFunction(Tree tree, Function function){}

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