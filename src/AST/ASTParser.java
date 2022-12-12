package AST;
// $ANTLR 3.5.3 ./grammars/AST.g 2022-12-12 12:09:11

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class ASTParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASSIGN", "COMMAND", "COMMANDS", 
		"CONS", "DIGIT", "ELSECOMMANDS", "EQUALS", "EXPRESSION", "EXPRS", "EXPR_BASE", 
		"FOR", "FOREACH", "FUNCDEF", "FUNCTION", "FUNCTIONCALL", "HEAD", "IF", 
		"INPUT", "LIST", "NIL", "NOP", "OUTPUT", "ROOT", "SYMBOL", "TAIL", "TOKENS", 
		"VARIABLE", "VARS", "WHILE", "WS", "' = '", "'%'", "'('", "')'", "','", 
		"':'", "':='", "';'", "'cons '", "'do'", "'else'", "'fi'", "'for'", "'foreach'", 
		"'function'", "'hd '", "'if'", "'in'", "'list '", "'nil'", "'nop'", "'od'", 
		"'read'", "'then'", "'tl '", "'while'", "'write'"
	};
	public static final int EOF=-1;
	public static final int T__34=34;
	public static final int T__35=35;
	public static final int T__36=36;
	public static final int T__37=37;
	public static final int T__38=38;
	public static final int T__39=39;
	public static final int T__40=40;
	public static final int T__41=41;
	public static final int T__42=42;
	public static final int T__43=43;
	public static final int T__44=44;
	public static final int T__45=45;
	public static final int T__46=46;
	public static final int T__47=47;
	public static final int T__48=48;
	public static final int T__49=49;
	public static final int T__50=50;
	public static final int T__51=51;
	public static final int T__52=52;
	public static final int T__53=53;
	public static final int T__54=54;
	public static final int T__55=55;
	public static final int T__56=56;
	public static final int T__57=57;
	public static final int T__58=58;
	public static final int T__59=59;
	public static final int T__60=60;
	public static final int ASSIGN=4;
	public static final int COMMAND=5;
	public static final int COMMANDS=6;
	public static final int CONS=7;
	public static final int DIGIT=8;
	public static final int ELSECOMMANDS=9;
	public static final int EQUALS=10;
	public static final int EXPRESSION=11;
	public static final int EXPRS=12;
	public static final int EXPR_BASE=13;
	public static final int FOR=14;
	public static final int FOREACH=15;
	public static final int FUNCDEF=16;
	public static final int FUNCTION=17;
	public static final int FUNCTIONCALL=18;
	public static final int HEAD=19;
	public static final int IF=20;
	public static final int INPUT=21;
	public static final int LIST=22;
	public static final int NIL=23;
	public static final int NOP=24;
	public static final int OUTPUT=25;
	public static final int ROOT=26;
	public static final int SYMBOL=27;
	public static final int TAIL=28;
	public static final int TOKENS=29;
	public static final int VARIABLE=30;
	public static final int VARS=31;
	public static final int WHILE=32;
	public static final int WS=33;

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
	@Override public String getGrammarFileName() { return "./grammars/AST.g"; }


	public static class program_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "program"
	// ./grammars/AST.g:39:1: program : ( WS )* ( function ( WS )* )+ -> ^( ROOT ( function )+ ) ;
	public final ASTParser.program_return program() throws RecognitionException {
		ASTParser.program_return retval = new ASTParser.program_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token WS1=null;
		Token WS3=null;
		ParserRuleReturnScope function2 =null;

		Object WS1_tree=null;
		Object WS3_tree=null;
		RewriteRuleTokenStream stream_WS=new RewriteRuleTokenStream(adaptor,"token WS");
		RewriteRuleSubtreeStream stream_function=new RewriteRuleSubtreeStream(adaptor,"rule function");

		try {
			// ./grammars/AST.g:39:8: ( ( WS )* ( function ( WS )* )+ -> ^( ROOT ( function )+ ) )
			// ./grammars/AST.g:39:10: ( WS )* ( function ( WS )* )+
			{
			// ./grammars/AST.g:39:10: ( WS )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==WS) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// ./grammars/AST.g:39:10: WS
					{
					WS1=(Token)match(input,WS,FOLLOW_WS_in_program141);  
					stream_WS.add(WS1);

					}
					break;

				default :
					break loop1;
				}
			}

			// ./grammars/AST.g:39:14: ( function ( WS )* )+
			int cnt3=0;
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==48) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// ./grammars/AST.g:39:15: function ( WS )*
					{
					pushFollow(FOLLOW_function_in_program145);
					function2=function();
					state._fsp--;

					stream_function.add(function2.getTree());
					// ./grammars/AST.g:39:24: ( WS )*
					loop2:
					while (true) {
						int alt2=2;
						int LA2_0 = input.LA(1);
						if ( (LA2_0==WS) ) {
							alt2=1;
						}

						switch (alt2) {
						case 1 :
							// ./grammars/AST.g:39:24: WS
							{
							WS3=(Token)match(input,WS,FOLLOW_WS_in_program147);  
							stream_WS.add(WS3);

							}
							break;

						default :
							break loop2;
						}
					}

					}
					break;

				default :
					if ( cnt3 >= 1 ) break loop3;
					EarlyExitException eee = new EarlyExitException(3, input);
					throw eee;
				}
				cnt3++;
			}


			// AST REWRITE
			// elements: function
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 39:30: -> ^( ROOT ( function )+ )
			{
				// ./grammars/AST.g:39:33: ^( ROOT ( function )+ )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ROOT, "ROOT"), root_1);
				if ( !(stream_function.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_function.hasNext() ) {
					adaptor.addChild(root_1, stream_function.nextTree());
				}
				stream_function.reset();

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


	public static class function_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "function"
	// ./grammars/AST.g:41:1: function : 'function' WS SYMBOL ( WS )? ':' WS definition -> ^( FUNCTION ^( SYMBOL definition ) ) ;
	public final ASTParser.function_return function() throws RecognitionException {
		ASTParser.function_return retval = new ASTParser.function_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal4=null;
		Token WS5=null;
		Token SYMBOL6=null;
		Token WS7=null;
		Token char_literal8=null;
		Token WS9=null;
		ParserRuleReturnScope definition10 =null;

		Object string_literal4_tree=null;
		Object WS5_tree=null;
		Object SYMBOL6_tree=null;
		Object WS7_tree=null;
		Object char_literal8_tree=null;
		Object WS9_tree=null;
		RewriteRuleTokenStream stream_SYMBOL=new RewriteRuleTokenStream(adaptor,"token SYMBOL");
		RewriteRuleTokenStream stream_48=new RewriteRuleTokenStream(adaptor,"token 48");
		RewriteRuleTokenStream stream_39=new RewriteRuleTokenStream(adaptor,"token 39");
		RewriteRuleTokenStream stream_WS=new RewriteRuleTokenStream(adaptor,"token WS");
		RewriteRuleSubtreeStream stream_definition=new RewriteRuleSubtreeStream(adaptor,"rule definition");

		try {
			// ./grammars/AST.g:41:9: ( 'function' WS SYMBOL ( WS )? ':' WS definition -> ^( FUNCTION ^( SYMBOL definition ) ) )
			// ./grammars/AST.g:41:11: 'function' WS SYMBOL ( WS )? ':' WS definition
			{
			string_literal4=(Token)match(input,48,FOLLOW_48_in_function166);  
			stream_48.add(string_literal4);

			WS5=(Token)match(input,WS,FOLLOW_WS_in_function168);  
			stream_WS.add(WS5);

			SYMBOL6=(Token)match(input,SYMBOL,FOLLOW_SYMBOL_in_function170);  
			stream_SYMBOL.add(SYMBOL6);

			// ./grammars/AST.g:41:32: ( WS )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==WS) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// ./grammars/AST.g:41:32: WS
					{
					WS7=(Token)match(input,WS,FOLLOW_WS_in_function172);  
					stream_WS.add(WS7);

					}
					break;

			}

			char_literal8=(Token)match(input,39,FOLLOW_39_in_function175);  
			stream_39.add(char_literal8);

			WS9=(Token)match(input,WS,FOLLOW_WS_in_function177);  
			stream_WS.add(WS9);

			pushFollow(FOLLOW_definition_in_function179);
			definition10=definition();
			state._fsp--;

			stream_definition.add(definition10.getTree());

			// AST REWRITE
			// elements: SYMBOL, definition
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 41:53: -> ^( FUNCTION ^( SYMBOL definition ) )
			{
				// ./grammars/AST.g:41:56: ^( FUNCTION ^( SYMBOL definition ) )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNCTION, "FUNCTION"), root_1);
				// ./grammars/AST.g:41:67: ^( SYMBOL definition )
				{
				Object root_2 = (Object)adaptor.nil();
				root_2 = (Object)adaptor.becomeRoot(stream_SYMBOL.nextNode(), root_2);
				adaptor.addChild(root_2, stream_definition.nextTree());
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
	// $ANTLR end "function"


	public static class definition_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "definition"
	// ./grammars/AST.g:43:1: definition : 'read' WS ( input WS )? '%' WS commands WS '%' WS 'write' output -> ^( FUNCDEF ( input )? ^( COMMANDS commands ) ^( OUTPUT output ) ) ;
	public final ASTParser.definition_return definition() throws RecognitionException {
		ASTParser.definition_return retval = new ASTParser.definition_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal11=null;
		Token WS12=null;
		Token WS14=null;
		Token char_literal15=null;
		Token WS16=null;
		Token WS18=null;
		Token char_literal19=null;
		Token WS20=null;
		Token string_literal21=null;
		ParserRuleReturnScope input13 =null;
		ParserRuleReturnScope commands17 =null;
		ParserRuleReturnScope output22 =null;

		Object string_literal11_tree=null;
		Object WS12_tree=null;
		Object WS14_tree=null;
		Object char_literal15_tree=null;
		Object WS16_tree=null;
		Object WS18_tree=null;
		Object char_literal19_tree=null;
		Object WS20_tree=null;
		Object string_literal21_tree=null;
		RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
		RewriteRuleTokenStream stream_35=new RewriteRuleTokenStream(adaptor,"token 35");
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
		RewriteRuleTokenStream stream_WS=new RewriteRuleTokenStream(adaptor,"token WS");
		RewriteRuleSubtreeStream stream_output=new RewriteRuleSubtreeStream(adaptor,"rule output");
		RewriteRuleSubtreeStream stream_input=new RewriteRuleSubtreeStream(adaptor,"rule input");
		RewriteRuleSubtreeStream stream_commands=new RewriteRuleSubtreeStream(adaptor,"rule commands");

		try {
			// ./grammars/AST.g:43:11: ( 'read' WS ( input WS )? '%' WS commands WS '%' WS 'write' output -> ^( FUNCDEF ( input )? ^( COMMANDS commands ) ^( OUTPUT output ) ) )
			// ./grammars/AST.g:44:2: 'read' WS ( input WS )? '%' WS commands WS '%' WS 'write' output
			{
			string_literal11=(Token)match(input,56,FOLLOW_56_in_definition198);  
			stream_56.add(string_literal11);

			WS12=(Token)match(input,WS,FOLLOW_WS_in_definition200);  
			stream_WS.add(WS12);

			// ./grammars/AST.g:44:12: ( input WS )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==VARIABLE||LA5_0==WS) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// ./grammars/AST.g:44:13: input WS
					{
					pushFollow(FOLLOW_input_in_definition203);
					input13=input();
					state._fsp--;

					stream_input.add(input13.getTree());
					WS14=(Token)match(input,WS,FOLLOW_WS_in_definition205);  
					stream_WS.add(WS14);

					}
					break;

			}

			char_literal15=(Token)match(input,35,FOLLOW_35_in_definition209);  
			stream_35.add(char_literal15);

			WS16=(Token)match(input,WS,FOLLOW_WS_in_definition211);  
			stream_WS.add(WS16);

			pushFollow(FOLLOW_commands_in_definition213);
			commands17=commands();
			state._fsp--;

			stream_commands.add(commands17.getTree());
			WS18=(Token)match(input,WS,FOLLOW_WS_in_definition215);  
			stream_WS.add(WS18);

			char_literal19=(Token)match(input,35,FOLLOW_35_in_definition217);  
			stream_35.add(char_literal19);

			WS20=(Token)match(input,WS,FOLLOW_WS_in_definition219);  
			stream_WS.add(WS20);

			string_literal21=(Token)match(input,60,FOLLOW_60_in_definition221);  
			stream_60.add(string_literal21);

			pushFollow(FOLLOW_output_in_definition223);
			output22=output();
			state._fsp--;

			stream_output.add(output22.getTree());

			// AST REWRITE
			// elements: commands, input, output
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 44:65: -> ^( FUNCDEF ( input )? ^( COMMANDS commands ) ^( OUTPUT output ) )
			{
				// ./grammars/AST.g:44:68: ^( FUNCDEF ( input )? ^( COMMANDS commands ) ^( OUTPUT output ) )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNCDEF, "FUNCDEF"), root_1);
				// ./grammars/AST.g:44:78: ( input )?
				if ( stream_input.hasNext() ) {
					adaptor.addChild(root_1, stream_input.nextTree());
				}
				stream_input.reset();

				// ./grammars/AST.g:44:85: ^( COMMANDS commands )
				{
				Object root_2 = (Object)adaptor.nil();
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(COMMANDS, "COMMANDS"), root_2);
				adaptor.addChild(root_2, stream_commands.nextTree());
				adaptor.addChild(root_1, root_2);
				}

				// ./grammars/AST.g:44:106: ^( OUTPUT output )
				{
				Object root_2 = (Object)adaptor.nil();
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(OUTPUT, "OUTPUT"), root_2);
				adaptor.addChild(root_2, stream_output.nextTree());
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
	// $ANTLR end "definition"


	public static class input_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "input"
	// ./grammars/AST.g:46:1: input : ( inputsub )? -> ^( INPUT ( inputsub )? ) ;
	public final ASTParser.input_return input() throws RecognitionException {
		ASTParser.input_return retval = new ASTParser.input_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope inputsub23 =null;

		RewriteRuleSubtreeStream stream_inputsub=new RewriteRuleSubtreeStream(adaptor,"rule inputsub");

		try {
			// ./grammars/AST.g:46:6: ( ( inputsub )? -> ^( INPUT ( inputsub )? ) )
			// ./grammars/AST.g:46:8: ( inputsub )?
			{
			// ./grammars/AST.g:46:8: ( inputsub )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==WS) ) {
				int LA6_1 = input.LA(2);
				if ( (LA6_1==VARIABLE) ) {
					alt6=1;
				}
			}
			else if ( (LA6_0==VARIABLE) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// ./grammars/AST.g:46:8: inputsub
					{
					pushFollow(FOLLOW_inputsub_in_input252);
					inputsub23=inputsub();
					state._fsp--;

					stream_inputsub.add(inputsub23.getTree());
					}
					break;

			}


			// AST REWRITE
			// elements: inputsub
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 46:18: -> ^( INPUT ( inputsub )? )
			{
				// ./grammars/AST.g:46:21: ^( INPUT ( inputsub )? )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(INPUT, "INPUT"), root_1);
				// ./grammars/AST.g:46:29: ( inputsub )?
				if ( stream_inputsub.hasNext() ) {
					adaptor.addChild(root_1, stream_inputsub.nextTree());
				}
				stream_inputsub.reset();

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
	// $ANTLR end "input"


	public static class inputsub_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "inputsub"
	// ./grammars/AST.g:48:1: inputsub : ( ( ( WS )? VARIABLE ( WS )? ',' inputsub ) -> VARIABLE inputsub | ( WS )? VARIABLE -> VARIABLE );
	public final ASTParser.inputsub_return inputsub() throws RecognitionException {
		ASTParser.inputsub_return retval = new ASTParser.inputsub_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token WS24=null;
		Token VARIABLE25=null;
		Token WS26=null;
		Token char_literal27=null;
		Token WS29=null;
		Token VARIABLE30=null;
		ParserRuleReturnScope inputsub28 =null;

		Object WS24_tree=null;
		Object VARIABLE25_tree=null;
		Object WS26_tree=null;
		Object char_literal27_tree=null;
		Object WS29_tree=null;
		Object VARIABLE30_tree=null;
		RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
		RewriteRuleTokenStream stream_VARIABLE=new RewriteRuleTokenStream(adaptor,"token VARIABLE");
		RewriteRuleTokenStream stream_WS=new RewriteRuleTokenStream(adaptor,"token WS");
		RewriteRuleSubtreeStream stream_inputsub=new RewriteRuleSubtreeStream(adaptor,"rule inputsub");

		try {
			// ./grammars/AST.g:48:9: ( ( ( WS )? VARIABLE ( WS )? ',' inputsub ) -> VARIABLE inputsub | ( WS )? VARIABLE -> VARIABLE )
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==WS) ) {
				int LA10_1 = input.LA(2);
				if ( (LA10_1==VARIABLE) ) {
					int LA10_2 = input.LA(3);
					if ( (LA10_2==WS) ) {
						int LA10_3 = input.LA(4);
						if ( (LA10_3==38) ) {
							alt10=1;
						}
						else if ( (LA10_3==35) ) {
							alt10=2;
						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 10, 3, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}
					else if ( (LA10_2==38) ) {
						alt10=1;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 10, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 10, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA10_0==VARIABLE) ) {
				int LA10_2 = input.LA(2);
				if ( (LA10_2==WS) ) {
					int LA10_3 = input.LA(3);
					if ( (LA10_3==38) ) {
						alt10=1;
					}
					else if ( (LA10_3==35) ) {
						alt10=2;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 10, 3, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}
				else if ( (LA10_2==38) ) {
					alt10=1;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 10, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}

			switch (alt10) {
				case 1 :
					// ./grammars/AST.g:48:11: ( ( WS )? VARIABLE ( WS )? ',' inputsub )
					{
					// ./grammars/AST.g:48:11: ( ( WS )? VARIABLE ( WS )? ',' inputsub )
					// ./grammars/AST.g:48:12: ( WS )? VARIABLE ( WS )? ',' inputsub
					{
					// ./grammars/AST.g:48:12: ( WS )?
					int alt7=2;
					int LA7_0 = input.LA(1);
					if ( (LA7_0==WS) ) {
						alt7=1;
					}
					switch (alt7) {
						case 1 :
							// ./grammars/AST.g:48:12: WS
							{
							WS24=(Token)match(input,WS,FOLLOW_WS_in_inputsub270);  
							stream_WS.add(WS24);

							}
							break;

					}

					VARIABLE25=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_inputsub273);  
					stream_VARIABLE.add(VARIABLE25);

					// ./grammars/AST.g:48:25: ( WS )?
					int alt8=2;
					int LA8_0 = input.LA(1);
					if ( (LA8_0==WS) ) {
						alt8=1;
					}
					switch (alt8) {
						case 1 :
							// ./grammars/AST.g:48:25: WS
							{
							WS26=(Token)match(input,WS,FOLLOW_WS_in_inputsub275);  
							stream_WS.add(WS26);

							}
							break;

					}

					char_literal27=(Token)match(input,38,FOLLOW_38_in_inputsub278);  
					stream_38.add(char_literal27);

					pushFollow(FOLLOW_inputsub_in_inputsub280);
					inputsub28=inputsub();
					state._fsp--;

					stream_inputsub.add(inputsub28.getTree());
					}


					// AST REWRITE
					// elements: inputsub, VARIABLE
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 48:43: -> VARIABLE inputsub
					{
						adaptor.addChild(root_0, stream_VARIABLE.nextNode());
						adaptor.addChild(root_0, stream_inputsub.nextTree());
					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// ./grammars/AST.g:48:66: ( WS )? VARIABLE
					{
					// ./grammars/AST.g:48:66: ( WS )?
					int alt9=2;
					int LA9_0 = input.LA(1);
					if ( (LA9_0==WS) ) {
						alt9=1;
					}
					switch (alt9) {
						case 1 :
							// ./grammars/AST.g:48:66: WS
							{
							WS29=(Token)match(input,WS,FOLLOW_WS_in_inputsub291);  
							stream_WS.add(WS29);

							}
							break;

					}

					VARIABLE30=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_inputsub294);  
					stream_VARIABLE.add(VARIABLE30);


					// AST REWRITE
					// elements: VARIABLE
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 48:79: -> VARIABLE
					{
						adaptor.addChild(root_0, stream_VARIABLE.nextNode());
					}


					retval.tree = root_0;

					}
					break;

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
	// $ANTLR end "inputsub"


	public static class output_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "output"
	// ./grammars/AST.g:50:1: output : ( ( ( WS )? VARIABLE ( WS )? ',' output ) -> VARIABLE output | ( WS )? VARIABLE -> VARIABLE );
	public final ASTParser.output_return output() throws RecognitionException {
		ASTParser.output_return retval = new ASTParser.output_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token WS31=null;
		Token VARIABLE32=null;
		Token WS33=null;
		Token char_literal34=null;
		Token WS36=null;
		Token VARIABLE37=null;
		ParserRuleReturnScope output35 =null;

		Object WS31_tree=null;
		Object VARIABLE32_tree=null;
		Object WS33_tree=null;
		Object char_literal34_tree=null;
		Object WS36_tree=null;
		Object VARIABLE37_tree=null;
		RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
		RewriteRuleTokenStream stream_VARIABLE=new RewriteRuleTokenStream(adaptor,"token VARIABLE");
		RewriteRuleTokenStream stream_WS=new RewriteRuleTokenStream(adaptor,"token WS");
		RewriteRuleSubtreeStream stream_output=new RewriteRuleSubtreeStream(adaptor,"rule output");

		try {
			// ./grammars/AST.g:50:7: ( ( ( WS )? VARIABLE ( WS )? ',' output ) -> VARIABLE output | ( WS )? VARIABLE -> VARIABLE )
			int alt14=2;
			int LA14_0 = input.LA(1);
			if ( (LA14_0==WS) ) {
				int LA14_1 = input.LA(2);
				if ( (LA14_1==VARIABLE) ) {
					switch ( input.LA(3) ) {
					case WS:
						{
						int LA14_3 = input.LA(4);
						if ( (LA14_3==38) ) {
							alt14=1;
						}
						else if ( (LA14_3==EOF||LA14_3==WS||LA14_3==48) ) {
							alt14=2;
						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 14, 3, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case 38:
						{
						alt14=1;
						}
						break;
					case EOF:
					case 48:
						{
						alt14=2;
						}
						break;
					default:
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 14, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 14, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA14_0==VARIABLE) ) {
				switch ( input.LA(2) ) {
				case WS:
					{
					int LA14_3 = input.LA(3);
					if ( (LA14_3==38) ) {
						alt14=1;
					}
					else if ( (LA14_3==EOF||LA14_3==WS||LA14_3==48) ) {
						alt14=2;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 14, 3, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

					}
					break;
				case 38:
					{
					alt14=1;
					}
					break;
				case EOF:
				case 48:
					{
					alt14=2;
					}
					break;
				default:
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 14, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 14, 0, input);
				throw nvae;
			}

			switch (alt14) {
				case 1 :
					// ./grammars/AST.g:50:9: ( ( WS )? VARIABLE ( WS )? ',' output )
					{
					// ./grammars/AST.g:50:9: ( ( WS )? VARIABLE ( WS )? ',' output )
					// ./grammars/AST.g:50:10: ( WS )? VARIABLE ( WS )? ',' output
					{
					// ./grammars/AST.g:50:10: ( WS )?
					int alt11=2;
					int LA11_0 = input.LA(1);
					if ( (LA11_0==WS) ) {
						alt11=1;
					}
					switch (alt11) {
						case 1 :
							// ./grammars/AST.g:50:10: WS
							{
							WS31=(Token)match(input,WS,FOLLOW_WS_in_output306);  
							stream_WS.add(WS31);

							}
							break;

					}

					VARIABLE32=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_output309);  
					stream_VARIABLE.add(VARIABLE32);

					// ./grammars/AST.g:50:23: ( WS )?
					int alt12=2;
					int LA12_0 = input.LA(1);
					if ( (LA12_0==WS) ) {
						alt12=1;
					}
					switch (alt12) {
						case 1 :
							// ./grammars/AST.g:50:23: WS
							{
							WS33=(Token)match(input,WS,FOLLOW_WS_in_output311);  
							stream_WS.add(WS33);

							}
							break;

					}

					char_literal34=(Token)match(input,38,FOLLOW_38_in_output314);  
					stream_38.add(char_literal34);

					pushFollow(FOLLOW_output_in_output316);
					output35=output();
					state._fsp--;

					stream_output.add(output35.getTree());
					}


					// AST REWRITE
					// elements: output, VARIABLE
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 50:39: -> VARIABLE output
					{
						adaptor.addChild(root_0, stream_VARIABLE.nextNode());
						adaptor.addChild(root_0, stream_output.nextTree());
					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// ./grammars/AST.g:50:60: ( WS )? VARIABLE
					{
					// ./grammars/AST.g:50:60: ( WS )?
					int alt13=2;
					int LA13_0 = input.LA(1);
					if ( (LA13_0==WS) ) {
						alt13=1;
					}
					switch (alt13) {
						case 1 :
							// ./grammars/AST.g:50:60: WS
							{
							WS36=(Token)match(input,WS,FOLLOW_WS_in_output327);  
							stream_WS.add(WS36);

							}
							break;

					}

					VARIABLE37=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_output330);  
					stream_VARIABLE.add(VARIABLE37);


					// AST REWRITE
					// elements: VARIABLE
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 50:73: -> VARIABLE
					{
						adaptor.addChild(root_0, stream_VARIABLE.nextNode());
					}


					retval.tree = root_0;

					}
					break;

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
	// $ANTLR end "output"


	public static class commands_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "commands"
	// ./grammars/AST.g:52:1: commands : ( WS )? command ( ( WS )? ';' ( WS )? command )* ( ';' )? -> ( command )+ ;
	public final ASTParser.commands_return commands() throws RecognitionException {
		ASTParser.commands_return retval = new ASTParser.commands_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token WS38=null;
		Token WS40=null;
		Token char_literal41=null;
		Token WS42=null;
		Token char_literal44=null;
		ParserRuleReturnScope command39 =null;
		ParserRuleReturnScope command43 =null;

		Object WS38_tree=null;
		Object WS40_tree=null;
		Object char_literal41_tree=null;
		Object WS42_tree=null;
		Object char_literal44_tree=null;
		RewriteRuleTokenStream stream_WS=new RewriteRuleTokenStream(adaptor,"token WS");
		RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
		RewriteRuleSubtreeStream stream_command=new RewriteRuleSubtreeStream(adaptor,"rule command");

		try {
			// ./grammars/AST.g:52:9: ( ( WS )? command ( ( WS )? ';' ( WS )? command )* ( ';' )? -> ( command )+ )
			// ./grammars/AST.g:53:5: ( WS )? command ( ( WS )? ';' ( WS )? command )* ( ';' )?
			{
			// ./grammars/AST.g:53:5: ( WS )?
			int alt15=2;
			int LA15_0 = input.LA(1);
			if ( (LA15_0==WS) ) {
				alt15=1;
			}
			switch (alt15) {
				case 1 :
					// ./grammars/AST.g:53:5: WS
					{
					WS38=(Token)match(input,WS,FOLLOW_WS_in_commands347);  
					stream_WS.add(WS38);

					}
					break;

			}

			pushFollow(FOLLOW_command_in_commands350);
			command39=command();
			state._fsp--;

			stream_command.add(command39.getTree());
			// ./grammars/AST.g:53:17: ( ( WS )? ';' ( WS )? command )*
			loop18:
			while (true) {
				int alt18=2;
				int LA18_0 = input.LA(1);
				if ( (LA18_0==41) ) {
					int LA18_1 = input.LA(2);
					if ( (LA18_1==WS) ) {
						int LA18_3 = input.LA(3);
						if ( (LA18_3==VARIABLE||(LA18_3 >= 46 && LA18_3 <= 47)||LA18_3==50||LA18_3==54||LA18_3==59) ) {
							alt18=1;
						}

					}
					else if ( (LA18_1==VARIABLE||(LA18_1 >= 46 && LA18_1 <= 47)||LA18_1==50||LA18_1==54||LA18_1==59) ) {
						alt18=1;
					}

				}
				else if ( (LA18_0==WS) ) {
					int LA18_2 = input.LA(2);
					if ( (LA18_2==41) ) {
						alt18=1;
					}

				}

				switch (alt18) {
				case 1 :
					// ./grammars/AST.g:53:18: ( WS )? ';' ( WS )? command
					{
					// ./grammars/AST.g:53:18: ( WS )?
					int alt16=2;
					int LA16_0 = input.LA(1);
					if ( (LA16_0==WS) ) {
						alt16=1;
					}
					switch (alt16) {
						case 1 :
							// ./grammars/AST.g:53:18: WS
							{
							WS40=(Token)match(input,WS,FOLLOW_WS_in_commands353);  
							stream_WS.add(WS40);

							}
							break;

					}

					char_literal41=(Token)match(input,41,FOLLOW_41_in_commands356);  
					stream_41.add(char_literal41);

					// ./grammars/AST.g:53:26: ( WS )?
					int alt17=2;
					int LA17_0 = input.LA(1);
					if ( (LA17_0==WS) ) {
						alt17=1;
					}
					switch (alt17) {
						case 1 :
							// ./grammars/AST.g:53:26: WS
							{
							WS42=(Token)match(input,WS,FOLLOW_WS_in_commands358);  
							stream_WS.add(WS42);

							}
							break;

					}

					pushFollow(FOLLOW_command_in_commands361);
					command43=command();
					state._fsp--;

					stream_command.add(command43.getTree());
					}
					break;

				default :
					break loop18;
				}
			}

			// ./grammars/AST.g:53:40: ( ';' )?
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==41) ) {
				alt19=1;
			}
			switch (alt19) {
				case 1 :
					// ./grammars/AST.g:53:41: ';'
					{
					char_literal44=(Token)match(input,41,FOLLOW_41_in_commands366);  
					stream_41.add(char_literal44);

					}
					break;

			}


			// AST REWRITE
			// elements: command
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 53:47: -> ( command )+
			{
				if ( !(stream_command.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_command.hasNext() ) {
					adaptor.addChild(root_0, stream_command.nextTree());
				}
				stream_command.reset();

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
	// $ANTLR end "commands"


	public static class command_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "command"
	// ./grammars/AST.g:55:1: command : ( ( 'nop' ) -> NOP | ( vars ( WS )? ':=' ( WS )? exprs ) -> ^( ASSIGN vars exprs ) | ( 'if' WS expression WS 'then' WS commands WS ( ( WS )? 'else' WS commands WS )? 'fi' ) -> ^( IF expression ^( COMMANDS commands ) ( ^( ELSECOMMANDS commands ) )? ) | ( 'while' WS expression WS 'do' WS commands WS 'od' ) -> ^( WHILE expression commands ) | ( 'for' WS expression WS 'do' WS commands WS 'od' ) -> ^( FOR expression commands ) | ( 'foreach' WS VARIABLE WS 'in' WS expression WS 'do' WS commands WS 'od' ) -> ^( FOREACH VARIABLE expression commands ) );
	public final ASTParser.command_return command() throws RecognitionException {
		ASTParser.command_return retval = new ASTParser.command_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal45=null;
		Token WS47=null;
		Token string_literal48=null;
		Token WS49=null;
		Token string_literal51=null;
		Token WS52=null;
		Token WS54=null;
		Token string_literal55=null;
		Token WS56=null;
		Token WS58=null;
		Token WS59=null;
		Token string_literal60=null;
		Token WS61=null;
		Token WS63=null;
		Token string_literal64=null;
		Token string_literal65=null;
		Token WS66=null;
		Token WS68=null;
		Token string_literal69=null;
		Token WS70=null;
		Token WS72=null;
		Token string_literal73=null;
		Token string_literal74=null;
		Token WS75=null;
		Token WS77=null;
		Token string_literal78=null;
		Token WS79=null;
		Token WS81=null;
		Token string_literal82=null;
		Token string_literal83=null;
		Token WS84=null;
		Token VARIABLE85=null;
		Token WS86=null;
		Token string_literal87=null;
		Token WS88=null;
		Token WS90=null;
		Token string_literal91=null;
		Token WS92=null;
		Token WS94=null;
		Token string_literal95=null;
		ParserRuleReturnScope vars46 =null;
		ParserRuleReturnScope exprs50 =null;
		ParserRuleReturnScope expression53 =null;
		ParserRuleReturnScope commands57 =null;
		ParserRuleReturnScope commands62 =null;
		ParserRuleReturnScope expression67 =null;
		ParserRuleReturnScope commands71 =null;
		ParserRuleReturnScope expression76 =null;
		ParserRuleReturnScope commands80 =null;
		ParserRuleReturnScope expression89 =null;
		ParserRuleReturnScope commands93 =null;

		Object string_literal45_tree=null;
		Object WS47_tree=null;
		Object string_literal48_tree=null;
		Object WS49_tree=null;
		Object string_literal51_tree=null;
		Object WS52_tree=null;
		Object WS54_tree=null;
		Object string_literal55_tree=null;
		Object WS56_tree=null;
		Object WS58_tree=null;
		Object WS59_tree=null;
		Object string_literal60_tree=null;
		Object WS61_tree=null;
		Object WS63_tree=null;
		Object string_literal64_tree=null;
		Object string_literal65_tree=null;
		Object WS66_tree=null;
		Object WS68_tree=null;
		Object string_literal69_tree=null;
		Object WS70_tree=null;
		Object WS72_tree=null;
		Object string_literal73_tree=null;
		Object string_literal74_tree=null;
		Object WS75_tree=null;
		Object WS77_tree=null;
		Object string_literal78_tree=null;
		Object WS79_tree=null;
		Object WS81_tree=null;
		Object string_literal82_tree=null;
		Object string_literal83_tree=null;
		Object WS84_tree=null;
		Object VARIABLE85_tree=null;
		Object WS86_tree=null;
		Object string_literal87_tree=null;
		Object WS88_tree=null;
		Object WS90_tree=null;
		Object string_literal91_tree=null;
		Object WS92_tree=null;
		Object WS94_tree=null;
		Object string_literal95_tree=null;
		RewriteRuleTokenStream stream_44=new RewriteRuleTokenStream(adaptor,"token 44");
		RewriteRuleTokenStream stream_55=new RewriteRuleTokenStream(adaptor,"token 55");
		RewriteRuleTokenStream stream_45=new RewriteRuleTokenStream(adaptor,"token 45");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_46=new RewriteRuleTokenStream(adaptor,"token 46");
		RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleTokenStream stream_VARIABLE=new RewriteRuleTokenStream(adaptor,"token VARIABLE");
		RewriteRuleTokenStream stream_50=new RewriteRuleTokenStream(adaptor,"token 50");
		RewriteRuleTokenStream stream_WS=new RewriteRuleTokenStream(adaptor,"token WS");
		RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
		RewriteRuleTokenStream stream_51=new RewriteRuleTokenStream(adaptor,"token 51");
		RewriteRuleTokenStream stream_54=new RewriteRuleTokenStream(adaptor,"token 54");
		RewriteRuleTokenStream stream_43=new RewriteRuleTokenStream(adaptor,"token 43");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
		RewriteRuleSubtreeStream stream_exprs=new RewriteRuleSubtreeStream(adaptor,"rule exprs");
		RewriteRuleSubtreeStream stream_vars=new RewriteRuleSubtreeStream(adaptor,"rule vars");
		RewriteRuleSubtreeStream stream_commands=new RewriteRuleSubtreeStream(adaptor,"rule commands");

		try {
			// ./grammars/AST.g:55:8: ( ( 'nop' ) -> NOP | ( vars ( WS )? ':=' ( WS )? exprs ) -> ^( ASSIGN vars exprs ) | ( 'if' WS expression WS 'then' WS commands WS ( ( WS )? 'else' WS commands WS )? 'fi' ) -> ^( IF expression ^( COMMANDS commands ) ( ^( ELSECOMMANDS commands ) )? ) | ( 'while' WS expression WS 'do' WS commands WS 'od' ) -> ^( WHILE expression commands ) | ( 'for' WS expression WS 'do' WS commands WS 'od' ) -> ^( FOR expression commands ) | ( 'foreach' WS VARIABLE WS 'in' WS expression WS 'do' WS commands WS 'od' ) -> ^( FOREACH VARIABLE expression commands ) )
			int alt24=6;
			switch ( input.LA(1) ) {
			case 54:
				{
				alt24=1;
				}
				break;
			case VARIABLE:
				{
				alt24=2;
				}
				break;
			case 50:
				{
				alt24=3;
				}
				break;
			case 59:
				{
				alt24=4;
				}
				break;
			case 46:
				{
				alt24=5;
				}
				break;
			case 47:
				{
				alt24=6;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 24, 0, input);
				throw nvae;
			}
			switch (alt24) {
				case 1 :
					// ./grammars/AST.g:56:4: ( 'nop' )
					{
					// ./grammars/AST.g:56:4: ( 'nop' )
					// ./grammars/AST.g:56:5: 'nop'
					{
					string_literal45=(Token)match(input,54,FOLLOW_54_in_command384);  
					stream_54.add(string_literal45);

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
					// 56:12: -> NOP
					{
						adaptor.addChild(root_0, (Object)adaptor.create(NOP, "NOP"));
					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// ./grammars/AST.g:57:4: ( vars ( WS )? ':=' ( WS )? exprs )
					{
					// ./grammars/AST.g:57:4: ( vars ( WS )? ':=' ( WS )? exprs )
					// ./grammars/AST.g:57:5: vars ( WS )? ':=' ( WS )? exprs
					{
					pushFollow(FOLLOW_vars_in_command395);
					vars46=vars();
					state._fsp--;

					stream_vars.add(vars46.getTree());
					// ./grammars/AST.g:57:10: ( WS )?
					int alt20=2;
					int LA20_0 = input.LA(1);
					if ( (LA20_0==WS) ) {
						alt20=1;
					}
					switch (alt20) {
						case 1 :
							// ./grammars/AST.g:57:10: WS
							{
							WS47=(Token)match(input,WS,FOLLOW_WS_in_command397);  
							stream_WS.add(WS47);

							}
							break;

					}

					string_literal48=(Token)match(input,40,FOLLOW_40_in_command400);  
					stream_40.add(string_literal48);

					// ./grammars/AST.g:57:19: ( WS )?
					int alt21=2;
					int LA21_0 = input.LA(1);
					if ( (LA21_0==WS) ) {
						alt21=1;
					}
					switch (alt21) {
						case 1 :
							// ./grammars/AST.g:57:19: WS
							{
							WS49=(Token)match(input,WS,FOLLOW_WS_in_command402);  
							stream_WS.add(WS49);

							}
							break;

					}

					pushFollow(FOLLOW_exprs_in_command405);
					exprs50=exprs();
					state._fsp--;

					stream_exprs.add(exprs50.getTree());
					}


					// AST REWRITE
					// elements: vars, exprs
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 57:30: -> ^( ASSIGN vars exprs )
					{
						// ./grammars/AST.g:57:33: ^( ASSIGN vars exprs )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ASSIGN, "ASSIGN"), root_1);
						adaptor.addChild(root_1, stream_vars.nextTree());
						adaptor.addChild(root_1, stream_exprs.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 3 :
					// ./grammars/AST.g:58:4: ( 'if' WS expression WS 'then' WS commands WS ( ( WS )? 'else' WS commands WS )? 'fi' )
					{
					// ./grammars/AST.g:58:4: ( 'if' WS expression WS 'then' WS commands WS ( ( WS )? 'else' WS commands WS )? 'fi' )
					// ./grammars/AST.g:58:5: 'if' WS expression WS 'then' WS commands WS ( ( WS )? 'else' WS commands WS )? 'fi'
					{
					string_literal51=(Token)match(input,50,FOLLOW_50_in_command422);  
					stream_50.add(string_literal51);

					WS52=(Token)match(input,WS,FOLLOW_WS_in_command424);  
					stream_WS.add(WS52);

					pushFollow(FOLLOW_expression_in_command426);
					expression53=expression();
					state._fsp--;

					stream_expression.add(expression53.getTree());
					WS54=(Token)match(input,WS,FOLLOW_WS_in_command428);  
					stream_WS.add(WS54);

					string_literal55=(Token)match(input,57,FOLLOW_57_in_command430);  
					stream_57.add(string_literal55);

					WS56=(Token)match(input,WS,FOLLOW_WS_in_command432);  
					stream_WS.add(WS56);

					pushFollow(FOLLOW_commands_in_command434);
					commands57=commands();
					state._fsp--;

					stream_commands.add(commands57.getTree());
					WS58=(Token)match(input,WS,FOLLOW_WS_in_command436);  
					stream_WS.add(WS58);

					// ./grammars/AST.g:58:48: ( ( WS )? 'else' WS commands WS )?
					int alt23=2;
					int LA23_0 = input.LA(1);
					if ( (LA23_0==WS||LA23_0==44) ) {
						alt23=1;
					}
					switch (alt23) {
						case 1 :
							// ./grammars/AST.g:58:49: ( WS )? 'else' WS commands WS
							{
							// ./grammars/AST.g:58:49: ( WS )?
							int alt22=2;
							int LA22_0 = input.LA(1);
							if ( (LA22_0==WS) ) {
								alt22=1;
							}
							switch (alt22) {
								case 1 :
									// ./grammars/AST.g:58:49: WS
									{
									WS59=(Token)match(input,WS,FOLLOW_WS_in_command438);  
									stream_WS.add(WS59);

									}
									break;

							}

							string_literal60=(Token)match(input,44,FOLLOW_44_in_command441);  
							stream_44.add(string_literal60);

							WS61=(Token)match(input,WS,FOLLOW_WS_in_command442);  
							stream_WS.add(WS61);

							pushFollow(FOLLOW_commands_in_command444);
							commands62=commands();
							state._fsp--;

							stream_commands.add(commands62.getTree());
							WS63=(Token)match(input,WS,FOLLOW_WS_in_command446);  
							stream_WS.add(WS63);

							}
							break;

					}

					string_literal64=(Token)match(input,45,FOLLOW_45_in_command450);  
					stream_45.add(string_literal64);

					}


					// AST REWRITE
					// elements: expression, commands, commands
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 58:82: -> ^( IF expression ^( COMMANDS commands ) ( ^( ELSECOMMANDS commands ) )? )
					{
						// ./grammars/AST.g:58:85: ^( IF expression ^( COMMANDS commands ) ( ^( ELSECOMMANDS commands ) )? )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF, "IF"), root_1);
						adaptor.addChild(root_1, stream_expression.nextTree());
						// ./grammars/AST.g:58:101: ^( COMMANDS commands )
						{
						Object root_2 = (Object)adaptor.nil();
						root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(COMMANDS, "COMMANDS"), root_2);
						adaptor.addChild(root_2, stream_commands.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						// ./grammars/AST.g:58:122: ( ^( ELSECOMMANDS commands ) )?
						if ( stream_commands.hasNext() ) {
							// ./grammars/AST.g:58:122: ^( ELSECOMMANDS commands )
							{
							Object root_2 = (Object)adaptor.nil();
							root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(ELSECOMMANDS, "ELSECOMMANDS"), root_2);
							adaptor.addChild(root_2, stream_commands.nextTree());
							adaptor.addChild(root_1, root_2);
							}

						}
						stream_commands.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 4 :
					// ./grammars/AST.g:59:4: ( 'while' WS expression WS 'do' WS commands WS 'od' )
					{
					// ./grammars/AST.g:59:4: ( 'while' WS expression WS 'do' WS commands WS 'od' )
					// ./grammars/AST.g:59:5: 'while' WS expression WS 'do' WS commands WS 'od'
					{
					string_literal65=(Token)match(input,59,FOLLOW_59_in_command478);  
					stream_59.add(string_literal65);

					WS66=(Token)match(input,WS,FOLLOW_WS_in_command480);  
					stream_WS.add(WS66);

					pushFollow(FOLLOW_expression_in_command482);
					expression67=expression();
					state._fsp--;

					stream_expression.add(expression67.getTree());
					WS68=(Token)match(input,WS,FOLLOW_WS_in_command484);  
					stream_WS.add(WS68);

					string_literal69=(Token)match(input,43,FOLLOW_43_in_command486);  
					stream_43.add(string_literal69);

					WS70=(Token)match(input,WS,FOLLOW_WS_in_command488);  
					stream_WS.add(WS70);

					pushFollow(FOLLOW_commands_in_command490);
					commands71=commands();
					state._fsp--;

					stream_commands.add(commands71.getTree());
					WS72=(Token)match(input,WS,FOLLOW_WS_in_command492);  
					stream_WS.add(WS72);

					string_literal73=(Token)match(input,55,FOLLOW_55_in_command494);  
					stream_55.add(string_literal73);

					}


					// AST REWRITE
					// elements: expression, commands
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 59:56: -> ^( WHILE expression commands )
					{
						// ./grammars/AST.g:59:59: ^( WHILE expression commands )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(WHILE, "WHILE"), root_1);
						adaptor.addChild(root_1, stream_expression.nextTree());
						adaptor.addChild(root_1, stream_commands.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 5 :
					// ./grammars/AST.g:60:4: ( 'for' WS expression WS 'do' WS commands WS 'od' )
					{
					// ./grammars/AST.g:60:4: ( 'for' WS expression WS 'do' WS commands WS 'od' )
					// ./grammars/AST.g:60:5: 'for' WS expression WS 'do' WS commands WS 'od'
					{
					string_literal74=(Token)match(input,46,FOLLOW_46_in_command511);  
					stream_46.add(string_literal74);

					WS75=(Token)match(input,WS,FOLLOW_WS_in_command513);  
					stream_WS.add(WS75);

					pushFollow(FOLLOW_expression_in_command515);
					expression76=expression();
					state._fsp--;

					stream_expression.add(expression76.getTree());
					WS77=(Token)match(input,WS,FOLLOW_WS_in_command517);  
					stream_WS.add(WS77);

					string_literal78=(Token)match(input,43,FOLLOW_43_in_command519);  
					stream_43.add(string_literal78);

					WS79=(Token)match(input,WS,FOLLOW_WS_in_command521);  
					stream_WS.add(WS79);

					pushFollow(FOLLOW_commands_in_command523);
					commands80=commands();
					state._fsp--;

					stream_commands.add(commands80.getTree());
					WS81=(Token)match(input,WS,FOLLOW_WS_in_command525);  
					stream_WS.add(WS81);

					string_literal82=(Token)match(input,55,FOLLOW_55_in_command527);  
					stream_55.add(string_literal82);

					}


					// AST REWRITE
					// elements: expression, commands
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 60:54: -> ^( FOR expression commands )
					{
						// ./grammars/AST.g:60:57: ^( FOR expression commands )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FOR, "FOR"), root_1);
						adaptor.addChild(root_1, stream_expression.nextTree());
						adaptor.addChild(root_1, stream_commands.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 6 :
					// ./grammars/AST.g:61:4: ( 'foreach' WS VARIABLE WS 'in' WS expression WS 'do' WS commands WS 'od' )
					{
					// ./grammars/AST.g:61:4: ( 'foreach' WS VARIABLE WS 'in' WS expression WS 'do' WS commands WS 'od' )
					// ./grammars/AST.g:61:5: 'foreach' WS VARIABLE WS 'in' WS expression WS 'do' WS commands WS 'od'
					{
					string_literal83=(Token)match(input,47,FOLLOW_47_in_command544);  
					stream_47.add(string_literal83);

					WS84=(Token)match(input,WS,FOLLOW_WS_in_command546);  
					stream_WS.add(WS84);

					VARIABLE85=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_command548);  
					stream_VARIABLE.add(VARIABLE85);

					WS86=(Token)match(input,WS,FOLLOW_WS_in_command550);  
					stream_WS.add(WS86);

					string_literal87=(Token)match(input,51,FOLLOW_51_in_command552);  
					stream_51.add(string_literal87);

					WS88=(Token)match(input,WS,FOLLOW_WS_in_command554);  
					stream_WS.add(WS88);

					pushFollow(FOLLOW_expression_in_command556);
					expression89=expression();
					state._fsp--;

					stream_expression.add(expression89.getTree());
					WS90=(Token)match(input,WS,FOLLOW_WS_in_command558);  
					stream_WS.add(WS90);

					string_literal91=(Token)match(input,43,FOLLOW_43_in_command560);  
					stream_43.add(string_literal91);

					WS92=(Token)match(input,WS,FOLLOW_WS_in_command562);  
					stream_WS.add(WS92);

					pushFollow(FOLLOW_commands_in_command564);
					commands93=commands();
					state._fsp--;

					stream_commands.add(commands93.getTree());
					WS94=(Token)match(input,WS,FOLLOW_WS_in_command566);  
					stream_WS.add(WS94);

					string_literal95=(Token)match(input,55,FOLLOW_55_in_command568);  
					stream_55.add(string_literal95);

					}


					// AST REWRITE
					// elements: expression, VARIABLE, commands
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 61:78: -> ^( FOREACH VARIABLE expression commands )
					{
						// ./grammars/AST.g:61:81: ^( FOREACH VARIABLE expression commands )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FOREACH, "FOREACH"), root_1);
						adaptor.addChild(root_1, stream_VARIABLE.nextNode());
						adaptor.addChild(root_1, stream_expression.nextTree());
						adaptor.addChild(root_1, stream_commands.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;

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
	// $ANTLR end "command"


	public static class vars_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "vars"
	// ./grammars/AST.g:63:1: vars : ( ( VARIABLE ( WS )? ',' vars ) -> VARIABLE | VARIABLE -> VARIABLE );
	public final ASTParser.vars_return vars() throws RecognitionException {
		ASTParser.vars_return retval = new ASTParser.vars_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token VARIABLE96=null;
		Token WS97=null;
		Token char_literal98=null;
		Token VARIABLE100=null;
		ParserRuleReturnScope vars99 =null;

		Object VARIABLE96_tree=null;
		Object WS97_tree=null;
		Object char_literal98_tree=null;
		Object VARIABLE100_tree=null;
		RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
		RewriteRuleTokenStream stream_VARIABLE=new RewriteRuleTokenStream(adaptor,"token VARIABLE");
		RewriteRuleTokenStream stream_WS=new RewriteRuleTokenStream(adaptor,"token WS");
		RewriteRuleSubtreeStream stream_vars=new RewriteRuleSubtreeStream(adaptor,"rule vars");

		try {
			// ./grammars/AST.g:63:7: ( ( VARIABLE ( WS )? ',' vars ) -> VARIABLE | VARIABLE -> VARIABLE )
			int alt26=2;
			int LA26_0 = input.LA(1);
			if ( (LA26_0==VARIABLE) ) {
				switch ( input.LA(2) ) {
				case WS:
					{
					int LA26_2 = input.LA(3);
					if ( (LA26_2==38) ) {
						alt26=1;
					}
					else if ( (LA26_2==40) ) {
						alt26=2;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 26, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

					}
					break;
				case 38:
					{
					alt26=1;
					}
					break;
				case 40:
					{
					alt26=2;
					}
					break;
				default:
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 26, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 26, 0, input);
				throw nvae;
			}

			switch (alt26) {
				case 1 :
					// ./grammars/AST.g:64:4: ( VARIABLE ( WS )? ',' vars )
					{
					// ./grammars/AST.g:64:4: ( VARIABLE ( WS )? ',' vars )
					// ./grammars/AST.g:64:5: VARIABLE ( WS )? ',' vars
					{
					VARIABLE96=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_vars596);  
					stream_VARIABLE.add(VARIABLE96);

					// ./grammars/AST.g:64:14: ( WS )?
					int alt25=2;
					int LA25_0 = input.LA(1);
					if ( (LA25_0==WS) ) {
						alt25=1;
					}
					switch (alt25) {
						case 1 :
							// ./grammars/AST.g:64:14: WS
							{
							WS97=(Token)match(input,WS,FOLLOW_WS_in_vars598);  
							stream_WS.add(WS97);

							}
							break;

					}

					char_literal98=(Token)match(input,38,FOLLOW_38_in_vars601);  
					stream_38.add(char_literal98);

					pushFollow(FOLLOW_vars_in_vars603);
					vars99=vars();
					state._fsp--;

					stream_vars.add(vars99.getTree());
					}


					// AST REWRITE
					// elements: VARIABLE
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 64:28: -> VARIABLE
					{
						adaptor.addChild(root_0, stream_VARIABLE.nextNode());
					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// ./grammars/AST.g:65:4: VARIABLE
					{
					VARIABLE100=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_vars614);  
					stream_VARIABLE.add(VARIABLE100);


					// AST REWRITE
					// elements: VARIABLE
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 65:13: -> VARIABLE
					{
						adaptor.addChild(root_0, stream_VARIABLE.nextNode());
					}


					retval.tree = root_0;

					}
					break;

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
	// $ANTLR end "vars"


	public static class exprs_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "exprs"
	// ./grammars/AST.g:68:1: exprs : expression ( ( WS )? ',' expression )* -> ( expression )+ ;
	public final ASTParser.exprs_return exprs() throws RecognitionException {
		ASTParser.exprs_return retval = new ASTParser.exprs_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token WS102=null;
		Token char_literal103=null;
		ParserRuleReturnScope expression101 =null;
		ParserRuleReturnScope expression104 =null;

		Object WS102_tree=null;
		Object char_literal103_tree=null;
		RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
		RewriteRuleTokenStream stream_WS=new RewriteRuleTokenStream(adaptor,"token WS");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");

		try {
			// ./grammars/AST.g:68:8: ( expression ( ( WS )? ',' expression )* -> ( expression )+ )
			// ./grammars/AST.g:68:10: expression ( ( WS )? ',' expression )*
			{
			pushFollow(FOLLOW_expression_in_exprs629);
			expression101=expression();
			state._fsp--;

			stream_expression.add(expression101.getTree());
			// ./grammars/AST.g:68:21: ( ( WS )? ',' expression )*
			loop28:
			while (true) {
				int alt28=2;
				int LA28_0 = input.LA(1);
				if ( (LA28_0==WS) ) {
					int LA28_1 = input.LA(2);
					if ( (LA28_1==38) ) {
						alt28=1;
					}

				}
				else if ( (LA28_0==38) ) {
					alt28=1;
				}

				switch (alt28) {
				case 1 :
					// ./grammars/AST.g:68:22: ( WS )? ',' expression
					{
					// ./grammars/AST.g:68:22: ( WS )?
					int alt27=2;
					int LA27_0 = input.LA(1);
					if ( (LA27_0==WS) ) {
						alt27=1;
					}
					switch (alt27) {
						case 1 :
							// ./grammars/AST.g:68:22: WS
							{
							WS102=(Token)match(input,WS,FOLLOW_WS_in_exprs632);  
							stream_WS.add(WS102);

							}
							break;

					}

					char_literal103=(Token)match(input,38,FOLLOW_38_in_exprs635);  
					stream_38.add(char_literal103);

					pushFollow(FOLLOW_expression_in_exprs636);
					expression104=expression();
					state._fsp--;

					stream_expression.add(expression104.getTree());
					}
					break;

				default :
					break loop28;
				}
			}


			// AST REWRITE
			// elements: expression
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 68:42: -> ( expression )+
			{
				if ( !(stream_expression.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_expression.hasNext() ) {
					adaptor.addChild(root_0, stream_expression.nextTree());
				}
				stream_expression.reset();

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
	// $ANTLR end "exprs"


	public static class expression_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expression"
	// ./grammars/AST.g:70:1: expression : e1= exprbase ( ' = ' e2= exprbase -> ^( EXPRESSION ^( EQUALS $e1 $e2) ) | -> ^( EXPRESSION $e1) ) ;
	public final ASTParser.expression_return expression() throws RecognitionException {
		ASTParser.expression_return retval = new ASTParser.expression_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal105=null;
		ParserRuleReturnScope e1 =null;
		ParserRuleReturnScope e2 =null;

		Object string_literal105_tree=null;
		RewriteRuleTokenStream stream_34=new RewriteRuleTokenStream(adaptor,"token 34");
		RewriteRuleSubtreeStream stream_exprbase=new RewriteRuleSubtreeStream(adaptor,"rule exprbase");

		try {
			// ./grammars/AST.g:71:2: (e1= exprbase ( ' = ' e2= exprbase -> ^( EXPRESSION ^( EQUALS $e1 $e2) ) | -> ^( EXPRESSION $e1) ) )
			// ./grammars/AST.g:71:5: e1= exprbase ( ' = ' e2= exprbase -> ^( EXPRESSION ^( EQUALS $e1 $e2) ) | -> ^( EXPRESSION $e1) )
			{
			pushFollow(FOLLOW_exprbase_in_expression657);
			e1=exprbase();
			state._fsp--;

			stream_exprbase.add(e1.getTree());
			// ./grammars/AST.g:71:16: ( ' = ' e2= exprbase -> ^( EXPRESSION ^( EQUALS $e1 $e2) ) | -> ^( EXPRESSION $e1) )
			int alt29=2;
			int LA29_0 = input.LA(1);
			if ( (LA29_0==34) ) {
				alt29=1;
			}
			else if ( (LA29_0==WS||LA29_0==38||LA29_0==41) ) {
				alt29=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 29, 0, input);
				throw nvae;
			}

			switch (alt29) {
				case 1 :
					// ./grammars/AST.g:72:3: ' = ' e2= exprbase
					{
					string_literal105=(Token)match(input,34,FOLLOW_34_in_expression662);  
					stream_34.add(string_literal105);

					pushFollow(FOLLOW_exprbase_in_expression665);
					e2=exprbase();
					state._fsp--;

					stream_exprbase.add(e2.getTree());

					// AST REWRITE
					// elements: e1, e2
					// token labels: 
					// rule labels: e1, e2, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_e1=new RewriteRuleSubtreeStream(adaptor,"rule e1",e1!=null?e1.getTree():null);
					RewriteRuleSubtreeStream stream_e2=new RewriteRuleSubtreeStream(adaptor,"rule e2",e2!=null?e2.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 72:20: -> ^( EXPRESSION ^( EQUALS $e1 $e2) )
					{
						// ./grammars/AST.g:72:23: ^( EXPRESSION ^( EQUALS $e1 $e2) )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EXPRESSION, "EXPRESSION"), root_1);
						// ./grammars/AST.g:72:36: ^( EQUALS $e1 $e2)
						{
						Object root_2 = (Object)adaptor.nil();
						root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(EQUALS, "EQUALS"), root_2);
						adaptor.addChild(root_2, stream_e1.nextTree());
						adaptor.addChild(root_2, stream_e2.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// ./grammars/AST.g:73:5: 
					{

					// AST REWRITE
					// elements: e1
					// token labels: 
					// rule labels: e1, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_e1=new RewriteRuleSubtreeStream(adaptor,"rule e1",e1!=null?e1.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 73:5: -> ^( EXPRESSION $e1)
					{
						// ./grammars/AST.g:73:8: ^( EXPRESSION $e1)
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EXPRESSION, "EXPRESSION"), root_1);
						adaptor.addChild(root_1, stream_e1.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;

			}

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
	// $ANTLR end "expression"


	public static class exprbase_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "exprbase"
	// ./grammars/AST.g:76:1: exprbase : ( '(' ( SYMBOL WS lexpr ')' -> ^( FUNCTIONCALL ^( SYMBOL lexpr ) ) | SYMBOL ')' -> ^( FUNCTIONCALL SYMBOL ) | 'hd ' exprbase ')' -> ^( HEAD exprbase ) | 'tl ' exprbase ')' -> ^( TAIL exprbase ) | 'cons ' lexpr ')' -> ^( CONS lexpr ) | 'list ' lexpr ')' -> ^( LIST lexpr ) ) | 'nil' -> NIL | VARIABLE -> VARIABLE | SYMBOL -> SYMBOL );
	public final ASTParser.exprbase_return exprbase() throws RecognitionException {
		ASTParser.exprbase_return retval = new ASTParser.exprbase_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal106=null;
		Token SYMBOL107=null;
		Token WS108=null;
		Token char_literal110=null;
		Token SYMBOL111=null;
		Token char_literal112=null;
		Token string_literal113=null;
		Token char_literal115=null;
		Token string_literal116=null;
		Token char_literal118=null;
		Token string_literal119=null;
		Token char_literal121=null;
		Token string_literal122=null;
		Token char_literal124=null;
		Token string_literal125=null;
		Token VARIABLE126=null;
		Token SYMBOL127=null;
		ParserRuleReturnScope lexpr109 =null;
		ParserRuleReturnScope exprbase114 =null;
		ParserRuleReturnScope exprbase117 =null;
		ParserRuleReturnScope lexpr120 =null;
		ParserRuleReturnScope lexpr123 =null;

		Object char_literal106_tree=null;
		Object SYMBOL107_tree=null;
		Object WS108_tree=null;
		Object char_literal110_tree=null;
		Object SYMBOL111_tree=null;
		Object char_literal112_tree=null;
		Object string_literal113_tree=null;
		Object char_literal115_tree=null;
		Object string_literal116_tree=null;
		Object char_literal118_tree=null;
		Object string_literal119_tree=null;
		Object char_literal121_tree=null;
		Object string_literal122_tree=null;
		Object char_literal124_tree=null;
		Object string_literal125_tree=null;
		Object VARIABLE126_tree=null;
		Object SYMBOL127_tree=null;
		RewriteRuleTokenStream stream_36=new RewriteRuleTokenStream(adaptor,"token 36");
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_SYMBOL=new RewriteRuleTokenStream(adaptor,"token SYMBOL");
		RewriteRuleTokenStream stream_37=new RewriteRuleTokenStream(adaptor,"token 37");
		RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
		RewriteRuleTokenStream stream_VARIABLE=new RewriteRuleTokenStream(adaptor,"token VARIABLE");
		RewriteRuleTokenStream stream_WS=new RewriteRuleTokenStream(adaptor,"token WS");
		RewriteRuleTokenStream stream_52=new RewriteRuleTokenStream(adaptor,"token 52");
		RewriteRuleTokenStream stream_42=new RewriteRuleTokenStream(adaptor,"token 42");
		RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
		RewriteRuleSubtreeStream stream_lexpr=new RewriteRuleSubtreeStream(adaptor,"rule lexpr");
		RewriteRuleSubtreeStream stream_exprbase=new RewriteRuleSubtreeStream(adaptor,"rule exprbase");

		try {
			// ./grammars/AST.g:77:2: ( '(' ( SYMBOL WS lexpr ')' -> ^( FUNCTIONCALL ^( SYMBOL lexpr ) ) | SYMBOL ')' -> ^( FUNCTIONCALL SYMBOL ) | 'hd ' exprbase ')' -> ^( HEAD exprbase ) | 'tl ' exprbase ')' -> ^( TAIL exprbase ) | 'cons ' lexpr ')' -> ^( CONS lexpr ) | 'list ' lexpr ')' -> ^( LIST lexpr ) ) | 'nil' -> NIL | VARIABLE -> VARIABLE | SYMBOL -> SYMBOL )
			int alt31=4;
			switch ( input.LA(1) ) {
			case 36:
				{
				alt31=1;
				}
				break;
			case 53:
				{
				alt31=2;
				}
				break;
			case VARIABLE:
				{
				alt31=3;
				}
				break;
			case SYMBOL:
				{
				alt31=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 31, 0, input);
				throw nvae;
			}
			switch (alt31) {
				case 1 :
					// ./grammars/AST.g:77:5: '(' ( SYMBOL WS lexpr ')' -> ^( FUNCTIONCALL ^( SYMBOL lexpr ) ) | SYMBOL ')' -> ^( FUNCTIONCALL SYMBOL ) | 'hd ' exprbase ')' -> ^( HEAD exprbase ) | 'tl ' exprbase ')' -> ^( TAIL exprbase ) | 'cons ' lexpr ')' -> ^( CONS lexpr ) | 'list ' lexpr ')' -> ^( LIST lexpr ) )
					{
					char_literal106=(Token)match(input,36,FOLLOW_36_in_exprbase708);  
					stream_36.add(char_literal106);

					// ./grammars/AST.g:77:8: ( SYMBOL WS lexpr ')' -> ^( FUNCTIONCALL ^( SYMBOL lexpr ) ) | SYMBOL ')' -> ^( FUNCTIONCALL SYMBOL ) | 'hd ' exprbase ')' -> ^( HEAD exprbase ) | 'tl ' exprbase ')' -> ^( TAIL exprbase ) | 'cons ' lexpr ')' -> ^( CONS lexpr ) | 'list ' lexpr ')' -> ^( LIST lexpr ) )
					int alt30=6;
					switch ( input.LA(1) ) {
					case SYMBOL:
						{
						int LA30_1 = input.LA(2);
						if ( (LA30_1==WS) ) {
							alt30=1;
						}
						else if ( (LA30_1==37) ) {
							alt30=2;
						}

						else {
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 30, 1, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case 49:
						{
						alt30=3;
						}
						break;
					case 58:
						{
						alt30=4;
						}
						break;
					case 42:
						{
						alt30=5;
						}
						break;
					case 52:
						{
						alt30=6;
						}
						break;
					default:
						NoViableAltException nvae =
							new NoViableAltException("", 30, 0, input);
						throw nvae;
					}
					switch (alt30) {
						case 1 :
							// ./grammars/AST.g:78:3: SYMBOL WS lexpr ')'
							{
							SYMBOL107=(Token)match(input,SYMBOL,FOLLOW_SYMBOL_in_exprbase713);  
							stream_SYMBOL.add(SYMBOL107);

							WS108=(Token)match(input,WS,FOLLOW_WS_in_exprbase715);  
							stream_WS.add(WS108);

							pushFollow(FOLLOW_lexpr_in_exprbase717);
							lexpr109=lexpr();
							state._fsp--;

							stream_lexpr.add(lexpr109.getTree());
							char_literal110=(Token)match(input,37,FOLLOW_37_in_exprbase718);  
							stream_37.add(char_literal110);


							// AST REWRITE
							// elements: SYMBOL, lexpr
							// token labels: 
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (Object)adaptor.nil();
							// 78:22: -> ^( FUNCTIONCALL ^( SYMBOL lexpr ) )
							{
								// ./grammars/AST.g:78:25: ^( FUNCTIONCALL ^( SYMBOL lexpr ) )
								{
								Object root_1 = (Object)adaptor.nil();
								root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNCTIONCALL, "FUNCTIONCALL"), root_1);
								// ./grammars/AST.g:78:40: ^( SYMBOL lexpr )
								{
								Object root_2 = (Object)adaptor.nil();
								root_2 = (Object)adaptor.becomeRoot(stream_SYMBOL.nextNode(), root_2);
								adaptor.addChild(root_2, stream_lexpr.nextTree());
								adaptor.addChild(root_1, root_2);
								}

								adaptor.addChild(root_0, root_1);
								}

							}


							retval.tree = root_0;

							}
							break;
						case 2 :
							// ./grammars/AST.g:79:5: SYMBOL ')'
							{
							SYMBOL111=(Token)match(input,SYMBOL,FOLLOW_SYMBOL_in_exprbase736);  
							stream_SYMBOL.add(SYMBOL111);

							char_literal112=(Token)match(input,37,FOLLOW_37_in_exprbase737);  
							stream_37.add(char_literal112);


							// AST REWRITE
							// elements: SYMBOL
							// token labels: 
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (Object)adaptor.nil();
							// 79:15: -> ^( FUNCTIONCALL SYMBOL )
							{
								// ./grammars/AST.g:79:18: ^( FUNCTIONCALL SYMBOL )
								{
								Object root_1 = (Object)adaptor.nil();
								root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNCTIONCALL, "FUNCTIONCALL"), root_1);
								adaptor.addChild(root_1, stream_SYMBOL.nextNode());
								adaptor.addChild(root_0, root_1);
								}

							}


							retval.tree = root_0;

							}
							break;
						case 3 :
							// ./grammars/AST.g:80:4: 'hd ' exprbase ')'
							{
							string_literal113=(Token)match(input,49,FOLLOW_49_in_exprbase750);  
							stream_49.add(string_literal113);

							pushFollow(FOLLOW_exprbase_in_exprbase751);
							exprbase114=exprbase();
							state._fsp--;

							stream_exprbase.add(exprbase114.getTree());
							char_literal115=(Token)match(input,37,FOLLOW_37_in_exprbase752);  
							stream_37.add(char_literal115);


							// AST REWRITE
							// elements: exprbase
							// token labels: 
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (Object)adaptor.nil();
							// 80:21: -> ^( HEAD exprbase )
							{
								// ./grammars/AST.g:80:24: ^( HEAD exprbase )
								{
								Object root_1 = (Object)adaptor.nil();
								root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(HEAD, "HEAD"), root_1);
								adaptor.addChild(root_1, stream_exprbase.nextTree());
								adaptor.addChild(root_0, root_1);
								}

							}


							retval.tree = root_0;

							}
							break;
						case 4 :
							// ./grammars/AST.g:81:4: 'tl ' exprbase ')'
							{
							string_literal116=(Token)match(input,58,FOLLOW_58_in_exprbase765);  
							stream_58.add(string_literal116);

							pushFollow(FOLLOW_exprbase_in_exprbase766);
							exprbase117=exprbase();
							state._fsp--;

							stream_exprbase.add(exprbase117.getTree());
							char_literal118=(Token)match(input,37,FOLLOW_37_in_exprbase767);  
							stream_37.add(char_literal118);


							// AST REWRITE
							// elements: exprbase
							// token labels: 
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (Object)adaptor.nil();
							// 81:21: -> ^( TAIL exprbase )
							{
								// ./grammars/AST.g:81:24: ^( TAIL exprbase )
								{
								Object root_1 = (Object)adaptor.nil();
								root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TAIL, "TAIL"), root_1);
								adaptor.addChild(root_1, stream_exprbase.nextTree());
								adaptor.addChild(root_0, root_1);
								}

							}


							retval.tree = root_0;

							}
							break;
						case 5 :
							// ./grammars/AST.g:82:4: 'cons ' lexpr ')'
							{
							string_literal119=(Token)match(input,42,FOLLOW_42_in_exprbase780);  
							stream_42.add(string_literal119);

							pushFollow(FOLLOW_lexpr_in_exprbase781);
							lexpr120=lexpr();
							state._fsp--;

							stream_lexpr.add(lexpr120.getTree());
							char_literal121=(Token)match(input,37,FOLLOW_37_in_exprbase782);  
							stream_37.add(char_literal121);


							// AST REWRITE
							// elements: lexpr
							// token labels: 
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (Object)adaptor.nil();
							// 82:20: -> ^( CONS lexpr )
							{
								// ./grammars/AST.g:82:23: ^( CONS lexpr )
								{
								Object root_1 = (Object)adaptor.nil();
								root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CONS, "CONS"), root_1);
								adaptor.addChild(root_1, stream_lexpr.nextTree());
								adaptor.addChild(root_0, root_1);
								}

							}


							retval.tree = root_0;

							}
							break;
						case 6 :
							// ./grammars/AST.g:83:4: 'list ' lexpr ')'
							{
							string_literal122=(Token)match(input,52,FOLLOW_52_in_exprbase795);  
							stream_52.add(string_literal122);

							pushFollow(FOLLOW_lexpr_in_exprbase796);
							lexpr123=lexpr();
							state._fsp--;

							stream_lexpr.add(lexpr123.getTree());
							char_literal124=(Token)match(input,37,FOLLOW_37_in_exprbase797);  
							stream_37.add(char_literal124);


							// AST REWRITE
							// elements: lexpr
							// token labels: 
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (Object)adaptor.nil();
							// 83:20: -> ^( LIST lexpr )
							{
								// ./grammars/AST.g:83:23: ^( LIST lexpr )
								{
								Object root_1 = (Object)adaptor.nil();
								root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(LIST, "LIST"), root_1);
								adaptor.addChild(root_1, stream_lexpr.nextTree());
								adaptor.addChild(root_0, root_1);
								}

							}


							retval.tree = root_0;

							}
							break;

					}

					}
					break;
				case 2 :
					// ./grammars/AST.g:85:4: 'nil'
					{
					string_literal125=(Token)match(input,53,FOLLOW_53_in_exprbase814);  
					stream_53.add(string_literal125);


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
					// 85:10: -> NIL
					{
						adaptor.addChild(root_0, (Object)adaptor.create(NIL, "NIL"));
					}


					retval.tree = root_0;

					}
					break;
				case 3 :
					// ./grammars/AST.g:86:5: VARIABLE
					{
					VARIABLE126=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_exprbase824);  
					stream_VARIABLE.add(VARIABLE126);


					// AST REWRITE
					// elements: VARIABLE
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 86:14: -> VARIABLE
					{
						adaptor.addChild(root_0, stream_VARIABLE.nextNode());
					}


					retval.tree = root_0;

					}
					break;
				case 4 :
					// ./grammars/AST.g:87:5: SYMBOL
					{
					SYMBOL127=(Token)match(input,SYMBOL,FOLLOW_SYMBOL_in_exprbase834);  
					stream_SYMBOL.add(SYMBOL127);


					// AST REWRITE
					// elements: SYMBOL
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 87:12: -> SYMBOL
					{
						adaptor.addChild(root_0, stream_SYMBOL.nextNode());
					}


					retval.tree = root_0;

					}
					break;

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
	// $ANTLR end "exprbase"


	public static class lexpr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "lexpr"
	// ./grammars/AST.g:89:2: lexpr : ( ( WS )? ( exprbase ( WS )? )* ) -> ( exprbase )* ;
	public final ASTParser.lexpr_return lexpr() throws RecognitionException {
		ASTParser.lexpr_return retval = new ASTParser.lexpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token WS128=null;
		Token WS130=null;
		ParserRuleReturnScope exprbase129 =null;

		Object WS128_tree=null;
		Object WS130_tree=null;
		RewriteRuleTokenStream stream_WS=new RewriteRuleTokenStream(adaptor,"token WS");
		RewriteRuleSubtreeStream stream_exprbase=new RewriteRuleSubtreeStream(adaptor,"rule exprbase");

		try {
			// ./grammars/AST.g:90:5: ( ( ( WS )? ( exprbase ( WS )? )* ) -> ( exprbase )* )
			// ./grammars/AST.g:90:7: ( ( WS )? ( exprbase ( WS )? )* )
			{
			// ./grammars/AST.g:90:7: ( ( WS )? ( exprbase ( WS )? )* )
			// ./grammars/AST.g:90:8: ( WS )? ( exprbase ( WS )? )*
			{
			// ./grammars/AST.g:90:8: ( WS )?
			int alt32=2;
			int LA32_0 = input.LA(1);
			if ( (LA32_0==WS) ) {
				alt32=1;
			}
			switch (alt32) {
				case 1 :
					// ./grammars/AST.g:90:8: WS
					{
					WS128=(Token)match(input,WS,FOLLOW_WS_in_lexpr854);  
					stream_WS.add(WS128);

					}
					break;

			}

			// ./grammars/AST.g:90:12: ( exprbase ( WS )? )*
			loop34:
			while (true) {
				int alt34=2;
				int LA34_0 = input.LA(1);
				if ( (LA34_0==SYMBOL||LA34_0==VARIABLE||LA34_0==36||LA34_0==53) ) {
					alt34=1;
				}

				switch (alt34) {
				case 1 :
					// ./grammars/AST.g:90:13: exprbase ( WS )?
					{
					pushFollow(FOLLOW_exprbase_in_lexpr858);
					exprbase129=exprbase();
					state._fsp--;

					stream_exprbase.add(exprbase129.getTree());
					// ./grammars/AST.g:90:22: ( WS )?
					int alt33=2;
					int LA33_0 = input.LA(1);
					if ( (LA33_0==WS) ) {
						alt33=1;
					}
					switch (alt33) {
						case 1 :
							// ./grammars/AST.g:90:22: WS
							{
							WS130=(Token)match(input,WS,FOLLOW_WS_in_lexpr860);  
							stream_WS.add(WS130);

							}
							break;

					}

					}
					break;

				default :
					break loop34;
				}
			}

			}


			// AST REWRITE
			// elements: exprbase
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 90:29: -> ( exprbase )*
			{
				// ./grammars/AST.g:90:32: ( exprbase )*
				while ( stream_exprbase.hasNext() ) {
					adaptor.addChild(root_0, stream_exprbase.nextTree());
				}
				stream_exprbase.reset();

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
	// $ANTLR end "lexpr"

	// Delegated rules



	public static final BitSet FOLLOW_WS_in_program141 = new BitSet(new long[]{0x0001000200000000L});
	public static final BitSet FOLLOW_function_in_program145 = new BitSet(new long[]{0x0001000200000002L});
	public static final BitSet FOLLOW_WS_in_program147 = new BitSet(new long[]{0x0001000200000002L});
	public static final BitSet FOLLOW_48_in_function166 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_WS_in_function168 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_SYMBOL_in_function170 = new BitSet(new long[]{0x0000008200000000L});
	public static final BitSet FOLLOW_WS_in_function172 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_39_in_function175 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_WS_in_function177 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_definition_in_function179 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_definition198 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_WS_in_definition200 = new BitSet(new long[]{0x0000000A40000000L});
	public static final BitSet FOLLOW_input_in_definition203 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_WS_in_definition205 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_35_in_definition209 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_WS_in_definition211 = new BitSet(new long[]{0x0844C00240000000L});
	public static final BitSet FOLLOW_commands_in_definition213 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_WS_in_definition215 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_35_in_definition217 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_WS_in_definition219 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_definition221 = new BitSet(new long[]{0x0000000240000000L});
	public static final BitSet FOLLOW_output_in_definition223 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_inputsub_in_input252 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WS_in_inputsub270 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_VARIABLE_in_inputsub273 = new BitSet(new long[]{0x0000004200000000L});
	public static final BitSet FOLLOW_WS_in_inputsub275 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_38_in_inputsub278 = new BitSet(new long[]{0x0000000240000000L});
	public static final BitSet FOLLOW_inputsub_in_inputsub280 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WS_in_inputsub291 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_VARIABLE_in_inputsub294 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WS_in_output306 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_VARIABLE_in_output309 = new BitSet(new long[]{0x0000004200000000L});
	public static final BitSet FOLLOW_WS_in_output311 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_38_in_output314 = new BitSet(new long[]{0x0000000240000000L});
	public static final BitSet FOLLOW_output_in_output316 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WS_in_output327 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_VARIABLE_in_output330 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WS_in_commands347 = new BitSet(new long[]{0x0844C00040000000L});
	public static final BitSet FOLLOW_command_in_commands350 = new BitSet(new long[]{0x0000020200000002L});
	public static final BitSet FOLLOW_WS_in_commands353 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_41_in_commands356 = new BitSet(new long[]{0x0844C00240000000L});
	public static final BitSet FOLLOW_WS_in_commands358 = new BitSet(new long[]{0x0844C00040000000L});
	public static final BitSet FOLLOW_command_in_commands361 = new BitSet(new long[]{0x0000020200000002L});
	public static final BitSet FOLLOW_41_in_commands366 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_54_in_command384 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_vars_in_command395 = new BitSet(new long[]{0x0000010200000000L});
	public static final BitSet FOLLOW_WS_in_command397 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_40_in_command400 = new BitSet(new long[]{0x0020001248000000L});
	public static final BitSet FOLLOW_WS_in_command402 = new BitSet(new long[]{0x0020001048000000L});
	public static final BitSet FOLLOW_exprs_in_command405 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_50_in_command422 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_WS_in_command424 = new BitSet(new long[]{0x0020001048000000L});
	public static final BitSet FOLLOW_expression_in_command426 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_WS_in_command428 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_command430 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_WS_in_command432 = new BitSet(new long[]{0x0844C00240000000L});
	public static final BitSet FOLLOW_commands_in_command434 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_WS_in_command436 = new BitSet(new long[]{0x0000300200000000L});
	public static final BitSet FOLLOW_WS_in_command438 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_44_in_command441 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_WS_in_command442 = new BitSet(new long[]{0x0844C00240000000L});
	public static final BitSet FOLLOW_commands_in_command444 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_WS_in_command446 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_45_in_command450 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_command478 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_WS_in_command480 = new BitSet(new long[]{0x0020001048000000L});
	public static final BitSet FOLLOW_expression_in_command482 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_WS_in_command484 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_43_in_command486 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_WS_in_command488 = new BitSet(new long[]{0x0844C00240000000L});
	public static final BitSet FOLLOW_commands_in_command490 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_WS_in_command492 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_55_in_command494 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_46_in_command511 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_WS_in_command513 = new BitSet(new long[]{0x0020001048000000L});
	public static final BitSet FOLLOW_expression_in_command515 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_WS_in_command517 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_43_in_command519 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_WS_in_command521 = new BitSet(new long[]{0x0844C00240000000L});
	public static final BitSet FOLLOW_commands_in_command523 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_WS_in_command525 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_55_in_command527 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_47_in_command544 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_WS_in_command546 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_VARIABLE_in_command548 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_WS_in_command550 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_51_in_command552 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_WS_in_command554 = new BitSet(new long[]{0x0020001048000000L});
	public static final BitSet FOLLOW_expression_in_command556 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_WS_in_command558 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_43_in_command560 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_WS_in_command562 = new BitSet(new long[]{0x0844C00240000000L});
	public static final BitSet FOLLOW_commands_in_command564 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_WS_in_command566 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_55_in_command568 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VARIABLE_in_vars596 = new BitSet(new long[]{0x0000004200000000L});
	public static final BitSet FOLLOW_WS_in_vars598 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_38_in_vars601 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_vars_in_vars603 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VARIABLE_in_vars614 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_exprs629 = new BitSet(new long[]{0x0000004200000002L});
	public static final BitSet FOLLOW_WS_in_exprs632 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_38_in_exprs635 = new BitSet(new long[]{0x0020001048000000L});
	public static final BitSet FOLLOW_expression_in_exprs636 = new BitSet(new long[]{0x0000004200000002L});
	public static final BitSet FOLLOW_exprbase_in_expression657 = new BitSet(new long[]{0x0000000400000002L});
	public static final BitSet FOLLOW_34_in_expression662 = new BitSet(new long[]{0x0020001048000000L});
	public static final BitSet FOLLOW_exprbase_in_expression665 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_36_in_exprbase708 = new BitSet(new long[]{0x0412040008000000L});
	public static final BitSet FOLLOW_SYMBOL_in_exprbase713 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_WS_in_exprbase715 = new BitSet(new long[]{0x0020003248000000L});
	public static final BitSet FOLLOW_lexpr_in_exprbase717 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_37_in_exprbase718 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SYMBOL_in_exprbase736 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_37_in_exprbase737 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_49_in_exprbase750 = new BitSet(new long[]{0x0020001048000000L});
	public static final BitSet FOLLOW_exprbase_in_exprbase751 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_37_in_exprbase752 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_58_in_exprbase765 = new BitSet(new long[]{0x0020001048000000L});
	public static final BitSet FOLLOW_exprbase_in_exprbase766 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_37_in_exprbase767 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_42_in_exprbase780 = new BitSet(new long[]{0x0020003248000000L});
	public static final BitSet FOLLOW_lexpr_in_exprbase781 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_37_in_exprbase782 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_52_in_exprbase795 = new BitSet(new long[]{0x0020003248000000L});
	public static final BitSet FOLLOW_lexpr_in_exprbase796 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_37_in_exprbase797 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_53_in_exprbase814 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VARIABLE_in_exprbase824 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SYMBOL_in_exprbase834 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WS_in_lexpr854 = new BitSet(new long[]{0x0020001048000002L});
	public static final BitSet FOLLOW_exprbase_in_lexpr858 = new BitSet(new long[]{0x0020001248000002L});
	public static final BitSet FOLLOW_WS_in_lexpr860 = new BitSet(new long[]{0x0020001048000002L});
}
