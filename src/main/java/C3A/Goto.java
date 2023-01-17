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

  @Override
  public String toPython(Indent indent) {
    // TODO Auto-generated method stub
    return "";
  }
  
}
