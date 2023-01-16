package C3A;

public class FuncBegin extends Instruction {
  private String funcName;

  public FuncBegin(String funcName) {
    this.funcName = funcName;
  }

  @Override
  public String toString() {
    return "func begin " + funcName;
  }

  @Override
  public String toPython(Indent indent) {
    String s = indent + "def " + funcName + "():\n";
    indent.inc();
    s += indent + "global stack";
    return s;
  }
}
