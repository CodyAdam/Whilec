package C3A;

public class Push extends Instruction{
  private Variable arg;

  public Push(Variable arg) {
    this.arg = arg;
  }

  @Override
  public String toString() {
    return "param " + arg;
  }

  @Override
  public String toPython(Indent indent) {
    return this.stack+".append("+arg.getName()+")";
  }
}
