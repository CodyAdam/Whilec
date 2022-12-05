package C3A;

public class IfGoto {
  private String label;
  private IfEnum condition;

  public IfGoto(String label, IfEnum condition) {
    this.label = label;
    this.condition = condition;
  }

  @Override
  public String toString() {
    return "if " + condition + " goto " + label;
  }
}
