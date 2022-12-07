// $ANTLR 3.5.3 AST__.g 2022-12-07 08:19:01

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class ASTLexer extends Lexer {
	public static final int EOF=-1;
	public static final int T__22=22;
	public static final int ASSIGN=4;
	public static final int COMMAND=5;
	public static final int COMMANDS=6;
	public static final int EXPRESSION=7;
	public static final int EXPRS=8;
	public static final int EXPR_BASE=9;
	public static final int FOR=10;
	public static final int FOREACH=11;
	public static final int FUNCTION=12;
	public static final int IF=13;
	public static final int INPUT=14;
	public static final int NOP=15;
	public static final int OUTPUT=16;
	public static final int ROOT=17;
	public static final int SYMBOL=18;
	public static final int VARIABLE=19;
	public static final int VARS=20;
	public static final int WHILE=21;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public ASTLexer() {} 
	public ASTLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public ASTLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "AST__.g"; }

	// $ANTLR start "T__22"
	public final void mT__22() throws RecognitionException {
		try {
			int _type = T__22;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// AST__.g:2:7: ( '.' )
			// AST__.g:2:9: '.'
			{
			match('.'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__22"

	@Override
	public void mTokens() throws RecognitionException {
		// AST__.g:1:8: ( T__22 )
		// AST__.g:1:10: T__22
		{
		mT__22(); 

		}

	}



}
