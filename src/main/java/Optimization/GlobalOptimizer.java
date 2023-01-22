package Optimization;

import C3A.Instruction;
import C3A.Instructions;
import C3A.Label;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GlobalOptimizer {

    private List<Optimizer> optimizers;
    private HashMap<String, Integer> labels;

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
     */
    public void optimize(Instructions code){
        this.processLabelsIndex(code);
        for (Optimizer optimizer : optimizers) {
            optimizer.optimize(code);
        }
    }

    /**
     * Adds an optimizer to the list of optimizers components of the GlobalOptimizer
     * @param optimizer the optimizer to add
     */
    public void addOptimizer(Optimizer optimizer){
        optimizers.add(optimizer);
        optimizer.setParent(this);
    }

    private void processLabelsIndex(Instructions code){
        HashMap<String, Integer> result = new HashMap<>();
        int i = 0;
        for (Instruction instruction : code.getInstructions()) {
            if(instruction instanceof Label){
                Label label = (Label) instruction;
                result.put(label.getName(), i);
            }
            i++;
        }
        this.labels = result;
    }

    public HashMap<String, Integer> getLabels() {
        return labels;
    }
}
