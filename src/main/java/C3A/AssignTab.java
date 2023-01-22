package C3A;

/**
 * Correspond to a=b in C3A
 */
public class AssignTab extends Instruction {
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

  @Override
  public String toPython(Indent indent) {
    String s = "";
    if (index == 0) {
      s += indent + left.getName() + " = " + this.binTree + "(left=" + right.toPython() + ")";
    } else {
      s += indent + left.getName() + ".right = " + right.toPython();
    }
    return s;
  }

  public Variable getLeft() {
    return left;
  }

  public int getIndex() {
    return index;
  }

  public ToAssign getRight() {
    return right;
  }

  public void setRight(ToAssign right) {
    this.right = right;
  }
}
