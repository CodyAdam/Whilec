package C3A;

/**
 * Unary operator extends ToAssign
 */
public class Unop extends ToAssign {
  private UnopEnum op;
  private Variable arg;

  public Unop(UnopEnum op, Variable arg) {
    this.op = op;
    this.arg = arg;
  }

  @Override
  public String toString() {
    String opString;
    switch (op) {
      case NOT:
        opString = "!";
        break;
      case SUB:
        opString = "-";
        break;
      case ADRESS:
        opString = "&";
        break;
      case CONTENT:
        opString = "*";
        break;
      default:
        opString = "UNKNOWN_UNOP";
    }
    return opString + arg;
  }
}
