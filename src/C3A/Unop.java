package C3A;

/**
 * Unary operator extends ToAssign
 */
public class Unop extends ToAssign {
  public UnopEnum op;
  public ToAssign arg;

  public Unop(UnopEnum op, ToAssign arg) {
    this.op = op;
    this.arg = arg;
  }

  @Override
  public String toString() {
    String opString;
    if (op == UnopEnum.NOT) {
      opString = "!";
    } else if (op == UnopEnum.SUB) {
      opString = "-";
    } else {
      opString = "~";
    }
    return opString + " " + arg;
  }
}
