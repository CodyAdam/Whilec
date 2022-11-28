package C3A;

public class Goto extends Instruction{
  private String label;

  public Goto(String label) {
    this.label = label;
  }

  @Override
  public String toString() {
    return "goto " + label;
  }
  
}
