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

  public String generateTargetCode(){
    return "TODO";
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
        for (int j = inputNode.getChildCount() - 1; j >= 0; j--) {
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
    i.add(new IfzGoto(elseLabel, endIfLabel, conditionVar));
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
    Tree expression = ast.getChild(0).getChild(0);
    Tree commands = ast.getChild(1);

    String name = expression.getChild(0).getText();
    Variable condition;
    if (scopeVars.containsKey(name)) {
      condition = scopeVars.get(name);
    } else {
      condition = new Variable(name);
      scopeVars.put(name, condition);
    }
    i.add(fromExpr(expression, scopeVars));
    i.add(new Assign(condition, i.getLastAssignedVariable()));

    // Labels
    Label startWhileLabel = new Label("startwhile");
    Label endWhileLabel = new Label("endwhile");
    Label startIfLabel = new Label("startif");

    i.add(startWhileLabel);
    i.add(new IfzGoto(startIfLabel, endWhileLabel, condition));
    i.add(new Goto(endWhileLabel));
    i.add(startIfLabel);
    i.add(fromCommands(commands, scopeVars));
    i.add(new Goto(startWhileLabel));
    i.add(endWhileLabel);
    return i;
  }

  private Instructions fromFor(Tree ast, HashMap<String, Variable> scopeVars) {
    Instructions i = new Instructions();
    i.add(new Comment("For"));
    Tree expression = ast.getChild(0).getChild(0);
    Tree commands = ast.getChild(1);

    i.add(fromExpr(expression, scopeVars));
    Variable index = i.getLastAssignedVariable();

    // For Labels
    Label startForLabel = new Label("startfor");
    Label endForLabel = new Label("endfor");
    Label startIfLabel = new Label("startif");

    i.add(startForLabel);
    i.add(new IfzGoto(startIfLabel, endForLabel, index));
    i.add(new Goto(endForLabel));
    i.add(startIfLabel);
    i.add(fromCommands(commands, scopeVars));
    i.add(new Assign(index, new Unop(UnopEnum.TAIL, index))); // decrement index
    i.add(new Goto(startForLabel));
    i.add(endForLabel);
    return i;
  }

  private Instructions fromForeach(Tree ast, HashMap<String, Variable> scopeVars) {
    Instructions i = new Instructions();
    i.add(new Comment("Foreach"));
    Tree indexNode = ast.getChild(0);
    Tree expression = ast.getChild(1).getChild(0);
    Tree commands = ast.getChild(2);

    String name = indexNode.getText();
    Variable index;
    if (scopeVars.containsKey(name)) {
      index = scopeVars.get(name);
    } else {
      index = new Variable(name);
      scopeVars.put(name, index);
    }
    i.add(fromExpr(expression, scopeVars));
    i.add(new Assign(index, i.getLastAssignedVariable()));

    // Labels
    Label startForLabel = new Label("startfor");
    Label endForLabel = new Label("endfor");
    Label startIfLabel = new Label("startif");

    i.add(startForLabel);
    i.add(new IfzGoto(startIfLabel, endForLabel, index));
    i.add(new Goto(endForLabel));
    i.add(startIfLabel);
    i.add(fromCommands(commands, scopeVars));
    i.add(new Assign(index, new Unop(UnopEnum.TAIL, index))); // decrement index
    i.add(new Goto(startForLabel));
    i.add(endForLabel);
    return i;
  }

  private Instructions fromAssign(Tree ast, HashMap<String, Variable> scopeVars) {
    Instructions i = new Instructions();
    i.add(new Comment("Assign"));
    Tree left = ast.getChild(0);
    Tree right = ast.getChild(1);

    // Parse left (variable names)
    int leftCount = left.getChildCount();
    Variable[] names = new Variable[leftCount];
    for (int j = 0; j < leftCount; j++) {
      String varName = left.getChild(j).getText();
      if (!scopeVars.containsKey(varName)) {
        scopeVars.put(varName, new Variable(varName));
      }
      names[j] = scopeVars.get(varName);
    }

    // Parse right (expressions)
    int rightCount = right.getChildCount();
    if (leftCount != rightCount)
      assert (false) : "Error during assign : left and right have different number of variables";

    for (int j = 0; j < rightCount; j++) {
      Tree exprNode = right.getChild(j).getChild(0); // EXPRESSION node
      i.add(fromExpr(exprNode, scopeVars));
      i.add(new Assign(names[j], i.getLastAssignedVariable()));
    }

    return i;
  }

  private Instructions fromExpr(Tree exprConditionNode, HashMap<String, Variable> scopeVars) {
    Instructions i = new Instructions();
    Tree node = exprConditionNode;
    Variable expr;
    int childCount = node.getChildCount();
    switch (AstNode.valueOf(node.getText())) {
      case CONS:
        expr = new Variable("CONS");
        for (int j = 0; j < childCount; j++) {
          Tree exprNode = node.getChild(j); // EXPRESSION node
          i.add(fromExpr(exprNode, scopeVars));
          i.add(new AssignTab(expr, j, i.getLastAssignedVariable()));
        }
        i.add(new Assign(expr, expr));
        break;
      case HEAD:
        expr = new Variable("HEAD");
        Tree childHead = node.getChild(0);
        boolean invalid = false;
        switch (AstNode.valueOf(childHead.getText())) {
          case CONS:
            if (childHead.getChildCount() < 2)
              invalid = true;
            i.add(fromExpr(childHead.getChild(0), scopeVars));
            i.add(new Assign(expr, i.getLastAssignedVariable()));
            break;
          case VARIABLE:
            String varName = childHead.getChild(0).getText();
            Variable var = scopeVars.get(varName);
            i.add(new Assign(expr, new Unop(UnopEnum.HEAD, var)));
            break;
          default:
            invalid = true;
            break;
        }
        if (invalid) {
          i.add(new Assign(expr, new Nil()));
        }
        break;
      case TAIL:
        expr = new Variable("TAIL");
        Tree childTail = node.getChild(0);
        boolean invalidHead = false;
        switch (AstNode.valueOf(childTail.getText())) {
          case CONS:
            if (childTail.getChildCount() < 2)
              invalidHead = true;
            i.add(fromExpr(childTail.getChild(1), scopeVars));
            i.add(new Assign(expr, i.getLastAssignedVariable()));
            break;
          case VARIABLE:
            String varName = childTail.getChild(0).getText();
            Variable var = scopeVars.get(varName);
            i.add(new Assign(expr, new Unop(UnopEnum.TAIL, var)));
            break;
          default:
            invalidHead = true;
            break;
        }
        if (invalidHead) {
          i.add(new Assign(expr, new Nil()));
        }
        break;

      case LIST:
        expr = new Variable("CONS");
        for (int j = 0; j < childCount; j++) {
          Tree exprNode = node.getChild(j); // EXPRESSION node
          i.add(fromExpr(exprNode, scopeVars));
          i.add(new AssignTab(expr, j, i.getLastAssignedVariable()));
        }
        // append a nill at the end
        i.add(new AssignTab(expr, childCount, new Nil()));
        i.add(new Assign(expr, expr));
        break;
      case FUNCTIONCALL:
        expr = new Variable("FUNCTIONCALL");
        Tree funcNode = node.getChild(0);
        String funcName = funcNode.getText();
        int funcChildCount = funcNode.getChildCount();

        for (int j = 0; j < funcChildCount; j++) {
          Tree exprNode = funcNode.getChild(j); // EXPRESSION node
          i.add(fromExpr(exprNode, scopeVars));
          i.add(new FuncParam(i.getLastAssignedVariable()));
        }
        i.add(new Assign(expr, new FuncCall(funcName, funcChildCount)));
        break;
      case NIL:
        expr = new Variable("NIL");
        i.add(new Assign(expr, new Nil()));
        break;
      case VARIABLE:
        expr = new Variable("VARIABLE");
        String name = node.getChild(0).getText();
        Variable var = scopeVars.get(name);
        if (var == null)
          i.add(new Assign(expr, new Nil()));
        else
          i.add(new Assign(expr, var));
        break;
      case SYMBOL:
        expr = new Variable("SYMBOL");
        String symbolValue = node.getChild(0).getText();
        i.add(new Assign(expr, new Symbol(symbolValue)));
      default:
        assert (false) : node.getText() + " is not valid child of EXPRESSION";
    }
    return i;
  }

  public String toString() {
    return instructions.toString();
  }
}
