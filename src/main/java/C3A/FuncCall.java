package C3A;

public class FuncCall extends ToAssign {
  private Symbol funcSymb;
  private int argsCount;

  public FuncCall(Symbol funcName, int argsCount) {
    this.funcSymb = funcName;
    this.argsCount = argsCount;
  }

  @Override
  public String toString() {
    return "call " + funcSymb.getValue() + " " + argsCount;
  }

  @Override
  public String toPython() {

    return funcSymb.getValue() + "()";
  }

}
