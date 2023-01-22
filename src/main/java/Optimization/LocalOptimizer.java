package Optimization;

import C3A.*;

import java.util.HashMap;
import java.util.Iterator;

public abstract class LocalOptimizer extends Optimizer{

    protected Instructions code;
    protected boolean codeChanged;

    @Override
    public void optimize(Instructions code) {
        this.code = code;
        this.optimizeWithRepeat(code);
    }

    private void optimizeWithRepeat(Instructions code){
        this.codeChanged = false;
        Iterator<Instruction> it = code.getInstructions().iterator();
        while(it.hasNext()){
            Instruction instruction = it.next();
            if(instruction instanceof FuncBegin){
                this.optimizeWithContext(it, new Context());
            }
        }
        if(this.codeChanged){
            System.out.println("##### New optimization cycle ####");
            this.optimizeWithRepeat(code);
        }
    }

    private void optimizeWithContext(Iterator<Instruction> it, Context context) {
        while (it.hasNext()){
            Instruction instruction = it.next();
            if(instruction instanceof FuncEnd || instruction instanceof FuncReturn){
                return;
            } else if(instruction instanceof Goto){
                Goto gotoI = (Goto) instruction;
                optimizeWithContext(this.code.getInstructions().listIterator(parent.getLabels().get(gotoI.getLabel().getName())), new Context(context));
                return;
            } else if(instruction instanceof IfzGoto){
                IfzGoto gotoI = (IfzGoto) instruction;
                optimizeWithContext(this.code.getInstructions().listIterator(parent.getLabels().get(gotoI.getEndIfLabel().getName())), new Context(context));
                optimizeWithContext(this.code.getInstructions().listIterator(parent.getLabels().get(gotoI.getElseLabel().getName())), new Context(context));
                return;
            } else {
                this.optimizeInstructionWithContext(instruction, context);
            }
        }
    }

    protected abstract void optimizeInstructionWithContext(Instruction instruction, Context context);

}

class Context {
    public HashMap<String, Variable> assignExpressions;
    public HashMap<String, AssignTab> assignTabExpressions;

    public Context() {
        assignExpressions = new HashMap<>();
        assignTabExpressions = new HashMap<>();
    }

    public Context(Context context) {
        assignExpressions = new HashMap<>(context.assignExpressions);
        assignTabExpressions = new HashMap<>(context.assignTabExpressions);
    }

    public Context(HashMap<String, Variable> assignExpressions, HashMap<String, AssignTab> assignTabExpressions) {
        this.assignExpressions = new HashMap<>(assignExpressions);
        this.assignTabExpressions = new HashMap<>(assignTabExpressions);
    }
}