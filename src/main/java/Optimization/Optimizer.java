package Optimization;

import C3A.Instructions;

public abstract class Optimizer {

    protected GlobalOptimizer parent;
    protected boolean codeChanged;
    protected Instructions code;
    protected int nbInstructionsEdited = 0;

    /**
     * Optimizes the given 3 address code
     * @param code the 3 address code to optimize
     */
    public abstract void optimize(Instructions code);

    public void setParent(GlobalOptimizer parent) {
        this.parent = parent;
    }

    public void addEditedInstruction(){
        nbInstructionsEdited++;
        codeChanged = true;
    }
}
