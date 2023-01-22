package C3A;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains a list of Instruction
 * used by the C3A generator
 */
public class Instructions {
  private List<Instruction> stack;

  public Instructions() {
    stack = new ArrayList<Instruction>();
  }

  public List<Instruction> getInstructions() {
    return stack;
  }

  public void add(Instruction i) {
    stack.add(i);
  }

  public void add(Instructions i) {
    stack.addAll(i.getInstructions());
  }

  public Variable getLastAssignedVariable() {
    for (int i = stack.size() - 1; i >= 0; i--) {
      if (stack.get(i) instanceof Assign) {
        return ((Assign) stack.get(i)).getLeft();
      }
    }
    return null;
  }

  public String toString() {
    String s = "";
    for (Instruction i : stack) {
      s += i.toString() + "\n";
    }
    // remove last \n
    s = s.substring(0, s.length() - 1);
    return s;
  }

  public void remove(Instruction instruction){
        stack.remove(instruction);
  }
}
