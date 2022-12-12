package C3A;

public class FuncReturn extends Instruction {
  private Variable var;

  public FuncReturn(Variable var) {
    this.var = var;
  }

  @Override
  public String toString() {
    return "return " + var.getName();
  }
}
