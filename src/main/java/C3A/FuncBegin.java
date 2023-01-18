package C3A;

public class FuncBegin extends Instruction {
  private Symbol funcSymb;

  public FuncBegin(Symbol funcName) {
    this.funcSymb = funcName;
  }

  @Override
  public String toString() {
    return "func begin " + funcSymb.getValue();
  }

  @Override
  public String toPython(Indent indent) {
    String s = indent + "def " + funcSymb.getValue() + "():\n";
    indent.inc();
    s += indent + "global stack\n";
    s += indent + "output = []";
    return s;
  }
}
