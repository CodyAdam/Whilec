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

  public Variable getLeft() {
    return left;
  }

  @Override
  public String toString() {
    return left + " = " + right;
  }

  @Override
  public String toPython(Indent indent) {
    return indent + left.getName() + " = " + right.toPython();
  }

  public ToAssign getRight() {
    return right;
  }

  public void setRight(ToAssign right) {
    this.right = right;
  }
}
