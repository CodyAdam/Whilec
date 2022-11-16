import org.antlr.runtime.tree.CommonTree;

public class Compiler {
  CommonTree tree;
  public Compiler(CommonTree root) {
    tree = root;
  }

  public String getCompiledCode() {
    // TODO
    return "";
  }

  public String toString(){
    return getCompiledCode();
  }

  private String rootNode(CommonTree node, int depth) {
    //TODO
    return "";
  }

  private String mainNode(CommonTree node, int depth) {
    //TODO
    return "";
  }

  private String functionNode(CommonTree node, int depth) {
    //TODO
    return "";
  }

  private String expressionsNode(CommonTree node, int depth) {
    //TODO
    return "";
  }

  private String expressionNode(CommonTree node, int depth) {
    //TODO
    return "";
  }

  private String varsNode(CommonTree node, int depth) {
    String t = node.getChild(0).getText();

    return t;
  } 

  private String varNode(CommonTree node, int depth) {
    //TODO
    return "";
  }

  private String ifNode(CommonTree node, int depth) {
    //TODO
    return "";
  }

  private String forNode(CommonTree node, int depth) {
    //TODO
    return "";
  }

  private String whileNode(CommonTree node, int depth) {
    //TODO
    return "";
  }

  private String assignNode(CommonTree node, int depth) {
    //TODO
    return "";
  }

  private String foreachNode(CommonTree node, int depth) {
    //TODO
    return "";
  }

  private String nopNode(CommonTree node, int depth) {
    return depthToString(depth) + "def nop():\n" + depthToString(depth+1) + "pass\n";
  }

  private String printNode(CommonTree node, int depth) {
    node.getChild(0).getText();
    return depthToString(depth) + "print(" + node.getChild(0).getText() + ")\n";
  }

  private String depthToString(int depth) {
    String s = "";
    for (int i = 0; i < depth; i++) {
      s += "  ";
    }
    return s;
  }

}
