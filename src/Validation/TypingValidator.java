package Validation;

import org.antlr.runtime.tree.Tree;

public class TypingValidator extends DeepValidator{
    private boolean debug = false;

    @Override
    protected void endValidation() {
        if(debug){
            for (Function function : this.functions.values()) {
                System.out.println(function.functionName + " : ");
                System.out.println("\tArguments : ");
                for (String arg : function.args.keySet()) {
                    System.out.println("\t\t" + arg + " : " + function.args.get(arg));
                }
                System.out.println("\tReturn values : ");
                for (String arg : function.returnType.keySet()) {
                    System.out.println("\t\t" + arg + " : " + function.returnType.get(arg));
                }
            }
        }
    }

    @Override
    protected void validateFUNCTION(Tree tree, Function function) {

    }

    @Override
    protected void validateASSIGN(Tree tree, Function function) {
        if(tree.getChild(1).getChildCount() == 1 && tree.getChild(1).getChild(0).getChild(0).getText().equals("FUNCTIONCALL")){
            Function f = this.functions.get(tree.getChild(1).getChild(0).getChild(0).getChild(0).getText());
            if(f != null) {
                int nbArgs = f.returnType.size();
                if (nbArgs != tree.getChild(0).getChildCount()) {
                    this.printError("The number of variable(s) is not equals to the number of value(s) that the function called returns. " +
                            "Function " + f.functionName + " returns " + nbArgs + " value(s), but " + tree.getChild(0).getChildCount() + " variable(s) are given.",
                            tree.getChild(1).getChild(0).getChild(0).getChild(0));
                }
            }
            return;
        }

        if(tree.getChild(0).getChildCount() != tree.getChild(1).getChildCount()){
            this.printError("The number of variables is not equals to the number of expressions in the assign statement.", tree);
        }
    }

    @Override
    protected void validateIF(Tree tree, Function function) {
        checkBooleanExpression(tree.getChild(0));
    }

    @Override
    protected void validateFOR(Tree tree, Function function) {
        checkIntExpression(tree.getChild(0));
    }

    @Override
    protected void validateFOREACH(Tree tree, Function function) {

    }

    @Override
    protected void validateWHILE(Tree tree, Function function) {
        checkBooleanExpression(tree.getChild(0));
    }

    private void checkBooleanExpression(Tree tree){
        if(tree.getChildCount() == 0) return;
        if(tree.getChild(0).getText().equals("FUNCTIONCALL")){
            String functionName = tree.getChild(0).getChild(0).getText();
            Function f = functions.get(functionName);
            if(f == null) return;
            if(f.returnType.size() != 1) {
                this.printError("Expected boolean expression. Got function call with multiple return values.", tree);
            }
        }
    }
    private void checkIntExpression(Tree tree){
        if(tree.getChildCount() == 0) return;
        if(tree.getChild(0).getText().equals("FUNCTIONCALL")){
            String functionName = tree.getChild(0).getChild(0).getText();
            Function f = functions.get(functionName);
            if(f == null) return;
            if(f.returnType.size() != 1) {
                this.printError("Expected integer value. Got function call with multiple return values.", tree);
            }
        }
    }

}
