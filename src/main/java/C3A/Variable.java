package C3A;

public class Variable extends ToAssign {
  private String name;
  static int count = 0;

  public Variable(String name) {
    this.name = name + "_" + count;
    count++;
  }

  public Variable(String name, boolean extra) {
    if(!extra) this.name = name;
    else {
        this.name = name + "_" + count;
        count++;
    }
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return getName();
  }

  @Override
  public String toPython() {
    return getName() + ".copy()";
  }

  @Override
    public boolean equals(Object o) {
        if (o instanceof Variable) {
        Variable other = (Variable) o;
        return this.name.equals(other.name);
        }
        return false;
    }

}
