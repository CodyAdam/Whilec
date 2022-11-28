package C3A;

public class FuncReturn extends Instruction {
  private String arg;

  public FuncReturn(String arg) {
    this.arg = arg;
  }

  @Override
  public String toString() {
    return "return " + arg;
  }
}
