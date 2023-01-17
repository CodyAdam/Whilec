package C3A;

public class Comment extends Instruction {
  private String comment;

  public Comment(String comment) {
    this.comment = comment;
  }

  public String toString() {
    return "// " + comment;
  }

  @Override
  public String toPython(Indent indent) {
    return indent + "# " + comment;
  } 

}
