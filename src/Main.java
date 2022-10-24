import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.ANTLRFileStream;

public class Main {
    public static void main(String[] args) throws Exception {
        String filepath;
        if (args.length != 1) {
            System.err.println("Wrong number of arguments, expected 1, got " + args.length);
            filepath = "test/nop.while";
        } else {
            filepath = args[0];
        }
        CharStream cs = new ANTLRFileStream(filepath);

        System.out.println(cs.toString());

        ASTLexer lexer = new ASTLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream();
        tokens.setTokenSource(lexer);
        ASTParser parser = new ASTParser(tokens);

        var prog = parser.program();
        prog.getStart();
        System.out.println(prog.getTree());
        
        System.out.println(prog.getTemplate());

    }
}
