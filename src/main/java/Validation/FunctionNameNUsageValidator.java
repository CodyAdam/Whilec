package Validation;

import java.util.HashMap;
import java.util.Stack;

import org.antlr.runtime.tree.Tree;

public class FunctionNameNUsageValidator extends DeepValidator {

    HashMap<String, FunctionUsage> functionUsages = new HashMap<>();

    @Override
    protected void validateFUNCTION(Tree tree, Function function) {
        Tree lineNode = tree.getChild(0).getChild(0);
        if(functionUsages.containsKey(function.functionName)) {
            this.printError("Duplicate function name " + function.functionName + ".", lineNode.getChild(0));
        } else {
            this.functionUsages.put(function.functionName, new FunctionUsage());
        }
    }

    @Override
    protected void endValidationFunction(Tree tree, Function function) {
        if(!functionUsages.containsKey("main")) {
            this.printError("No main in the program", tree.getChild(0));
        }
    }

    private void checkExpressionFunctionUsage(Tree tree, Function function) {
        Stack<Tree> stack = new Stack<>();
        stack.push(tree);
        while(!stack.empty()){
            Tree node = stack.pop();
            if(node.getText().equals("FUNCTIONCALL")) {
                if(!this.functions.containsKey(node.getChild(0).getText())) {
                    System.out.println(node);
                    this.printError("No function called " + node.getChild(0).getText() + ".", node.getChild(0));
                }
                if(this.functions.get(node.getChild(0).getText()).inputOrder.size() != node.getChild(0).getChildCount()) {
                    this.printError("Bad number of input arguments.", node.getChild(0));
                    System.out.println(this.functions.get(node.getChild(0).getText()).inputOrder.size());
                    System.out.println(node.getChildCount());
                    System.out.println(node);
                }
            } else {
                for (int i = 0; i < node.getChildCount(); i++) {
                    stack.push(node.getChild(i));
                }
            }
        }
    }

    @Override
    protected void validateASSIGN(Tree tree, Function function) {
        for (int i = 0; i < tree.getChild(1).getChildCount(); i++) {
            this.checkExpressionFunctionUsage(tree.getChild(1).getChild(i), function);
        }
    }

    @Override
    protected void validateIF(Tree tree, Function function) {
        this.checkExpressionFunctionUsage(tree.getChild(0), function);
    }

    @Override
    protected void validateFOR(Tree tree, Function function) {
        this.checkExpressionFunctionUsage(tree.getChild(0), function);
    }

    @Override
    protected void validateWHILE(Tree tree, Function function) {
        this.checkExpressionFunctionUsage(tree.getChild(0), function);
    }

    @Override
    protected void validateFOREACH(Tree tree, Function function) {
        this.functionUsages.get(function.functionName).functionUsageCall.put(tree.getChild(0).getText(), tree.getChild(0));
        this.checkExpressionFunctionUsage(tree.getChild(1), function);
    }

    class FunctionUsage {
        public HashMap<String, Tree> functionUsageCall;

        public FunctionUsage() {
            this.functionUsageCall = new HashMap<>();
        }
    }

}
