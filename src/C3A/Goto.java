package C3A;

public class Goto extends Instruction{
  private Label label;

  public Goto(Label label) {
    this.label = label;
  }

  @Override
  public String toString() {
    return "goto " + label;
  }
  
}
