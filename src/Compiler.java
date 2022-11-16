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
}
