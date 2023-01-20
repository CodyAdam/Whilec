package Optimization;

public abstract class Optimizer {

    /**
     * Optimizes the given 3 address code
     * @param code the 3 address code to optimize
     * @return the optimized 3 address code
     */
    public abstract String optimize(String code);
}
