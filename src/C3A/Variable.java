package C3A;

public class Variable<T> {
  private String name;
  private T value;

  public Variable(String name, T value) {
    this.name = name;
    this.value = value;
  }

  public Variable(String name) {
    this.name = name;
    this.value = null;
  }

  public String getName() {
    return name;
  }

  public T getValue() {
    return value;
  }

  @Override
  public String toString() {
    return getName();
  }
}
