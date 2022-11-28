package C3A;

public class Assign extends ToAssign {
  public String left;
  public ToAssign right;

  public Assign(String left, ToAssign right) {
    this.left = left;
    this.right = right;
  }

  @Override
  public String toString() {
    return left + " = " + right;
  }
}
