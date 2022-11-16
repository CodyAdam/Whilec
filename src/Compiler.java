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

  private static String varsNode(CommonTree node, int depth) {
    String t = node.getChild(0).getText();

    return t;
  }

  private static String varNode(CommonTree node, int depth) {
    // TODO
    return "";
  }

  private static String ifNode(CommonTree node, int depth) {
    // TODO
    return "";
  }

  private static String forNode(CommonTree node, int depth) {
    // TODO
    return "";
  }

  private static String whileNode(CommonTree node, int depth) {
    // TODO
    return "";
  }

  private static String assignNode(CommonTree node, int depth) {
    // TODO
    return "";
  }

  private static String foreachNode(CommonTree node, int depth) {
    // TODO
    return "";
  }

  private static String nopNode(CommonTree node, int depth) {
    return depthToString(depth) + "def nop():\n" + depthToString(depth+1) + "pass\n";
  }

  private static String printNode(CommonTree node, int depth) {
    node.getChild(0).getText();
    return depthToString(depth) + "print(" + node.getChild(0).getText() + ")\n";
  }

  private static String depthToString(int depth) {
    String s = "";
    for (int i = 0; i < depth; i++) {
      s += "  ";
    }
    return s;
  }

}
