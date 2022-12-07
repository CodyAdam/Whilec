// import Validation.*;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

import C3A.C3A;
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
        CommonTree tree = (CommonTree) prog.getTree();

        System.out.println(tree.getToken());
    }
}
