// $ANTLR 3.5.3 /home/cody/Git/Project_TLC/grammars/AST.g 2022-10-18 13:44:32

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class ASTParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "DIGIT", "SYMBOL", "VARIABLE", 
		"' % '", "' % write '", "' : '", "'function '", "'nop'", "'oui'", "'read '"
	};
	public static final int EOF=-1;
	public static final int T__7=7;
	public static final int T__8=8;
	public static final int T__9=9;
	public static final int T__10=10;
	public static final int T__11=11;
	public static final int T__12=12;
	public static final int T__13=13;
	public static final int DIGIT=4;
	public static final int SYMBOL=5;
	public static final int VARIABLE=6;

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

	@Override public String[] getTokenNames() { return ASTParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/home/cody/Git/Project_TLC/grammars/AST.g"; }



	// $ANTLR start "program"
	// /home/cody/Git/Project_TLC/grammars/AST.g:5:1: program : ( function )+ ;
	public final void program() throws RecognitionException {
		try {
			// /home/cody/Git/Project_TLC/grammars/AST.g:5:9: ( ( function )+ )
			// /home/cody/Git/Project_TLC/grammars/AST.g:5:12: ( function )+
			{
			// /home/cody/Git/Project_TLC/grammars/AST.g:5:12: ( function )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==10) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /home/cody/Git/Project_TLC/grammars/AST.g:5:12: function
					{
					pushFollow(FOLLOW_function_in_program13);
					function();
					state._fsp--;

					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "program"



	// $ANTLR start "function"
	// /home/cody/Git/Project_TLC/grammars/AST.g:7:1: function : 'function ' SYMBOL ' : ' definition ;
	public final void function() throws RecognitionException {
		try {
			// /home/cody/Git/Project_TLC/grammars/AST.g:8:2: ( 'function ' SYMBOL ' : ' definition )
			// /home/cody/Git/Project_TLC/grammars/AST.g:8:5: 'function ' SYMBOL ' : ' definition
			{
			match(input,10,FOLLOW_10_in_function24); 
			match(input,SYMBOL,FOLLOW_SYMBOL_in_function25); 
			match(input,9,FOLLOW_9_in_function26); 
			pushFollow(FOLLOW_definition_in_function27);
			definition();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "function"



	// $ANTLR start "definition"
	// /home/cody/Git/Project_TLC/grammars/AST.g:12:1: definition : 'read ' input ' % ' commands ' % write ' input ;
	public final void definition() throws RecognitionException {
		try {
			// /home/cody/Git/Project_TLC/grammars/AST.g:13:2: ( 'read ' input ' % ' commands ' % write ' input )
			// /home/cody/Git/Project_TLC/grammars/AST.g:13:5: 'read ' input ' % ' commands ' % write ' input
			{
			match(input,13,FOLLOW_13_in_definition41); 
			pushFollow(FOLLOW_input_in_definition42);
			input();
			state._fsp--;

			match(input,7,FOLLOW_7_in_definition43); 
			pushFollow(FOLLOW_commands_in_definition44);
			commands();
			state._fsp--;

			match(input,8,FOLLOW_8_in_definition45); 
			pushFollow(FOLLOW_input_in_definition46);
			input();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "definition"



	// $ANTLR start "input"
	// /home/cody/Git/Project_TLC/grammars/AST.g:15:1: input : ( inputsub )? ;
	public final void input() throws RecognitionException {
		try {
			// /home/cody/Git/Project_TLC/grammars/AST.g:15:8: ( ( inputsub )? )
			// /home/cody/Git/Project_TLC/grammars/AST.g:15:11: ( inputsub )?
			{
			// /home/cody/Git/Project_TLC/grammars/AST.g:15:11: ( inputsub )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==VARIABLE) ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// /home/cody/Git/Project_TLC/grammars/AST.g:15:11: inputsub
					{
					pushFollow(FOLLOW_inputsub_in_input57);
					inputsub();
					state._fsp--;

					}
					break;

			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "input"



	// $ANTLR start "inputsub"
	// /home/cody/Git/Project_TLC/grammars/AST.g:19:1: inputsub : VARIABLE ;
	public final void inputsub() throws RecognitionException {
		try {
			// /home/cody/Git/Project_TLC/grammars/AST.g:20:2: ( VARIABLE )
			// /home/cody/Git/Project_TLC/grammars/AST.g:20:5: VARIABLE
			{
			match(input,VARIABLE,FOLLOW_VARIABLE_in_inputsub71); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "inputsub"



	// $ANTLR start "commands"
	// /home/cody/Git/Project_TLC/grammars/AST.g:26:1: commands : ( command )+ ;
	public final void commands() throws RecognitionException {
		try {
			// /home/cody/Git/Project_TLC/grammars/AST.g:27:2: ( ( command )+ )
			// /home/cody/Git/Project_TLC/grammars/AST.g:27:5: ( command )+
			{
			// /home/cody/Git/Project_TLC/grammars/AST.g:27:5: ( command )+
			int cnt3=0;
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==11) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// /home/cody/Git/Project_TLC/grammars/AST.g:27:5: command
					{
					pushFollow(FOLLOW_command_in_commands87);
					command();
					state._fsp--;

					}
					break;

				default :
					if ( cnt3 >= 1 ) break loop3;
					EarlyExitException eee = new EarlyExitException(3, input);
					throw eee;
				}
				cnt3++;
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "commands"



	// $ANTLR start "command"
	// /home/cody/Git/Project_TLC/grammars/AST.g:29:1: command : 'nop' ;
	public final void command() throws RecognitionException {
		try {
			// /home/cody/Git/Project_TLC/grammars/AST.g:29:10: ( 'nop' )
			// /home/cody/Git/Project_TLC/grammars/AST.g:29:13: 'nop'
			{
			match(input,11,FOLLOW_11_in_command99); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "command"



	// $ANTLR start "vars"
	// /home/cody/Git/Project_TLC/grammars/AST.g:36:1: vars : VARIABLE ;
	public final void vars() throws RecognitionException {
		try {
			// /home/cody/Git/Project_TLC/grammars/AST.g:36:7: ( VARIABLE )
			// /home/cody/Git/Project_TLC/grammars/AST.g:36:10: VARIABLE
			{
			match(input,VARIABLE,FOLLOW_VARIABLE_in_vars111); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "vars"



	// $ANTLR start "exprs"
	// /home/cody/Git/Project_TLC/grammars/AST.g:39:1: exprs : ( expression )+ ;
	public final void exprs() throws RecognitionException {
		try {
			// /home/cody/Git/Project_TLC/grammars/AST.g:39:8: ( ( expression )+ )
			// /home/cody/Git/Project_TLC/grammars/AST.g:39:11: ( expression )+
			{
			// /home/cody/Git/Project_TLC/grammars/AST.g:39:11: ( expression )+
			int cnt4=0;
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==12) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// /home/cody/Git/Project_TLC/grammars/AST.g:39:11: expression
					{
					pushFollow(FOLLOW_expression_in_exprs122);
					expression();
					state._fsp--;

					}
					break;

				default :
					if ( cnt4 >= 1 ) break loop4;
					EarlyExitException eee = new EarlyExitException(4, input);
					throw eee;
				}
				cnt4++;
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "exprs"



	// $ANTLR start "expression"
	// /home/cody/Git/Project_TLC/grammars/AST.g:41:1: expression : 'oui' ;
	public final void expression() throws RecognitionException {
		try {
			// /home/cody/Git/Project_TLC/grammars/AST.g:42:2: ( 'oui' )
			// /home/cody/Git/Project_TLC/grammars/AST.g:42:5: 'oui'
			{
			match(input,12,FOLLOW_12_in_expression134); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "expression"

	// Delegated rules



	public static final BitSet FOLLOW_function_in_program13 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_10_in_function24 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_SYMBOL_in_function25 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_function26 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_definition_in_function27 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_13_in_definition41 = new BitSet(new long[]{0x00000000000000C0L});
	public static final BitSet FOLLOW_input_in_definition42 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_7_in_definition43 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_commands_in_definition44 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_8_in_definition45 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_input_in_definition46 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_inputsub_in_input57 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VARIABLE_in_inputsub71 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_command_in_commands87 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_11_in_command99 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VARIABLE_in_vars111 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_exprs122 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_12_in_expression134 = new BitSet(new long[]{0x0000000000000002L});
}
