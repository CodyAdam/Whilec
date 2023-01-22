package C3A;

public class Push extends Instruction{
  private Variable arg;

  public Push(Variable arg) {
    this.arg = arg;
  }

  @Override
  public String toString() {
    return "push " + arg;
  }

  @Override
  public String toPython(Indent indent) {
    return indent + this.stack+".append("+arg.getName()+")";
  }

    public Variable getV() {
        return arg;
    }
}
