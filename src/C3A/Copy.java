package C3A;

public class Copy extends ToAssign {
  String label;

  public Copy(String label) {
    this.label = label;
  }

  @Override
  public String toString() {
    return label;
  }
}
