// $ANTLR 3.5.3 ./grammars/AST.g 2022-12-07 08:19:55

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class ASTParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASSIGN", "COMMAND", "COMMANDS", 
		"CONS", "DIGIT", "EQUALS", "EXPRESSION", "EXPRS", "EXPR_BASE", "FOR", 
		"FOREACH", "FUNCDEF", "FUNCTION", "FUNCTIONCALL", "HEAD", "IF", "INPUT", 
		"LIST", "NIL", "NOP", "OUTPUT", "ROOT", "SYMBOL", "TAIL", "TOKENS", "VARIABLE", 
		"VARS", "WHILE", "WS", "' = '", "'%'", "'('", "'(cons '", "'(hd '", "'(list '", 
		"'(tl '", "')'", "','", "':'", "':='", "';'", "'do'", "'else'", "'fi'", 
		"'for'", "'foreach'", "'function'", "'if'", "'in'", "'nil'", "'nop'", 
		"'od'", "'read'", "'then'", "'while'", "'write'"
	};
	public static final int EOF=-1;
	public static final int T__33=33;
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
	public static final int ASSIGN=4;
	public static final int COMMAND=5;
	public static final int COMMANDS=6;
	public static final int CONS=7;
	public static final int DIGIT=8;
	public static final int EQUALS=9;
	public static final int EXPRESSION=10;
	public static final int EXPRS=11;
	public static final int EXPR_BASE=12;
	public static final int FOR=13;
	public static final int FOREACH=14;
	public static final int FUNCDEF=15;
	public static final int FUNCTION=16;
	public static final int FUNCTIONCALL=17;
	public static final int HEAD=18;
	public static final int IF=19;
	public static final int INPUT=20;
	public static final int LIST=21;
	public static final int NIL=22;
	public static final int NOP=23;
	public static final int OUTPUT=24;
	public static final int ROOT=25;
	public static final int SYMBOL=26;
	public static final int TAIL=27;
	public static final int TOKENS=28;
	public static final int VARIABLE=29;
	public static final int VARS=30;
	public static final int WHILE=31;
	public static final int WS=32;

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
	// ./grammars/AST.g:38:1: program : ( function )+ -> ( function )+ ;
	public final ASTParser.program_return program() throws RecognitionException {
		ASTParser.program_return retval = new ASTParser.program_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope function1 =null;

		RewriteRuleSubtreeStream stream_function=new RewriteRuleSubtreeStream(adaptor,"rule function");

		try {
			// ./grammars/AST.g:38:8: ( ( function )+ -> ( function )+ )
			// ./grammars/AST.g:38:10: ( function )+
			{
			// ./grammars/AST.g:38:10: ( function )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==WS||LA1_0==50) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// ./grammars/AST.g:38:10: function
					{
					pushFollow(FOLLOW_function_in_program137);
					function1=function();
					state._fsp--;

					stream_function.add(function1.getTree());
					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
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
			// 38:20: -> ( function )+
			{
				if ( !(stream_function.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_function.hasNext() ) {
					adaptor.addChild(root_0, stream_function.nextTree());
				}
				stream_function.reset();

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
	// ./grammars/AST.g:40:1: function : ( WS )? 'function' WS SYMBOL ( WS )? ':' WS definition -> ^( FUNCTION ^( SYMBOL definition ) ) ;
	public final ASTParser.function_return function() throws RecognitionException {
		ASTParser.function_return retval = new ASTParser.function_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token WS2=null;
		Token string_literal3=null;
		Token WS4=null;
		Token SYMBOL5=null;
		Token WS6=null;
		Token char_literal7=null;
		Token WS8=null;
		ParserRuleReturnScope definition9 =null;

		Object WS2_tree=null;
		Object string_literal3_tree=null;
		Object WS4_tree=null;
		Object SYMBOL5_tree=null;
		Object WS6_tree=null;
		Object char_literal7_tree=null;
		Object WS8_tree=null;
		RewriteRuleTokenStream stream_SYMBOL=new RewriteRuleTokenStream(adaptor,"token SYMBOL");
		RewriteRuleTokenStream stream_50=new RewriteRuleTokenStream(adaptor,"token 50");
		RewriteRuleTokenStream stream_WS=new RewriteRuleTokenStream(adaptor,"token WS");
		RewriteRuleTokenStream stream_42=new RewriteRuleTokenStream(adaptor,"token 42");
		RewriteRuleSubtreeStream stream_definition=new RewriteRuleSubtreeStream(adaptor,"rule definition");

		try {
			// ./grammars/AST.g:40:9: ( ( WS )? 'function' WS SYMBOL ( WS )? ':' WS definition -> ^( FUNCTION ^( SYMBOL definition ) ) )
			// ./grammars/AST.g:40:11: ( WS )? 'function' WS SYMBOL ( WS )? ':' WS definition
			{
			// ./grammars/AST.g:40:11: ( WS )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==WS) ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// ./grammars/AST.g:40:11: WS
					{
					WS2=(Token)match(input,WS,FOLLOW_WS_in_function150);  
					stream_WS.add(WS2);

					}
					break;

			}

			string_literal3=(Token)match(input,50,FOLLOW_50_in_function153);  
			stream_50.add(string_literal3);

			WS4=(Token)match(input,WS,FOLLOW_WS_in_function155);  
			stream_WS.add(WS4);

			SYMBOL5=(Token)match(input,SYMBOL,FOLLOW_SYMBOL_in_function157);  
			stream_SYMBOL.add(SYMBOL5);

			// ./grammars/AST.g:40:36: ( WS )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==WS) ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// ./grammars/AST.g:40:36: WS
					{
					WS6=(Token)match(input,WS,FOLLOW_WS_in_function159);  
					stream_WS.add(WS6);

					}
					break;

			}

			char_literal7=(Token)match(input,42,FOLLOW_42_in_function162);  
			stream_42.add(char_literal7);

			WS8=(Token)match(input,WS,FOLLOW_WS_in_function164);  
			stream_WS.add(WS8);

			pushFollow(FOLLOW_definition_in_function166);
			definition9=definition();
			state._fsp--;

			stream_definition.add(definition9.getTree());

			// AST REWRITE
			// elements: definition, SYMBOL
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 40:57: -> ^( FUNCTION ^( SYMBOL definition ) )
			{
				// ./grammars/AST.g:40:60: ^( FUNCTION ^( SYMBOL definition ) )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNCTION, "FUNCTION"), root_1);
				// ./grammars/AST.g:40:71: ^( SYMBOL definition )
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
	// ./grammars/AST.g:42:1: definition : 'read' WS ( input WS )? '%' WS commands WS '%' WS 'write' output -> ^( FUNCDEF ( input )? ^( COMMANDS commands ) ^( OUTPUT output ) ) ;
	public final ASTParser.definition_return definition() throws RecognitionException {
		ASTParser.definition_return retval = new ASTParser.definition_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal10=null;
		Token WS11=null;
		Token WS13=null;
		Token char_literal14=null;
		Token WS15=null;
		Token WS17=null;
		Token char_literal18=null;
		Token WS19=null;
		Token string_literal20=null;
		ParserRuleReturnScope input12 =null;
		ParserRuleReturnScope commands16 =null;
		ParserRuleReturnScope output21 =null;

		Object string_literal10_tree=null;
		Object WS11_tree=null;
		Object WS13_tree=null;
		Object char_literal14_tree=null;
		Object WS15_tree=null;
		Object WS17_tree=null;
		Object char_literal18_tree=null;
		Object WS19_tree=null;
		Object string_literal20_tree=null;
		RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
		RewriteRuleTokenStream stream_34=new RewriteRuleTokenStream(adaptor,"token 34");
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleTokenStream stream_WS=new RewriteRuleTokenStream(adaptor,"token WS");
		RewriteRuleSubtreeStream stream_output=new RewriteRuleSubtreeStream(adaptor,"rule output");
		RewriteRuleSubtreeStream stream_input=new RewriteRuleSubtreeStream(adaptor,"rule input");
		RewriteRuleSubtreeStream stream_commands=new RewriteRuleSubtreeStream(adaptor,"rule commands");

		try {
			// ./grammars/AST.g:42:11: ( 'read' WS ( input WS )? '%' WS commands WS '%' WS 'write' output -> ^( FUNCDEF ( input )? ^( COMMANDS commands ) ^( OUTPUT output ) ) )
			// ./grammars/AST.g:43:2: 'read' WS ( input WS )? '%' WS commands WS '%' WS 'write' output
			{
			string_literal10=(Token)match(input,56,FOLLOW_56_in_definition185);  
			stream_56.add(string_literal10);

			WS11=(Token)match(input,WS,FOLLOW_WS_in_definition187);  
			stream_WS.add(WS11);

			// ./grammars/AST.g:43:12: ( input WS )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==VARIABLE||LA4_0==WS) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// ./grammars/AST.g:43:13: input WS
					{
					pushFollow(FOLLOW_input_in_definition190);
					input12=input();
					state._fsp--;

					stream_input.add(input12.getTree());
					WS13=(Token)match(input,WS,FOLLOW_WS_in_definition192);  
					stream_WS.add(WS13);

					}
					break;

			}

			char_literal14=(Token)match(input,34,FOLLOW_34_in_definition196);  
			stream_34.add(char_literal14);

			WS15=(Token)match(input,WS,FOLLOW_WS_in_definition198);  
			stream_WS.add(WS15);

			pushFollow(FOLLOW_commands_in_definition200);
			commands16=commands();
			state._fsp--;

			stream_commands.add(commands16.getTree());
			WS17=(Token)match(input,WS,FOLLOW_WS_in_definition202);  
			stream_WS.add(WS17);

			char_literal18=(Token)match(input,34,FOLLOW_34_in_definition204);  
			stream_34.add(char_literal18);

			WS19=(Token)match(input,WS,FOLLOW_WS_in_definition206);  
			stream_WS.add(WS19);

			string_literal20=(Token)match(input,59,FOLLOW_59_in_definition208);  
			stream_59.add(string_literal20);

			pushFollow(FOLLOW_output_in_definition210);
			output21=output();
			state._fsp--;

			stream_output.add(output21.getTree());

			// AST REWRITE
			// elements: input, output, commands
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 43:65: -> ^( FUNCDEF ( input )? ^( COMMANDS commands ) ^( OUTPUT output ) )
			{
				// ./grammars/AST.g:43:68: ^( FUNCDEF ( input )? ^( COMMANDS commands ) ^( OUTPUT output ) )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNCDEF, "FUNCDEF"), root_1);
				// ./grammars/AST.g:43:78: ( input )?
				if ( stream_input.hasNext() ) {
					adaptor.addChild(root_1, stream_input.nextTree());
				}
				stream_input.reset();

				// ./grammars/AST.g:43:85: ^( COMMANDS commands )
				{
				Object root_2 = (Object)adaptor.nil();
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(COMMANDS, "COMMANDS"), root_2);
				adaptor.addChild(root_2, stream_commands.nextTree());
				adaptor.addChild(root_1, root_2);
				}

				// ./grammars/AST.g:43:106: ^( OUTPUT output )
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
	// ./grammars/AST.g:45:1: input : ( inputsub )? -> ^( INPUT ( inputsub )? ) ;
	public final ASTParser.input_return input() throws RecognitionException {
		ASTParser.input_return retval = new ASTParser.input_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope inputsub22 =null;

		RewriteRuleSubtreeStream stream_inputsub=new RewriteRuleSubtreeStream(adaptor,"rule inputsub");

		try {
			// ./grammars/AST.g:45:6: ( ( inputsub )? -> ^( INPUT ( inputsub )? ) )
			// ./grammars/AST.g:45:8: ( inputsub )?
			{
			// ./grammars/AST.g:45:8: ( inputsub )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==WS) ) {
				int LA5_1 = input.LA(2);
				if ( (LA5_1==VARIABLE) ) {
					alt5=1;
				}
			}
			else if ( (LA5_0==VARIABLE) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// ./grammars/AST.g:45:8: inputsub
					{
					pushFollow(FOLLOW_inputsub_in_input239);
					inputsub22=inputsub();
					state._fsp--;

					stream_inputsub.add(inputsub22.getTree());
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
			// 45:18: -> ^( INPUT ( inputsub )? )
			{
				// ./grammars/AST.g:45:21: ^( INPUT ( inputsub )? )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(INPUT, "INPUT"), root_1);
				// ./grammars/AST.g:45:29: ( inputsub )?
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
	// ./grammars/AST.g:47:1: inputsub : ( ( ( WS )? VARIABLE ( WS )? ',' inputsub ) -> VARIABLE inputsub | ( WS )? VARIABLE -> VARIABLE );
	public final ASTParser.inputsub_return inputsub() throws RecognitionException {
		ASTParser.inputsub_return retval = new ASTParser.inputsub_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token WS23=null;
		Token VARIABLE24=null;
		Token WS25=null;
		Token char_literal26=null;
		Token WS28=null;
		Token VARIABLE29=null;
		ParserRuleReturnScope inputsub27 =null;

		Object WS23_tree=null;
		Object VARIABLE24_tree=null;
		Object WS25_tree=null;
		Object char_literal26_tree=null;
		Object WS28_tree=null;
		Object VARIABLE29_tree=null;
		RewriteRuleTokenStream stream_VARIABLE=new RewriteRuleTokenStream(adaptor,"token VARIABLE");
		RewriteRuleTokenStream stream_WS=new RewriteRuleTokenStream(adaptor,"token WS");
		RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
		RewriteRuleSubtreeStream stream_inputsub=new RewriteRuleSubtreeStream(adaptor,"rule inputsub");

		try {
			// ./grammars/AST.g:47:9: ( ( ( WS )? VARIABLE ( WS )? ',' inputsub ) -> VARIABLE inputsub | ( WS )? VARIABLE -> VARIABLE )
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==WS) ) {
				int LA9_1 = input.LA(2);
				if ( (LA9_1==VARIABLE) ) {
					int LA9_2 = input.LA(3);
					if ( (LA9_2==WS) ) {
						int LA9_3 = input.LA(4);
						if ( (LA9_3==41) ) {
							alt9=1;
						}
						else if ( (LA9_3==34) ) {
							alt9=2;
						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 9, 3, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}
					else if ( (LA9_2==41) ) {
						alt9=1;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 9, 2, input);
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
							new NoViableAltException("", 9, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA9_0==VARIABLE) ) {
				int LA9_2 = input.LA(2);
				if ( (LA9_2==WS) ) {
					int LA9_3 = input.LA(3);
					if ( (LA9_3==41) ) {
						alt9=1;
					}
					else if ( (LA9_3==34) ) {
						alt9=2;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 9, 3, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}
				else if ( (LA9_2==41) ) {
					alt9=1;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 9, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}

			switch (alt9) {
				case 1 :
					// ./grammars/AST.g:47:11: ( ( WS )? VARIABLE ( WS )? ',' inputsub )
					{
					// ./grammars/AST.g:47:11: ( ( WS )? VARIABLE ( WS )? ',' inputsub )
					// ./grammars/AST.g:47:12: ( WS )? VARIABLE ( WS )? ',' inputsub
					{
					// ./grammars/AST.g:47:12: ( WS )?
					int alt6=2;
					int LA6_0 = input.LA(1);
					if ( (LA6_0==WS) ) {
						alt6=1;
					}
					switch (alt6) {
						case 1 :
							// ./grammars/AST.g:47:12: WS
							{
							WS23=(Token)match(input,WS,FOLLOW_WS_in_inputsub257);  
							stream_WS.add(WS23);

							}
							break;

					}

					VARIABLE24=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_inputsub260);  
					stream_VARIABLE.add(VARIABLE24);

					// ./grammars/AST.g:47:25: ( WS )?
					int alt7=2;
					int LA7_0 = input.LA(1);
					if ( (LA7_0==WS) ) {
						alt7=1;
					}
					switch (alt7) {
						case 1 :
							// ./grammars/AST.g:47:25: WS
							{
							WS25=(Token)match(input,WS,FOLLOW_WS_in_inputsub262);  
							stream_WS.add(WS25);

							}
							break;

					}

					char_literal26=(Token)match(input,41,FOLLOW_41_in_inputsub265);  
					stream_41.add(char_literal26);

					pushFollow(FOLLOW_inputsub_in_inputsub267);
					inputsub27=inputsub();
					state._fsp--;

					stream_inputsub.add(inputsub27.getTree());
					}


					// AST REWRITE
					// elements: VARIABLE, inputsub
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 47:43: -> VARIABLE inputsub
					{
						adaptor.addChild(root_0, stream_VARIABLE.nextNode());
						adaptor.addChild(root_0, stream_inputsub.nextTree());
					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// ./grammars/AST.g:47:66: ( WS )? VARIABLE
					{
					// ./grammars/AST.g:47:66: ( WS )?
					int alt8=2;
					int LA8_0 = input.LA(1);
					if ( (LA8_0==WS) ) {
						alt8=1;
					}
					switch (alt8) {
						case 1 :
							// ./grammars/AST.g:47:66: WS
							{
							WS28=(Token)match(input,WS,FOLLOW_WS_in_inputsub278);  
							stream_WS.add(WS28);

							}
							break;

					}

					VARIABLE29=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_inputsub281);  
					stream_VARIABLE.add(VARIABLE29);


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
					// 47:79: -> VARIABLE
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
	// ./grammars/AST.g:49:1: output : ( ( ( WS )? VARIABLE ( WS )? ',' output ) -> VARIABLE output | ( WS )? VARIABLE -> VARIABLE );
	public final ASTParser.output_return output() throws RecognitionException {
		ASTParser.output_return retval = new ASTParser.output_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token WS30=null;
		Token VARIABLE31=null;
		Token WS32=null;
		Token char_literal33=null;
		Token WS35=null;
		Token VARIABLE36=null;
		ParserRuleReturnScope output34 =null;

		Object WS30_tree=null;
		Object VARIABLE31_tree=null;
		Object WS32_tree=null;
		Object char_literal33_tree=null;
		Object WS35_tree=null;
		Object VARIABLE36_tree=null;
		RewriteRuleTokenStream stream_VARIABLE=new RewriteRuleTokenStream(adaptor,"token VARIABLE");
		RewriteRuleTokenStream stream_WS=new RewriteRuleTokenStream(adaptor,"token WS");
		RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
		RewriteRuleSubtreeStream stream_output=new RewriteRuleSubtreeStream(adaptor,"rule output");

		try {
			// ./grammars/AST.g:49:7: ( ( ( WS )? VARIABLE ( WS )? ',' output ) -> VARIABLE output | ( WS )? VARIABLE -> VARIABLE )
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( (LA13_0==WS) ) {
				int LA13_1 = input.LA(2);
				if ( (LA13_1==VARIABLE) ) {
					switch ( input.LA(3) ) {
					case WS:
						{
						int LA13_3 = input.LA(4);
						if ( (LA13_3==41) ) {
							alt13=1;
						}
						else if ( (LA13_3==50) ) {
							alt13=2;
						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 13, 3, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case 41:
						{
						alt13=1;
						}
						break;
					case EOF:
					case 50:
						{
						alt13=2;
						}
						break;
					default:
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 13, 2, input);
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
							new NoViableAltException("", 13, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA13_0==VARIABLE) ) {
				switch ( input.LA(2) ) {
				case WS:
					{
					int LA13_3 = input.LA(3);
					if ( (LA13_3==41) ) {
						alt13=1;
					}
					else if ( (LA13_3==50) ) {
						alt13=2;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 13, 3, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

					}
					break;
				case 41:
					{
					alt13=1;
					}
					break;
				case EOF:
				case 50:
					{
					alt13=2;
					}
					break;
				default:
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 13, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}

			switch (alt13) {
				case 1 :
					// ./grammars/AST.g:49:9: ( ( WS )? VARIABLE ( WS )? ',' output )
					{
					// ./grammars/AST.g:49:9: ( ( WS )? VARIABLE ( WS )? ',' output )
					// ./grammars/AST.g:49:10: ( WS )? VARIABLE ( WS )? ',' output
					{
					// ./grammars/AST.g:49:10: ( WS )?
					int alt10=2;
					int LA10_0 = input.LA(1);
					if ( (LA10_0==WS) ) {
						alt10=1;
					}
					switch (alt10) {
						case 1 :
							// ./grammars/AST.g:49:10: WS
							{
							WS30=(Token)match(input,WS,FOLLOW_WS_in_output293);  
							stream_WS.add(WS30);

							}
							break;

					}

					VARIABLE31=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_output296);  
					stream_VARIABLE.add(VARIABLE31);

					// ./grammars/AST.g:49:23: ( WS )?
					int alt11=2;
					int LA11_0 = input.LA(1);
					if ( (LA11_0==WS) ) {
						alt11=1;
					}
					switch (alt11) {
						case 1 :
							// ./grammars/AST.g:49:23: WS
							{
							WS32=(Token)match(input,WS,FOLLOW_WS_in_output298);  
							stream_WS.add(WS32);

							}
							break;

					}

					char_literal33=(Token)match(input,41,FOLLOW_41_in_output301);  
					stream_41.add(char_literal33);

					pushFollow(FOLLOW_output_in_output303);
					output34=output();
					state._fsp--;

					stream_output.add(output34.getTree());
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
					// 49:39: -> VARIABLE output
					{
						adaptor.addChild(root_0, stream_VARIABLE.nextNode());
						adaptor.addChild(root_0, stream_output.nextTree());
					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// ./grammars/AST.g:49:60: ( WS )? VARIABLE
					{
					// ./grammars/AST.g:49:60: ( WS )?
					int alt12=2;
					int LA12_0 = input.LA(1);
					if ( (LA12_0==WS) ) {
						alt12=1;
					}
					switch (alt12) {
						case 1 :
							// ./grammars/AST.g:49:60: WS
							{
							WS35=(Token)match(input,WS,FOLLOW_WS_in_output314);  
							stream_WS.add(WS35);

							}
							break;

					}

					VARIABLE36=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_output317);  
					stream_VARIABLE.add(VARIABLE36);


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
					// 49:73: -> VARIABLE
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
	// ./grammars/AST.g:51:1: commands : ( WS )? command ( ( WS )? ';' ( WS )? command )* ( ';' )? -> ( command )+ ;
	public final ASTParser.commands_return commands() throws RecognitionException {
		ASTParser.commands_return retval = new ASTParser.commands_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token WS37=null;
		Token WS39=null;
		Token char_literal40=null;
		Token WS41=null;
		Token char_literal43=null;
		ParserRuleReturnScope command38 =null;
		ParserRuleReturnScope command42 =null;

		Object WS37_tree=null;
		Object WS39_tree=null;
		Object char_literal40_tree=null;
		Object WS41_tree=null;
		Object char_literal43_tree=null;
		RewriteRuleTokenStream stream_44=new RewriteRuleTokenStream(adaptor,"token 44");
		RewriteRuleTokenStream stream_WS=new RewriteRuleTokenStream(adaptor,"token WS");
		RewriteRuleSubtreeStream stream_command=new RewriteRuleSubtreeStream(adaptor,"rule command");

		try {
			// ./grammars/AST.g:51:9: ( ( WS )? command ( ( WS )? ';' ( WS )? command )* ( ';' )? -> ( command )+ )
			// ./grammars/AST.g:52:5: ( WS )? command ( ( WS )? ';' ( WS )? command )* ( ';' )?
			{
			// ./grammars/AST.g:52:5: ( WS )?
			int alt14=2;
			int LA14_0 = input.LA(1);
			if ( (LA14_0==WS) ) {
				alt14=1;
			}
			switch (alt14) {
				case 1 :
					// ./grammars/AST.g:52:5: WS
					{
					WS37=(Token)match(input,WS,FOLLOW_WS_in_commands334);  
					stream_WS.add(WS37);

					}
					break;

			}

			pushFollow(FOLLOW_command_in_commands337);
			command38=command();
			state._fsp--;

			stream_command.add(command38.getTree());
			// ./grammars/AST.g:52:17: ( ( WS )? ';' ( WS )? command )*
			loop17:
			while (true) {
				int alt17=2;
				int LA17_0 = input.LA(1);
				if ( (LA17_0==44) ) {
					int LA17_1 = input.LA(2);
					if ( (LA17_1==WS) ) {
						int LA17_3 = input.LA(3);
						if ( (LA17_3==VARIABLE||(LA17_3 >= 48 && LA17_3 <= 49)||LA17_3==51||LA17_3==54||LA17_3==58) ) {
							alt17=1;
						}

					}
					else if ( (LA17_1==VARIABLE||(LA17_1 >= 48 && LA17_1 <= 49)||LA17_1==51||LA17_1==54||LA17_1==58) ) {
						alt17=1;
					}

				}
				else if ( (LA17_0==WS) ) {
					int LA17_2 = input.LA(2);
					if ( (LA17_2==44) ) {
						alt17=1;
					}

				}

				switch (alt17) {
				case 1 :
					// ./grammars/AST.g:52:18: ( WS )? ';' ( WS )? command
					{
					// ./grammars/AST.g:52:18: ( WS )?
					int alt15=2;
					int LA15_0 = input.LA(1);
					if ( (LA15_0==WS) ) {
						alt15=1;
					}
					switch (alt15) {
						case 1 :
							// ./grammars/AST.g:52:18: WS
							{
							WS39=(Token)match(input,WS,FOLLOW_WS_in_commands340);  
							stream_WS.add(WS39);

							}
							break;

					}

					char_literal40=(Token)match(input,44,FOLLOW_44_in_commands343);  
					stream_44.add(char_literal40);

					// ./grammars/AST.g:52:26: ( WS )?
					int alt16=2;
					int LA16_0 = input.LA(1);
					if ( (LA16_0==WS) ) {
						alt16=1;
					}
					switch (alt16) {
						case 1 :
							// ./grammars/AST.g:52:26: WS
							{
							WS41=(Token)match(input,WS,FOLLOW_WS_in_commands345);  
							stream_WS.add(WS41);

							}
							break;

					}

					pushFollow(FOLLOW_command_in_commands348);
					command42=command();
					state._fsp--;

					stream_command.add(command42.getTree());
					}
					break;

				default :
					break loop17;
				}
			}

			// ./grammars/AST.g:52:40: ( ';' )?
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0==44) ) {
				alt18=1;
			}
			switch (alt18) {
				case 1 :
					// ./grammars/AST.g:52:41: ';'
					{
					char_literal43=(Token)match(input,44,FOLLOW_44_in_commands353);  
					stream_44.add(char_literal43);

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
			// 52:47: -> ( command )+
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
	// ./grammars/AST.g:54:1: command : ( ( 'nop' ) -> 'nop' | ( vars WS ':=' WS exprs ) -> ^( ASSIGN vars exprs ) | ( 'if' WS expression WS 'then' WS commands WS ( ( WS )? 'else' WS commands WS )? 'fi' ) -> ^( IF expression commands ( commands )? ) | ( 'while' WS expression WS 'do' WS commands WS 'od' ) -> ^( WHILE expression commands ) | ( 'for' WS expression WS 'do' WS commands WS 'od' ) -> ^( FOR expression commands ) | ( 'foreach' WS VARIABLE WS 'in' WS expression WS 'do' WS commands WS 'od' ) -> ^( FOREACH VARIABLE expression commands ) );
	public final ASTParser.command_return command() throws RecognitionException {
		ASTParser.command_return retval = new ASTParser.command_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal44=null;
		Token WS46=null;
		Token string_literal47=null;
		Token WS48=null;
		Token string_literal50=null;
		Token WS51=null;
		Token WS53=null;
		Token string_literal54=null;
		Token WS55=null;
		Token WS57=null;
		Token WS58=null;
		Token string_literal59=null;
		Token WS60=null;
		Token WS62=null;
		Token string_literal63=null;
		Token string_literal64=null;
		Token WS65=null;
		Token WS67=null;
		Token string_literal68=null;
		Token WS69=null;
		Token WS71=null;
		Token string_literal72=null;
		Token string_literal73=null;
		Token WS74=null;
		Token WS76=null;
		Token string_literal77=null;
		Token WS78=null;
		Token WS80=null;
		Token string_literal81=null;
		Token string_literal82=null;
		Token WS83=null;
		Token VARIABLE84=null;
		Token WS85=null;
		Token string_literal86=null;
		Token WS87=null;
		Token WS89=null;
		Token string_literal90=null;
		Token WS91=null;
		Token WS93=null;
		Token string_literal94=null;
		ParserRuleReturnScope vars45 =null;
		ParserRuleReturnScope exprs49 =null;
		ParserRuleReturnScope expression52 =null;
		ParserRuleReturnScope commands56 =null;
		ParserRuleReturnScope commands61 =null;
		ParserRuleReturnScope expression66 =null;
		ParserRuleReturnScope commands70 =null;
		ParserRuleReturnScope expression75 =null;
		ParserRuleReturnScope commands79 =null;
		ParserRuleReturnScope expression88 =null;
		ParserRuleReturnScope commands92 =null;

		Object string_literal44_tree=null;
		Object WS46_tree=null;
		Object string_literal47_tree=null;
		Object WS48_tree=null;
		Object string_literal50_tree=null;
		Object WS51_tree=null;
		Object WS53_tree=null;
		Object string_literal54_tree=null;
		Object WS55_tree=null;
		Object WS57_tree=null;
		Object WS58_tree=null;
		Object string_literal59_tree=null;
		Object WS60_tree=null;
		Object WS62_tree=null;
		Object string_literal63_tree=null;
		Object string_literal64_tree=null;
		Object WS65_tree=null;
		Object WS67_tree=null;
		Object string_literal68_tree=null;
		Object WS69_tree=null;
		Object WS71_tree=null;
		Object string_literal72_tree=null;
		Object string_literal73_tree=null;
		Object WS74_tree=null;
		Object WS76_tree=null;
		Object string_literal77_tree=null;
		Object WS78_tree=null;
		Object WS80_tree=null;
		Object string_literal81_tree=null;
		Object string_literal82_tree=null;
		Object WS83_tree=null;
		Object VARIABLE84_tree=null;
		Object WS85_tree=null;
		Object string_literal86_tree=null;
		Object WS87_tree=null;
		Object WS89_tree=null;
		Object string_literal90_tree=null;
		Object WS91_tree=null;
		Object WS93_tree=null;
		Object string_literal94_tree=null;
		RewriteRuleTokenStream stream_55=new RewriteRuleTokenStream(adaptor,"token 55");
		RewriteRuleTokenStream stream_45=new RewriteRuleTokenStream(adaptor,"token 45");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_46=new RewriteRuleTokenStream(adaptor,"token 46");
		RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_48=new RewriteRuleTokenStream(adaptor,"token 48");
		RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
		RewriteRuleTokenStream stream_VARIABLE=new RewriteRuleTokenStream(adaptor,"token VARIABLE");
		RewriteRuleTokenStream stream_WS=new RewriteRuleTokenStream(adaptor,"token WS");
		RewriteRuleTokenStream stream_51=new RewriteRuleTokenStream(adaptor,"token 51");
		RewriteRuleTokenStream stream_52=new RewriteRuleTokenStream(adaptor,"token 52");
		RewriteRuleTokenStream stream_54=new RewriteRuleTokenStream(adaptor,"token 54");
		RewriteRuleTokenStream stream_43=new RewriteRuleTokenStream(adaptor,"token 43");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
		RewriteRuleSubtreeStream stream_exprs=new RewriteRuleSubtreeStream(adaptor,"rule exprs");
		RewriteRuleSubtreeStream stream_vars=new RewriteRuleSubtreeStream(adaptor,"rule vars");
		RewriteRuleSubtreeStream stream_commands=new RewriteRuleSubtreeStream(adaptor,"rule commands");

		try {
			// ./grammars/AST.g:54:8: ( ( 'nop' ) -> 'nop' | ( vars WS ':=' WS exprs ) -> ^( ASSIGN vars exprs ) | ( 'if' WS expression WS 'then' WS commands WS ( ( WS )? 'else' WS commands WS )? 'fi' ) -> ^( IF expression commands ( commands )? ) | ( 'while' WS expression WS 'do' WS commands WS 'od' ) -> ^( WHILE expression commands ) | ( 'for' WS expression WS 'do' WS commands WS 'od' ) -> ^( FOR expression commands ) | ( 'foreach' WS VARIABLE WS 'in' WS expression WS 'do' WS commands WS 'od' ) -> ^( FOREACH VARIABLE expression commands ) )
			int alt21=6;
			switch ( input.LA(1) ) {
			case 54:
				{
				alt21=1;
				}
				break;
			case VARIABLE:
				{
				alt21=2;
				}
				break;
			case 51:
				{
				alt21=3;
				}
				break;
			case 58:
				{
				alt21=4;
				}
				break;
			case 48:
				{
				alt21=5;
				}
				break;
			case 49:
				{
				alt21=6;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 21, 0, input);
				throw nvae;
			}
			switch (alt21) {
				case 1 :
					// ./grammars/AST.g:55:4: ( 'nop' )
					{
					// ./grammars/AST.g:55:4: ( 'nop' )
					// ./grammars/AST.g:55:5: 'nop'
					{
					string_literal44=(Token)match(input,54,FOLLOW_54_in_command371);  
					stream_54.add(string_literal44);

					}


					// AST REWRITE
					// elements: 54
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 55:12: -> 'nop'
					{
						adaptor.addChild(root_0, stream_54.nextNode());
					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// ./grammars/AST.g:56:4: ( vars WS ':=' WS exprs )
					{
					// ./grammars/AST.g:56:4: ( vars WS ':=' WS exprs )
					// ./grammars/AST.g:56:5: vars WS ':=' WS exprs
					{
					pushFollow(FOLLOW_vars_in_command382);
					vars45=vars();
					state._fsp--;

					stream_vars.add(vars45.getTree());
					WS46=(Token)match(input,WS,FOLLOW_WS_in_command384);  
					stream_WS.add(WS46);

					string_literal47=(Token)match(input,43,FOLLOW_43_in_command386);  
					stream_43.add(string_literal47);

					WS48=(Token)match(input,WS,FOLLOW_WS_in_command388);  
					stream_WS.add(WS48);

					pushFollow(FOLLOW_exprs_in_command390);
					exprs49=exprs();
					state._fsp--;

					stream_exprs.add(exprs49.getTree());
					}


					// AST REWRITE
					// elements: exprs, vars
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 56:28: -> ^( ASSIGN vars exprs )
					{
						// ./grammars/AST.g:56:31: ^( ASSIGN vars exprs )
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
					// ./grammars/AST.g:57:4: ( 'if' WS expression WS 'then' WS commands WS ( ( WS )? 'else' WS commands WS )? 'fi' )
					{
					// ./grammars/AST.g:57:4: ( 'if' WS expression WS 'then' WS commands WS ( ( WS )? 'else' WS commands WS )? 'fi' )
					// ./grammars/AST.g:57:5: 'if' WS expression WS 'then' WS commands WS ( ( WS )? 'else' WS commands WS )? 'fi'
					{
					string_literal50=(Token)match(input,51,FOLLOW_51_in_command407);  
					stream_51.add(string_literal50);

					WS51=(Token)match(input,WS,FOLLOW_WS_in_command409);  
					stream_WS.add(WS51);

					pushFollow(FOLLOW_expression_in_command411);
					expression52=expression();
					state._fsp--;

					stream_expression.add(expression52.getTree());
					WS53=(Token)match(input,WS,FOLLOW_WS_in_command413);  
					stream_WS.add(WS53);

					string_literal54=(Token)match(input,57,FOLLOW_57_in_command415);  
					stream_57.add(string_literal54);

					WS55=(Token)match(input,WS,FOLLOW_WS_in_command417);  
					stream_WS.add(WS55);

					pushFollow(FOLLOW_commands_in_command419);
					commands56=commands();
					state._fsp--;

					stream_commands.add(commands56.getTree());
					WS57=(Token)match(input,WS,FOLLOW_WS_in_command421);  
					stream_WS.add(WS57);

					// ./grammars/AST.g:57:49: ( ( WS )? 'else' WS commands WS )?
					int alt20=2;
					int LA20_0 = input.LA(1);
					if ( (LA20_0==WS||LA20_0==46) ) {
						alt20=1;
					}
					switch (alt20) {
						case 1 :
							// ./grammars/AST.g:57:50: ( WS )? 'else' WS commands WS
							{
							// ./grammars/AST.g:57:50: ( WS )?
							int alt19=2;
							int LA19_0 = input.LA(1);
							if ( (LA19_0==WS) ) {
								alt19=1;
							}
							switch (alt19) {
								case 1 :
									// ./grammars/AST.g:57:50: WS
									{
									WS58=(Token)match(input,WS,FOLLOW_WS_in_command424);  
									stream_WS.add(WS58);

									}
									break;

							}

							string_literal59=(Token)match(input,46,FOLLOW_46_in_command427);  
							stream_46.add(string_literal59);

							WS60=(Token)match(input,WS,FOLLOW_WS_in_command429);  
							stream_WS.add(WS60);

							pushFollow(FOLLOW_commands_in_command431);
							commands61=commands();
							state._fsp--;

							stream_commands.add(commands61.getTree());
							WS62=(Token)match(input,WS,FOLLOW_WS_in_command433);  
							stream_WS.add(WS62);

							}
							break;

					}

					string_literal63=(Token)match(input,47,FOLLOW_47_in_command437);  
					stream_47.add(string_literal63);

					}


					// AST REWRITE
					// elements: commands, expression, commands
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 57:84: -> ^( IF expression commands ( commands )? )
					{
						// ./grammars/AST.g:57:87: ^( IF expression commands ( commands )? )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF, "IF"), root_1);
						adaptor.addChild(root_1, stream_expression.nextTree());
						adaptor.addChild(root_1, stream_commands.nextTree());
						// ./grammars/AST.g:57:112: ( commands )?
						if ( stream_commands.hasNext() ) {
							adaptor.addChild(root_1, stream_commands.nextTree());
						}
						stream_commands.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 4 :
					// ./grammars/AST.g:58:4: ( 'while' WS expression WS 'do' WS commands WS 'od' )
					{
					// ./grammars/AST.g:58:4: ( 'while' WS expression WS 'do' WS commands WS 'od' )
					// ./grammars/AST.g:58:5: 'while' WS expression WS 'do' WS commands WS 'od'
					{
					string_literal64=(Token)match(input,58,FOLLOW_58_in_command459);  
					stream_58.add(string_literal64);

					WS65=(Token)match(input,WS,FOLLOW_WS_in_command461);  
					stream_WS.add(WS65);

					pushFollow(FOLLOW_expression_in_command463);
					expression66=expression();
					state._fsp--;

					stream_expression.add(expression66.getTree());
					WS67=(Token)match(input,WS,FOLLOW_WS_in_command465);  
					stream_WS.add(WS67);

					string_literal68=(Token)match(input,45,FOLLOW_45_in_command467);  
					stream_45.add(string_literal68);

					WS69=(Token)match(input,WS,FOLLOW_WS_in_command469);  
					stream_WS.add(WS69);

					pushFollow(FOLLOW_commands_in_command471);
					commands70=commands();
					state._fsp--;

					stream_commands.add(commands70.getTree());
					WS71=(Token)match(input,WS,FOLLOW_WS_in_command473);  
					stream_WS.add(WS71);

					string_literal72=(Token)match(input,55,FOLLOW_55_in_command475);  
					stream_55.add(string_literal72);

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
					// 58:56: -> ^( WHILE expression commands )
					{
						// ./grammars/AST.g:58:59: ^( WHILE expression commands )
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
					// ./grammars/AST.g:59:4: ( 'for' WS expression WS 'do' WS commands WS 'od' )
					{
					// ./grammars/AST.g:59:4: ( 'for' WS expression WS 'do' WS commands WS 'od' )
					// ./grammars/AST.g:59:5: 'for' WS expression WS 'do' WS commands WS 'od'
					{
					string_literal73=(Token)match(input,48,FOLLOW_48_in_command492);  
					stream_48.add(string_literal73);

					WS74=(Token)match(input,WS,FOLLOW_WS_in_command494);  
					stream_WS.add(WS74);

					pushFollow(FOLLOW_expression_in_command496);
					expression75=expression();
					state._fsp--;

					stream_expression.add(expression75.getTree());
					WS76=(Token)match(input,WS,FOLLOW_WS_in_command498);  
					stream_WS.add(WS76);

					string_literal77=(Token)match(input,45,FOLLOW_45_in_command500);  
					stream_45.add(string_literal77);

					WS78=(Token)match(input,WS,FOLLOW_WS_in_command502);  
					stream_WS.add(WS78);

					pushFollow(FOLLOW_commands_in_command504);
					commands79=commands();
					state._fsp--;

					stream_commands.add(commands79.getTree());
					WS80=(Token)match(input,WS,FOLLOW_WS_in_command506);  
					stream_WS.add(WS80);

					string_literal81=(Token)match(input,55,FOLLOW_55_in_command508);  
					stream_55.add(string_literal81);

					}


					// AST REWRITE
					// elements: commands, expression
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 59:54: -> ^( FOR expression commands )
					{
						// ./grammars/AST.g:59:57: ^( FOR expression commands )
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
					// ./grammars/AST.g:60:4: ( 'foreach' WS VARIABLE WS 'in' WS expression WS 'do' WS commands WS 'od' )
					{
					// ./grammars/AST.g:60:4: ( 'foreach' WS VARIABLE WS 'in' WS expression WS 'do' WS commands WS 'od' )
					// ./grammars/AST.g:60:5: 'foreach' WS VARIABLE WS 'in' WS expression WS 'do' WS commands WS 'od'
					{
					string_literal82=(Token)match(input,49,FOLLOW_49_in_command525);  
					stream_49.add(string_literal82);

					WS83=(Token)match(input,WS,FOLLOW_WS_in_command527);  
					stream_WS.add(WS83);

					VARIABLE84=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_command529);  
					stream_VARIABLE.add(VARIABLE84);

					WS85=(Token)match(input,WS,FOLLOW_WS_in_command531);  
					stream_WS.add(WS85);

					string_literal86=(Token)match(input,52,FOLLOW_52_in_command533);  
					stream_52.add(string_literal86);

					WS87=(Token)match(input,WS,FOLLOW_WS_in_command535);  
					stream_WS.add(WS87);

					pushFollow(FOLLOW_expression_in_command537);
					expression88=expression();
					state._fsp--;

					stream_expression.add(expression88.getTree());
					WS89=(Token)match(input,WS,FOLLOW_WS_in_command539);  
					stream_WS.add(WS89);

					string_literal90=(Token)match(input,45,FOLLOW_45_in_command541);  
					stream_45.add(string_literal90);

					WS91=(Token)match(input,WS,FOLLOW_WS_in_command543);  
					stream_WS.add(WS91);

					pushFollow(FOLLOW_commands_in_command545);
					commands92=commands();
					state._fsp--;

					stream_commands.add(commands92.getTree());
					WS93=(Token)match(input,WS,FOLLOW_WS_in_command547);  
					stream_WS.add(WS93);

					string_literal94=(Token)match(input,55,FOLLOW_55_in_command549);  
					stream_55.add(string_literal94);

					}


					// AST REWRITE
					// elements: commands, expression, VARIABLE
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 60:78: -> ^( FOREACH VARIABLE expression commands )
					{
						// ./grammars/AST.g:60:81: ^( FOREACH VARIABLE expression commands )
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
	// ./grammars/AST.g:62:1: vars : ( ( VARIABLE ( WS )? ',' vars ) -> VARIABLE | VARIABLE -> VARIABLE );
	public final ASTParser.vars_return vars() throws RecognitionException {
		ASTParser.vars_return retval = new ASTParser.vars_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token VARIABLE95=null;
		Token WS96=null;
		Token char_literal97=null;
		Token VARIABLE99=null;
		ParserRuleReturnScope vars98 =null;

		Object VARIABLE95_tree=null;
		Object WS96_tree=null;
		Object char_literal97_tree=null;
		Object VARIABLE99_tree=null;
		RewriteRuleTokenStream stream_VARIABLE=new RewriteRuleTokenStream(adaptor,"token VARIABLE");
		RewriteRuleTokenStream stream_WS=new RewriteRuleTokenStream(adaptor,"token WS");
		RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
		RewriteRuleSubtreeStream stream_vars=new RewriteRuleSubtreeStream(adaptor,"rule vars");

		try {
			// ./grammars/AST.g:62:7: ( ( VARIABLE ( WS )? ',' vars ) -> VARIABLE | VARIABLE -> VARIABLE )
			int alt23=2;
			int LA23_0 = input.LA(1);
			if ( (LA23_0==VARIABLE) ) {
				int LA23_1 = input.LA(2);
				if ( (LA23_1==WS) ) {
					int LA23_2 = input.LA(3);
					if ( (LA23_2==43) ) {
						alt23=2;
					}
					else if ( (LA23_2==41) ) {
						alt23=1;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 23, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}
				else if ( (LA23_1==41) ) {
					alt23=1;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 23, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 23, 0, input);
				throw nvae;
			}

			switch (alt23) {
				case 1 :
					// ./grammars/AST.g:63:4: ( VARIABLE ( WS )? ',' vars )
					{
					// ./grammars/AST.g:63:4: ( VARIABLE ( WS )? ',' vars )
					// ./grammars/AST.g:63:5: VARIABLE ( WS )? ',' vars
					{
					VARIABLE95=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_vars577);  
					stream_VARIABLE.add(VARIABLE95);

					// ./grammars/AST.g:63:14: ( WS )?
					int alt22=2;
					int LA22_0 = input.LA(1);
					if ( (LA22_0==WS) ) {
						alt22=1;
					}
					switch (alt22) {
						case 1 :
							// ./grammars/AST.g:63:14: WS
							{
							WS96=(Token)match(input,WS,FOLLOW_WS_in_vars579);  
							stream_WS.add(WS96);

							}
							break;

					}

					char_literal97=(Token)match(input,41,FOLLOW_41_in_vars582);  
					stream_41.add(char_literal97);

					pushFollow(FOLLOW_vars_in_vars584);
					vars98=vars();
					state._fsp--;

					stream_vars.add(vars98.getTree());
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
					// 63:28: -> VARIABLE
					{
						adaptor.addChild(root_0, stream_VARIABLE.nextNode());
					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// ./grammars/AST.g:64:4: VARIABLE
					{
					VARIABLE99=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_vars595);  
					stream_VARIABLE.add(VARIABLE99);


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
					// 64:13: -> VARIABLE
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
	// ./grammars/AST.g:67:1: exprs : expression ( ( WS )? ',' expression )* -> ( expression )+ ;
	public final ASTParser.exprs_return exprs() throws RecognitionException {
		ASTParser.exprs_return retval = new ASTParser.exprs_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token WS101=null;
		Token char_literal102=null;
		ParserRuleReturnScope expression100 =null;
		ParserRuleReturnScope expression103 =null;

		Object WS101_tree=null;
		Object char_literal102_tree=null;
		RewriteRuleTokenStream stream_WS=new RewriteRuleTokenStream(adaptor,"token WS");
		RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");

		try {
			// ./grammars/AST.g:67:8: ( expression ( ( WS )? ',' expression )* -> ( expression )+ )
			// ./grammars/AST.g:67:10: expression ( ( WS )? ',' expression )*
			{
			pushFollow(FOLLOW_expression_in_exprs610);
			expression100=expression();
			state._fsp--;

			stream_expression.add(expression100.getTree());
			// ./grammars/AST.g:67:21: ( ( WS )? ',' expression )*
			loop25:
			while (true) {
				int alt25=2;
				int LA25_0 = input.LA(1);
				if ( (LA25_0==WS) ) {
					int LA25_1 = input.LA(2);
					if ( (LA25_1==41) ) {
						alt25=1;
					}

				}
				else if ( (LA25_0==41) ) {
					alt25=1;
				}

				switch (alt25) {
				case 1 :
					// ./grammars/AST.g:67:22: ( WS )? ',' expression
					{
					// ./grammars/AST.g:67:22: ( WS )?
					int alt24=2;
					int LA24_0 = input.LA(1);
					if ( (LA24_0==WS) ) {
						alt24=1;
					}
					switch (alt24) {
						case 1 :
							// ./grammars/AST.g:67:22: WS
							{
							WS101=(Token)match(input,WS,FOLLOW_WS_in_exprs613);  
							stream_WS.add(WS101);

							}
							break;

					}

					char_literal102=(Token)match(input,41,FOLLOW_41_in_exprs616);  
					stream_41.add(char_literal102);

					pushFollow(FOLLOW_expression_in_exprs617);
					expression103=expression();
					state._fsp--;

					stream_expression.add(expression103.getTree());
					}
					break;

				default :
					break loop25;
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
			// 67:42: -> ( expression )+
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
	// ./grammars/AST.g:69:1: expression : e1= exprbase ( ' = ' e2= exprbase -> ^( EXPRESSION ^( EQUALS $e1 $e2) ) | -> ^( EXPRESSION $e1) ) ;
	public final ASTParser.expression_return expression() throws RecognitionException {
		ASTParser.expression_return retval = new ASTParser.expression_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal104=null;
		ParserRuleReturnScope e1 =null;
		ParserRuleReturnScope e2 =null;

		Object string_literal104_tree=null;
		RewriteRuleTokenStream stream_33=new RewriteRuleTokenStream(adaptor,"token 33");
		RewriteRuleSubtreeStream stream_exprbase=new RewriteRuleSubtreeStream(adaptor,"rule exprbase");

		try {
			// ./grammars/AST.g:70:2: (e1= exprbase ( ' = ' e2= exprbase -> ^( EXPRESSION ^( EQUALS $e1 $e2) ) | -> ^( EXPRESSION $e1) ) )
			// ./grammars/AST.g:70:5: e1= exprbase ( ' = ' e2= exprbase -> ^( EXPRESSION ^( EQUALS $e1 $e2) ) | -> ^( EXPRESSION $e1) )
			{
			pushFollow(FOLLOW_exprbase_in_expression638);
			e1=exprbase();
			state._fsp--;

			stream_exprbase.add(e1.getTree());
			// ./grammars/AST.g:70:16: ( ' = ' e2= exprbase -> ^( EXPRESSION ^( EQUALS $e1 $e2) ) | -> ^( EXPRESSION $e1) )
			int alt26=2;
			int LA26_0 = input.LA(1);
			if ( (LA26_0==33) ) {
				alt26=1;
			}
			else if ( (LA26_0==WS||LA26_0==41||LA26_0==44) ) {
				alt26=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 26, 0, input);
				throw nvae;
			}

			switch (alt26) {
				case 1 :
					// ./grammars/AST.g:71:3: ' = ' e2= exprbase
					{
					string_literal104=(Token)match(input,33,FOLLOW_33_in_expression643);  
					stream_33.add(string_literal104);

					pushFollow(FOLLOW_exprbase_in_expression646);
					e2=exprbase();
					state._fsp--;

					stream_exprbase.add(e2.getTree());

					// AST REWRITE
					// elements: e2, e1
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
					// 71:20: -> ^( EXPRESSION ^( EQUALS $e1 $e2) )
					{
						// ./grammars/AST.g:71:23: ^( EXPRESSION ^( EQUALS $e1 $e2) )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EXPRESSION, "EXPRESSION"), root_1);
						// ./grammars/AST.g:71:36: ^( EQUALS $e1 $e2)
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
					// ./grammars/AST.g:72:5: 
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
					// 72:5: -> ^( EXPRESSION $e1)
					{
						// ./grammars/AST.g:72:8: ^( EXPRESSION $e1)
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
	// ./grammars/AST.g:75:1: exprbase : ( '(hd ' exprbase ')' -> ^( HEAD exprbase ) | '(tl ' exprbase ')' -> ^( TAIL exprbase ) | '(cons ' lexpr ')' -> ^( CONS lexpr ) | '(list ' lexpr ')' -> ^( LIST lexpr ) | '(' SYMBOL WS lexpr ')' -> ^( FUNCTIONCALL ^( SYMBOL lexpr ) ) | 'nil' -> NIL | VARIABLE -> VARIABLE | SYMBOL -> SYMBOL );
	public final ASTParser.exprbase_return exprbase() throws RecognitionException {
		ASTParser.exprbase_return retval = new ASTParser.exprbase_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal105=null;
		Token char_literal107=null;
		Token string_literal108=null;
		Token char_literal110=null;
		Token string_literal111=null;
		Token char_literal113=null;
		Token string_literal114=null;
		Token char_literal116=null;
		Token char_literal117=null;
		Token SYMBOL118=null;
		Token WS119=null;
		Token char_literal121=null;
		Token string_literal122=null;
		Token VARIABLE123=null;
		Token SYMBOL124=null;
		ParserRuleReturnScope exprbase106 =null;
		ParserRuleReturnScope exprbase109 =null;
		ParserRuleReturnScope lexpr112 =null;
		ParserRuleReturnScope lexpr115 =null;
		ParserRuleReturnScope lexpr120 =null;

		Object string_literal105_tree=null;
		Object char_literal107_tree=null;
		Object string_literal108_tree=null;
		Object char_literal110_tree=null;
		Object string_literal111_tree=null;
		Object char_literal113_tree=null;
		Object string_literal114_tree=null;
		Object char_literal116_tree=null;
		Object char_literal117_tree=null;
		Object SYMBOL118_tree=null;
		Object WS119_tree=null;
		Object char_literal121_tree=null;
		Object string_literal122_tree=null;
		Object VARIABLE123_tree=null;
		Object SYMBOL124_tree=null;
		RewriteRuleTokenStream stream_35=new RewriteRuleTokenStream(adaptor,"token 35");
		RewriteRuleTokenStream stream_36=new RewriteRuleTokenStream(adaptor,"token 36");
		RewriteRuleTokenStream stream_37=new RewriteRuleTokenStream(adaptor,"token 37");
		RewriteRuleTokenStream stream_SYMBOL=new RewriteRuleTokenStream(adaptor,"token SYMBOL");
		RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
		RewriteRuleTokenStream stream_39=new RewriteRuleTokenStream(adaptor,"token 39");
		RewriteRuleTokenStream stream_VARIABLE=new RewriteRuleTokenStream(adaptor,"token VARIABLE");
		RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
		RewriteRuleTokenStream stream_WS=new RewriteRuleTokenStream(adaptor,"token WS");
		RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
		RewriteRuleSubtreeStream stream_lexpr=new RewriteRuleSubtreeStream(adaptor,"rule lexpr");
		RewriteRuleSubtreeStream stream_exprbase=new RewriteRuleSubtreeStream(adaptor,"rule exprbase");

		try {
			// ./grammars/AST.g:76:2: ( '(hd ' exprbase ')' -> ^( HEAD exprbase ) | '(tl ' exprbase ')' -> ^( TAIL exprbase ) | '(cons ' lexpr ')' -> ^( CONS lexpr ) | '(list ' lexpr ')' -> ^( LIST lexpr ) | '(' SYMBOL WS lexpr ')' -> ^( FUNCTIONCALL ^( SYMBOL lexpr ) ) | 'nil' -> NIL | VARIABLE -> VARIABLE | SYMBOL -> SYMBOL )
			int alt27=8;
			switch ( input.LA(1) ) {
			case 37:
				{
				alt27=1;
				}
				break;
			case 39:
				{
				alt27=2;
				}
				break;
			case 36:
				{
				alt27=3;
				}
				break;
			case 38:
				{
				alt27=4;
				}
				break;
			case 35:
				{
				alt27=5;
				}
				break;
			case 53:
				{
				alt27=6;
				}
				break;
			case VARIABLE:
				{
				alt27=7;
				}
				break;
			case SYMBOL:
				{
				alt27=8;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 27, 0, input);
				throw nvae;
			}
			switch (alt27) {
				case 1 :
					// ./grammars/AST.g:76:4: '(hd ' exprbase ')'
					{
					string_literal105=(Token)match(input,37,FOLLOW_37_in_exprbase688);  
					stream_37.add(string_literal105);

					pushFollow(FOLLOW_exprbase_in_exprbase689);
					exprbase106=exprbase();
					state._fsp--;

					stream_exprbase.add(exprbase106.getTree());
					char_literal107=(Token)match(input,40,FOLLOW_40_in_exprbase690);  
					stream_40.add(char_literal107);


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
					// 76:22: -> ^( HEAD exprbase )
					{
						// ./grammars/AST.g:76:25: ^( HEAD exprbase )
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
				case 2 :
					// ./grammars/AST.g:77:4: '(tl ' exprbase ')'
					{
					string_literal108=(Token)match(input,39,FOLLOW_39_in_exprbase703);  
					stream_39.add(string_literal108);

					pushFollow(FOLLOW_exprbase_in_exprbase704);
					exprbase109=exprbase();
					state._fsp--;

					stream_exprbase.add(exprbase109.getTree());
					char_literal110=(Token)match(input,40,FOLLOW_40_in_exprbase705);  
					stream_40.add(char_literal110);


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
					// 77:22: -> ^( TAIL exprbase )
					{
						// ./grammars/AST.g:77:25: ^( TAIL exprbase )
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
				case 3 :
					// ./grammars/AST.g:78:5: '(cons ' lexpr ')'
					{
					string_literal111=(Token)match(input,36,FOLLOW_36_in_exprbase719);  
					stream_36.add(string_literal111);

					pushFollow(FOLLOW_lexpr_in_exprbase721);
					lexpr112=lexpr();
					state._fsp--;

					stream_lexpr.add(lexpr112.getTree());
					char_literal113=(Token)match(input,40,FOLLOW_40_in_exprbase722);  
					stream_40.add(char_literal113);


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
					// 78:23: -> ^( CONS lexpr )
					{
						// ./grammars/AST.g:78:26: ^( CONS lexpr )
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
				case 4 :
					// ./grammars/AST.g:79:4: '(list ' lexpr ')'
					{
					string_literal114=(Token)match(input,38,FOLLOW_38_in_exprbase735);  
					stream_38.add(string_literal114);

					pushFollow(FOLLOW_lexpr_in_exprbase737);
					lexpr115=lexpr();
					state._fsp--;

					stream_lexpr.add(lexpr115.getTree());
					char_literal116=(Token)match(input,40,FOLLOW_40_in_exprbase738);  
					stream_40.add(char_literal116);


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
					// 79:22: -> ^( LIST lexpr )
					{
						// ./grammars/AST.g:79:25: ^( LIST lexpr )
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
				case 5 :
					// ./grammars/AST.g:80:4: '(' SYMBOL WS lexpr ')'
					{
					char_literal117=(Token)match(input,35,FOLLOW_35_in_exprbase751);  
					stream_35.add(char_literal117);

					SYMBOL118=(Token)match(input,SYMBOL,FOLLOW_SYMBOL_in_exprbase752);  
					stream_SYMBOL.add(SYMBOL118);

					WS119=(Token)match(input,WS,FOLLOW_WS_in_exprbase754);  
					stream_WS.add(WS119);

					pushFollow(FOLLOW_lexpr_in_exprbase756);
					lexpr120=lexpr();
					state._fsp--;

					stream_lexpr.add(lexpr120.getTree());
					char_literal121=(Token)match(input,40,FOLLOW_40_in_exprbase757);  
					stream_40.add(char_literal121);


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
					// 80:26: -> ^( FUNCTIONCALL ^( SYMBOL lexpr ) )
					{
						// ./grammars/AST.g:80:29: ^( FUNCTIONCALL ^( SYMBOL lexpr ) )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNCTIONCALL, "FUNCTIONCALL"), root_1);
						// ./grammars/AST.g:80:44: ^( SYMBOL lexpr )
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
				case 6 :
					// ./grammars/AST.g:81:4: 'nil'
					{
					string_literal122=(Token)match(input,53,FOLLOW_53_in_exprbase774);  
					stream_53.add(string_literal122);


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
					// 81:10: -> NIL
					{
						adaptor.addChild(root_0, (Object)adaptor.create(NIL, "NIL"));
					}


					retval.tree = root_0;

					}
					break;
				case 7 :
					// ./grammars/AST.g:82:5: VARIABLE
					{
					VARIABLE123=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_exprbase784);  
					stream_VARIABLE.add(VARIABLE123);


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
					// 82:14: -> VARIABLE
					{
						adaptor.addChild(root_0, stream_VARIABLE.nextNode());
					}


					retval.tree = root_0;

					}
					break;
				case 8 :
					// ./grammars/AST.g:83:5: SYMBOL
					{
					SYMBOL124=(Token)match(input,SYMBOL,FOLLOW_SYMBOL_in_exprbase794);  
					stream_SYMBOL.add(SYMBOL124);


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
					// 83:12: -> SYMBOL
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
	// ./grammars/AST.g:85:2: lexpr : ( ( WS )? ( exprbase ( WS )? )* ) -> ( exprbase )* ;
	public final ASTParser.lexpr_return lexpr() throws RecognitionException {
		ASTParser.lexpr_return retval = new ASTParser.lexpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token WS125=null;
		Token WS127=null;
		ParserRuleReturnScope exprbase126 =null;

		Object WS125_tree=null;
		Object WS127_tree=null;
		RewriteRuleTokenStream stream_WS=new RewriteRuleTokenStream(adaptor,"token WS");
		RewriteRuleSubtreeStream stream_exprbase=new RewriteRuleSubtreeStream(adaptor,"rule exprbase");

		try {
			// ./grammars/AST.g:86:5: ( ( ( WS )? ( exprbase ( WS )? )* ) -> ( exprbase )* )
			// ./grammars/AST.g:86:7: ( ( WS )? ( exprbase ( WS )? )* )
			{
			// ./grammars/AST.g:86:7: ( ( WS )? ( exprbase ( WS )? )* )
			// ./grammars/AST.g:86:8: ( WS )? ( exprbase ( WS )? )*
			{
			// ./grammars/AST.g:86:8: ( WS )?
			int alt28=2;
			int LA28_0 = input.LA(1);
			if ( (LA28_0==WS) ) {
				alt28=1;
			}
			switch (alt28) {
				case 1 :
					// ./grammars/AST.g:86:8: WS
					{
					WS125=(Token)match(input,WS,FOLLOW_WS_in_lexpr814);  
					stream_WS.add(WS125);

					}
					break;

			}

			// ./grammars/AST.g:86:12: ( exprbase ( WS )? )*
			loop30:
			while (true) {
				int alt30=2;
				int LA30_0 = input.LA(1);
				if ( (LA30_0==SYMBOL||LA30_0==VARIABLE||(LA30_0 >= 35 && LA30_0 <= 39)||LA30_0==53) ) {
					alt30=1;
				}

				switch (alt30) {
				case 1 :
					// ./grammars/AST.g:86:13: exprbase ( WS )?
					{
					pushFollow(FOLLOW_exprbase_in_lexpr818);
					exprbase126=exprbase();
					state._fsp--;

					stream_exprbase.add(exprbase126.getTree());
					// ./grammars/AST.g:86:22: ( WS )?
					int alt29=2;
					int LA29_0 = input.LA(1);
					if ( (LA29_0==WS) ) {
						alt29=1;
					}
					switch (alt29) {
						case 1 :
							// ./grammars/AST.g:86:22: WS
							{
							WS127=(Token)match(input,WS,FOLLOW_WS_in_lexpr820);  
							stream_WS.add(WS127);

							}
							break;

					}

					}
					break;

				default :
					break loop30;
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
			// 86:29: -> ( exprbase )*
			{
				// ./grammars/AST.g:86:32: ( exprbase )*
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



	public static final BitSet FOLLOW_function_in_program137 = new BitSet(new long[]{0x0004000100000002L});
	public static final BitSet FOLLOW_WS_in_function150 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_50_in_function153 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_WS_in_function155 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_SYMBOL_in_function157 = new BitSet(new long[]{0x0000040100000000L});
	public static final BitSet FOLLOW_WS_in_function159 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_42_in_function162 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_WS_in_function164 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_definition_in_function166 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_definition185 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_WS_in_definition187 = new BitSet(new long[]{0x0000000520000000L});
	public static final BitSet FOLLOW_input_in_definition190 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_WS_in_definition192 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_34_in_definition196 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_WS_in_definition198 = new BitSet(new long[]{0x044B000120000000L});
	public static final BitSet FOLLOW_commands_in_definition200 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_WS_in_definition202 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_34_in_definition204 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_WS_in_definition206 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_59_in_definition208 = new BitSet(new long[]{0x0000000120000000L});
	public static final BitSet FOLLOW_output_in_definition210 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_inputsub_in_input239 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WS_in_inputsub257 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_VARIABLE_in_inputsub260 = new BitSet(new long[]{0x0000020100000000L});
	public static final BitSet FOLLOW_WS_in_inputsub262 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_41_in_inputsub265 = new BitSet(new long[]{0x0000000120000000L});
	public static final BitSet FOLLOW_inputsub_in_inputsub267 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WS_in_inputsub278 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_VARIABLE_in_inputsub281 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WS_in_output293 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_VARIABLE_in_output296 = new BitSet(new long[]{0x0000020100000000L});
	public static final BitSet FOLLOW_WS_in_output298 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_41_in_output301 = new BitSet(new long[]{0x0000000120000000L});
	public static final BitSet FOLLOW_output_in_output303 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WS_in_output314 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_VARIABLE_in_output317 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WS_in_commands334 = new BitSet(new long[]{0x044B000020000000L});
	public static final BitSet FOLLOW_command_in_commands337 = new BitSet(new long[]{0x0000100100000002L});
	public static final BitSet FOLLOW_WS_in_commands340 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_44_in_commands343 = new BitSet(new long[]{0x044B000120000000L});
	public static final BitSet FOLLOW_WS_in_commands345 = new BitSet(new long[]{0x044B000020000000L});
	public static final BitSet FOLLOW_command_in_commands348 = new BitSet(new long[]{0x0000100100000002L});
	public static final BitSet FOLLOW_44_in_commands353 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_54_in_command371 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_vars_in_command382 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_WS_in_command384 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_43_in_command386 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_WS_in_command388 = new BitSet(new long[]{0x002000F824000000L});
	public static final BitSet FOLLOW_exprs_in_command390 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_51_in_command407 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_WS_in_command409 = new BitSet(new long[]{0x002000F824000000L});
	public static final BitSet FOLLOW_expression_in_command411 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_WS_in_command413 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_command415 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_WS_in_command417 = new BitSet(new long[]{0x044B000120000000L});
	public static final BitSet FOLLOW_commands_in_command419 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_WS_in_command421 = new BitSet(new long[]{0x0000C00100000000L});
	public static final BitSet FOLLOW_WS_in_command424 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_46_in_command427 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_WS_in_command429 = new BitSet(new long[]{0x044B000120000000L});
	public static final BitSet FOLLOW_commands_in_command431 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_WS_in_command433 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_47_in_command437 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_58_in_command459 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_WS_in_command461 = new BitSet(new long[]{0x002000F824000000L});
	public static final BitSet FOLLOW_expression_in_command463 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_WS_in_command465 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_45_in_command467 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_WS_in_command469 = new BitSet(new long[]{0x044B000120000000L});
	public static final BitSet FOLLOW_commands_in_command471 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_WS_in_command473 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_55_in_command475 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_48_in_command492 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_WS_in_command494 = new BitSet(new long[]{0x002000F824000000L});
	public static final BitSet FOLLOW_expression_in_command496 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_WS_in_command498 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_45_in_command500 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_WS_in_command502 = new BitSet(new long[]{0x044B000120000000L});
	public static final BitSet FOLLOW_commands_in_command504 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_WS_in_command506 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_55_in_command508 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_49_in_command525 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_WS_in_command527 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_VARIABLE_in_command529 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_WS_in_command531 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_52_in_command533 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_WS_in_command535 = new BitSet(new long[]{0x002000F824000000L});
	public static final BitSet FOLLOW_expression_in_command537 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_WS_in_command539 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_45_in_command541 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_WS_in_command543 = new BitSet(new long[]{0x044B000120000000L});
	public static final BitSet FOLLOW_commands_in_command545 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_WS_in_command547 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_55_in_command549 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VARIABLE_in_vars577 = new BitSet(new long[]{0x0000020100000000L});
	public static final BitSet FOLLOW_WS_in_vars579 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_41_in_vars582 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_vars_in_vars584 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VARIABLE_in_vars595 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_exprs610 = new BitSet(new long[]{0x0000020100000002L});
	public static final BitSet FOLLOW_WS_in_exprs613 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_41_in_exprs616 = new BitSet(new long[]{0x002000F824000000L});
	public static final BitSet FOLLOW_expression_in_exprs617 = new BitSet(new long[]{0x0000020100000002L});
	public static final BitSet FOLLOW_exprbase_in_expression638 = new BitSet(new long[]{0x0000000200000002L});
	public static final BitSet FOLLOW_33_in_expression643 = new BitSet(new long[]{0x002000F824000000L});
	public static final BitSet FOLLOW_exprbase_in_expression646 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_37_in_exprbase688 = new BitSet(new long[]{0x002000F824000000L});
	public static final BitSet FOLLOW_exprbase_in_exprbase689 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_40_in_exprbase690 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_39_in_exprbase703 = new BitSet(new long[]{0x002000F824000000L});
	public static final BitSet FOLLOW_exprbase_in_exprbase704 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_40_in_exprbase705 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_36_in_exprbase719 = new BitSet(new long[]{0x002001F924000000L});
	public static final BitSet FOLLOW_lexpr_in_exprbase721 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_40_in_exprbase722 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_38_in_exprbase735 = new BitSet(new long[]{0x002001F924000000L});
	public static final BitSet FOLLOW_lexpr_in_exprbase737 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_40_in_exprbase738 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_35_in_exprbase751 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_SYMBOL_in_exprbase752 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_WS_in_exprbase754 = new BitSet(new long[]{0x002001F924000000L});
	public static final BitSet FOLLOW_lexpr_in_exprbase756 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_40_in_exprbase757 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_53_in_exprbase774 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VARIABLE_in_exprbase784 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SYMBOL_in_exprbase794 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WS_in_lexpr814 = new BitSet(new long[]{0x002000F824000002L});
	public static final BitSet FOLLOW_exprbase_in_lexpr818 = new BitSet(new long[]{0x002000F924000002L});
	public static final BitSet FOLLOW_WS_in_lexpr820 = new BitSet(new long[]{0x002000F824000002L});
}
