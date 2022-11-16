import org.antlr.runtime.tree.CommonTree;

public class Compiler {
  CommonTree tree;

  public Compiler(CommonTree root) {
    tree = root;
  }

  public String getCompiledCode() {
    return rootNode(tree, 0);
  }

  static public String compile(CommonTree tree) {
    return rootNode(tree, 0);
  }

  public String toString() {
    return getCompiledCode();
  }

  private static String rootNode(CommonTree node, int depth) {
    // TODO
    return "";
  }

  private static String mainNode(CommonTree node, int depth) {
    // TODO
    return "";
  }

  private static String functionNode(CommonTree node, int depth) {
    // TODO
    return "";
  }

  private static String expressionsNode(CommonTree node, int depth) {
    // TODO
    return "";
  }

  private static String expressionNode(CommonTree node, int depth) {
    // TODO
    return "";
  }

  private static String inputNode(CommonTree node, int depth) {
    return depthToString(depth) + "input " + node.getChild(0).getText() + ";\n";
  }

  private static String outputNode(CommonTree node, int depth) {
    return depthToString(depth) + "output " + node.getChild(0).getText() + ";\n";
  }

  private static String varsNode(CommonTree node, int depth) {
    return node.getChild(0).getText() + " " + varsNode((CommonTree) node.getChild(1), depth);
  }

  private static String varNode(CommonTree node, int depth) {
    return node.getChild(0).getText();
  }

  private static String ifNode(CommonTree node, int depth) {
    return depthToString(depth) + "if (" + expressionNode((CommonTree) node.getChild(0), depth) + ") {\n"
        + expressionsNode((CommonTree) node.getChild(1), depth + 1) + depthToString(depth) + "}\n";
  }

  private static String forNode(CommonTree node, int depth) {
    return depthToString(depth) + "for (" + expressionNode((CommonTree) node.getChild(0), depth) + "; "
        + expressionNode((CommonTree) node.getChild(1), depth) + "; "
        + expressionNode((CommonTree) node.getChild(2), depth) + ") {\n"
        + expressionsNode((CommonTree) node.getChild(3), depth + 1) + depthToString(depth) + "}\n";
  }

  private static String whileNode(CommonTree node, int depth) {
    return depthToString(depth) + "while (" + expressionNode((CommonTree) node.getChild(0), depth) + ") {\n"
        + expressionsNode((CommonTree) node.getChild(1), depth + 1) + depthToString(depth) + "}\n";
  }

  private static String assignNode(CommonTree node, int depth) {
    return depthToString(depth) + expressionNode((CommonTree) node.getChild(0), depth) + " = "
        + expressionNode((CommonTree) node.getChild(1), depth) + ";\n";
  }

  private static String foreachNode(CommonTree node, int depth) {
    return depthToString(depth) + "for (" + varNode((CommonTree) node.getChild(0), depth) + " : "
        + expressionNode((CommonTree) node.getChild(1), depth) + ") {\n"
        + expressionsNode((CommonTree) node.getChild(2), depth + 1) + depthToString(depth) + "}\n";
  }

  private static String nopNode(CommonTree node, int depth) {
    return depthToString(depth) + "def nop():\n" + depthToString(depth + 1) + "pass\n";
  }

  private static String printNode(CommonTree node, int depth) {
    node.getChild(0).getText();
    return depthToString(depth) + "print(" + node.getChild(0).getText() + ")\n";
  }

  private static String depthToString(int depth) {
    return "  ".repeat(depth);
  }

}
