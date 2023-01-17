package C3A;

public class Symbol extends ToAssign {
  private String value;

  public Symbol(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "\"" + value + "\"";
  }

  @Override
  public String toPython() {
    return this.binTree + "(key= \"" + value + "\")";
  }

}
