package C3A;

import org.antlr.runtime.tree.Tree;

public class Generator {
  private Instructions instructions;

  public Generator(Tree ast) {
    instructions = new Instructions();
    instructions = fromRoot(ast);
  }

  public Instructions getInstructions() {
    return instructions;
  }

  private Instructions fromRoot(Tree ast) {
    Instructions i = new Instructions();
    for (int j = 0; j < ast.getChildCount(); j++) {
      Tree child = ast.getChild(j);
      assert (child.getText().equals(AstNode.FUNCTION.toString()));
      i.add(fromFunction((Tree) child));
    }
    return i;
  }

  /**
   * func begin <name>
   * <command>
   * <command>
   * return <expr>  OR   Return
   * <command>
   * return <expr>  OR   Return
   * func end
   */
  private Instructions fromFunction(Tree ast) {
    Instructions i = new Instructions();
    Tree funcName = ast.getChild(0);
    i.add(new FuncBegin(funcName.getText()));
    Tree funcDef = funcName.getChild(0);

    if (funcDef.getChildCount() == 3) { 
      // Has parameters
    } else {
      // No Parameters
    }

    return i;
  }

  /*
   * if(a + 3 / 2 == 4)
   * 
   * 
   * b = a + 3
   * c = b / 2
   * d = c == 4
   * ifz d goto end
   */
  private Instructions fromIf(Tree ast) {
    Tree condition = ast.getChild(0);
    Tree commandsIf = ast.getChild(1);
    Label els = new Label("else");
    Label end = new Label("end");
    if (ast.getChildCount() == 3) {
      Tree commandsElse = ast.getChild(2);
      assert (commandsElse.getText().equals(AstNode.COMMANDS.toString()));
    } else {
      els = end;
    }
    assert (condition.getText().equals(AstNode.EXPRESSION.toString()));
    assert (commandsIf.getText().equals(AstNode.COMMANDS.toString()));

    Instructions i = new Instructions();
    // Instruction cond = fromExpression(condition);
    // Variable lastVariable = cond.getLast();

    // i.add(new IfGoto(els, IfEnum.NZ, lastVariable));
    // i.add(fromCommands(commandsIf));
    // I don't know what I am doing

    return i;
  }

  private Instructions fromWhile(Tree ast) {
    Instructions i = new Instructions();
    return i;
  }

  private Instructions fromFor(Tree ast) {
    Instructions i = new Instructions();
    return i;
  }

  private Instructions fromAssign(Tree ast) {
    Instructions i = new Instructions();
    return i;
  }

  private Instructions fromCommands(Tree ast) {
    return null;
  }

  public String toString() {
    return instructions.toString();
  }
}
