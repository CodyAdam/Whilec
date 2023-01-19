package C3A;

import java.util.HashMap;
import java.util.Map;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.Tree;
import org.antlr.runtime.ANTLRStringStream;

import AST.ASTLexer;
import AST.ASTParser;

public class Generator {
  private Instructions instructions;
  private String[] args;
  private Map<String, Symbol> symbolTable;

  public Generator(Tree ast, String[] args) throws Exception {
    this.args = args;
    this.symbolTable = new HashMap<String, Symbol>();
    instructions = new Instructions();
    instructions = fromRoot(ast);
  }

  public Instructions getInstructions() {
    return instructions;
  }

  private Instructions fromRoot(Tree ast) throws Exception {
    Instructions i = new Instructions();
    for (int j = 0; j < ast.getChildCount(); j++) {
      Tree child = ast.getChild(j);
      assert (child.getText().equals(AstNode.FUNCTION.toString()));
      i.add(fromFunction((Tree) child));
    }
    return i;
  }

  private Instructions fromFunction(Tree ast) throws Exception {
    Instructions i = new Instructions();
    HashMap<String, Variable> scopeVars = new HashMap<String, Variable>();

    // Parse Func name
    Tree funcName = ast.getChild(0);
    String funcNameStr = funcName.getText();
    if (symbolTable.get(funcNameStr) == null)
      symbolTable.put(funcNameStr, new Symbol(funcNameStr));
    Symbol funcSymbol = symbolTable.get(funcNameStr);

    i.add(new FuncBegin(funcSymbol));

    // Parse Func definition (input?, commands, output)
    {
      Tree funcDef = funcName.getChild(0);
      Tree inputNode = funcDef.getChild(0);
      Tree commandsNode = funcDef.getChild(0);
      Tree outputNode = funcDef.getChild(1);
      if (funcDef.getChildCount() == 3) {
        // Has parameters
        if (funcNameStr.equals("main"))
          i.add(this.fromArgs());
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
          i.add(new Assign(scopeVars.get(varName), new Nil()));
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
      i.add(new FuncEnd(funcSymbol));
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
  private Instructions fromCommands(Tree ast, HashMap<String, Variable> scopeVars) throws Exception {
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
          i.add(new Nop());
          break;
        default:
          throw new Exception(child.getText() + " is not valid child of COMMANDS");
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
  private Instructions fromIf(Tree ast, HashMap<String, Variable> scopeVars) throws Exception {
    Instructions i = new Instructions();

    Tree exprConditionNode = ast.getChild(0).getChild(0);
    Tree trueCommandsNode = ast.getChild(1);
    Tree falseCommandsNode = null;
    if (ast.getChildCount() == 3) {
      falseCommandsNode = ast.getChild(2);
    }

    // Parse condition
    i.add(fromExpr(exprConditionNode, scopeVars));
    Variable conditionVar = i.getLastAssignedVariable();

    // Labels
    Label elseLabel = new Label("if_else");
    Label endIfLabel = new Label("if_end");

    // Parse if == true commands
    i.add(new IfzGoto(elseLabel, endIfLabel, conditionVar));
    i.add(fromCommands(trueCommandsNode, scopeVars));
    i.add(new Goto(endIfLabel));

    // Parse else commands
    i.add(elseLabel);
    if (falseCommandsNode != null) {
      i.add(fromCommands(falseCommandsNode, scopeVars));
    }
    i.add(endIfLabel);
    return i;
  }

  private Instructions fromWhile(Tree ast, HashMap<String, Variable> scopeVars) throws Exception {
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
    Label startWhileLabel = new Label("while_start");
    Label endWhileLabel = new Label("while_end");

    i.add(startWhileLabel);
    i.add(new IfzGoto(endWhileLabel, endWhileLabel, condition));
    i.add(fromCommands(commands, scopeVars));
    i.add(new Goto(startWhileLabel));
    i.add(endWhileLabel);
    return i;
  }

  private Instructions fromFor(Tree ast, HashMap<String, Variable> scopeVars) throws Exception {
    Instructions i = new Instructions();
    i.add(new Comment("For"));
    Tree expression = ast.getChild(0).getChild(0);
    Tree commands = ast.getChild(1);

    i.add(fromExpr(expression, scopeVars));
    Variable index = i.getLastAssignedVariable();

    // For Labels
    Label startForLabel = new Label("for_start");
    Label endForLabel = new Label("for_end");

    i.add(startForLabel);
    i.add(new IfzGoto(endForLabel, endForLabel, index));
    i.add(fromCommands(commands, scopeVars));
    i.add(new Assign(index, new Unop(UnopEnum.TAIL, index))); // decrement index
    i.add(new Goto(startForLabel));
    i.add(endForLabel);
    return i;
  }

  private Instructions fromForeach(Tree ast, HashMap<String, Variable> scopeVars) throws Exception {
    Instructions i = new Instructions();
    i.add(new Comment("Foreach"));
    Tree indexNode = ast.getChild(0);
    Tree expression = ast.getChild(1).getChild(0);
    Tree commands = ast.getChild(2);

    String name = indexNode.getText();
    Variable item;
    if (scopeVars.containsKey(name)) {
      item = scopeVars.get(name);
    } else {
      item = new Variable(name);
      scopeVars.put(name, item);
    }
    i.add(fromExpr(expression, scopeVars));
    i.add(new Assign(item, i.getLastAssignedVariable()));
    Variable index = new Variable("INDEX");
    i.add(new Assign(index, item));

    // Labels
    Label startForLabel = new Label("for_start");
    Label endForLabel = new Label("for_end");

    i.add(startForLabel);
    i.add(new IfzGoto(endForLabel, endForLabel, index));
    i.add(new Assign(item, new Unop(UnopEnum.HEAD, index)));
    i.add(fromCommands(commands, scopeVars));
    i.add(new Assign(index, new Unop(UnopEnum.TAIL, index)));
    i.add(new Goto(startForLabel));
    i.add(endForLabel);
    return i;
  }

  private Instructions fromAssign(Tree ast, HashMap<String, Variable> scopeVars) throws Exception {
    Instructions i = new Instructions();
    i.add(new Comment("Assign"));
    Tree left = ast.getChild(0); // Vars
    Tree right = ast.getChild(1); // Expressions

    // Parse left (variable names)
    int leftCount = left.getChildCount();
    Variable[] vars = new Variable[leftCount];
    for (int j = 0; j < leftCount; j++) {
      String varName = left.getChild(j).getText();
      if (!scopeVars.containsKey(varName)) {
        scopeVars.put(varName, new Variable(varName));
        i.add(new Assign(scopeVars.get(varName), new Nil()));
      }
      vars[j] = scopeVars.get(varName);
    }

    // Parse right (expressions)
    Tree firstNode = right.getChild(0).getChild(0);
    if (AstNode.valueOf(firstNode.getText()) == AstNode.FUNCTIONCALL) {
      Variable functionCall = new Variable("FUNCCALL");
      {
        Tree funcNode = firstNode.getChild(0);
        String funcName = funcNode.getText();
        if (symbolTable.get(funcName) == null)
          symbolTable.put(funcName, new Symbol(funcName));
        Symbol funcSymbol = symbolTable.get(funcName);
        int funcChildCount = funcNode.getChildCount();
        for (int j = 0; j < funcChildCount; j++) {
          Tree exprNode = funcNode.getChild(j); // EXPRESSION node
          i.add(fromExpr(exprNode, scopeVars));
          i.add(new Push(i.getLastAssignedVariable()));
        }
        i.add(new Assign(functionCall, new FuncCall(funcSymbol, funcChildCount)));
      }
      i.add(new Assign(functionCall, i.getLastAssignedVariable()));
      for (int j = 0; j < leftCount; j++) {
        i.add(new Assign(vars[j], new TabValue(functionCall, j)));
      }
    } else {
      int rightCount = right.getChildCount();
      if (leftCount != rightCount)
        throw new Exception("Error during assign : left and right have different number of variables");
      for (int j = 0; j < rightCount; j++) {
        Tree exprNode = right.getChild(j).getChild(0); // EXPRBASE node
        i.add(fromExpr(exprNode, scopeVars));
        i.add(new Assign(vars[j], i.getLastAssignedVariable()));
      }
    }

    return i;
  }

  private Instructions fromExpr(Tree exprConditionNode, HashMap<String, Variable> scopeVars) throws Exception {
    Instructions i = new Instructions();
    Tree node = exprConditionNode;
    Variable expr;
    int childCount = node.getChildCount();
    switch (AstNode.valueOf(node.getText())) {
      case CONS:
        expr = new Variable("CONS");
        Variable subnode = new Variable("CONS_FIRST");
        if (childCount > 0) {
          Tree exprNode = node.getChild(childCount - 1); // EXPRESSION node
          i.add(fromExpr(exprNode, scopeVars));
          i.add(new Assign(subnode, i.getLastAssignedVariable()));
        }
        for (int j = childCount - 2; j >= 0; j--) {
          Tree exprNode = node.getChild(j); // EXPRESSION node
          Variable newNode = new Variable("CONS");
          i.add(fromExpr(exprNode, scopeVars));
          i.add(new AssignTab(newNode, 0, i.getLastAssignedVariable()));
          i.add(new AssignTab(newNode, 1, subnode));
          subnode = newNode;
        }
        i.add(new Assign(expr, subnode));
        break;
      case LIST:
        expr = new Variable("LIST");
        Variable subNode = new Variable("NIL");
        i.add(new Assign(subNode, new Nil()));
        for (int j = childCount - 1; j >= 0; j--) {
          Tree exprNode = node.getChild(j); // EXPRESSION node
          Variable newNode = new Variable("CONS");
          i.add(fromExpr(exprNode, scopeVars));
          i.add(new AssignTab(newNode, 0, i.getLastAssignedVariable()));
          i.add(new AssignTab(newNode, 1, subNode));
          subNode = newNode;
        }
        i.add(new Assign(expr, subNode));
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
      case FUNCTIONCALL:
        expr = new Variable("FUNCTIONCALL");
        Tree funcNode = node.getChild(0);
        String funcName = funcNode.getText();
        if (symbolTable.get(funcName) == null)
          symbolTable.put(funcName, new Symbol(funcName));
        Symbol funcSymbol = symbolTable.get(funcName);

        int funcChildCount = funcNode.getChildCount();

        for (int j = 0; j < funcChildCount; j++) {
          Tree exprNode = funcNode.getChild(j); // EXPRESSION node
          i.add(fromExpr(exprNode, scopeVars));
          i.add(new Push(i.getLastAssignedVariable()));
        }
        Variable temp = new Variable("FUNCCALL_TEMP");
        i.add(new Assign(temp, new FuncCall(funcSymbol, funcChildCount)));
        i.add(new Assign(expr, new TabValue(temp, 0)));
        break;
      case SYMBOL:
        expr = new Variable("SYMBOL");
        String symbolValue = node.getChild(0).getText();
        i.add(new Assign(expr, new Symbol(symbolValue, true)));
        break;
      default:
        throw new Exception(node.getText() + " is not valid child of EXPRESSION");
    }
    return i;
  }

  public Instructions fromArgs() throws Exception {
    Instructions i = new Instructions();
    for (int j = 1; j < args.length; j++) {
      Variable var = new Variable("ARG" + j);
      String arg = args[j];
      try {
        // is a int
        int value = Integer.parseInt(arg);
        Variable subVar = new Variable("INT_ARG");
        i.add(new Assign(subVar, new Nil()));
        for (int k = 0; k < value; k++) {
          subVar = new Variable("INT_ARG");
          i.add(new AssignTab(subVar, 1, i.getLastAssignedVariable()));
          i.add(new AssignTab(subVar, 0, new Nil()));
          i.add(new Assign(subVar, subVar));
        }
        i.add(new Assign(var, subVar));
      } catch (Exception e) {
        // a base expression as string
        CharStream cs = new ANTLRStringStream(arg);
        ASTLexer lexer = new ASTLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream();
        tokens.setTokenSource(lexer);
        ASTParser parser = new ASTParser(tokens);
        var prog = parser.exprbase();
        Tree tree = (Tree) prog.getTree();
        i.add(fromExpr(tree, new HashMap<String, Variable>()));
        i.add(new Assign(var, i.getLastAssignedVariable()));
      }
      i.add(new Push(var));
    }
    return i;
  }

  public String toString() {
    return instructions.toString();
  }
}
