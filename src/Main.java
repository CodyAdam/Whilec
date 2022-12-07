
// import Validation.*;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.Tree;

import C3A.Generator;
import C3A.Instructions;

import org.antlr.runtime.ANTLRFileStream;

public class Main {

    public static void main(String[] args) throws Exception {
        String filepath;
        if (args.length != 1) {
            // System.err.println("Wrong number of arguments, expected 1, got " +
            // args.length);
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


        ASTPrinter printer = new ASTPrinter();
        printer.printTree(tree);
        printer.save("ASTPrinted.puml");

        // PreCompileValidator validator = new PreCompileValidator();
        // validator.addValidator(new FunctionNameNUsageValidator());
        // validator.addValidator(new VariableNameNUsageValidator());
        // validator.addValidator(new TypingValidator());
        // validator.validate(tree);

        Generator generator = new Generator(tree);
        Instructions code3adress = generator.getInstructions();
        System.out.println(code3adress);

    }
}
