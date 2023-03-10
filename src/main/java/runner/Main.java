package runner;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import Optimization.DeadCodeOptimizer;
import Optimization.GlobalOptimizer;
import Optimization.SubExpressionOptimizer;
import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.Tree;

import AST.ASTLexer;
import AST.ASTParser;
import AST.ASTPrinter;
import AST.OurASTParser;
import C3A.Generator;
import C3A.Instructions;
import Validation.FunctionNameNUsageValidator;
import Validation.PreCompileValidator;
import Validation.TypingValidator;
import Validation.VariableNameNUsageValidator;
import translate.PythonTranslator;

public class Main {

    public static boolean verbose = false;
    public static boolean execute = false;
    public static boolean debug = false;
    public static boolean optimize = false;

    public static void main(String[] args) throws Exception {

        // for debugging
        //args = new String[] { "sample/good/integers.while", "-x", "-o", "-v", "-d" };

        if (args.length == 0) {
            System.err.println("Wrong number of arguments, expected at least 1, got " +
                    args.length);
            System.exit(1);
        }

        String filepath = args[0];
        File filepathAsFile = new File(filepath);
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
            if(arg.equals("-o")){
                optimize = true;
            }
        }
        String[] argsWithoutOptions = Arrays.stream(args).filter(s -> !s.startsWith("-")).toArray(String[]::new);

        // Parse the input file
        CharStream cs = new ANTLRFileStream(filepath);
        ASTLexer lexer = new ASTLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream();
        tokens.setTokenSource(lexer);
        ASTParser parser = new OurASTParser(tokens, filepathAsFile.getAbsolutePath());
        var prog = parser.program();
        Tree tree = (Tree) prog.getTree();

        // Print the AST to PlantUML
        if (debug) {
            System.out.println("Printing AST to ./ASTPrintend.puml ...");
            ASTPrinter printer = new ASTPrinter();
            printer.printTree(tree);
            printer.save("ASTPrinted.puml");
        }

        // Validate the AST

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

        // Optimize 3-address code
        if(optimize){
            GlobalOptimizer optimizer = new GlobalOptimizer();
            optimizer.addOptimizer(new SubExpressionOptimizer());
            optimizer.addOptimizer(new DeadCodeOptimizer());
            optimizer.optimize(code3adress);
        }

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
