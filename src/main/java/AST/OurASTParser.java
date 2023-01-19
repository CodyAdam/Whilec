package AST;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.TokenStream;

public class OurASTParser extends ASTParser {
  public OurASTParser(TokenStream input) {
    super(input, new RecognizerSharedState());
  }

  public OurASTParser(TokenStream input, RecognizerSharedState state) {
    super(input, state);
  }

  @Override
  public void reportError(RecognitionException e) {
    throw new RuntimeException(e);
  }
}
