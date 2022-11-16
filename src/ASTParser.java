// $ANTLR 3.5.3 ./AST.g 2022-10-24 11:42:10

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class ASTParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASSIGN", "COMMAND", "COMMANDS", 
		"EXPRESSION", "EXPRS", "EXPR_BASE", "FOR", "FOREACH", "FUNCTION", "IF", 
		"INPUT", "NOP", "OUTPUT", "ROOT", "SYMBOL", "VARIABLE", "VARS", "WHILE", 
		"'.'"
	};
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
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public ASTParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public ASTParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return ASTParser.tokenNames; }
	@Override public String getGrammarFileName() { return "./AST.g"; }


	public static class program_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "program"
	// ./AST.g:29:1: program : ( '.' )* -> ^( FUNCTION ^( INPUT ) NOP ^( VARS VARIABLE ) ) ;
	public final ASTParser.program_return program() throws RecognitionException {
		ASTParser.program_return retval = new ASTParser.program_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal1=null;

		Object char_literal1_tree=null;
		RewriteRuleTokenStream stream_22=new RewriteRuleTokenStream(adaptor,"token 22");

		try {
			// ./AST.g:29:9: ( ( '.' )* -> ^( FUNCTION ^( INPUT ) NOP ^( VARS VARIABLE ) ) )
			// ./AST.g:29:11: ( '.' )*
			{
			// ./AST.g:29:11: ( '.' )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==22) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// ./AST.g:29:12: '.'
					{
					char_literal1=(Token)match(input,22,FOLLOW_22_in_program102);  
					stream_22.add(char_literal1);

					}
					break;

				default :
					break loop1;
				}
			}


			// AST REWRITE
			// elements: 
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 29:17: -> ^( FUNCTION ^( INPUT ) NOP ^( VARS VARIABLE ) )
			{
				// ./AST.g:29:19: ^( FUNCTION ^( INPUT ) NOP ^( VARS VARIABLE ) )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNCTION, "FUNCTION"), root_1);
				// ./AST.g:29:30: ^( INPUT )
				{
				Object root_2 = (Object)adaptor.nil();
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(INPUT, "INPUT"), root_2);
				adaptor.addChild(root_1, root_2);
				}

				adaptor.addChild(root_1, (Object)adaptor.create(NOP, "NOP"));
				// ./AST.g:29:43: ^( VARS VARIABLE )
				{
				Object root_2 = (Object)adaptor.nil();
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(VARS, "VARS"), root_2);
				adaptor.addChild(root_2, (Object)adaptor.create(VARIABLE, "VARIABLE"));
				adaptor.addChild(root_1, root_2);
				}

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "program"

	// Delegated rules



	public static final BitSet FOLLOW_22_in_program102 = new BitSet(new long[]{0x0000000000400002L});
}
