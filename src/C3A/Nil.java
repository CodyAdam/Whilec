package C3A;

public class Nil extends ToAssign {
  @Override
  public String toString() {
    return "nil";
  }

  @Override
  public String toPython() {
    return this.binTree + "(key= \"NIL\")";
  }

}
