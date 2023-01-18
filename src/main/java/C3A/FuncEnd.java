package C3A;

public class FuncEnd extends Instruction {
  private Symbol funcSymb; // not used but might be useful for debugging

  public FuncEnd(Symbol funcName) {
    this.funcSymb = funcName;
  }

  @Override
  public String toString() {
    return "func end\n";
  }

  @Override
  public String toPython(Indent indent) {
    String s = indent + "return output";
    indent.dec();
    return s;
  }
}
