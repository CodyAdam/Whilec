package C3A;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains a list of Instruction
 * used by the C3A generator
 */
public class Stack {
  private List<Instruction> stack;
  public Stack() {
    stack = new ArrayList<Instruction>();
  }

  public List<Instruction> getStack() {
    return stack;
  }
}
