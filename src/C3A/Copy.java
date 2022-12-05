package C3A;

public class Copy extends ToAssign {
  private String label;

  public Copy(String label) {
    this.label = label;
  }

  @Override
  public String toString() {
    return label;
  }
}
