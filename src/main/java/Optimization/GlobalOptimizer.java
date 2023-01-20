package Optimization;

import java.util.LinkedList;
import java.util.List;

public class GlobalOptimizer {

    List<Optimizer> optimizers;


    /**
     * Creates a new GlobalOptimizer with the given optimizers
     * @param optimizers the optimizers to use
     */
    public GlobalOptimizer(List<Optimizer> optimizers) {
        this.optimizers = optimizers;
    }

    /**
     * Create a new GlobalOptimizer with no optimizers
     */
    public GlobalOptimizer() {
        this.optimizers = new LinkedList<>();
    }

    /**
     * Optimize the given 3 address code with all components optimizers
     * @param code the 3 address code to optimize
     * @return the optimized 3 address code
     */
    public String optimize(String code){
        String codeOpti = code;
        for (Optimizer optimizer : optimizers) {
            codeOpti = optimizer.optimize(codeOpti);
        }
        return codeOpti;
    }

    /**
     * Adds an optimizer to the list of optimizers components of the GlobalOptimizer
     * @param optimizer the optimizer to add
     */
    public void addOptimizer(Optimizer optimizer){
        optimizers.add(optimizer);
    }
}
