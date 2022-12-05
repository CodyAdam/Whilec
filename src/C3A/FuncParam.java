package C3A;

public class FuncParam extends Instruction{
  private String arg;

  public FuncParam(String arg) {
    this.arg = arg;
  }

  @Override
  public String toString() {
    return "param " + arg;
  }
}
