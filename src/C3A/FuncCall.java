package C3A;

public class FuncCall extends ToAssign {
  private String funcName;
  private int argsCount;

  public FuncCall(String funcName, int argsCount) {
    this.funcName = funcName;
    this.argsCount = argsCount;
  }

  @Override
  public String toString() {
    return "call " + funcName + " " + argsCount;
  }

  @Override
  public String toPython() {

    return funcName + "()";
  }

}
