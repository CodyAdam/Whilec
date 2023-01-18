package C3A;

import java.util.ArrayList;
import java.util.Arrays;

public class Symbol extends ToAssign {
  private String value;
  static int count = 0;
  public static final ArrayList<String> whitelist = new ArrayList<String>(
      Arrays.asList("main", "bool", "int", "string"));

  public Symbol(String value) {
    if (whitelist.contains(value))
      this.value = value;
    else {
      this.value = value + count;
      count++;
    }
  }

  public Symbol(String value, boolean fixedName) {
    if (fixedName)
      this.value = value;
    else {
      this.value = value + count;
      count++;
    }
  }

  public String getValue() {
    return value;
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
