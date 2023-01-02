package Validation;

import org.antlr.runtime.tree.Tree;

public abstract class Validator {

    public abstract void validate(Tree tree) throws Exception;

    protected PreCompileValidator parent;

    public void setParent(PreCompileValidator parent) {
        this.parent = parent;
    }
}
