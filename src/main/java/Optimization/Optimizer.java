package Optimization;

import C3A.Instructions;

public abstract class Optimizer {

    protected boolean changeInstructions = false;
    protected GlobalOptimizer parent;

    /**
     * Optimizes the given 3 address code
     * @param code the 3 address code to optimize
     */
    public abstract void optimize(Instructions code);

    public void setParent(GlobalOptimizer parent) {
        this.parent = parent;
    }
}
