package Validation;

import C3A.Assign;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class VariableNameNUsageValidator extends Validator{

    HashSet<String> notVariable = new HashSet<>(Arrays.asList("cons", "hd", "tl", "list", "nil", "nop", "if", "then", "fi", "while", "do", "od", "foreach", "in", "function", "read", "write", "true", "false"));

    @Override
    public void validate(Tree tree) {

    }
    
}
