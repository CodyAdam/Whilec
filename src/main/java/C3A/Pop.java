package C3A;

public class Pop extends ToAssign {
  public Pop() {
  }

  @Override
  public String toString() {
    return "pop";
  }

  @Override
  public String toPython() {
    return this.stack + ".pop()";
  }
}
