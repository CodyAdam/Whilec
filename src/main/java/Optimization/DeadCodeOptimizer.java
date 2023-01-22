package Optimization;

import C3A.*;
import Validation.Color;
import Validation.FontDetail;
import Validation.VPrinter;
import runner.Main;

import java.util.*;

public class DeadCodeOptimizer extends Optimizer{

    private DeadCodeInfo info;

    @Override
    public void optimize(Instructions code) {
        this.code = code;

        info = new DeadCodeInfo();
        Iterator<Instruction> it = code.getInstructions().iterator();
        while(it.hasNext()){
            Instruction instruction = it.next();

            if(instruction instanceof Assign || instruction instanceof AssignTab) {
                VarAssign varAssign;
                if(instruction instanceof Assign) varAssign = new VarAssign(((Assign) instruction));
                else varAssign = new VarAssign(((AssignTab) instruction));
                if (info.assignments.containsKey(varAssign.name)) {
                    info.assignments.get(varAssign.name).add(instruction);
                } else {
                    List<Instruction> list = new LinkedList<>();
                    list.add(instruction);
                    info.assignments.put(varAssign.name, list);
                }

                ToAssign value;
                if(instruction instanceof Assign) value = ((Assign) instruction).getRight();
                else value = ((AssignTab) instruction).getRight();
                if(value instanceof Variable || value instanceof TabValue){
                    VarAssign varAssignValue;
                    if(value instanceof Variable) varAssignValue = new VarAssign(((Variable) value).getName());
                    else varAssignValue = new VarAssign(((TabValue) value));
                    info.usedVariables.add(varAssignValue.name);
                } else if(value instanceof Unop){
                    info.usedVariables.add(((Unop) value).getArg().getName());
                } else if(value instanceof Pop || value instanceof FuncCall){
                    info.usedVariables.add(varAssign.name);
                }
            } else if(instruction instanceof FuncReturn){
                info.usedVariables.add(((FuncReturn) instruction).getVar().getName());
            } else if(instruction instanceof IfzGoto){
                info.usedVariables.add(((IfzGoto) instruction).getV().getName());
            } else if(instruction instanceof Push){
                info.usedVariables.add(((Push) instruction).getV().getName());
            }

        }


        for(String varAssign : info.assignments.keySet()){
            if(!info.usedVariables.contains(varAssign)){
                for(Instruction instruction : info.assignments.get(varAssign)){
                    code.remove(instruction);
                    this.addEditedInstruction();
                }
            }
        }

        if(this.codeChanged){
            this.codeChanged = false;
            this.optimize(this.code);
        } else {
            this.printResult();
        }
    }

    private void printResult(){
        if(Main.verbose){
            String message = "### OPTIMIZATION : DEAD CODE ###";
            String reportmessage = this.nbInstructionsEdited + " LINE(S) REMOVED";
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

class DeadCodeInfo{
    public HashMap<String, List<Instruction>> assignments;
    public HashSet<String> usedVariables;

    public DeadCodeInfo(){
        assignments = new HashMap<>();
        usedVariables = new HashSet<>();
    }
}