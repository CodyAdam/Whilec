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
      case TAIL:
        opString = "tl ";
        break;
      case HEAD:
        opString = "hd ";
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

  @Override
  public String toPython() {
    switch (op) {
      case TAIL:
        return arg.getName() + ".right";
      case HEAD:
        return arg.getName() + ".left";
      default:
        System.err.println("Unop not implemented in python");
        return null;
    }
  }

  public Variable getArg() {
    return arg;
  }

  @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Unop unop = (Unop) o;
        return op == unop.op &&
                arg.equals(unop.arg);
    }
}
