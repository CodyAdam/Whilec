package C3A;

public class IfzGoto extends Instruction {
  private Label elseLabel;
  private Label endIfLabel;
  private Variable v;

  public IfzGoto(Label elseLabel, Label endIfLabel, Variable v) {
    this.elseLabel = elseLabel;
    this.endIfLabel = endIfLabel;
    this.v = v;
  }

  @Override
  public String toString() {
    return "ifz " + v + " goto " + elseLabel;
  }
}
