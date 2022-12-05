package C3A;

public class Constant extends ToAssign {
  private int value;

  public Constant(int value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "" + value;
  }
}
