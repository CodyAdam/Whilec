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
        case IF:
          i.add(fromIf(child, scopeVars));
          break;
        case WHILE:
          i.add(fromWhile(child, scopeVars));
          break;
        case FOR:
          i.add(fromFor(child, scopeVars));
          break;
        case FOREACH:
          i.add(fromForeach(child, scopeVars));
          break;
        case ASSIGN:
          i.add(fromAssign(child, scopeVars));
          break;
        case NOP:
          i.add(new Comment("Nop :>"));
          break;
        default:
          assert (false) : child.getText() + " is not valid child of COMMANDS";
      }
    }
    return i;
  }

  /*
   * b = a + 3
   * c = b 22
   * d = c == 4
   * 
   * ifz d goto end
   */
  private Instructions fromIf(Tree ast, HashMap<String, Variable> scopeVars) {
    Instructions i = new Instructions();

    Tree exprConditionNode = ast.getChild(0);
    Tree trueCommandsNode = ast.getChild(1);
    Tree falseCommandsNode = null;
    if (ast.getChildCount() == 3) {
      falseCommandsNode = ast.getChild(2);
    }

    // Parse condition
    Instructions exprCondition = fromExpr(exprConditionNode, scopeVars);
    i.add(exprCondition);
    Variable conditionVar = exprCondition.getLastAssignedVariable();

    // Labels
    Label elseLabel = new Label("else");
    Label endIfLabel = new Label("endif");

    // Parse if == true commands
    i.add(new IfzGoto(elseLabel, conditionVar));
    i.add(fromCommands(trueCommandsNode, scopeVars));
    i.add(new Goto(endIfLabel));

    // Parse else commands
    if (falseCommandsNode != null) {
      i.add(elseLabel);
      i.add(fromCommands(falseCommandsNode, scopeVars));
    }
    i.add(endIfLabel);
    return i;
  }

  private Instructions fromWhile(Tree ast, HashMap<String, Variable> scopeVars) {
    Instructions i = new Instructions();
    i.add(new Comment("While"));
    return i;
  }

  private Instructions fromFor(Tree ast, HashMap<String, Variable> scopeVars) {
    Instructions i = new Instructions();
    i.add(new Comment("For"));
    return i;
  }

  private Instructions fromForeach(Tree child, HashMap<String, Variable> scopeVars) {
    Instructions i = new Instructions();
    i.add(new Comment("Foreach"));
    return i;
  }

  private Instructions fromAssign(Tree ast, HashMap<String, Variable> scopeVars) {
    Instructions i = new Instructions();
    i.add(new Comment("Assign"));
    // CANT BE DONE NOW BECAUSE ASSIGN GRAMMAR IS BROKEN
    // TODO
    return i;
  }

  private Instructions fromExpr(Tree exprConditionNode, HashMap<String, Variable> scopeVars) {
    Instructions i = new Instructions();
    i.add(new Comment("Expr"));
    return i;
  }

  public String toString() {
    return instructions.toString();
  }
}
