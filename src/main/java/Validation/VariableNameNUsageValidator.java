package Validation;

import java.util.*;

import org.antlr.runtime.tree.Tree;

public class VariableNameNUsageValidator extends DeepValidator{

    HashMap<String, VariableUsage> variableUsages = new HashMap<>();

    @Override
    protected void validateFUNCTION(Tree tree, Function function) {
        this.variableUsages.put(function.functionName, new VariableUsage());

        HashSet<String> variables = new HashSet<>();
        Tree lineNode = tree.getChild(0).getChild(0);
        for (String s : function.outputOrder) {
            if(variables.contains(s)) {
                this.printError("Duplicate variable output name " + s + ".", lineNode.getChild(function.outputInd));
            }
            variables.add(s);
        }
        variables.clear();
        for (String s : function.inputOrder) {
            if(variables.contains(s)) {
                this.printError("Duplicate variable argument name " + s + ".", lineNode.getChild(0));
            }
            variables.add(s);
        }
    }

    @Override
    protected void endValidationFunction(Tree tree, Function function) {
        for (String s : function.inputOrder) {
                if(!checkVarWrittenBeforeRead(s, function) && !variableUsages.get(function.functionName).variableUsageRead.keySet().contains(s)) {
                    this.printWarning("Input variable " + s + " is never read.",
                            tree.getChild(0),
                            new ArrayList<>(Arrays.asList("Remove unused variable from function inputs.")));
                }
        }
        for (String s : function.outputOrder) {
            if(!variableUsages.get(function.functionName).variableUsageWrite.keySet().contains(s)) {
                this.printWarning("No value is assign to output variable " + s + " in the function "+function.functionName+".",
                        tree.getChild(function.outputInd),
                        new ArrayList<>(Arrays.asList("Remove unused variable from function outputs.",
                                "Assign a value to the output variable.")));
            }
        }

        for (String s : this.variableUsages.get(function.functionName).variableUsageWrite.keySet()) {
            if(!this.variableUsages.get(function.functionName).variableUsageRead.keySet().contains(s) && !function.returnType.keySet().contains(s)) {
                ArrayList<String> tips = new ArrayList<>();
                if(this.variableUsages.get(function.functionName).variableUsageWrite.get(s).getParent().getText().equals("FOREACH")){
                    tips.add("Replace foreach loop with a for loop.");
                } else {
                    tips.add("Remove useless variable "+s+" assignment line.");
                }
                System.out.println();
                this.printWarning("Variable " + s + " value is written but never read.",
                        this.variableUsages.get(function.functionName).variableUsageWrite.get(s),
                        new ArrayList<>(tips));
            }
        }

        for (String s : this.variableUsages.get(function.functionName).variableUsageRead.keySet()) {
            if(!function.args.keySet().contains(s) && !this.variableUsages.get(function.functionName).variableUsageWrite.keySet().contains(s)) {
                this.printWarning("Variable " + s + " is read but has never been initialized.",
                        this.variableUsages.get(function.functionName).variableUsageRead.get(s),
                        new ArrayList<>(Arrays.asList("Replace usage of variable "+s+" with 'nil'.", "Initialize variable "+s+" before usage.")));
            }
        }
    }

    private boolean checkVarWrittenBeforeRead(String s, Function function) {
        if(variableUsages.get(function.functionName).variableWrittenBeforeRead.containsKey(s)) {
            this.printWarning("Input variable " + s + " is written before it is read.",
                    variableUsages.get(function.functionName).variableWrittenBeforeRead.get(s),
                    new ArrayList<String>(Arrays.asList("Remove unused variable from function inputs.")));
        }
        return variableUsages.get(function.functionName).variableWrittenBeforeRead.containsKey(s);
    }

    @Override
    protected void validateASSIGN(Tree tree, Function function) {
        for (int i = 0; i < tree.getChild(1).getChildCount(); i++) {
            this.checkExpressionVariableUsage(tree.getChild(1).getChild(i), function);
        }

        for (int i = 0; i < tree.getChild(0).getChildCount(); i++) {
            this.variableUsages.get(function.functionName).variableUsageWrite.put(tree.getChild(0).getChild(i).getText(), tree.getChild(0).getChild(i));
            if(!this.variableUsages.get(function.functionName).variableUsageRead.keySet().contains(tree.getChild(0).getChild(i).getText())) {
                this.variableUsages.get(function.functionName).variableWrittenBeforeRead.put(tree.getChild(0).getChild(i).getText(), tree.getChild(0).getChild(i));
            }
        }
    }

    private void checkExpressionVariableUsage(Tree tree, Function function){
        Stack<Tree> stack = new Stack<>();
        stack.push(tree);
        while(!stack.empty()){
            Tree node = stack.pop();
            if(node.getText().equals("VARIABLE")){
                this.variableUsages.get(function.functionName).variableUsageRead.put(node.getChild(0).getText(), node.getChild(0));
            } else {
                for (int i = 0; i < node.getChildCount(); i++) {
                    stack.push(node.getChild(i));
                }
            }
        }
    }

    @Override
    protected void validateIF(Tree tree, Function function) {
        this.checkExpressionVariableUsage(tree.getChild(0), function);
    }

    @Override
    protected void validateFOR(Tree tree, Function function) {
        this.checkExpressionVariableUsage(tree.getChild(0), function);
    }

    @Override
    protected void validateWHILE(Tree tree, Function function) {
        this.checkExpressionVariableUsage(tree.getChild(0), function);
    }

    @Override
    protected void validateFOREACH(Tree tree, Function function) {
        this.variableUsages.get(function.functionName).variableUsageWrite.put(tree.getChild(0).getText(), tree.getChild(0));
        this.checkExpressionVariableUsage(tree.getChild(1), function);
    }

}

class VariableUsage {
    public HashMap<String, Tree> variableUsageRead;
    public HashMap<String, Tree> variableUsageWrite;
    public HashMap<String, Tree> variableWrittenBeforeRead;

    public VariableUsage() {
        this.variableUsageRead = new HashMap<>();
        this.variableUsageWrite = new HashMap<>();
        this.variableWrittenBeforeRead = new HashMap<>();
    }
}
