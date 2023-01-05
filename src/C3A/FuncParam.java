package C3A;

public class FuncParam extends Instruction{
  private Variable arg;

  public FuncParam(Variable arg) {
    this.arg = arg;
  }

  @Override
  public String toString() {
    return "param " + arg;
  }
}
