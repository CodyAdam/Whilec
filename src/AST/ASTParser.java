package AST;
// $ANTLR 3.5.3 ./grammars/AST.g 2023-01-15 21:12:34

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class ASTParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASSIGN", "COMMAND", "COMMANDS", 
		"CONS", "DIGIT", "ELSECOMMANDS", "EQUALS", "EXPRESSION", "EXPRESSIONS", 
		"EXPRS", "EXPR_BASE", "FOR", "FOREACH", "FUNCDEF", "FUNCTION", "FUNCTIONCALL", 
		"HEAD", "IF", "INPUT", "LIST", "NIL", "NOP", "OUTPUT", "ROOT", "SYMBOL", 
		"SYMBOL_LEX", "TAIL", "TOKENS", "VARIABLE", "VARIABLE_LEX", "VARS", "WHILE", 
		"WS", "' = '", "'%'", "'('", "')'", "','", "':'", "':='", "';'", "'cons '", 
		"'do'", "'else'", "'fi'", "'for'", "'foreach'", "'function'", "'hd '", 
		"'if'", "'in'", "'list '", "'nil'", "'nop'", "'od'", "'read'", "'then'", 
		"'tl '", "'while'", "'write'"
	};
	public static final int EOF=-1;
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
	public static final int T__61=61;
	public static final int T__62=62;
	public static final int T__63=63;
	public static final int ASSIGN=4;
	public static final int COMMAND=5;
	public static final int COMMANDS=6;
	public static final int CONS=7;
	public static final int DIGIT=8;
	public static final int ELSECOMMANDS=9;
	public static final int EQUALS=10;
	public static final int EXPRESSION=11;
	public static final int EXPRESSIONS=12;
	public static final int EXPRS=13;
	public static final int EXPR_BASE=14;
	public static final int FOR=15;
	public static final int FOREACH=16;
	public static final int FUNCDEF=17;
	public static final int FUNCTION=18;
	public static final int FUNCTIONCALL=19;
	public static final int HEAD=20;
	public static final int IF=21;
	public static final int INPUT=22;
	public static final int LIST=23;
	public static final int NIL=24;
	public static final int NOP=25;
	public static final int OUTPUT=26;
	public static final int ROOT=27;
	public static final int SYMBOL=28;
	public static final int SYMBOL_LEX=29;
	public static final int TAIL=30;
	public static final int TOKENS=31;
	public static final int VARIABLE=32;
	public static final int VARIABLE_LEX=33;
	public static final int VARS=34;
	public static final int WHILE=35;
	public static final int WS=36;

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
	// ./grammars/AST.g:40:1: program : ( WS )* ( function ( WS )* )+ -> ^( ROOT ( function )+ ) ;
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
			// ./grammars/AST.g:40:8: ( ( WS )* ( function ( WS )* )+ -> ^( ROOT ( function )+ ) )
			// ./grammars/AST.g:40:10: ( WS )* ( function ( WS )* )+
			{
			// ./grammars/AST.g:40:10: ( WS )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==WS) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// ./grammars/AST.g:40:10: WS
					{
					WS1=(Token)match(input,WS,FOLLOW_WS_in_program144);  
					stream_WS.add(WS1);

					}
					break;

				default :
					break loop1;
				}
			}

			// ./grammars/AST.g:40:14: ( function ( WS )* )+
			int cnt3=0;
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==51) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// ./grammars/AST.g:40:15: function ( WS )*
					{
					pushFollow(FOLLOW_function_in_program148);
					function2=function();
					state._fsp--;

					stream_function.add(function2.getTree());
					// ./grammars/AST.g:40:24: ( WS )*
					loop2:
					while (true) {
						int alt2=2;
						int LA2_0 = input.LA(1);
						if ( (LA2_0==WS) ) {
							alt2=1;
						}

						switch (alt2) {
						case 1 :
							// ./grammars/AST.g:40:24: WS
							{
							WS3=(Token)match(input,WS,FOLLOW_WS_in_program150);  
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
			// 40:30: -> ^( ROOT ( function )+ )
			{
				// ./grammars/AST.g:40:33: ^( ROOT ( function )+ )
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
	// ./grammars/AST.g:42:1: function : 'function' WS SYMBOL_LEX ( WS )? ':' WS definition -> ^( FUNCTION ^( SYMBOL_LEX definition ) ) ;
	public final ASTParser.function_return function() throws RecognitionException {
		ASTParser.function_return retval = new ASTParser.function_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal4=null;
		Token WS5=null;
		Token SYMBOL_LEX6=null;
		Token WS7=null;
		Token char_literal8=null;
		Token WS9=null;
		ParserRuleReturnScope definition10 =null;

		Object string_literal4_tree=null;
		Object WS5_tree=null;
		Object SYMBOL_LEX6_tree=null;
		Object WS7_tree=null;
		Object char_literal8_tree=null;
		Object WS9_tree=null;
		RewriteRuleTokenStream stream_SYMBOL_LEX=new RewriteRuleTokenStream(adaptor,"token SYMBOL_LEX");
		RewriteRuleTokenStream stream_51=new RewriteRuleTokenStream(adaptor,"token 51");
		RewriteRuleTokenStream stream_WS=new RewriteRuleTokenStream(adaptor,"token WS");
		RewriteRuleTokenStream stream_42=new RewriteRuleTokenStream(adaptor,"token 42");
		RewriteRuleSubtreeStream stream_definition=new RewriteRuleSubtreeStream(adaptor,"rule definition");

		try {
			// ./grammars/AST.g:42:9: ( 'function' WS SYMBOL_LEX ( WS )? ':' WS definition -> ^( FUNCTION ^( SYMBOL_LEX definition ) ) )
			// ./grammars/AST.g:42:11: 'function' WS SYMBOL_LEX ( WS )? ':' WS definition
			{
			string_literal4=(Token)match(input,51,FOLLOW_51_in_function169);  
			stream_51.add(string_literal4);

			WS5=(Token)match(input,WS,FOLLOW_WS_in_function171);  
			stream_WS.add(WS5);

			SYMBOL_LEX6=(Token)match(input,SYMBOL_LEX,FOLLOW_SYMBOL_LEX_in_function173);  
			stream_SYMBOL_LEX.add(SYMBOL_LEX6);

			// ./grammars/AST.g:42:36: ( WS )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==WS) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// ./grammars/AST.g:42:36: WS
					{
					WS7=(Token)match(input,WS,FOLLOW_WS_in_function175);  
					stream_WS.add(WS7);

					}
					break;

			}

			char_literal8=(Token)match(input,42,FOLLOW_42_in_function178);  
			stream_42.add(char_literal8);

			WS9=(Token)match(input,WS,FOLLOW_WS_in_function180);  
			stream_WS.add(WS9);

			pushFollow(FOLLOW_definition_in_function182);
			definition10=definition();
			state._fsp--;

			stream_definition.add(definition10.getTree());

			// AST REWRITE
			// elements: SYMBOL_LEX, definition
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 42:57: -> ^( FUNCTION ^( SYMBOL_LEX definition ) )
			{
				// ./grammars/AST.g:42:60: ^( FUNCTION ^( SYMBOL_LEX definition ) )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNCTION, "FUNCTION"), root_1);
				// ./grammars/AST.g:42:71: ^( SYMBOL_LEX definition )
				{
				Object root_2 = (Object)adaptor.nil();
				root_2 = (Object)adaptor.becomeRoot(stream_SYMBOL_LEX.nextNode(), root_2);
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
	// ./grammars/AST.g:44:1: definition : 'read' WS ( input WS )? '%' WS commands WS '%' WS 'write' output -> ^( FUNCDEF ( input )? ^( COMMANDS commands ) ^( OUTPUT output ) ) ;
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
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
		RewriteRuleTokenStream stream_WS=new RewriteRuleTokenStream(adaptor,"token WS");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleSubtreeStream stream_output=new RewriteRuleSubtreeStream(adaptor,"rule output");
		RewriteRuleSubtreeStream stream_input=new RewriteRuleSubtreeStream(adaptor,"rule input");
		RewriteRuleSubtreeStream stream_commands=new RewriteRuleSubtreeStream(adaptor,"rule commands");

		try {
			// ./grammars/AST.g:44:11: ( 'read' WS ( input WS )? '%' WS commands WS '%' WS 'write' output -> ^( FUNCDEF ( input )? ^( COMMANDS commands ) ^( OUTPUT output ) ) )
			// ./grammars/AST.g:45:2: 'read' WS ( input WS )? '%' WS commands WS '%' WS 'write' output
			{
			string_literal11=(Token)match(input,59,FOLLOW_59_in_definition201);  
			stream_59.add(string_literal11);

			WS12=(Token)match(input,WS,FOLLOW_WS_in_definition203);  
			stream_WS.add(WS12);

			// ./grammars/AST.g:45:12: ( input WS )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==VARIABLE_LEX||LA5_0==WS) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// ./grammars/AST.g:45:13: input WS
					{
					pushFollow(FOLLOW_input_in_definition206);
					input13=input();
					state._fsp--;

					stream_input.add(input13.getTree());
					WS14=(Token)match(input,WS,FOLLOW_WS_in_definition208);  
					stream_WS.add(WS14);

					}
					break;

			}

			char_literal15=(Token)match(input,38,FOLLOW_38_in_definition212);  
			stream_38.add(char_literal15);

			WS16=(Token)match(input,WS,FOLLOW_WS_in_definition214);  
			stream_WS.add(WS16);

			pushFollow(FOLLOW_commands_in_definition216);
			commands17=commands();
			state._fsp--;

			stream_commands.add(commands17.getTree());
			WS18=(Token)match(input,WS,FOLLOW_WS_in_definition218);  
			stream_WS.add(WS18);

			char_literal19=(Token)match(input,38,FOLLOW_38_in_definition220);  
			stream_38.add(char_literal19);

			WS20=(Token)match(input,WS,FOLLOW_WS_in_definition222);  
			stream_WS.add(WS20);

			string_literal21=(Token)match(input,63,FOLLOW_63_in_definition224);  
			stream_63.add(string_literal21);

			pushFollow(FOLLOW_output_in_definition226);
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
			// 45:65: -> ^( FUNCDEF ( input )? ^( COMMANDS commands ) ^( OUTPUT output ) )
			{
				// ./grammars/AST.g:45:68: ^( FUNCDEF ( input )? ^( COMMANDS commands ) ^( OUTPUT output ) )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNCDEF, "FUNCDEF"), root_1);
				// ./grammars/AST.g:45:78: ( input )?
				if ( stream_input.hasNext() ) {
					adaptor.addChild(root_1, stream_input.nextTree());
				}
				stream_input.reset();

				// ./grammars/AST.g:45:85: ^( COMMANDS commands )
				{
				Object root_2 = (Object)adaptor.nil();
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(COMMANDS, "COMMANDS"), root_2);
				adaptor.addChild(root_2, stream_commands.nextTree());
				adaptor.addChild(root_1, root_2);
				}

				// ./grammars/AST.g:45:106: ^( OUTPUT output )
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
	// ./grammars/AST.g:47:1: input : ( inputsub )? -> ^( INPUT ( inputsub )? ) ;
	public final ASTParser.input_return input() throws RecognitionException {
		ASTParser.input_return retval = new ASTParser.input_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope inputsub23 =null;

		RewriteRuleSubtreeStream stream_inputsub=new RewriteRuleSubtreeStream(adaptor,"rule inputsub");

		try {
			// ./grammars/AST.g:47:6: ( ( inputsub )? -> ^( INPUT ( inputsub )? ) )
			// ./grammars/AST.g:47:8: ( inputsub )?
			{
			// ./grammars/AST.g:47:8: ( inputsub )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==WS) ) {
				int LA6_1 = input.LA(2);
				if ( (LA6_1==VARIABLE_LEX) ) {
					alt6=1;
				}
			}
			else if ( (LA6_0==VARIABLE_LEX) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// ./grammars/AST.g:47:8: inputsub
					{
					pushFollow(FOLLOW_inputsub_in_input255);
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
			// 47:18: -> ^( INPUT ( inputsub )? )
			{
				// ./grammars/AST.g:47:21: ^( INPUT ( inputsub )? )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(INPUT, "INPUT"), root_1);
				// ./grammars/AST.g:47:29: ( inputsub )?
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
	// ./grammars/AST.g:49:1: inputsub : ( ( ( WS )? VARIABLE_LEX ( WS )? ',' inputsub ) -> VARIABLE_LEX inputsub | ( WS )? VARIABLE_LEX -> VARIABLE_LEX );
	public final ASTParser.inputsub_return inputsub() throws RecognitionException {
		ASTParser.inputsub_return retval = new ASTParser.inputsub_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token WS24=null;
		Token VARIABLE_LEX25=null;
		Token WS26=null;
		Token char_literal27=null;
		Token WS29=null;
		Token VARIABLE_LEX30=null;
		ParserRuleReturnScope inputsub28 =null;

		Object WS24_tree=null;
		Object VARIABLE_LEX25_tree=null;
		Object WS26_tree=null;
		Object char_literal27_tree=null;
		Object WS29_tree=null;
		Object VARIABLE_LEX30_tree=null;
		RewriteRuleTokenStream stream_VARIABLE_LEX=new RewriteRuleTokenStream(adaptor,"token VARIABLE_LEX");
		RewriteRuleTokenStream stream_WS=new RewriteRuleTokenStream(adaptor,"token WS");
		RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
		RewriteRuleSubtreeStream stream_inputsub=new RewriteRuleSubtreeStream(adaptor,"rule inputsub");

		try {
			// ./grammars/AST.g:49:9: ( ( ( WS )? VARIABLE_LEX ( WS )? ',' inputsub ) -> VARIABLE_LEX inputsub | ( WS )? VARIABLE_LEX -> VARIABLE_LEX )
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==WS) ) {
				int LA10_1 = input.LA(2);
				if ( (LA10_1==VARIABLE_LEX) ) {
					int LA10_2 = input.LA(3);
					if ( (LA10_2==WS) ) {
						int LA10_3 = input.LA(4);
						if ( (LA10_3==41) ) {
							alt10=1;
						}
						else if ( (LA10_3==38) ) {
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
					else if ( (LA10_2==41) ) {
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
			else if ( (LA10_0==VARIABLE_LEX) ) {
				int LA10_2 = input.LA(2);
				if ( (LA10_2==WS) ) {
					int LA10_3 = input.LA(3);
					if ( (LA10_3==41) ) {
						alt10=1;
					}
					else if ( (LA10_3==38) ) {
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
				else if ( (LA10_2==41) ) {
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
					// ./grammars/AST.g:49:11: ( ( WS )? VARIABLE_LEX ( WS )? ',' inputsub )
					{
					// ./grammars/AST.g:49:11: ( ( WS )? VARIABLE_LEX ( WS )? ',' inputsub )
					// ./grammars/AST.g:49:12: ( WS )? VARIABLE_LEX ( WS )? ',' inputsub
					{
					// ./grammars/AST.g:49:12: ( WS )?
					int alt7=2;
					int LA7_0 = input.LA(1);
					if ( (LA7_0==WS) ) {
						alt7=1;
					}
					switch (alt7) {
						case 1 :
							// ./grammars/AST.g:49:12: WS
							{
							WS24=(Token)match(input,WS,FOLLOW_WS_in_inputsub273);  
							stream_WS.add(WS24);

							}
							break;

					}

					VARIABLE_LEX25=(Token)match(input,VARIABLE_LEX,FOLLOW_VARIABLE_LEX_in_inputsub276);  
					stream_VARIABLE_LEX.add(VARIABLE_LEX25);

					// ./grammars/AST.g:49:29: ( WS )?
					int alt8=2;
					int LA8_0 = input.LA(1);
					if ( (LA8_0==WS) ) {
						alt8=1;
					}
					switch (alt8) {
						case 1 :
							// ./grammars/AST.g:49:29: WS
							{
							WS26=(Token)match(input,WS,FOLLOW_WS_in_inputsub278);  
							stream_WS.add(WS26);

							}
							break;

					}

					char_literal27=(Token)match(input,41,FOLLOW_41_in_inputsub281);  
					stream_41.add(char_literal27);

					pushFollow(FOLLOW_inputsub_in_inputsub283);
					inputsub28=inputsub();
					state._fsp--;

					stream_inputsub.add(inputsub28.getTree());
					}


					// AST REWRITE
					// elements: inputsub, VARIABLE_LEX
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 49:47: -> VARIABLE_LEX inputsub
					{
						adaptor.addChild(root_0, stream_VARIABLE_LEX.nextNode());
						adaptor.addChild(root_0, stream_inputsub.nextTree());
					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// ./grammars/AST.g:49:74: ( WS )? VARIABLE_LEX
					{
					// ./grammars/AST.g:49:74: ( WS )?
					int alt9=2;
					int LA9_0 = input.LA(1);
					if ( (LA9_0==WS) ) {
						alt9=1;
					}
					switch (alt9) {
						case 1 :
							// ./grammars/AST.g:49:74: WS
							{
							WS29=(Token)match(input,WS,FOLLOW_WS_in_inputsub294);  
							stream_WS.add(WS29);

							}
							break;

					}

					VARIABLE_LEX30=(Token)match(input,VARIABLE_LEX,FOLLOW_VARIABLE_LEX_in_inputsub297);  
					stream_VARIABLE_LEX.add(VARIABLE_LEX30);


					// AST REWRITE
					// elements: VARIABLE_LEX
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 49:91: -> VARIABLE_LEX
					{
						adaptor.addChild(root_0, stream_VARIABLE_LEX.nextNode());
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
	// ./grammars/AST.g:51:1: output : ( ( ( WS )? VARIABLE_LEX ( WS )? ',' output ) -> VARIABLE_LEX output | ( WS )? VARIABLE_LEX -> VARIABLE_LEX );
	public final ASTParser.output_return output() throws RecognitionException {
		ASTParser.output_return retval = new ASTParser.output_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token WS31=null;
		Token VARIABLE_LEX32=null;
		Token WS33=null;
		Token char_literal34=null;
		Token WS36=null;
		Token VARIABLE_LEX37=null;
		ParserRuleReturnScope output35 =null;

		Object WS31_tree=null;
		Object VARIABLE_LEX32_tree=null;
		Object WS33_tree=null;
		Object char_literal34_tree=null;
		Object WS36_tree=null;
		Object VARIABLE_LEX37_tree=null;
		RewriteRuleTokenStream stream_VARIABLE_LEX=new RewriteRuleTokenStream(adaptor,"token VARIABLE_LEX");
		RewriteRuleTokenStream stream_WS=new RewriteRuleTokenStream(adaptor,"token WS");
		RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
		RewriteRuleSubtreeStream stream_output=new RewriteRuleSubtreeStream(adaptor,"rule output");

		try {
			// ./grammars/AST.g:51:7: ( ( ( WS )? VARIABLE_LEX ( WS )? ',' output ) -> VARIABLE_LEX output | ( WS )? VARIABLE_LEX -> VARIABLE_LEX )
			int alt14=2;
			int LA14_0 = input.LA(1);
			if ( (LA14_0==WS) ) {
				int LA14_1 = input.LA(2);
				if ( (LA14_1==VARIABLE_LEX) ) {
					switch ( input.LA(3) ) {
					case WS:
						{
						int LA14_3 = input.LA(4);
						if ( (LA14_3==41) ) {
							alt14=1;
						}
						else if ( (LA14_3==EOF||LA14_3==WS||LA14_3==51) ) {
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
					case 41:
						{
						alt14=1;
						}
						break;
					case EOF:
					case 51:
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
			else if ( (LA14_0==VARIABLE_LEX) ) {
				switch ( input.LA(2) ) {
				case WS:
					{
					int LA14_3 = input.LA(3);
					if ( (LA14_3==41) ) {
						alt14=1;
					}
					else if ( (LA14_3==EOF||LA14_3==WS||LA14_3==51) ) {
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
				case 41:
					{
					alt14=1;
					}
					break;
				case EOF:
				case 51:
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
					// ./grammars/AST.g:51:9: ( ( WS )? VARIABLE_LEX ( WS )? ',' output )
					{
					// ./grammars/AST.g:51:9: ( ( WS )? VARIABLE_LEX ( WS )? ',' output )
					// ./grammars/AST.g:51:10: ( WS )? VARIABLE_LEX ( WS )? ',' output
					{
					// ./grammars/AST.g:51:10: ( WS )?
					int alt11=2;
					int LA11_0 = input.LA(1);
					if ( (LA11_0==WS) ) {
						alt11=1;
					}
					switch (alt11) {
						case 1 :
							// ./grammars/AST.g:51:10: WS
							{
							WS31=(Token)match(input,WS,FOLLOW_WS_in_output309);  
							stream_WS.add(WS31);

							}
							break;

					}

					VARIABLE_LEX32=(Token)match(input,VARIABLE_LEX,FOLLOW_VARIABLE_LEX_in_output312);  
					stream_VARIABLE_LEX.add(VARIABLE_LEX32);

					// ./grammars/AST.g:51:27: ( WS )?
					int alt12=2;
					int LA12_0 = input.LA(1);
					if ( (LA12_0==WS) ) {
						alt12=1;
					}
					switch (alt12) {
						case 1 :
							// ./grammars/AST.g:51:27: WS
							{
							WS33=(Token)match(input,WS,FOLLOW_WS_in_output314);  
							stream_WS.add(WS33);

							}
							break;

					}

					char_literal34=(Token)match(input,41,FOLLOW_41_in_output317);  
					stream_41.add(char_literal34);

					pushFollow(FOLLOW_output_in_output319);
					output35=output();
					state._fsp--;

					stream_output.add(output35.getTree());
					}


					// AST REWRITE
					// elements: output, VARIABLE_LEX
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 51:43: -> VARIABLE_LEX output
					{
						adaptor.addChild(root_0, stream_VARIABLE_LEX.nextNode());
						adaptor.addChild(root_0, stream_output.nextTree());
					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// ./grammars/AST.g:51:68: ( WS )? VARIABLE_LEX
					{
					// ./grammars/AST.g:51:68: ( WS )?
					int alt13=2;
					int LA13_0 = input.LA(1);
					if ( (LA13_0==WS) ) {
						alt13=1;
					}
					switch (alt13) {
						case 1 :
							// ./grammars/AST.g:51:68: WS
							{
							WS36=(Token)match(input,WS,FOLLOW_WS_in_output330);  
							stream_WS.add(WS36);

							}
							break;

					}

					VARIABLE_LEX37=(Token)match(input,VARIABLE_LEX,FOLLOW_VARIABLE_LEX_in_output333);  
					stream_VARIABLE_LEX.add(VARIABLE_LEX37);


					// AST REWRITE
					// elements: VARIABLE_LEX
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 51:85: -> VARIABLE_LEX
					{
						adaptor.addChild(root_0, stream_VARIABLE_LEX.nextNode());
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
	// ./grammars/AST.g:53:1: commands : ( WS )? command ( ( WS )? ';' ( WS )? command )* ( ';' )? -> ( command )+ ;
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
		RewriteRuleTokenStream stream_44=new RewriteRuleTokenStream(adaptor,"token 44");
		RewriteRuleTokenStream stream_WS=new RewriteRuleTokenStream(adaptor,"token WS");
		RewriteRuleSubtreeStream stream_command=new RewriteRuleSubtreeStream(adaptor,"rule command");

		try {
			// ./grammars/AST.g:53:9: ( ( WS )? command ( ( WS )? ';' ( WS )? command )* ( ';' )? -> ( command )+ )
			// ./grammars/AST.g:54:5: ( WS )? command ( ( WS )? ';' ( WS )? command )* ( ';' )?
			{
			// ./grammars/AST.g:54:5: ( WS )?
			int alt15=2;
			int LA15_0 = input.LA(1);
			if ( (LA15_0==WS) ) {
				alt15=1;
			}
			switch (alt15) {
				case 1 :
					// ./grammars/AST.g:54:5: WS
					{
					WS38=(Token)match(input,WS,FOLLOW_WS_in_commands350);  
					stream_WS.add(WS38);

					}
					break;

			}

			pushFollow(FOLLOW_command_in_commands353);
			command39=command();
			state._fsp--;

			stream_command.add(command39.getTree());
			// ./grammars/AST.g:54:17: ( ( WS )? ';' ( WS )? command )*
			loop18:
			while (true) {
				int alt18=2;
				int LA18_0 = input.LA(1);
				if ( (LA18_0==44) ) {
					int LA18_1 = input.LA(2);
					if ( (LA18_1==WS) ) {
						int LA18_3 = input.LA(3);
						if ( (LA18_3==VARIABLE_LEX||(LA18_3 >= 49 && LA18_3 <= 50)||LA18_3==53||LA18_3==57||LA18_3==62) ) {
							alt18=1;
						}

					}
					else if ( (LA18_1==VARIABLE_LEX||(LA18_1 >= 49 && LA18_1 <= 50)||LA18_1==53||LA18_1==57||LA18_1==62) ) {
						alt18=1;
					}

				}
				else if ( (LA18_0==WS) ) {
					int LA18_2 = input.LA(2);
					if ( (LA18_2==44) ) {
						alt18=1;
					}

				}

				switch (alt18) {
				case 1 :
					// ./grammars/AST.g:54:18: ( WS )? ';' ( WS )? command
					{
					// ./grammars/AST.g:54:18: ( WS )?
					int alt16=2;
					int LA16_0 = input.LA(1);
					if ( (LA16_0==WS) ) {
						alt16=1;
					}
					switch (alt16) {
						case 1 :
							// ./grammars/AST.g:54:18: WS
							{
							WS40=(Token)match(input,WS,FOLLOW_WS_in_commands356);  
							stream_WS.add(WS40);

							}
							break;

					}

					char_literal41=(Token)match(input,44,FOLLOW_44_in_commands359);  
					stream_44.add(char_literal41);

					// ./grammars/AST.g:54:26: ( WS )?
					int alt17=2;
					int LA17_0 = input.LA(1);
					if ( (LA17_0==WS) ) {
						alt17=1;
					}
					switch (alt17) {
						case 1 :
							// ./grammars/AST.g:54:26: WS
							{
							WS42=(Token)match(input,WS,FOLLOW_WS_in_commands361);  
							stream_WS.add(WS42);

							}
							break;

					}

					pushFollow(FOLLOW_command_in_commands364);
					command43=command();
					state._fsp--;

					stream_command.add(command43.getTree());
					}
					break;

				default :
					break loop18;
				}
			}

			// ./grammars/AST.g:54:40: ( ';' )?
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==44) ) {
				alt19=1;
			}
			switch (alt19) {
				case 1 :
					// ./grammars/AST.g:54:41: ';'
					{
					char_literal44=(Token)match(input,44,FOLLOW_44_in_commands369);  
					stream_44.add(char_literal44);

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
			// 54:47: -> ( command )+
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
	// ./grammars/AST.g:56:1: command : ( ( 'nop' ) -> NOP | ( vars ( WS )? ':=' ( WS )? exprs ) -> ^( ASSIGN ^( VARS vars ) ^( EXPRESSIONS exprs ) ) | ( 'if' WS expression WS 'then' WS commands WS ( ( WS )? 'else' WS commands WS )? 'fi' ) -> ^( IF expression ^( COMMANDS commands ) ( ^( ELSECOMMANDS commands ) )? ) | ( 'while' WS expression WS 'do' WS commands WS 'od' ) -> ^( WHILE expression ^( COMMANDS commands ) ) | ( 'for' WS expression WS 'do' WS commands WS 'od' ) -> ^( FOR expression ^( COMMANDS commands ) ) | ( 'foreach' WS VARIABLE_LEX WS 'in' WS expression WS 'do' WS commands WS 'od' ) -> ^( FOREACH VARIABLE_LEX expression ^( COMMANDS commands ) ) );
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
		Token VARIABLE_LEX85=null;
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
		Object VARIABLE_LEX85_tree=null;
		Object WS86_tree=null;
		Object string_literal87_tree=null;
		Object WS88_tree=null;
		Object WS90_tree=null;
		Object string_literal91_tree=null;
		Object WS92_tree=null;
		Object WS94_tree=null;
		Object string_literal95_tree=null;
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_46=new RewriteRuleTokenStream(adaptor,"token 46");
		RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_48=new RewriteRuleTokenStream(adaptor,"token 48");
		RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
		RewriteRuleTokenStream stream_VARIABLE_LEX=new RewriteRuleTokenStream(adaptor,"token VARIABLE_LEX");
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
		RewriteRuleTokenStream stream_50=new RewriteRuleTokenStream(adaptor,"token 50");
		RewriteRuleTokenStream stream_WS=new RewriteRuleTokenStream(adaptor,"token WS");
		RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
		RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
		RewriteRuleTokenStream stream_43=new RewriteRuleTokenStream(adaptor,"token 43");
		RewriteRuleTokenStream stream_54=new RewriteRuleTokenStream(adaptor,"token 54");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
		RewriteRuleSubtreeStream stream_exprs=new RewriteRuleSubtreeStream(adaptor,"rule exprs");
		RewriteRuleSubtreeStream stream_vars=new RewriteRuleSubtreeStream(adaptor,"rule vars");
		RewriteRuleSubtreeStream stream_commands=new RewriteRuleSubtreeStream(adaptor,"rule commands");

		try {
			// ./grammars/AST.g:56:8: ( ( 'nop' ) -> NOP | ( vars ( WS )? ':=' ( WS )? exprs ) -> ^( ASSIGN ^( VARS vars ) ^( EXPRESSIONS exprs ) ) | ( 'if' WS expression WS 'then' WS commands WS ( ( WS )? 'else' WS commands WS )? 'fi' ) -> ^( IF expression ^( COMMANDS commands ) ( ^( ELSECOMMANDS commands ) )? ) | ( 'while' WS expression WS 'do' WS commands WS 'od' ) -> ^( WHILE expression ^( COMMANDS commands ) ) | ( 'for' WS expression WS 'do' WS commands WS 'od' ) -> ^( FOR expression ^( COMMANDS commands ) ) | ( 'foreach' WS VARIABLE_LEX WS 'in' WS expression WS 'do' WS commands WS 'od' ) -> ^( FOREACH VARIABLE_LEX expression ^( COMMANDS commands ) ) )
			int alt24=6;
			switch ( input.LA(1) ) {
			case 57:
				{
				alt24=1;
				}
				break;
			case VARIABLE_LEX:
				{
				alt24=2;
				}
				break;
			case 53:
				{
				alt24=3;
				}
				break;
			case 62:
				{
				alt24=4;
				}
				break;
			case 49:
				{
				alt24=5;
				}
				break;
			case 50:
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
					// ./grammars/AST.g:57:4: ( 'nop' )
					{
					// ./grammars/AST.g:57:4: ( 'nop' )
					// ./grammars/AST.g:57:5: 'nop'
					{
					string_literal45=(Token)match(input,57,FOLLOW_57_in_command387);  
					stream_57.add(string_literal45);

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
					// 57:12: -> NOP
					{
						adaptor.addChild(root_0, (Object)adaptor.create(NOP, "NOP"));
					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// ./grammars/AST.g:58:4: ( vars ( WS )? ':=' ( WS )? exprs )
					{
					// ./grammars/AST.g:58:4: ( vars ( WS )? ':=' ( WS )? exprs )
					// ./grammars/AST.g:58:5: vars ( WS )? ':=' ( WS )? exprs
					{
					pushFollow(FOLLOW_vars_in_command398);
					vars46=vars();
					state._fsp--;

					stream_vars.add(vars46.getTree());
					// ./grammars/AST.g:58:10: ( WS )?
					int alt20=2;
					int LA20_0 = input.LA(1);
					if ( (LA20_0==WS) ) {
						alt20=1;
					}
					switch (alt20) {
						case 1 :
							// ./grammars/AST.g:58:10: WS
							{
							WS47=(Token)match(input,WS,FOLLOW_WS_in_command400);  
							stream_WS.add(WS47);

							}
							break;

					}

					string_literal48=(Token)match(input,43,FOLLOW_43_in_command403);  
					stream_43.add(string_literal48);

					// ./grammars/AST.g:58:19: ( WS )?
					int alt21=2;
					int LA21_0 = input.LA(1);
					if ( (LA21_0==WS) ) {
						alt21=1;
					}
					switch (alt21) {
						case 1 :
							// ./grammars/AST.g:58:19: WS
							{
							WS49=(Token)match(input,WS,FOLLOW_WS_in_command405);  
							stream_WS.add(WS49);

							}
							break;

					}

					pushFollow(FOLLOW_exprs_in_command408);
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
					// 58:30: -> ^( ASSIGN ^( VARS vars ) ^( EXPRESSIONS exprs ) )
					{
						// ./grammars/AST.g:58:33: ^( ASSIGN ^( VARS vars ) ^( EXPRESSIONS exprs ) )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ASSIGN, "ASSIGN"), root_1);
						// ./grammars/AST.g:58:42: ^( VARS vars )
						{
						Object root_2 = (Object)adaptor.nil();
						root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(VARS, "VARS"), root_2);
						adaptor.addChild(root_2, stream_vars.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						// ./grammars/AST.g:58:55: ^( EXPRESSIONS exprs )
						{
						Object root_2 = (Object)adaptor.nil();
						root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(EXPRESSIONS, "EXPRESSIONS"), root_2);
						adaptor.addChild(root_2, stream_exprs.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 3 :
					// ./grammars/AST.g:59:4: ( 'if' WS expression WS 'then' WS commands WS ( ( WS )? 'else' WS commands WS )? 'fi' )
					{
					// ./grammars/AST.g:59:4: ( 'if' WS expression WS 'then' WS commands WS ( ( WS )? 'else' WS commands WS )? 'fi' )
					// ./grammars/AST.g:59:5: 'if' WS expression WS 'then' WS commands WS ( ( WS )? 'else' WS commands WS )? 'fi'
					{
					string_literal51=(Token)match(input,53,FOLLOW_53_in_command433);  
					stream_53.add(string_literal51);

					WS52=(Token)match(input,WS,FOLLOW_WS_in_command435);  
					stream_WS.add(WS52);

					pushFollow(FOLLOW_expression_in_command437);
					expression53=expression();
					state._fsp--;

					stream_expression.add(expression53.getTree());
					WS54=(Token)match(input,WS,FOLLOW_WS_in_command439);  
					stream_WS.add(WS54);

					string_literal55=(Token)match(input,60,FOLLOW_60_in_command441);  
					stream_60.add(string_literal55);

					WS56=(Token)match(input,WS,FOLLOW_WS_in_command443);  
					stream_WS.add(WS56);

					pushFollow(FOLLOW_commands_in_command445);
					commands57=commands();
					state._fsp--;

					stream_commands.add(commands57.getTree());
					WS58=(Token)match(input,WS,FOLLOW_WS_in_command447);  
					stream_WS.add(WS58);

					// ./grammars/AST.g:59:48: ( ( WS )? 'else' WS commands WS )?
					int alt23=2;
					int LA23_0 = input.LA(1);
					if ( (LA23_0==WS||LA23_0==47) ) {
						alt23=1;
					}
					switch (alt23) {
						case 1 :
							// ./grammars/AST.g:59:49: ( WS )? 'else' WS commands WS
							{
							// ./grammars/AST.g:59:49: ( WS )?
							int alt22=2;
							int LA22_0 = input.LA(1);
							if ( (LA22_0==WS) ) {
								alt22=1;
							}
							switch (alt22) {
								case 1 :
									// ./grammars/AST.g:59:49: WS
									{
									WS59=(Token)match(input,WS,FOLLOW_WS_in_command449);  
									stream_WS.add(WS59);

									}
									break;

							}

							string_literal60=(Token)match(input,47,FOLLOW_47_in_command452);  
							stream_47.add(string_literal60);

							WS61=(Token)match(input,WS,FOLLOW_WS_in_command453);  
							stream_WS.add(WS61);

							pushFollow(FOLLOW_commands_in_command455);
							commands62=commands();
							state._fsp--;

							stream_commands.add(commands62.getTree());
							WS63=(Token)match(input,WS,FOLLOW_WS_in_command457);  
							stream_WS.add(WS63);

							}
							break;

					}

					string_literal64=(Token)match(input,48,FOLLOW_48_in_command461);  
					stream_48.add(string_literal64);

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
					// 59:82: -> ^( IF expression ^( COMMANDS commands ) ( ^( ELSECOMMANDS commands ) )? )
					{
						// ./grammars/AST.g:59:85: ^( IF expression ^( COMMANDS commands ) ( ^( ELSECOMMANDS commands ) )? )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF, "IF"), root_1);
						adaptor.addChild(root_1, stream_expression.nextTree());
						// ./grammars/AST.g:59:101: ^( COMMANDS commands )
						{
						Object root_2 = (Object)adaptor.nil();
						root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(COMMANDS, "COMMANDS"), root_2);
						adaptor.addChild(root_2, stream_commands.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						// ./grammars/AST.g:59:122: ( ^( ELSECOMMANDS commands ) )?
						if ( stream_commands.hasNext() ) {
							// ./grammars/AST.g:59:122: ^( ELSECOMMANDS commands )
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
					// ./grammars/AST.g:60:4: ( 'while' WS expression WS 'do' WS commands WS 'od' )
					{
					// ./grammars/AST.g:60:4: ( 'while' WS expression WS 'do' WS commands WS 'od' )
					// ./grammars/AST.g:60:5: 'while' WS expression WS 'do' WS commands WS 'od'
					{
					string_literal65=(Token)match(input,62,FOLLOW_62_in_command489);  
					stream_62.add(string_literal65);

					WS66=(Token)match(input,WS,FOLLOW_WS_in_command491);  
					stream_WS.add(WS66);

					pushFollow(FOLLOW_expression_in_command493);
					expression67=expression();
					state._fsp--;

					stream_expression.add(expression67.getTree());
					WS68=(Token)match(input,WS,FOLLOW_WS_in_command495);  
					stream_WS.add(WS68);

					string_literal69=(Token)match(input,46,FOLLOW_46_in_command497);  
					stream_46.add(string_literal69);

					WS70=(Token)match(input,WS,FOLLOW_WS_in_command499);  
					stream_WS.add(WS70);

					pushFollow(FOLLOW_commands_in_command501);
					commands71=commands();
					state._fsp--;

					stream_commands.add(commands71.getTree());
					WS72=(Token)match(input,WS,FOLLOW_WS_in_command503);  
					stream_WS.add(WS72);

					string_literal73=(Token)match(input,58,FOLLOW_58_in_command505);  
					stream_58.add(string_literal73);

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
					// 60:56: -> ^( WHILE expression ^( COMMANDS commands ) )
					{
						// ./grammars/AST.g:60:59: ^( WHILE expression ^( COMMANDS commands ) )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(WHILE, "WHILE"), root_1);
						adaptor.addChild(root_1, stream_expression.nextTree());
						// ./grammars/AST.g:60:78: ^( COMMANDS commands )
						{
						Object root_2 = (Object)adaptor.nil();
						root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(COMMANDS, "COMMANDS"), root_2);
						adaptor.addChild(root_2, stream_commands.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 5 :
					// ./grammars/AST.g:61:4: ( 'for' WS expression WS 'do' WS commands WS 'od' )
					{
					// ./grammars/AST.g:61:4: ( 'for' WS expression WS 'do' WS commands WS 'od' )
					// ./grammars/AST.g:61:5: 'for' WS expression WS 'do' WS commands WS 'od'
					{
					string_literal74=(Token)match(input,49,FOLLOW_49_in_command526);  
					stream_49.add(string_literal74);

					WS75=(Token)match(input,WS,FOLLOW_WS_in_command528);  
					stream_WS.add(WS75);

					pushFollow(FOLLOW_expression_in_command530);
					expression76=expression();
					state._fsp--;

					stream_expression.add(expression76.getTree());
					WS77=(Token)match(input,WS,FOLLOW_WS_in_command532);  
					stream_WS.add(WS77);

					string_literal78=(Token)match(input,46,FOLLOW_46_in_command534);  
					stream_46.add(string_literal78);

					WS79=(Token)match(input,WS,FOLLOW_WS_in_command536);  
					stream_WS.add(WS79);

					pushFollow(FOLLOW_commands_in_command538);
					commands80=commands();
					state._fsp--;

					stream_commands.add(commands80.getTree());
					WS81=(Token)match(input,WS,FOLLOW_WS_in_command540);  
					stream_WS.add(WS81);

					string_literal82=(Token)match(input,58,FOLLOW_58_in_command542);  
					stream_58.add(string_literal82);

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
					// 61:54: -> ^( FOR expression ^( COMMANDS commands ) )
					{
						// ./grammars/AST.g:61:57: ^( FOR expression ^( COMMANDS commands ) )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FOR, "FOR"), root_1);
						adaptor.addChild(root_1, stream_expression.nextTree());
						// ./grammars/AST.g:61:74: ^( COMMANDS commands )
						{
						Object root_2 = (Object)adaptor.nil();
						root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(COMMANDS, "COMMANDS"), root_2);
						adaptor.addChild(root_2, stream_commands.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 6 :
					// ./grammars/AST.g:62:4: ( 'foreach' WS VARIABLE_LEX WS 'in' WS expression WS 'do' WS commands WS 'od' )
					{
					// ./grammars/AST.g:62:4: ( 'foreach' WS VARIABLE_LEX WS 'in' WS expression WS 'do' WS commands WS 'od' )
					// ./grammars/AST.g:62:5: 'foreach' WS VARIABLE_LEX WS 'in' WS expression WS 'do' WS commands WS 'od'
					{
					string_literal83=(Token)match(input,50,FOLLOW_50_in_command563);  
					stream_50.add(string_literal83);

					WS84=(Token)match(input,WS,FOLLOW_WS_in_command565);  
					stream_WS.add(WS84);

					VARIABLE_LEX85=(Token)match(input,VARIABLE_LEX,FOLLOW_VARIABLE_LEX_in_command567);  
					stream_VARIABLE_LEX.add(VARIABLE_LEX85);

					WS86=(Token)match(input,WS,FOLLOW_WS_in_command569);  
					stream_WS.add(WS86);

					string_literal87=(Token)match(input,54,FOLLOW_54_in_command571);  
					stream_54.add(string_literal87);

					WS88=(Token)match(input,WS,FOLLOW_WS_in_command573);  
					stream_WS.add(WS88);

					pushFollow(FOLLOW_expression_in_command575);
					expression89=expression();
					state._fsp--;

					stream_expression.add(expression89.getTree());
					WS90=(Token)match(input,WS,FOLLOW_WS_in_command577);  
					stream_WS.add(WS90);

					string_literal91=(Token)match(input,46,FOLLOW_46_in_command579);  
					stream_46.add(string_literal91);

					WS92=(Token)match(input,WS,FOLLOW_WS_in_command581);  
					stream_WS.add(WS92);

					pushFollow(FOLLOW_commands_in_command583);
					commands93=commands();
					state._fsp--;

					stream_commands.add(commands93.getTree());
					WS94=(Token)match(input,WS,FOLLOW_WS_in_command585);  
					stream_WS.add(WS94);

					string_literal95=(Token)match(input,58,FOLLOW_58_in_command587);  
					stream_58.add(string_literal95);

					}


					// AST REWRITE
					// elements: expression, VARIABLE_LEX, commands
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 62:82: -> ^( FOREACH VARIABLE_LEX expression ^( COMMANDS commands ) )
					{
						// ./grammars/AST.g:62:85: ^( FOREACH VARIABLE_LEX expression ^( COMMANDS commands ) )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FOREACH, "FOREACH"), root_1);
						adaptor.addChild(root_1, stream_VARIABLE_LEX.nextNode());
						adaptor.addChild(root_1, stream_expression.nextTree());
						// ./grammars/AST.g:62:119: ^( COMMANDS commands )
						{
						Object root_2 = (Object)adaptor.nil();
						root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(COMMANDS, "COMMANDS"), root_2);
						adaptor.addChild(root_2, stream_commands.nextTree());
						adaptor.addChild(root_1, root_2);
						}

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
	// ./grammars/AST.g:64:1: vars : ( ( VARIABLE_LEX ( WS )? ',' ( WS )? vars ) -> VARIABLE_LEX vars | VARIABLE_LEX -> VARIABLE_LEX );
	public final ASTParser.vars_return vars() throws RecognitionException {
		ASTParser.vars_return retval = new ASTParser.vars_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token VARIABLE_LEX96=null;
		Token WS97=null;
		Token char_literal98=null;
		Token WS99=null;
		Token VARIABLE_LEX101=null;
		ParserRuleReturnScope vars100 =null;

		Object VARIABLE_LEX96_tree=null;
		Object WS97_tree=null;
		Object char_literal98_tree=null;
		Object WS99_tree=null;
		Object VARIABLE_LEX101_tree=null;
		RewriteRuleTokenStream stream_VARIABLE_LEX=new RewriteRuleTokenStream(adaptor,"token VARIABLE_LEX");
		RewriteRuleTokenStream stream_WS=new RewriteRuleTokenStream(adaptor,"token WS");
		RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
		RewriteRuleSubtreeStream stream_vars=new RewriteRuleSubtreeStream(adaptor,"rule vars");

		try {
			// ./grammars/AST.g:64:7: ( ( VARIABLE_LEX ( WS )? ',' ( WS )? vars ) -> VARIABLE_LEX vars | VARIABLE_LEX -> VARIABLE_LEX )
			int alt27=2;
			int LA27_0 = input.LA(1);
			if ( (LA27_0==VARIABLE_LEX) ) {
				switch ( input.LA(2) ) {
				case WS:
					{
					int LA27_2 = input.LA(3);
					if ( (LA27_2==41) ) {
						alt27=1;
					}
					else if ( (LA27_2==43) ) {
						alt27=2;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 27, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

					}
					break;
				case 41:
					{
					alt27=1;
					}
					break;
				case 43:
					{
					alt27=2;
					}
					break;
				default:
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 27, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 27, 0, input);
				throw nvae;
			}

			switch (alt27) {
				case 1 :
					// ./grammars/AST.g:65:4: ( VARIABLE_LEX ( WS )? ',' ( WS )? vars )
					{
					// ./grammars/AST.g:65:4: ( VARIABLE_LEX ( WS )? ',' ( WS )? vars )
					// ./grammars/AST.g:65:5: VARIABLE_LEX ( WS )? ',' ( WS )? vars
					{
					VARIABLE_LEX96=(Token)match(input,VARIABLE_LEX,FOLLOW_VARIABLE_LEX_in_vars619);  
					stream_VARIABLE_LEX.add(VARIABLE_LEX96);

					// ./grammars/AST.g:65:18: ( WS )?
					int alt25=2;
					int LA25_0 = input.LA(1);
					if ( (LA25_0==WS) ) {
						alt25=1;
					}
					switch (alt25) {
						case 1 :
							// ./grammars/AST.g:65:18: WS
							{
							WS97=(Token)match(input,WS,FOLLOW_WS_in_vars621);  
							stream_WS.add(WS97);

							}
							break;

					}

					char_literal98=(Token)match(input,41,FOLLOW_41_in_vars624);  
					stream_41.add(char_literal98);

					// ./grammars/AST.g:65:26: ( WS )?
					int alt26=2;
					int LA26_0 = input.LA(1);
					if ( (LA26_0==WS) ) {
						alt26=1;
					}
					switch (alt26) {
						case 1 :
							// ./grammars/AST.g:65:26: WS
							{
							WS99=(Token)match(input,WS,FOLLOW_WS_in_vars626);  
							stream_WS.add(WS99);

							}
							break;

					}

					pushFollow(FOLLOW_vars_in_vars629);
					vars100=vars();
					state._fsp--;

					stream_vars.add(vars100.getTree());
					}


					// AST REWRITE
					// elements: VARIABLE_LEX, vars
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 65:36: -> VARIABLE_LEX vars
					{
						adaptor.addChild(root_0, stream_VARIABLE_LEX.nextNode());
						adaptor.addChild(root_0, stream_vars.nextTree());
					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// ./grammars/AST.g:66:4: VARIABLE_LEX
					{
					VARIABLE_LEX101=(Token)match(input,VARIABLE_LEX,FOLLOW_VARIABLE_LEX_in_vars641);  
					stream_VARIABLE_LEX.add(VARIABLE_LEX101);


					// AST REWRITE
					// elements: VARIABLE_LEX
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 66:17: -> VARIABLE_LEX
					{
						adaptor.addChild(root_0, stream_VARIABLE_LEX.nextNode());
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
	// ./grammars/AST.g:69:1: exprs : expression ( ( WS )? ',' ( WS )? expression )* -> ( expression )+ ;
	public final ASTParser.exprs_return exprs() throws RecognitionException {
		ASTParser.exprs_return retval = new ASTParser.exprs_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token WS103=null;
		Token char_literal104=null;
		Token WS105=null;
		ParserRuleReturnScope expression102 =null;
		ParserRuleReturnScope expression106 =null;

		Object WS103_tree=null;
		Object char_literal104_tree=null;
		Object WS105_tree=null;
		RewriteRuleTokenStream stream_WS=new RewriteRuleTokenStream(adaptor,"token WS");
		RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");

		try {
			// ./grammars/AST.g:69:8: ( expression ( ( WS )? ',' ( WS )? expression )* -> ( expression )+ )
			// ./grammars/AST.g:69:10: expression ( ( WS )? ',' ( WS )? expression )*
			{
			pushFollow(FOLLOW_expression_in_exprs656);
			expression102=expression();
			state._fsp--;

			stream_expression.add(expression102.getTree());
			// ./grammars/AST.g:69:21: ( ( WS )? ',' ( WS )? expression )*
			loop30:
			while (true) {
				int alt30=2;
				int LA30_0 = input.LA(1);
				if ( (LA30_0==WS) ) {
					int LA30_1 = input.LA(2);
					if ( (LA30_1==41) ) {
						alt30=1;
					}

				}
				else if ( (LA30_0==41) ) {
					alt30=1;
				}

				switch (alt30) {
				case 1 :
					// ./grammars/AST.g:69:22: ( WS )? ',' ( WS )? expression
					{
					// ./grammars/AST.g:69:22: ( WS )?
					int alt28=2;
					int LA28_0 = input.LA(1);
					if ( (LA28_0==WS) ) {
						alt28=1;
					}
					switch (alt28) {
						case 1 :
							// ./grammars/AST.g:69:22: WS
							{
							WS103=(Token)match(input,WS,FOLLOW_WS_in_exprs659);  
							stream_WS.add(WS103);

							}
							break;

					}

					char_literal104=(Token)match(input,41,FOLLOW_41_in_exprs662);  
					stream_41.add(char_literal104);

					// ./grammars/AST.g:69:30: ( WS )?
					int alt29=2;
					int LA29_0 = input.LA(1);
					if ( (LA29_0==WS) ) {
						alt29=1;
					}
					switch (alt29) {
						case 1 :
							// ./grammars/AST.g:69:30: WS
							{
							WS105=(Token)match(input,WS,FOLLOW_WS_in_exprs664);  
							stream_WS.add(WS105);

							}
							break;

					}

					pushFollow(FOLLOW_expression_in_exprs667);
					expression106=expression();
					state._fsp--;

					stream_expression.add(expression106.getTree());
					}
					break;

				default :
					break loop30;
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
			// 69:47: -> ( expression )+
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
	// ./grammars/AST.g:71:1: expression : e1= exprbase ( ' = ' e2= exprbase -> ^( EXPRESSION ^( EQUALS $e1 $e2) ) | -> ^( EXPRESSION $e1) ) ;
	public final ASTParser.expression_return expression() throws RecognitionException {
		ASTParser.expression_return retval = new ASTParser.expression_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal107=null;
		ParserRuleReturnScope e1 =null;
		ParserRuleReturnScope e2 =null;

		Object string_literal107_tree=null;
		RewriteRuleTokenStream stream_37=new RewriteRuleTokenStream(adaptor,"token 37");
		RewriteRuleSubtreeStream stream_exprbase=new RewriteRuleSubtreeStream(adaptor,"rule exprbase");

		try {
			// ./grammars/AST.g:72:2: (e1= exprbase ( ' = ' e2= exprbase -> ^( EXPRESSION ^( EQUALS $e1 $e2) ) | -> ^( EXPRESSION $e1) ) )
			// ./grammars/AST.g:72:5: e1= exprbase ( ' = ' e2= exprbase -> ^( EXPRESSION ^( EQUALS $e1 $e2) ) | -> ^( EXPRESSION $e1) )
			{
			pushFollow(FOLLOW_exprbase_in_expression688);
			e1=exprbase();
			state._fsp--;

			stream_exprbase.add(e1.getTree());
			// ./grammars/AST.g:72:16: ( ' = ' e2= exprbase -> ^( EXPRESSION ^( EQUALS $e1 $e2) ) | -> ^( EXPRESSION $e1) )
			int alt31=2;
			int LA31_0 = input.LA(1);
			if ( (LA31_0==37) ) {
				alt31=1;
			}
			else if ( (LA31_0==WS||LA31_0==41||LA31_0==44) ) {
				alt31=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 31, 0, input);
				throw nvae;
			}

			switch (alt31) {
				case 1 :
					// ./grammars/AST.g:73:3: ' = ' e2= exprbase
					{
					string_literal107=(Token)match(input,37,FOLLOW_37_in_expression693);  
					stream_37.add(string_literal107);

					pushFollow(FOLLOW_exprbase_in_expression696);
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
					// 73:20: -> ^( EXPRESSION ^( EQUALS $e1 $e2) )
					{
						// ./grammars/AST.g:73:23: ^( EXPRESSION ^( EQUALS $e1 $e2) )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EXPRESSION, "EXPRESSION"), root_1);
						// ./grammars/AST.g:73:36: ^( EQUALS $e1 $e2)
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
					// ./grammars/AST.g:74:5: 
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
					// 74:5: -> ^( EXPRESSION $e1)
					{
						// ./grammars/AST.g:74:8: ^( EXPRESSION $e1)
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
	// ./grammars/AST.g:77:1: exprbase : ( '(' ( WS )? ( SYMBOL_LEX WS lexpr ')' -> ^( FUNCTIONCALL ^( SYMBOL_LEX lexpr ) ) | SYMBOL_LEX ')' -> ^( FUNCTIONCALL SYMBOL_LEX ) | 'hd ' exprbase ( WS )? ')' -> ^( HEAD exprbase ) | 'tl ' exprbase ( WS )? ')' -> ^( TAIL exprbase ) | 'cons ' lexpr ')' -> ^( CONS lexpr ) | 'list ' lexpr ')' -> ^( LIST lexpr ) ) | 'nil' -> NIL | VARIABLE_LEX -> ^( VARIABLE VARIABLE_LEX ) | SYMBOL_LEX -> ^( SYMBOL SYMBOL_LEX ) );
	public final ASTParser.exprbase_return exprbase() throws RecognitionException {
		ASTParser.exprbase_return retval = new ASTParser.exprbase_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal108=null;
		Token WS109=null;
		Token SYMBOL_LEX110=null;
		Token WS111=null;
		Token char_literal113=null;
		Token SYMBOL_LEX114=null;
		Token char_literal115=null;
		Token string_literal116=null;
		Token WS118=null;
		Token char_literal119=null;
		Token string_literal120=null;
		Token WS122=null;
		Token char_literal123=null;
		Token string_literal124=null;
		Token char_literal126=null;
		Token string_literal127=null;
		Token char_literal129=null;
		Token string_literal130=null;
		Token VARIABLE_LEX131=null;
		Token SYMBOL_LEX132=null;
		ParserRuleReturnScope lexpr112 =null;
		ParserRuleReturnScope exprbase117 =null;
		ParserRuleReturnScope exprbase121 =null;
		ParserRuleReturnScope lexpr125 =null;
		ParserRuleReturnScope lexpr128 =null;

		Object char_literal108_tree=null;
		Object WS109_tree=null;
		Object SYMBOL_LEX110_tree=null;
		Object WS111_tree=null;
		Object char_literal113_tree=null;
		Object SYMBOL_LEX114_tree=null;
		Object char_literal115_tree=null;
		Object string_literal116_tree=null;
		Object WS118_tree=null;
		Object char_literal119_tree=null;
		Object string_literal120_tree=null;
		Object WS122_tree=null;
		Object char_literal123_tree=null;
		Object string_literal124_tree=null;
		Object char_literal126_tree=null;
		Object string_literal127_tree=null;
		Object char_literal129_tree=null;
		Object string_literal130_tree=null;
		Object VARIABLE_LEX131_tree=null;
		Object SYMBOL_LEX132_tree=null;
		RewriteRuleTokenStream stream_55=new RewriteRuleTokenStream(adaptor,"token 55");
		RewriteRuleTokenStream stream_45=new RewriteRuleTokenStream(adaptor,"token 45");
		RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
		RewriteRuleTokenStream stream_SYMBOL_LEX=new RewriteRuleTokenStream(adaptor,"token SYMBOL_LEX");
		RewriteRuleTokenStream stream_VARIABLE_LEX=new RewriteRuleTokenStream(adaptor,"token VARIABLE_LEX");
		RewriteRuleTokenStream stream_39=new RewriteRuleTokenStream(adaptor,"token 39");
		RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
		RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
		RewriteRuleTokenStream stream_WS=new RewriteRuleTokenStream(adaptor,"token WS");
		RewriteRuleTokenStream stream_52=new RewriteRuleTokenStream(adaptor,"token 52");
		RewriteRuleSubtreeStream stream_lexpr=new RewriteRuleSubtreeStream(adaptor,"rule lexpr");
		RewriteRuleSubtreeStream stream_exprbase=new RewriteRuleSubtreeStream(adaptor,"rule exprbase");

		try {
			// ./grammars/AST.g:78:2: ( '(' ( WS )? ( SYMBOL_LEX WS lexpr ')' -> ^( FUNCTIONCALL ^( SYMBOL_LEX lexpr ) ) | SYMBOL_LEX ')' -> ^( FUNCTIONCALL SYMBOL_LEX ) | 'hd ' exprbase ( WS )? ')' -> ^( HEAD exprbase ) | 'tl ' exprbase ( WS )? ')' -> ^( TAIL exprbase ) | 'cons ' lexpr ')' -> ^( CONS lexpr ) | 'list ' lexpr ')' -> ^( LIST lexpr ) ) | 'nil' -> NIL | VARIABLE_LEX -> ^( VARIABLE VARIABLE_LEX ) | SYMBOL_LEX -> ^( SYMBOL SYMBOL_LEX ) )
			int alt36=4;
			switch ( input.LA(1) ) {
			case 39:
				{
				alt36=1;
				}
				break;
			case 56:
				{
				alt36=2;
				}
				break;
			case VARIABLE_LEX:
				{
				alt36=3;
				}
				break;
			case SYMBOL_LEX:
				{
				alt36=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 36, 0, input);
				throw nvae;
			}
			switch (alt36) {
				case 1 :
					// ./grammars/AST.g:78:5: '(' ( WS )? ( SYMBOL_LEX WS lexpr ')' -> ^( FUNCTIONCALL ^( SYMBOL_LEX lexpr ) ) | SYMBOL_LEX ')' -> ^( FUNCTIONCALL SYMBOL_LEX ) | 'hd ' exprbase ( WS )? ')' -> ^( HEAD exprbase ) | 'tl ' exprbase ( WS )? ')' -> ^( TAIL exprbase ) | 'cons ' lexpr ')' -> ^( CONS lexpr ) | 'list ' lexpr ')' -> ^( LIST lexpr ) )
					{
					char_literal108=(Token)match(input,39,FOLLOW_39_in_exprbase739);  
					stream_39.add(char_literal108);

					// ./grammars/AST.g:78:9: ( WS )?
					int alt32=2;
					int LA32_0 = input.LA(1);
					if ( (LA32_0==WS) ) {
						alt32=1;
					}
					switch (alt32) {
						case 1 :
							// ./grammars/AST.g:78:9: WS
							{
							WS109=(Token)match(input,WS,FOLLOW_WS_in_exprbase741);  
							stream_WS.add(WS109);

							}
							break;

					}

					// ./grammars/AST.g:78:13: ( SYMBOL_LEX WS lexpr ')' -> ^( FUNCTIONCALL ^( SYMBOL_LEX lexpr ) ) | SYMBOL_LEX ')' -> ^( FUNCTIONCALL SYMBOL_LEX ) | 'hd ' exprbase ( WS )? ')' -> ^( HEAD exprbase ) | 'tl ' exprbase ( WS )? ')' -> ^( TAIL exprbase ) | 'cons ' lexpr ')' -> ^( CONS lexpr ) | 'list ' lexpr ')' -> ^( LIST lexpr ) )
					int alt35=6;
					switch ( input.LA(1) ) {
					case SYMBOL_LEX:
						{
						int LA35_1 = input.LA(2);
						if ( (LA35_1==WS) ) {
							alt35=1;
						}
						else if ( (LA35_1==40) ) {
							alt35=2;
						}

						else {
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 35, 1, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case 52:
						{
						alt35=3;
						}
						break;
					case 61:
						{
						alt35=4;
						}
						break;
					case 45:
						{
						alt35=5;
						}
						break;
					case 55:
						{
						alt35=6;
						}
						break;
					default:
						NoViableAltException nvae =
							new NoViableAltException("", 35, 0, input);
						throw nvae;
					}
					switch (alt35) {
						case 1 :
							// ./grammars/AST.g:79:3: SYMBOL_LEX WS lexpr ')'
							{
							SYMBOL_LEX110=(Token)match(input,SYMBOL_LEX,FOLLOW_SYMBOL_LEX_in_exprbase748);  
							stream_SYMBOL_LEX.add(SYMBOL_LEX110);

							WS111=(Token)match(input,WS,FOLLOW_WS_in_exprbase750);  
							stream_WS.add(WS111);

							pushFollow(FOLLOW_lexpr_in_exprbase752);
							lexpr112=lexpr();
							state._fsp--;

							stream_lexpr.add(lexpr112.getTree());
							char_literal113=(Token)match(input,40,FOLLOW_40_in_exprbase753);  
							stream_40.add(char_literal113);


							// AST REWRITE
							// elements: SYMBOL_LEX, lexpr
							// token labels: 
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (Object)adaptor.nil();
							// 79:26: -> ^( FUNCTIONCALL ^( SYMBOL_LEX lexpr ) )
							{
								// ./grammars/AST.g:79:29: ^( FUNCTIONCALL ^( SYMBOL_LEX lexpr ) )
								{
								Object root_1 = (Object)adaptor.nil();
								root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNCTIONCALL, "FUNCTIONCALL"), root_1);
								// ./grammars/AST.g:79:44: ^( SYMBOL_LEX lexpr )
								{
								Object root_2 = (Object)adaptor.nil();
								root_2 = (Object)adaptor.becomeRoot(stream_SYMBOL_LEX.nextNode(), root_2);
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
							// ./grammars/AST.g:80:5: SYMBOL_LEX ')'
							{
							SYMBOL_LEX114=(Token)match(input,SYMBOL_LEX,FOLLOW_SYMBOL_LEX_in_exprbase771);  
							stream_SYMBOL_LEX.add(SYMBOL_LEX114);

							char_literal115=(Token)match(input,40,FOLLOW_40_in_exprbase772);  
							stream_40.add(char_literal115);


							// AST REWRITE
							// elements: SYMBOL_LEX
							// token labels: 
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (Object)adaptor.nil();
							// 80:19: -> ^( FUNCTIONCALL SYMBOL_LEX )
							{
								// ./grammars/AST.g:80:22: ^( FUNCTIONCALL SYMBOL_LEX )
								{
								Object root_1 = (Object)adaptor.nil();
								root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNCTIONCALL, "FUNCTIONCALL"), root_1);
								adaptor.addChild(root_1, stream_SYMBOL_LEX.nextNode());
								adaptor.addChild(root_0, root_1);
								}

							}


							retval.tree = root_0;

							}
							break;
						case 3 :
							// ./grammars/AST.g:81:4: 'hd ' exprbase ( WS )? ')'
							{
							string_literal116=(Token)match(input,52,FOLLOW_52_in_exprbase785);  
							stream_52.add(string_literal116);

							pushFollow(FOLLOW_exprbase_in_exprbase786);
							exprbase117=exprbase();
							state._fsp--;

							stream_exprbase.add(exprbase117.getTree());
							// ./grammars/AST.g:81:18: ( WS )?
							int alt33=2;
							int LA33_0 = input.LA(1);
							if ( (LA33_0==WS) ) {
								alt33=1;
							}
							switch (alt33) {
								case 1 :
									// ./grammars/AST.g:81:18: WS
									{
									WS118=(Token)match(input,WS,FOLLOW_WS_in_exprbase788);  
									stream_WS.add(WS118);

									}
									break;

							}

							char_literal119=(Token)match(input,40,FOLLOW_40_in_exprbase790);  
							stream_40.add(char_literal119);


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
							// 81:25: -> ^( HEAD exprbase )
							{
								// ./grammars/AST.g:81:28: ^( HEAD exprbase )
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
							// ./grammars/AST.g:82:4: 'tl ' exprbase ( WS )? ')'
							{
							string_literal120=(Token)match(input,61,FOLLOW_61_in_exprbase803);  
							stream_61.add(string_literal120);

							pushFollow(FOLLOW_exprbase_in_exprbase804);
							exprbase121=exprbase();
							state._fsp--;

							stream_exprbase.add(exprbase121.getTree());
							// ./grammars/AST.g:82:18: ( WS )?
							int alt34=2;
							int LA34_0 = input.LA(1);
							if ( (LA34_0==WS) ) {
								alt34=1;
							}
							switch (alt34) {
								case 1 :
									// ./grammars/AST.g:82:18: WS
									{
									WS122=(Token)match(input,WS,FOLLOW_WS_in_exprbase806);  
									stream_WS.add(WS122);

									}
									break;

							}

							char_literal123=(Token)match(input,40,FOLLOW_40_in_exprbase808);  
							stream_40.add(char_literal123);


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
							// 82:25: -> ^( TAIL exprbase )
							{
								// ./grammars/AST.g:82:28: ^( TAIL exprbase )
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
							// ./grammars/AST.g:83:4: 'cons ' lexpr ')'
							{
							string_literal124=(Token)match(input,45,FOLLOW_45_in_exprbase821);  
							stream_45.add(string_literal124);

							pushFollow(FOLLOW_lexpr_in_exprbase822);
							lexpr125=lexpr();
							state._fsp--;

							stream_lexpr.add(lexpr125.getTree());
							char_literal126=(Token)match(input,40,FOLLOW_40_in_exprbase823);  
							stream_40.add(char_literal126);


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
							// 83:20: -> ^( CONS lexpr )
							{
								// ./grammars/AST.g:83:23: ^( CONS lexpr )
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
							// ./grammars/AST.g:84:4: 'list ' lexpr ')'
							{
							string_literal127=(Token)match(input,55,FOLLOW_55_in_exprbase836);  
							stream_55.add(string_literal127);

							pushFollow(FOLLOW_lexpr_in_exprbase837);
							lexpr128=lexpr();
							state._fsp--;

							stream_lexpr.add(lexpr128.getTree());
							char_literal129=(Token)match(input,40,FOLLOW_40_in_exprbase838);  
							stream_40.add(char_literal129);


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
							// 84:20: -> ^( LIST lexpr )
							{
								// ./grammars/AST.g:84:23: ^( LIST lexpr )
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
					// ./grammars/AST.g:86:4: 'nil'
					{
					string_literal130=(Token)match(input,56,FOLLOW_56_in_exprbase855);  
					stream_56.add(string_literal130);


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
					// 86:10: -> NIL
					{
						adaptor.addChild(root_0, (Object)adaptor.create(NIL, "NIL"));
					}


					retval.tree = root_0;

					}
					break;
				case 3 :
					// ./grammars/AST.g:87:5: VARIABLE_LEX
					{
					VARIABLE_LEX131=(Token)match(input,VARIABLE_LEX,FOLLOW_VARIABLE_LEX_in_exprbase865);  
					stream_VARIABLE_LEX.add(VARIABLE_LEX131);


					// AST REWRITE
					// elements: VARIABLE_LEX
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 87:18: -> ^( VARIABLE VARIABLE_LEX )
					{
						// ./grammars/AST.g:87:21: ^( VARIABLE VARIABLE_LEX )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(VARIABLE, "VARIABLE"), root_1);
						adaptor.addChild(root_1, stream_VARIABLE_LEX.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 4 :
					// ./grammars/AST.g:88:5: SYMBOL_LEX
					{
					SYMBOL_LEX132=(Token)match(input,SYMBOL_LEX,FOLLOW_SYMBOL_LEX_in_exprbase879);  
					stream_SYMBOL_LEX.add(SYMBOL_LEX132);


					// AST REWRITE
					// elements: SYMBOL_LEX
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 88:16: -> ^( SYMBOL SYMBOL_LEX )
					{
						// ./grammars/AST.g:88:19: ^( SYMBOL SYMBOL_LEX )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(SYMBOL, "SYMBOL"), root_1);
						adaptor.addChild(root_1, stream_SYMBOL_LEX.nextNode());
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
	// $ANTLR end "exprbase"


	public static class lexpr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "lexpr"
	// ./grammars/AST.g:90:2: lexpr : ( ( WS )? ( exprbase ( WS )? )* ) -> ( exprbase )* ;
	public final ASTParser.lexpr_return lexpr() throws RecognitionException {
		ASTParser.lexpr_return retval = new ASTParser.lexpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token WS133=null;
		Token WS135=null;
		ParserRuleReturnScope exprbase134 =null;

		Object WS133_tree=null;
		Object WS135_tree=null;
		RewriteRuleTokenStream stream_WS=new RewriteRuleTokenStream(adaptor,"token WS");
		RewriteRuleSubtreeStream stream_exprbase=new RewriteRuleSubtreeStream(adaptor,"rule exprbase");

		try {
			// ./grammars/AST.g:91:5: ( ( ( WS )? ( exprbase ( WS )? )* ) -> ( exprbase )* )
			// ./grammars/AST.g:91:7: ( ( WS )? ( exprbase ( WS )? )* )
			{
			// ./grammars/AST.g:91:7: ( ( WS )? ( exprbase ( WS )? )* )
			// ./grammars/AST.g:91:8: ( WS )? ( exprbase ( WS )? )*
			{
			// ./grammars/AST.g:91:8: ( WS )?
			int alt37=2;
			int LA37_0 = input.LA(1);
			if ( (LA37_0==WS) ) {
				alt37=1;
			}
			switch (alt37) {
				case 1 :
					// ./grammars/AST.g:91:8: WS
					{
					WS133=(Token)match(input,WS,FOLLOW_WS_in_lexpr902);  
					stream_WS.add(WS133);

					}
					break;

			}

			// ./grammars/AST.g:91:12: ( exprbase ( WS )? )*
			loop39:
			while (true) {
				int alt39=2;
				int LA39_0 = input.LA(1);
				if ( (LA39_0==SYMBOL_LEX||LA39_0==VARIABLE_LEX||LA39_0==39||LA39_0==56) ) {
					alt39=1;
				}

				switch (alt39) {
				case 1 :
					// ./grammars/AST.g:91:13: exprbase ( WS )?
					{
					pushFollow(FOLLOW_exprbase_in_lexpr906);
					exprbase134=exprbase();
					state._fsp--;

					stream_exprbase.add(exprbase134.getTree());
					// ./grammars/AST.g:91:22: ( WS )?
					int alt38=2;
					int LA38_0 = input.LA(1);
					if ( (LA38_0==WS) ) {
						alt38=1;
					}
					switch (alt38) {
						case 1 :
							// ./grammars/AST.g:91:22: WS
							{
							WS135=(Token)match(input,WS,FOLLOW_WS_in_lexpr908);  
							stream_WS.add(WS135);

							}
							break;

					}

					}
					break;

				default :
					break loop39;
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
			// 91:29: -> ( exprbase )*
			{
				// ./grammars/AST.g:91:32: ( exprbase )*
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



	public static final BitSet FOLLOW_WS_in_program144 = new BitSet(new long[]{0x0008001000000000L});
	public static final BitSet FOLLOW_function_in_program148 = new BitSet(new long[]{0x0008001000000002L});
	public static final BitSet FOLLOW_WS_in_program150 = new BitSet(new long[]{0x0008001000000002L});
	public static final BitSet FOLLOW_51_in_function169 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_WS_in_function171 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_SYMBOL_LEX_in_function173 = new BitSet(new long[]{0x0000041000000000L});
	public static final BitSet FOLLOW_WS_in_function175 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_42_in_function178 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_WS_in_function180 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_definition_in_function182 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_definition201 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_WS_in_definition203 = new BitSet(new long[]{0x0000005200000000L});
	public static final BitSet FOLLOW_input_in_definition206 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_WS_in_definition208 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_38_in_definition212 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_WS_in_definition214 = new BitSet(new long[]{0x4226001200000000L});
	public static final BitSet FOLLOW_commands_in_definition216 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_WS_in_definition218 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_38_in_definition220 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_WS_in_definition222 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_definition224 = new BitSet(new long[]{0x0000001200000000L});
	public static final BitSet FOLLOW_output_in_definition226 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_inputsub_in_input255 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WS_in_inputsub273 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_VARIABLE_LEX_in_inputsub276 = new BitSet(new long[]{0x0000021000000000L});
	public static final BitSet FOLLOW_WS_in_inputsub278 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_41_in_inputsub281 = new BitSet(new long[]{0x0000001200000000L});
	public static final BitSet FOLLOW_inputsub_in_inputsub283 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WS_in_inputsub294 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_VARIABLE_LEX_in_inputsub297 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WS_in_output309 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_VARIABLE_LEX_in_output312 = new BitSet(new long[]{0x0000021000000000L});
	public static final BitSet FOLLOW_WS_in_output314 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_41_in_output317 = new BitSet(new long[]{0x0000001200000000L});
	public static final BitSet FOLLOW_output_in_output319 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WS_in_output330 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_VARIABLE_LEX_in_output333 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WS_in_commands350 = new BitSet(new long[]{0x4226000200000000L});
	public static final BitSet FOLLOW_command_in_commands353 = new BitSet(new long[]{0x0000101000000002L});
	public static final BitSet FOLLOW_WS_in_commands356 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_44_in_commands359 = new BitSet(new long[]{0x4226001200000000L});
	public static final BitSet FOLLOW_WS_in_commands361 = new BitSet(new long[]{0x4226000200000000L});
	public static final BitSet FOLLOW_command_in_commands364 = new BitSet(new long[]{0x0000101000000002L});
	public static final BitSet FOLLOW_44_in_commands369 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_command387 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_vars_in_command398 = new BitSet(new long[]{0x0000081000000000L});
	public static final BitSet FOLLOW_WS_in_command400 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_43_in_command403 = new BitSet(new long[]{0x0100009220000000L});
	public static final BitSet FOLLOW_WS_in_command405 = new BitSet(new long[]{0x0100008220000000L});
	public static final BitSet FOLLOW_exprs_in_command408 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_53_in_command433 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_WS_in_command435 = new BitSet(new long[]{0x0100008220000000L});
	public static final BitSet FOLLOW_expression_in_command437 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_WS_in_command439 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_command441 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_WS_in_command443 = new BitSet(new long[]{0x4226001200000000L});
	public static final BitSet FOLLOW_commands_in_command445 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_WS_in_command447 = new BitSet(new long[]{0x0001801000000000L});
	public static final BitSet FOLLOW_WS_in_command449 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_47_in_command452 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_WS_in_command453 = new BitSet(new long[]{0x4226001200000000L});
	public static final BitSet FOLLOW_commands_in_command455 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_WS_in_command457 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_48_in_command461 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_command489 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_WS_in_command491 = new BitSet(new long[]{0x0100008220000000L});
	public static final BitSet FOLLOW_expression_in_command493 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_WS_in_command495 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_46_in_command497 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_WS_in_command499 = new BitSet(new long[]{0x4226001200000000L});
	public static final BitSet FOLLOW_commands_in_command501 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_WS_in_command503 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_command505 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_49_in_command526 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_WS_in_command528 = new BitSet(new long[]{0x0100008220000000L});
	public static final BitSet FOLLOW_expression_in_command530 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_WS_in_command532 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_46_in_command534 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_WS_in_command536 = new BitSet(new long[]{0x4226001200000000L});
	public static final BitSet FOLLOW_commands_in_command538 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_WS_in_command540 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_command542 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_50_in_command563 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_WS_in_command565 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_VARIABLE_LEX_in_command567 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_WS_in_command569 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_54_in_command571 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_WS_in_command573 = new BitSet(new long[]{0x0100008220000000L});
	public static final BitSet FOLLOW_expression_in_command575 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_WS_in_command577 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_46_in_command579 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_WS_in_command581 = new BitSet(new long[]{0x4226001200000000L});
	public static final BitSet FOLLOW_commands_in_command583 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_WS_in_command585 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_command587 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VARIABLE_LEX_in_vars619 = new BitSet(new long[]{0x0000021000000000L});
	public static final BitSet FOLLOW_WS_in_vars621 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_41_in_vars624 = new BitSet(new long[]{0x0000001200000000L});
	public static final BitSet FOLLOW_WS_in_vars626 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_vars_in_vars629 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VARIABLE_LEX_in_vars641 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_exprs656 = new BitSet(new long[]{0x0000021000000002L});
	public static final BitSet FOLLOW_WS_in_exprs659 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_41_in_exprs662 = new BitSet(new long[]{0x0100009220000000L});
	public static final BitSet FOLLOW_WS_in_exprs664 = new BitSet(new long[]{0x0100008220000000L});
	public static final BitSet FOLLOW_expression_in_exprs667 = new BitSet(new long[]{0x0000021000000002L});
	public static final BitSet FOLLOW_exprbase_in_expression688 = new BitSet(new long[]{0x0000002000000002L});
	public static final BitSet FOLLOW_37_in_expression693 = new BitSet(new long[]{0x0100008220000000L});
	public static final BitSet FOLLOW_exprbase_in_expression696 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_39_in_exprbase739 = new BitSet(new long[]{0x2090201020000000L});
	public static final BitSet FOLLOW_WS_in_exprbase741 = new BitSet(new long[]{0x2090200020000000L});
	public static final BitSet FOLLOW_SYMBOL_LEX_in_exprbase748 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_WS_in_exprbase750 = new BitSet(new long[]{0x0100019220000000L});
	public static final BitSet FOLLOW_lexpr_in_exprbase752 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_40_in_exprbase753 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SYMBOL_LEX_in_exprbase771 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_40_in_exprbase772 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_52_in_exprbase785 = new BitSet(new long[]{0x0100008220000000L});
	public static final BitSet FOLLOW_exprbase_in_exprbase786 = new BitSet(new long[]{0x0000011000000000L});
	public static final BitSet FOLLOW_WS_in_exprbase788 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_40_in_exprbase790 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_61_in_exprbase803 = new BitSet(new long[]{0x0100008220000000L});
	public static final BitSet FOLLOW_exprbase_in_exprbase804 = new BitSet(new long[]{0x0000011000000000L});
	public static final BitSet FOLLOW_WS_in_exprbase806 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_40_in_exprbase808 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_45_in_exprbase821 = new BitSet(new long[]{0x0100019220000000L});
	public static final BitSet FOLLOW_lexpr_in_exprbase822 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_40_in_exprbase823 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_55_in_exprbase836 = new BitSet(new long[]{0x0100019220000000L});
	public static final BitSet FOLLOW_lexpr_in_exprbase837 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_40_in_exprbase838 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_exprbase855 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VARIABLE_LEX_in_exprbase865 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SYMBOL_LEX_in_exprbase879 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WS_in_lexpr902 = new BitSet(new long[]{0x0100008220000002L});
	public static final BitSet FOLLOW_exprbase_in_lexpr906 = new BitSet(new long[]{0x0100009220000002L});
	public static final BitSet FOLLOW_WS_in_lexpr908 = new BitSet(new long[]{0x0100008220000002L});
}
