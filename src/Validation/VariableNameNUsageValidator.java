package Validation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import org.antlr.runtime.tree.Tree;

public class VariableNameNUsageValidator extends DeepValidator{

    @Override
    protected void validateFUNCTION(Tree tree, Function function) {
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
    protected void validateASSIGN(Tree tree, Function function) {

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

}
