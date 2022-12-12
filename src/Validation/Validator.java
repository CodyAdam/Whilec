package Validation;

import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

public abstract class Validator {

    public abstract void validate(Tree tree) throws Exception;
}
