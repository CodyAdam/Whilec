import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.Tree;

import C3A.C3AGenerator;
import C3A.Instructions;

import org.antlr.runtime.ANTLRFileStream;

public class Main {
    public static void main(String[] args) throws Exception {
        String filepath;
        if (args.length != 1) {
            // System.err.println("Wrong number of arguments, expected 1, got " + args.length);
            filepath = "test/functions.while";
        } else {
            filepath = args[0];
        }
        CharStream cs = new ANTLRFileStream(filepath);
        ASTLexer lexer = new ASTLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream();
        tokens.setTokenSource(lexer);
        ASTParser parser = new ASTParser(tokens);

        var prog = parser.program();
        prog.getStart();
        Tree tree = (Tree) prog.getTree();

        C3AGenerator c3a = new C3AGenerator(tree);
        Instructions code3adress = c3a.getInstructions();
        System.out.println(code3adress);
    }
}
