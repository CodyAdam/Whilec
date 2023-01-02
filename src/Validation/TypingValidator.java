package Validation;

import org.antlr.runtime.tree.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TypingValidator extends Validator{

    private List<Function> functions;
    private List<FunctionCall> functionCalls;

    private boolean debug = false;

    @Override
    public void validate(Tree tree) {
        this.functions = new ArrayList<>();
        this.functionCalls = new ArrayList<>();

        this.validateAllTree(tree);

        if(debug){
            for (Function function : this.functions) {
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

    private void validateAllTree(Tree tree) {
        for (int i = 0; i < tree.getChildCount(); i++) {
            String functionName = tree.getChild(i).getChild(0).getText();
            Function function = new Function(functionName);
            this.functions.add(function);
            this.validateFunction(tree.getChild(i).getChild(0).getChild(0), function);
        }
    }

    private void validateFunction(Tree tree, Function function) {
        if(tree.getChildCount() == 0) return;

        int outputInd = 1;

        // INPUTS
        if(tree.getChild(0).getText().equals("INPUT")) {
            for (int i = 0; i < tree.getChild(0).getChildCount(); i++) {
                function.args.put(tree.getChild(0).getChild(i).getText(), ExpType.UNKNOWN);
            }
            outputInd = 2;
        }

        // OUTPUTS
        for (int i = 0; i < tree.getChild(outputInd).getChildCount(); i++) {
            function.returnType.put(tree.getChild(outputInd).getChild(i).getText(), ExpType.UNKNOWN);
        }

        // COMMANDS
        for(int i = 0; i < tree.getChild(outputInd-1).getChildCount(); i++) {
            this.validateCommand(tree.getChild(outputInd-1).getChild(i), function);
        }
    }

    private void validateCommand(Tree tree, Function function){
        if(tree.getChildCount() == 0) return;

        switch (tree.getText()) {
            case "IF":
                this.validateIF(tree, function);
                break;
            case "FOR":
                this.validateFOR(tree, function);
                break;
            case "WHILE":
                this.validateWHILE(tree, function);
                break;
            case "ASSIGN":
                this.validateASSIGN(tree, function);
                break;
        }
    }

    private void validateASSIGN(Tree tree, Function function) {
        if(tree.getChildCount() != 2) return;

        if(tree.getChild(0).getChildCount() != tree.getChild(1).getChildCount()){
            VPrinter.getInstance().printError(
                    "The number of variables is not equals to the number of expressions in the assign statement.",
                    this.parent.getFilepath(),
                    tree.getLine(),
                    tree.getCharPositionInLine());
            this.parent.incrementErrorCount();
        }
    }

    private void validateIF(Tree tree, Function function) {
        if(tree.getChildCount() == 0) return;

        for (int i = 0; i < tree.getChild(1).getChildCount(); i++) {
            this.validateCommand(tree.getChild(1).getChild(i), function);
        }
        if(tree.getChildCount() == 3) {
            for (int i = 0; i < tree.getChild(2).getChildCount(); i++) {
                this.validateCommand(tree.getChild(2).getChild(i), function);
            }
        }
    }

    private void validateFOR(Tree tree, Function function) {
        if(tree.getChildCount() == 0) return;

        for (int i = 0; i < tree.getChild(1).getChildCount(); i++) {
            this.validateCommand(tree.getChild(1).getChild(i), function);
        }
    }

    private void validateWHILE(Tree tree, Function function) {
        if(tree.getChildCount() == 0) return;

        for (int i = 0; i < tree.getChild(1).getChildCount(); i++) {
            this.validateCommand(tree.getChild(1).getChild(i), function);
        }
    }

    private boolean validateExpression(Tree tree, ExpType ExpectedType, Function function){
        return true;
    }

}

class FunctionCall{
    public String functionName;
    public ArrayList<ExpType> args;

    public FunctionCall(String functionName) {
        this.functionName = functionName;
        this.args = new ArrayList<>();
    }
}

class Function{
    public String functionName;
    public HashMap<String, ExpType> args;
    public HashMap<String, ExpType> returnType;

    public Function(String functionName) {
        this.functionName = functionName;
        this.args = new HashMap<>();
        this.returnType = new HashMap<>();
    }
}

class Argument{
    public String name;
    public ExpType type;

    public Argument(String name, ExpType type) {
        this.name = name;
        this.type = type;
    }
}

enum ExpType{
    UNKNOWN, ANY, INT, BOOL, LIST, NIL
}