package C3A;

public class Goto extends Instruction{
  private Label label;

  public Goto(Label label) {
    this.label = label;
  }

  public Label getLabel() {
    return label;
  }

  @Override
  public String toString() {
    return "goto " + label.getName();
  }

  @Override
  public String toPython(Indent indent) {
    return "";
  }
  
}
