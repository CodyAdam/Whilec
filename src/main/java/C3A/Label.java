package C3A;

import java.util.function.Function;

public class Label extends Instruction {
  private String label;
  static int count = 0;
  public Function<Indent, String> toPythonCallback;

  public Label(String label) {
    this.label = label + "_" + count;
    count++;
    this.toPythonCallback = (indent) -> {
      return "";
    };
  }

  @Override
  public String toString() {
    return label + ":";
  }

  @Override
  public String toPython(Indent indent) {
    return this.toPythonCallback.apply(indent);
  }
}
