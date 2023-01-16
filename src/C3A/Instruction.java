package C3A;

public abstract class Instruction {
  final protected String stack = "stack";
  final protected String binTree = "BinTree";

  public abstract String toString();

  public abstract String toPython(Indent indent);

}
