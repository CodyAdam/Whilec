package C3A;

public enum AstNode {
  ASSIGN("ASSIGN"),
  COMMAND("COMMAND"),
  COMMANDS("COMMANDS"),
  EXPRESSION("EXPRESSION"),
  EXPRS("EXPRS"),
  EXPR_BASE("EXPR_BASE"),
  FOR("FOR"),
  FOREACH("FOREACH"),
  FUNCTION("FUNCTION"),
  FUNC_DEF("FUNC_DEF"),
  IF("IF"),
  INPUT("INPUT"),
  NOP("NOP"),
  OUTPUT("OUTPUT"),
  ROOT("ROOT"),
  SYMBOL("SYMBOL"),
  VARIABLE("VARIABLE"),
  VARS("VARS"),
  WHILE("WHILE"),
  HEAD("HEAD"),
  TAIL("TAIL"),
  CONS("CONS"),
  LIST("LIST"),
  NIL("NIL"),
  FUNCTIONCALL("FUNCTIONCALL");

  private final String name;

  private AstNode(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }
}