package C3A;

public class FuncEnd extends Instruction {
  private String funcName; // not used but might be useful for debugging

  public FuncEnd(String funcName) {
    this.funcName = funcName;
  }

  @Override
  public String toString() {
    return "func end";
  }
}
