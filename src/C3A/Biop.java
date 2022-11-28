package C3A;

public class Biop extends ToAssign {
  private BiopEnum op;
  private Variable arg1;
  private Variable arg2;

  public Biop(BiopEnum op, Variable arg1, Variable arg2) {
    this.op = op;
    this.arg1 = arg1;
    this.arg2 = arg2;
  }

  @Override
  public String toString() {
    String opString;
    switch (op) {
      case ADD:
        opString = "+";
        break;
      case SUB:
        opString = "-";
        break;
      case MUL:
        opString = "*";
        break;
      case DIV:
        opString = "/";
        break;
      case AND:
        opString = "&&";
        break;
      case OR:
        opString = "||";
        break;
      case EQ:
        opString = "==";
        break;
      case NEQ:
        opString = "!=";
        break;
      case LT:
        opString = "<";
        break;
      case LE:
        opString = "<=";
        break;
      case GT:
        opString = ">";
        break;
      case GE:
        opString = ">=";
        break;
      default:
        opString = "UNKNOWN_BIOP";
    }
    return arg1 + " " + opString + " " + arg2;
  }

}
