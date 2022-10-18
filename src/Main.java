import org.antlr.runtime.CharStream;
import org.antlr.runtime.ANTLRFileStream;

public class Main {
    public static void main(String[] args) throws Exception {
        String filepath;
        if (args.length != 1) {
            System.err.println("Wrong number of arguments, expected 1, got " + args.length);
            filepath = "test/1.while";
        } else {
            filepath = args[0];
        }
        CharStream cs = new ANTLRFileStream(filepath);

        System.out.println(cs.toString());

        JavaParserLexer lexer = new JavaParserLexer(cs);

    }
}
