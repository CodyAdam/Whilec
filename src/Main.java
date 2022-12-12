
// import Validation.*;
import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.Tree;

import AST.ASTLexer;
import AST.ASTParser;
import AST.ASTPrinter;
import C3A.Generator;
import C3A.Instructions;

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

        // Parse the input file
        CharStream cs = new ANTLRFileStream(filepath);
        ASTLexer lexer = new ASTLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream();
        tokens.setTokenSource(lexer);
        ASTParser parser = new ASTParser(tokens);
        var prog = parser.program();
        Tree tree = (Tree) prog.getTree();

        // Print the AST to PlantUML
        ASTPrinter printer = new ASTPrinter();
        printer.printTree(tree);
        printer.save("ASTPrinted.puml");

        // Validate the AST
        // PreCompileValidator validator = new PreCompileValidator();
        // validator.addValidator(new FunctionNameNUsageValidator());
        // validator.addValidator(new VariableNameNUsageValidator());
        // validator.addValidator(new TypingValidator());
        // validator.validate(tree);

        // Generate 3-address code
        Generator generator = new Generator(tree);
        Instructions code3adress = generator.getInstructions();
        System.out.println("\n--- 3 Adress Code Start ---\n" + code3adress + "\n--- 3 Adress Code End ---\n");

    }
}
