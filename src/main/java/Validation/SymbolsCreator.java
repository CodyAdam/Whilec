package Validation;

import org.antlr.runtime.tree.Tree;

import java.util.HashMap;

public class SymbolsCreator extends DeepValidator{
    @Override
    protected void validateFUNCTION(Tree tree, Function function) {
        String functionName = tree.getChild(0).getText();
        Function functionCreated = new Function(functionName);
        this.functions.put(functionName, functionCreated);
        functionCreated.outputInd = this.parseFunctionDefinition(tree.getChild(0).getChild(0), functionCreated);
    }

    protected int parseFunctionDefinition(Tree tree, Function function) {
        int outputInd = 1;

        // INPUTS
        if(tree.getChild(0).getText().equals("INPUT")) {
            for (int i = 0; i < tree.getChild(0).getChildCount(); i++) {
                function.args.put(tree.getChild(0).getChild(i).getText(), null);
                function.inputOrder.add(tree.getChild(0).getChild(i).getText());
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

    @Override
    protected void validateASSIGN(Tree tree, Function function) {

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

    @Override
    protected void validateIF(Tree tree, Function function) {

    }

    @Override
    protected void validateFOR(Tree tree, Function function) {

    }

    @Override
    protected void validateWHILE(Tree tree, Function function) {

    }

    @Override
    protected void validateFOREACH(Tree tree, Function function) {

    }

    public HashMap<String, Function> getFunctionsSymbols(Tree tree) throws Exception {
        if(this.functions == null || this.functions.keySet().size() == 0) this.validate(tree, new HashMap<>());
        return this.functions;
    }
}
