package C3A;

public class IfzGoto extends Instruction {
  private Label label;
  private Variable v;

  public IfzGoto(Label label, Variable v) {
    this.label = label;
    this.v = v;
  }

  @Override
  public String toString() {
    return "ifz " + v + " goto " + label;
  }
}
