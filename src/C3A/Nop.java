package C3A;

public class Nop extends Instruction{

  @Override
  public String toString() {
    return "NOP";
  }

  @Override
  public String toPython(Indent indent) {
    return indent + "pass";
  }
  
}
