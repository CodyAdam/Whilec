package C3A;


/**
 * Correspond to a=b in C3A
 */
public class Assign extends Instruction {
  private Variable left;
  private ToAssign right;

  public Assign(Variable left, ToAssign right) {
    this.left = left;
    this.right = right;
  }

  @Override
  public String toString() {
    return left + " = " + right;
  }
}
