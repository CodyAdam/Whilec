package C3A;

import C3A.AstNode;
import java.util.List;
import org.antlr.runtime.tree.Tree;
import org.antlr.runtime.tree.Tree;

public class C3A {
  private Instructions instructions;

  public C3A(Tree ast) {
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

  private Instructions fromFunction(Tree ast) {
    Tree funcName = ast.getChild(0);
    Tree funcDef = ast.getChild(1);
    assert (funcName.getText().equals(AstNode.SYMBOL.toString()));
    assert (funcDef.getText().equals(AstNode.FUNC_DEF.toString()));

    Instructions i = new Instructions();
    i.add(new FuncBegin(funcName.getText())); // TODO change later with a real function name

    Tree input = funcDef.getChild(0);
    Tree commands = funcDef.getChild(1);
    Tree output = funcDef.getChild(2);
    assert (input.getText().equals(AstNode.INPUT.toString()));
    assert (commands.getText().equals(AstNode.COMMANDS.toString()));
    assert (output.getText().equals(AstNode.OUTPUT.toString()));

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

  private Instructions fromCommands(Tree ast) {
    return null;
  }

  public String toString() {
    return instructions.toString();
  }
}
