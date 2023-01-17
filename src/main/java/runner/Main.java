package runner;
// import Validation.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.Tree;

import AST.ASTLexer;
import AST.ASTParser;
import AST.ASTPrinter;
import C3A.Generator;
import C3A.Instructions;
import Validation.FunctionNameNUsageValidator;
import Validation.PreCompileValidator;
import Validation.TypingValidator;
import Validation.VariableNameNUsageValidator;

public class Main {

    public static void main(String[] args) throws Exception {
        String filepath;
        if (args.length != 1) {
            // System.err.println("Wrong number of arguments, expected 1, got " +
            // args.length);
            filepath = "test/string.while";
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
        PreCompileValidator validator = new PreCompileValidator(filepath);
        validator.addValidator(new FunctionNameNUsageValidator());
        validator.addValidator(new VariableNameNUsageValidator());
        validator.addValidator(new TypingValidator());
        validator.validate(tree);

        // Generate 3-address code
        Generator generator = new Generator(tree);
        Instructions code3adress = generator.getInstructions();
        // System.out.println("\n--- 3 Adress Code Start ---\n" + code3adress + "\n--- 3
        // Adress Code End ---\n");

        // Generate target code from 3-address code
        String basePythonFilePath = "resources/base.py";
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(basePythonFilePath), "UTF-8"));
        String basePythonFile = reader.lines().reduce("", (a, b) -> a + b + "\n");
        reader.close();
        String outputPython = basePythonFile.replaceFirst("# CODE INSERTED HERE", code3adress.toTargetCode());

        // Write output to file
        Path path = Paths.get("output.py");
        Files.write(path, outputPython.getBytes());

        // Run the output file with python
        System.out.println("Output :");
        ProcessBuilder OSRunner = new ProcessBuilder("python", "output.py");
        OSRunner.inheritIO();
        Process process = OSRunner.start();
        process.waitFor();
    }
}
