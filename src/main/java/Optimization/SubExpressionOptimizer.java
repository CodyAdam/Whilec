package Optimization;

import C3A.*;
import Validation.Color;
import Validation.FontDetail;
import Validation.VPrinter;
import runner.Main;

import java.nio.channels.Pipe;
import java.util.Collections;
import java.util.HashSet;

public class SubExpressionOptimizer extends LocalOptimizer {
    @Override
    protected void optimizeInstructionWithContext(Instruction instruction, Context context) {
        if(instruction instanceof Assign){
            Assign assign = (Assign) instruction;
            if(assign.getRight() instanceof Pop) return;

            // Remove all stored assignments that depend on the current assign
            if(context.varDependencies.containsKey(new VarAssign(assign))) {
                for (VarAssign s : context.varDependencies.get(new VarAssign(assign))) {
                    context.assignments.remove(s);
                }
            }

            // Optimization
            if(assign.getRight() instanceof Variable){
                Variable variable = (Variable) assign.getRight();
                if(context.assignments.containsKey(new VarAssign(variable.getName())) &&
                        (context.assignments.get(new VarAssign(variable.getName())) instanceof Variable
                                || context.assignments.get(new VarAssign(variable.getName())) instanceof TabValue)){
                    ToAssign newValue = context.assignments.get(new VarAssign(variable.getName()));
                    if(!newValue.equals(assign.getRight())) {
                        assign.setRight(newValue);
                        this.addEditedInstruction();
                    }
                }
            } else if(assign.getRight() instanceof TabValue){
                TabValue tabvalue = (TabValue) assign.getRight();
                if(context.assignments.containsKey(new VarAssign(tabvalue)) &&
                        (context.assignments.get(new VarAssign(tabvalue)) instanceof Variable
                                || context.assignments.get(new VarAssign(tabvalue)) instanceof TabValue)){
                    ToAssign newValue =context.assignments.get(new VarAssign(tabvalue));
                    if(!newValue.equals(assign.getRight())) {
                        assign.setRight(newValue);
                        this.addEditedInstruction();
                    }
                }
            } else {
                for (VarAssign key : context.assignments.keySet()) {
                    ToAssign value = context.assignments.get(key);

                    if (value.equals(assign.getRight()) && (!(assign.getRight() instanceof Variable) || !(assign.getRight() instanceof TabValue))) {
                        assign.setRight(new Variable(key.name, false));
                        this.addEditedInstruction();
                        break;
                    }
                }
            }

            context.assignments.put(new VarAssign(assign), assign.getRight());

            // Process dependencies of the variable
            for (VarAssign dependency : context.getDependencies(assign.getRight())) {
                if(context.varDependencies.containsKey(dependency)){
                    context.varDependencies.get(dependency).add(new VarAssign(assign));
                } else {
                    HashSet<VarAssign> dependencies = new HashSet<>();
                    dependencies.add(new VarAssign(assign));
                    context.varDependencies.put(dependency, dependencies);
                }
            }

        } else if(instruction instanceof AssignTab){
            AssignTab assignTab = (AssignTab) instruction;
            if(assignTab.getRight() instanceof Pop) return;

            // Remove all stored assignments that depend on the current assign
            if(context.varDependencies.containsKey(new VarAssign(assignTab))){
                for (VarAssign s : context.varDependencies.get(new VarAssign(assignTab))) {
                    context.assignments.remove(s);
                }
            }

            // Optimization
            if(assignTab.getRight() instanceof Variable){
                Variable variable = (Variable) assignTab.getRight();
                if(context.assignments.containsKey(new VarAssign(variable.getName())) &&
                        (context.assignments.get(new VarAssign(variable.getName())) instanceof Variable
                                || context.assignments.get(new VarAssign(variable.getName())) instanceof TabValue)){
                    ToAssign newValue = context.assignments.get(new VarAssign(variable.getName()));
                    if(!newValue.equals(assignTab.getRight())) {
                        assignTab.setRight(newValue);
                        this.addEditedInstruction();
                    }

                }
            } else if(assignTab.getRight() instanceof TabValue){
                TabValue tabvalue = (TabValue) assignTab.getRight();
                if(context.assignments.containsKey(new VarAssign(tabvalue)) &&
                        (context.assignments.get(new VarAssign(tabvalue)) instanceof Variable
                                || context.assignments.get(new VarAssign(tabvalue)) instanceof TabValue)){
                    ToAssign newValue = context.assignments.get(new VarAssign(tabvalue));
                    if(!newValue.equals(assignTab.getRight())) {
                        assignTab.setRight(newValue);
                        this.addEditedInstruction();
                    }

                }
            } else {
                for (VarAssign key : context.assignments.keySet()) {
                    ToAssign value = context.assignments.get(key);

                    if(value.equals(assignTab.getRight()) && (!(assignTab.getRight() instanceof Variable) || !(assignTab.getRight() instanceof TabValue))){
                        assignTab.setRight(new Variable(key.name, false));
                        this.addEditedInstruction();
                        break;
                    }
                }
            }

            context.assignments.put(new VarAssign(assignTab), assignTab.getRight());

            // Process dependencies of the variable
            for (VarAssign dependency : context.getDependencies(assignTab.getRight())) {
                if(context.varDependencies.containsKey(dependency)){
                    context.varDependencies.get(dependency).add(new VarAssign(assignTab));
                } else {
                    HashSet<VarAssign> dependencies = new HashSet<>();
                    dependencies.add(new VarAssign(assignTab));
                    context.varDependencies.put(dependency, dependencies);
                }
            }

        } else if(instruction instanceof IfzGoto){
            IfzGoto ifzGoto = (IfzGoto) instruction;
            Variable var = ifzGoto.getV();
            if(context.assignments.containsKey(new VarAssign(var.getName())) &&
                    (context.assignments.get(new VarAssign(var.getName())) instanceof Variable)){
                    Variable newValue = (Variable) context.assignments.get(new VarAssign(var.getName()));
                    if(!newValue.equals(ifzGoto.getV())) {
                        ifzGoto.setV(newValue);
                        this.addEditedInstruction();
                    }
                }
        } else if(instruction instanceof Push){
            Push push = (Push) instruction;
            Variable var = push.getV();
            if(context.assignments.containsKey(new VarAssign(var.getName())) &&
                    (context.assignments.get(new VarAssign(var.getName())) instanceof Variable)){
                Variable newValue = (Variable) context.assignments.get(new VarAssign(var.getName()));
                if(!newValue.equals(push.getV())) {
                    push.setV(newValue);
                    this.addEditedInstruction();
                }
            }
        }
    }

    @Override
    protected void endOptimization(Instructions code) {
        printResult();
    }

    private void printResult(){
        if(Main.verbose){
            String message = "### OPTIMIZATION : SUBEXPRESSIONS ###";
            String reportmessage = this.nbInstructionsEdited + " LINE(S) EDITED";
            int n = (message.length() - reportmessage.length() - 6);
            String space = String.join("", Collections.nCopies(n/2, " "));
            reportmessage = "###" + space + reportmessage + space + (n%2!=0 ? " " : "") + "###";
            String line = String.join("", Collections.nCopies(message.length(), "#"));
            FontDetail font = new FontDetail(Color.PURPLE, true, false);
            VPrinter.getInstance().println(line, font);
            VPrinter.getInstance().println(message, font);
            VPrinter.getInstance().println(reportmessage, font);
            VPrinter.getInstance().println(line+"\n", font);
        }
    }
}