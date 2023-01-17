package Validation;

import java.util.*;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

import AST.ASTLexer;
import AST.ASTParser;

public class FunctionNameNUsageValidator extends Validator {

    HashSet<String> notVariable = new HashSet<>(Arrays.asList("cons", "hd", "tl", "list", "nil", "nop", "if", "then", "fi", "while", "do", "od", "foreach", "in", "function", "read", "write", "true", "false"));

    @Override
    public void validate(Tree tree, HashMap<String, Function> functions) throws Exception {
        List<String> functionNames = new ArrayList<>();
        for (int i = 0; i < tree.getChildCount(); i++) {
            String functionName = tree.getChild(i).getChild(0).getText();
            if(functionNames.contains(functionName)) {
                throw new Exception("Multiple declarations with the same name");
            }
            functionNames.add(functionName);
            if(notVariable.contains(functionName)) {
                throw new Exception("Invalid function name");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        String filepath = "/home/pataubeur/IdeaProjects/Project_TLC/test/badfunctionname.while";
        CharStream cs = new ANTLRFileStream(filepath);
        ASTLexer lexer = new ASTLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream();
        tokens.setTokenSource(lexer);
        ASTParser parser = new ASTParser(tokens);

        var prog = parser.program();
        prog.getStart();
        CommonTree tree = (CommonTree) prog.getTree();

        PreCompileValidator validator = new PreCompileValidator(filepath);
        validator.addValidator(new FunctionNameNUsageValidator());
        //validator.addValidator(new VariableNameNUsageValidator());
        //validator.addValidator(new TypingValidator());
        validator.validate(tree);
    }

}
