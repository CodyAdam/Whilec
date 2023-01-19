package AST;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.TokenStream;

import Validation.VPrinter;

public class OurASTParser extends ASTParser {
  private String filepath;

  public OurASTParser(TokenStream input, String filepath) {
    super(input, new RecognizerSharedState());
    this.filepath = filepath;
  }

  public OurASTParser(TokenStream input, RecognizerSharedState state, String filepath) {
    super(input, state);
    this.filepath = filepath;
  }

  @Override
  public void reportError(RecognitionException e) {
    VPrinter.getInstance().printError("Syntax error during parsing : " + getErrorMessage(e, tokenNames), filepath, e.line, e.charPositionInLine);
    System.exit(1);
  }
}
