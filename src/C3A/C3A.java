package C3A;

import C3A.AstNode;
import java.util.List;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

public class C3A {
  private Instructions instructions;

  public C3A(CommonTree ast, List<Variable> stack) {
    instructions = new Instructions();
    instructions = AstToInstructions(ast);
  }

  private Instructions fromFunction(CommonTree ast) {
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
  private Instructions fromIf(CommonTree ast) {
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

  private Instructions fromWhile(CommonTree ast) {
    return this;
  }

  private Instructions fromFor(CommonTree ast) {
    return this;
  }

  private Instructions fromAssign(CommonTree ast) {
    return 
  }

  private Instructions AstToInstructions(CommonTree ast) {
    String node = ast.getText();
    System.out.println("Converting : " + node);
    if (node.equals(AstNode.FUNCTION.toString())) {
      return fromFunction(ast);
    } else if (node.equals(AstNode.IF.toString())) {
      return fromIf(ast);
    } else if (node.equals(AstNode.WHILE.toString())) {
      return fromWhile(ast);
    } else if (node.equals(AstNode.FOR.toString())) {
      return fromFor(ast);
    } else if (node.equals(AstNode.ASSIGN.toString())) {
      return fromAssign(ast);
    } else {
      return fromCommands(ast);
    }
  }

  private Instructions fromCommands(CommonTree ast) {
    return null;
  }

  public String toString() {
    return instructions.toString();
  }
}
