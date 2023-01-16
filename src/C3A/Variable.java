package C3A;

public class Variable extends ToAssign {
  private String name;
  static int count = 0;

  public Variable(String name) {
    this.name = name + "_" + count;
    count++;
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
    return getName();
  }

  
}
