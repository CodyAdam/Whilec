package C3A;

import java.util.HashMap;

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

  private Instructions fromFunction(Tree ast) {
    Instructions i = new Instructions();
    HashMap<String, Variable> scopeVars = new HashMap<String, Variable>();

    // Parse Func name
    Tree funcName = ast.getChild(0);
    i.add(new FuncBegin(funcName.getText()));

    // Parse Func definition (input?, commands, output)
    {
      Tree funcDef = funcName.getChild(0);
      Tree inputNode = funcDef.getChild(0);
      Tree commandsNode = funcDef.getChild(0);
      Tree outputNode = funcDef.getChild(1);
      if (funcDef.getChildCount() == 3) {
        // Has parameters
        commandsNode = funcDef.getChild(1);
        outputNode = funcDef.getChild(2);
        // Parse input
        for (int j = 0; j < inputNode.getChildCount(); j++) {
          String varName = inputNode.getChild(j).getText();
          Variable var = new Variable(varName);
          i.add(new Assign(var, new Pop()));
          scopeVars.put(varName, var);
        }
      }
      // Add output variables to scope
      for (int j = 0; j < outputNode.getChildCount(); j++) {
        String varName = outputNode.getChild(j).getText();
        if (!scopeVars.containsKey(varName)) {
          scopeVars.put(varName, new Variable(varName));
        }
      }

      // Parse commands
      Instructions commands = fromCommands(commandsNode, scopeVars);
      i.add(commands);

      // Parse output
      for (int j = 0; j < outputNode.getChildCount(); j++) {
        String varName = outputNode.getChild(j).getText();
        i.add(new FuncReturn(scopeVars.get(varName)));
      }
      i.add(new FuncEnd(funcName.getText()));
    }

    return i;
  }

  /*
   * Multiplexer for commands node
   * Possible commands :
   * - while
   * - if
   * - for
   * - assign
   * - foreach
   * - nop
   */
  private Instructions fromCommands(Tree ast, HashMap<String, Variable> scopeVars) {
    Instructions i = new Instructions();
    for (int j = 0; j < ast.getChildCount(); j++) {
      Tree child = ast.getChild(j);
      switch (AstNode.valueOf(child.getText())) {
        case WHILE:
          i.add(new Comment("While"));
          i.add(fromWhile(child));
          break;
        case IF:
          i.add(new Comment("If"));
          i.add(fromIf(child));
          break;
        case FOR:
          i.add(new Comment("For"));
          i.add(fromFor(child));
          break;
        case ASSIGN:
          i.add(new Comment("Assign"));
          i.add(fromAssign(child));
          break;
        case FOREACH:
          i.add(new Comment("Foreach"));
          i.add(fromForeach(child));
          break;
        case NOP:
          i.add(new Comment("Nope command here"));
          break;
        default:
          assert (false) : child.getText() + " is not valid child of COMMANDS";
      }
    }
    return i;
  }

  private Instructions fromForeach(Tree child) {
    Instructions i = new Instructions();
    return i;
  }

  /*
   * 
   * 
   * 
   * b = a + 3
   * c = b 22
   * d = c == 4
   * 
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
    // CANT BE DONE NOW BECAUSE GRAMMAR IS BROKEN
    // TODO

    return i;
  }

  public String toString() {
    return instructions.toString();
  }
}
