package runner;

// import Validation.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

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
import translate.PythonTranslator;

public class Main {

    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            // System.err.println("Wrong number of arguments, expected at least 1, got " +
            // args.length);
            // System.exit(1);
        }
        args = new String[] { "test/bad/multipleNameFunction.while" };
        String filepath = args[0];

        Boolean verbose = false;
        Boolean execute = false;
        Boolean debug = false;
        for (String arg : args) {
            if (arg.equals("-v")) {
                verbose = true;
            }
            if (arg.equals("-x")) {
                execute = true;
            }
            if (arg.equals("-d")) {
                debug = true;
            }
        }
        String[] argsWithoutOptions = Arrays.stream(args).filter(s -> !s.startsWith("-")).toArray(String[]::new);

        // Parse the input file
        CharStream cs = new ANTLRFileStream(filepath);
        ASTLexer lexer = new ASTLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream();
        tokens.setTokenSource(lexer);
        ASTParser parser = new ASTParser(tokens);
        var prog = parser.program();
        Tree tree = (Tree) prog.getTree();

        // Print the AST to PlantUML
        if(debug){
            System.out.println("Printing AST to ./ASTPrintend.puml ...");
            ASTPrinter printer = new ASTPrinter();
            printer.printTree(tree);
            printer.save("ASTPrinted.puml");
        }


        // Validate the AST
        File filepathAsFile = new File(filepath);
        PreCompileValidator validator = new PreCompileValidator(filepathAsFile.getAbsolutePath());
        validator.addValidator(new FunctionNameNUsageValidator());
        validator.addValidator(new VariableNameNUsageValidator());
        validator.addValidator(new TypingValidator());
        validator.validate(tree);

        // Generate 3-address code
        Generator generator = new Generator(tree, argsWithoutOptions);
        Instructions code3adress = generator.getInstructions();
        if (debug)
            System.out.println("\n--- 3 Adress Code Start ---\n" + code3adress + "\n--- 3 Adress Code End ---\n");

        // Generate target code from 3-address code
        String basePythonFilePath = "resources/base.py";
        if (verbose)
            basePythonFilePath = "resources/base_verbose.py";
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(basePythonFilePath), "UTF-8"));
        String basePythonFile = reader.lines().reduce("", (a, b) -> a + b + "\n");
        reader.close();
        PythonTranslator python = new PythonTranslator();
        String outputPython = basePythonFile.replaceFirst("# CODE INSERTED HERE", python.from(code3adress));

        // Write output to file
        Path path = Paths.get("output.py");
        Files.write(path, outputPython.getBytes());
        if (verbose)
            System.out.println("File output.py generated at " + path.toAbsolutePath().toString());

        // Run the output file with python
        if (execute) {
            ProcessBuilder OSRunner = new ProcessBuilder("python", "output.py");
            OSRunner.inheritIO();
            Process process = OSRunner.start();
            process.waitFor();
        }
    }
}
