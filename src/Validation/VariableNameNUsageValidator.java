package Validation;

import java.util.Arrays;
import java.util.HashSet;

import org.antlr.runtime.tree.Tree;

public class VariableNameNUsageValidator extends Validator{

    HashSet<String> notVariable = new HashSet<>(Arrays.asList("cons", "hd", "tl", "list", "nil", "nop", "if", "then", "fi", "while", "do", "od", "foreach", "in", "function", "read", "write", "true", "false"));

    @Override
    public void validate(Tree tree) {

    }
    
}
