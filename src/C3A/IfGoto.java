package C3A;

public class IfGoto extends Instruction {
  private Label label;
  private IfEnum condition;
  private Variable v;

  public IfGoto(Label label, IfEnum condition, Variable v) {
    this.label = label;
    this.condition = condition;
    this.v = v;
  }

  @Override
  public String toString() {
    return condition + " " + v + " goto " + label;
  }
}
