package Optimization;

import C3A.*;

public class SubExpressionOptimizer extends LocalOptimizer {
    @Override
    protected void optimizeInstructionWithContext(Instruction instruction, Context context) {
        if(instruction instanceof Assign){
            Assign assign = (Assign) instruction;
            if(assign.getRight() instanceof Pop) return;
            if(context.assignExpressions.containsKey(assign.getRight().toString())) {
                System.out.println("From "+assign);
                assign.setRight(context.assignExpressions.get(assign.getRight().toString()));
                System.out.println("To "+assign);
                this.codeChanged = true;
            }/* else if (context.assignTabExpressions.containsKey(assign.getRight().toString())){
                    AssignTab assignTab = context.assignTabExpressions.get(assign.getRight().toString());
                    assign.setRight(new TabValue(assignTab.getLeft(), assignTab.getIndex()));
                    this.changeInstructions = true;
                }*/ else {
                    context.assignExpressions.put(assign.getRight().toString(), assign.getLeft());
                }
            } else if(instruction instanceof AssignTab){
                AssignTab assignTab = (AssignTab) instruction;
                if(assignTab.getRight() instanceof Pop) return;
                if(context.assignExpressions.containsKey(assignTab.getRight().toString())) {
                    System.out.println("From "+assignTab);
                    assignTab.setRight(context.assignExpressions.get(assignTab.getRight().toString()));
                    System.out.println("To "+assignTab);
                    this.codeChanged = true;
                    System.out.println("Changed");
                }/* else if (context.assignTabExpressions.containsKey(assignTab.getRight().toString())){
                    AssignTab assignTab2 = context.assignTabExpressions.get(assignTab.getRight().toString());
                    assignTab.setRight(new TabValue(assignTab2.getLeft(), assignTab2.getIndex()));
                    this.changeInstructions = true;
                } else {
                    context.assignTabExpressions.put(assignTab.getRight().toString(), assignTab);
                }*/
            }
    }

    /*@Override
    public void optimize(Instructions code) {
        // Iterator over the instructions
        Iterator<Instruction> it = code.getInstructions().iterator();
        while(it.hasNext()){
            Instruction instruction = it.next();
            if(instruction instanceof FuncBegin){
                it = this.optimizeWithContext(it, new Context());
            }
        }
        if(this.changeInstructions){
            this.changeInstructions = false;
            this.optimize(code);
            System.out.println("re-optimize");
        }
    }*/

    /*private Iterator<Instruction> optimizeWithContext(Iterator<Instruction> it, Context context){
        while (it.hasNext()){
            Instruction instruction = it.next();
            if(instruction instanceof FuncEnd || instruction instanceof FuncReturn){
                return it;
            } else if(instruction instanceof Assign){
                Assign assign = (Assign) instruction;
                if(assign.getRight() instanceof Pop) continue;
                if(context.assignExpressions.containsKey(assign.getRight().toString())) {
                    assign.setRight(context.assignExpressions.get(assign.getRight().toString()));
                    this.changeInstructions = true;
                }/* else if (context.assignTabExpressions.containsKey(assign.getRight().toString())){
                    AssignTab assignTab = context.assignTabExpressions.get(assign.getRight().toString());
                    assign.setRight(new TabValue(assignTab.getLeft(), assignTab.getIndex()));
                    this.changeInstructions = true;
                } else {
                    context.assignExpressions.put(assign.getRight().toString(), assign.getLeft());
                }
            } else if(instruction instanceof AssignTab){
                AssignTab assignTab = (AssignTab) instruction;
                if(assignTab.getRight() instanceof Pop) continue;
                if(context.assignExpressions.containsKey(assignTab.getRight().toString())) {
                    assignTab.setRight(context.assignExpressions.get(assignTab.getRight().toString()));
                    this.changeInstructions = true;
                }/* else if (context.assignTabExpressions.containsKey(assignTab.getRight().toString())){
                    AssignTab assignTab2 = context.assignTabExpressions.get(assignTab.getRight().toString());
                    assignTab.setRight(new TabValue(assignTab2.getLeft(), assignTab2.getIndex()));
                    this.changeInstructions = true;
                } else {
                    context.assignTabExpressions.put(assignTab.getRight().toString(), assignTab);
                }
            }
        }
        return it;
    }*/
}