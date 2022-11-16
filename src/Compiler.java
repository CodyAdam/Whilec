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

  private String rootNode(CommonTree node) {
    //TODO
    return "";
  }

  private String mainNode(CommonTree node) {
    //TODO
    return "";
  }

  private String functionNode(CommonTree node) {
    //TODO
    return "";
  }

  private String expressionsNode(CommonTree node) {
    //TODO
    return "";
  }

  private String expressionNode(CommonTree node) {
    //TODO
    return "";
  }

  private String varsNode(CommonTree node) {
    String t = node.getChild(0).getText();

    return t;
  } 

  private String varNode(CommonTree node) {
    //TODO
    return "";
  }

  private String ifNode(CommonTree node) {
    //TODO
    return "";
  }

  private String forNode(CommonTree node) {
    //TODO
    return "";
  }

  private String whileNode(CommonTree node) {
    //TODO
    return "";
  }

  private String assignNode(CommonTree node) {
    //TODO
    return "";
  }

  private String foreachNode(CommonTree node) {
    //TODO
    return "";
  }

  private String nopNode(CommonTree node) {
    //TODO
    return "";
  }

  private String printNode(CommonTree node) {
    //TODO
    return "";
  }

}
