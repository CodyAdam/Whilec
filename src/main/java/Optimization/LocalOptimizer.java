package Optimization;

import C3A.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public abstract class LocalOptimizer extends Optimizer{

    protected Instructions code;
    protected boolean codeChanged;
    HashSet<String> visitedLabel;

    @Override
    public void optimize(Instructions code) {
        this.code = code;
        visitedLabel = new HashSet<>();
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
                optimizeWithContext(this.code.getInstructions().listIterator(parent.getLabels().get(gotoI.getLabel().getName())), new Context());
                return;
            } else if(instruction instanceof IfzGoto){
                IfzGoto gotoI = (IfzGoto) instruction;
                optimizeWithContext(this.code.getInstructions().listIterator(parent.getLabels().get(gotoI.getEndIfLabel().getName())), new Context());
                optimizeWithContext(it, new Context(context));
                return;
            } else if(instruction instanceof Label){
                Label label = (Label) instruction;
                if(visitedLabel.contains(label.getName())){
                    return;
                } else {
                    visitedLabel.add(label.getName());
                    optimizeWithContext(it, new Context());
                    return;
                }
            }
            else {
                this.optimizeInstructionWithContext(instruction, context);
            }
        }
    }

    protected abstract void optimizeInstructionWithContext(Instruction instruction, Context context);

}

class Context {

    public HashMap<VarAssign, ToAssign> assignments;
    public HashMap<VarAssign, HashSet<VarAssign>> varDependencies;

    public Context() {
        assignments = new HashMap<>();
        varDependencies = new HashMap<>();
    }

    public Context(Context context) {
        assignments = new HashMap<>(context.assignments);
        varDependencies = new HashMap<>(context.varDependencies);
    }

    public HashSet<VarAssign> getDependencies(ToAssign value){
        HashSet<VarAssign> dependencies = new HashSet<>();
        if(value instanceof Variable){
            Variable variable = (Variable) value;
            dependencies.add(new VarAssign(variable.getName()));
        } else if(value instanceof TabValue){
            TabValue tabValue = (TabValue) value;
            dependencies.add(new VarAssign(tabValue.getTab().getName(), tabValue.getIndex()));
        } else if(value instanceof Unop){
            Unop unop = (Unop) value;
            dependencies.add(new VarAssign(unop.getArg().getName()));
        }
        return dependencies;
    }
}

class VarAssign{
    public String name;
    public int index;

    public VarAssign(String name, int index){
        this.name = name;
        this.index = index;
    }

    public VarAssign(String name){
        this.name = name;
        this.index = -1;
    }

    public VarAssign(Assign assign){
        this.name = assign.getLeft().getName();
        this.index = -1;
    }

    public VarAssign(AssignTab assignTab){
        this.name = assignTab.getLeft().getName();
        this.index = assignTab.getIndex();
    }

    public VarAssign(TabValue value){
        this.name = value.getTab().getName();
        this.index = value.getIndex();
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof VarAssign){
            VarAssign other = (VarAssign) o;
            return this.name.equals(other.name) && this.index == other.index;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + this.index;
    }
}