package translate;

import java.util.Iterator;

import C3A.IfzGoto;
import C3A.Indent;
import C3A.Instruction;
import C3A.Instructions;
import C3A.Label;

public class PythonTranslator extends Translator {

  @Override
  public String from(Instructions instructions) {
    String s = "";
    Indent indent = new Indent();
    Iterator<Instruction> it = instructions.getInstructions().iterator();
    while (it.hasNext()) {
      s += multiplexer(it.next(), it, indent);
      if (it.hasNext())
        s += "\n";
    }
    return s;
  }

  private String ifs(Instruction current, Iterator<Instruction> it, Indent indent) {
    IfzGoto ifz = (IfzGoto) current;
    Label elseLabel = ifz.getElseLabel();
    Label endIfLabel = ifz.getEndIfLabel();
    String s = ifz.toPython(indent);

    while (it.hasNext()) {
      Instruction i = it.next();
      if (i instanceof Label && ((Label) i) == elseLabel) {
        indent.dec();
        s += indent + "else:\n";
        indent.inc();
        s += indent + "pass\n";
      } else if (i instanceof Label && ((Label) i) == endIfLabel) {
        indent.dec();
        return s;
      } else
        s += multiplexer(i, it, indent);
      if (it.hasNext())
        s += "\n";
    }
    return s;

  }

  private String fors(Instruction current, Iterator<Instruction> it, Indent indent) {
    IfzGoto ifz = (IfzGoto) it.next();
    Label forEnd = ifz.getEndIfLabel();
    String s = indent + String.format("while %s.toInt() > 0:\n", ifz.getV().getName());
    indent.inc();
    while (it.hasNext()) {
      Instruction i = it.next();
      if (i instanceof Label && ((Label) i) == forEnd) {
        indent.dec();
        return s;
      } else
        s += multiplexer(i, it, indent);
      if (it.hasNext())
        s += "\n";
    }
    return s;
  }

  private String whiles(Instruction current, Iterator<Instruction> it, Indent indent) {
    IfzGoto ifz = (IfzGoto) it.next();
    Label whileEnd = ifz.getEndIfLabel();
    String s = indent + String.format("while %s.toBool():\n", ifz.getV().getName());
    indent.inc();
    while (it.hasNext()) {
      Instruction i = it.next();
      if (i instanceof Label && ((Label) i) == whileEnd) {
        indent.dec();
        return s;
      } else
        s += multiplexer(i, it, indent);
      if (it.hasNext())
        s += "\n";
    }
    return s;
  }

  private String multiplexer(Instruction i, Iterator<Instruction> it, Indent indent) {
    String s = "";
    if (i instanceof IfzGoto && ((IfzGoto) i).getElseLabel().getName().startsWith("if_else"))
      s += ifs(i, it, indent);
    else if (i instanceof Label && ((Label) i).getName().startsWith("for_start"))
      s += fors(i, it, indent);
    else if (i instanceof Label && ((Label) i).getName().startsWith("while_start"))
      s += whiles(i, it, indent);
    else
      s += i.toPython(indent);
    return s;
  }
}
