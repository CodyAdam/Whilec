package C3A;

public class TabValue extends ToAssign {
  private String tab;
  private String index;

  public TabValue(String tab, String index) {
    this.tab = tab;
    this.index = index;
  }

  @Override
  public String toString() {
    return tab + "[" + index + "]";
  }

}
