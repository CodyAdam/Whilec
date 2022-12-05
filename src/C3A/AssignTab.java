package C3A;

/**
 * Correspond to a=b in C3A
 */
public class AssignTab {
  private Variable left;
  private int index;
  private ToAssign right;

  public AssignTab(Variable left, int index, ToAssign right) {
    this.left = left;
    this.index = index;
    this.right = right;
  }

  @Override
  public String toString() {
    return left + "[" + index + "]" + " = " + right;
  }
}
