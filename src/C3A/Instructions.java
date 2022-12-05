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

  public String toString() {
    String s = "";
    for (Instruction i : stack) {
      s += i.toString() + "\n";
    }
    return s;
  }
}
