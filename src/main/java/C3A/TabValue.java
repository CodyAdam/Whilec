package C3A;

public class TabValue extends ToAssign {
  private Variable tab;
  private int index;

  public TabValue(Variable tab, int index) {
    this.tab = tab;
    this.index = index;
  }

  @Override
  public String toString() {
    return tab.getName() + "[" + index + "]";
  }

  @Override
  public String toPython() {
    return tab.getName() + "[" + index + "]";
  }

    public Variable getTab() {
        return tab;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof TabValue){
            TabValue other = (TabValue) o;
            return this.tab.equals(other.tab) && this.index == other.index;
        }
        return false;
    }
}
