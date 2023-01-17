package C3A;

public class Label extends Instruction {
  private String label;
  static int count = 0;

  public Label(String label) {
    this.label = label + "_" + count;
    count++;
  }

  @Override
  public String toString() {
    return label + ":";
  }

  @Override
  public String toPython(Indent indent) {
    // TODO Auto-generated method stub
    return "";
  }
}
