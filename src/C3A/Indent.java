package C3A;

public class Indent {
  int count = 0;
  final String spaces = "  ";

  public Indent() {
    count = 0;
  }  

  public Indent(int count) {
    this.count = count;
  }

  public void inc() {
    count++;
  }

  public void dec() {
    count--;
  }

  public String toString() {
    String s = "";
    for (int i = 0; i < count; i++) {
      s += spaces;
    }
    return s;
  }
}
