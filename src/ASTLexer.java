// $ANTLR 3.5.3 /home/cody/Git/Project_TLC/grammars/AST.g 2022-10-18 13:44:32

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class ASTLexer extends Lexer {
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
	@Override public String getGrammarFileName() { return "/home/cody/Git/Project_TLC/grammars/AST.g"; }

	// $ANTLR start "T__7"
	public final void mT__7() throws RecognitionException {
		try {
			int _type = T__7;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/cody/Git/Project_TLC/grammars/AST.g:2:6: ( ' % ' )
			// /home/cody/Git/Project_TLC/grammars/AST.g:2:8: ' % '
			{
			match(" % "); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__7"

	// $ANTLR start "T__8"
	public final void mT__8() throws RecognitionException {
		try {
			int _type = T__8;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/cody/Git/Project_TLC/grammars/AST.g:3:6: ( ' % write ' )
			// /home/cody/Git/Project_TLC/grammars/AST.g:3:8: ' % write '
			{
			match(" % write "); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__8"

	// $ANTLR start "T__9"
	public final void mT__9() throws RecognitionException {
		try {
			int _type = T__9;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/cody/Git/Project_TLC/grammars/AST.g:4:6: ( ' : ' )
			// /home/cody/Git/Project_TLC/grammars/AST.g:4:8: ' : '
			{
			match(" : "); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__9"

	// $ANTLR start "T__10"
	public final void mT__10() throws RecognitionException {
		try {
			int _type = T__10;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/cody/Git/Project_TLC/grammars/AST.g:5:7: ( 'function ' )
			// /home/cody/Git/Project_TLC/grammars/AST.g:5:9: 'function '
			{
			match("function "); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__10"

	// $ANTLR start "T__11"
	public final void mT__11() throws RecognitionException {
		try {
			int _type = T__11;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/cody/Git/Project_TLC/grammars/AST.g:6:7: ( 'nop' )
			// /home/cody/Git/Project_TLC/grammars/AST.g:6:9: 'nop'
			{
			match("nop"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__11"

	// $ANTLR start "T__12"
	public final void mT__12() throws RecognitionException {
		try {
			int _type = T__12;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/cody/Git/Project_TLC/grammars/AST.g:7:7: ( 'oui' )
			// /home/cody/Git/Project_TLC/grammars/AST.g:7:9: 'oui'
			{
			match("oui"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__12"

	// $ANTLR start "T__13"
	public final void mT__13() throws RecognitionException {
		try {
			int _type = T__13;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/cody/Git/Project_TLC/grammars/AST.g:8:7: ( 'read ' )
			// /home/cody/Git/Project_TLC/grammars/AST.g:8:9: 'read '
			{
			match("read "); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__13"

	// $ANTLR start "SYMBOL"
	public final void mSYMBOL() throws RecognitionException {
		try {
			int _type = SYMBOL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/cody/Git/Project_TLC/grammars/AST.g:62:2: ( ( 'a' .. 'z' ) ( ( 'A' .. 'Z' ) | ( 'a' .. 'z' ) | DIGIT )* ( '!' | '?' )? )
			// /home/cody/Git/Project_TLC/grammars/AST.g:62:4: ( 'a' .. 'z' ) ( ( 'A' .. 'Z' ) | ( 'a' .. 'z' ) | DIGIT )* ( '!' | '?' )?
			{
			if ( (input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// /home/cody/Git/Project_TLC/grammars/AST.g:62:14: ( ( 'A' .. 'Z' ) | ( 'a' .. 'z' ) | DIGIT )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /home/cody/Git/Project_TLC/grammars/AST.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop1;
				}
			}

			// /home/cody/Git/Project_TLC/grammars/AST.g:62:44: ( '!' | '?' )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0=='!'||LA2_0=='?') ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// /home/cody/Git/Project_TLC/grammars/AST.g:
					{
					if ( input.LA(1)=='!'||input.LA(1)=='?' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SYMBOL"

	// $ANTLR start "VARIABLE"
	public final void mVARIABLE() throws RecognitionException {
		try {
			int _type = VARIABLE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/cody/Git/Project_TLC/grammars/AST.g:65:3: ( ( 'A' .. 'Z' ) ( ( 'A' .. 'Z' ) | ( 'a' .. 'z' ) | DIGIT )* ( '!' | '?' )? )
			// /home/cody/Git/Project_TLC/grammars/AST.g:65:5: ( 'A' .. 'Z' ) ( ( 'A' .. 'Z' ) | ( 'a' .. 'z' ) | DIGIT )* ( '!' | '?' )?
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// /home/cody/Git/Project_TLC/grammars/AST.g:65:15: ( ( 'A' .. 'Z' ) | ( 'a' .. 'z' ) | DIGIT )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( ((LA3_0 >= '0' && LA3_0 <= '9')||(LA3_0 >= 'A' && LA3_0 <= 'Z')||(LA3_0 >= 'a' && LA3_0 <= 'z')) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// /home/cody/Git/Project_TLC/grammars/AST.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop3;
				}
			}

			// /home/cody/Git/Project_TLC/grammars/AST.g:65:45: ( '!' | '?' )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0=='!'||LA4_0=='?') ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// /home/cody/Git/Project_TLC/grammars/AST.g:
					{
					if ( input.LA(1)=='!'||input.LA(1)=='?' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "VARIABLE"

	// $ANTLR start "DIGIT"
	public final void mDIGIT() throws RecognitionException {
		try {
			int _type = DIGIT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/cody/Git/Project_TLC/grammars/AST.g:67:8: ( ( '0' .. '9' ) )
			// /home/cody/Git/Project_TLC/grammars/AST.g:
			{
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIGIT"

	@Override
	public void mTokens() throws RecognitionException {
		// /home/cody/Git/Project_TLC/grammars/AST.g:1:8: ( T__7 | T__8 | T__9 | T__10 | T__11 | T__12 | T__13 | SYMBOL | VARIABLE | DIGIT )
		int alt5=10;
		switch ( input.LA(1) ) {
		case ' ':
			{
			int LA5_1 = input.LA(2);
			if ( (LA5_1=='%') ) {
				int LA5_9 = input.LA(3);
				if ( (LA5_9==' ') ) {
					int LA5_15 = input.LA(4);
					if ( (LA5_15=='w') ) {
						alt5=2;
					}

					else {
						alt5=1;
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
							input.consume();
						}
						NoViableAltException nvae =
							new NoViableAltException("", 5, 9, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA5_1==':') ) {
				alt5=3;
			}

			else {
				int nvaeMark = input.mark();
				try {
					input.consume();
					NoViableAltException nvae =
						new NoViableAltException("", 5, 1, input);
					throw nvae;
				} finally {
					input.rewind(nvaeMark);
				}
			}

			}
			break;
		case 'f':
			{
			int LA5_2 = input.LA(2);
			if ( (LA5_2=='u') ) {
				int LA5_11 = input.LA(3);
				if ( (LA5_11=='n') ) {
					int LA5_16 = input.LA(4);
					if ( (LA5_16=='c') ) {
						int LA5_22 = input.LA(5);
						if ( (LA5_22=='t') ) {
							int LA5_26 = input.LA(6);
							if ( (LA5_26=='i') ) {
								int LA5_28 = input.LA(7);
								if ( (LA5_28=='o') ) {
									int LA5_29 = input.LA(8);
									if ( (LA5_29=='n') ) {
										int LA5_30 = input.LA(9);
										if ( (LA5_30==' ') ) {
											alt5=4;
										}

										else {
											alt5=8;
										}

									}

									else {
										alt5=8;
									}

								}

								else {
									alt5=8;
								}

							}

							else {
								alt5=8;
							}

						}

						else {
							alt5=8;
						}

					}

					else {
						alt5=8;
					}

				}

				else {
					alt5=8;
				}

			}

			else {
				alt5=8;
			}

			}
			break;
		case 'n':
			{
			int LA5_3 = input.LA(2);
			if ( (LA5_3=='o') ) {
				int LA5_12 = input.LA(3);
				if ( (LA5_12=='p') ) {
					int LA5_17 = input.LA(4);
					if ( (LA5_17=='!'||(LA5_17 >= '0' && LA5_17 <= '9')||LA5_17=='?'||(LA5_17 >= 'A' && LA5_17 <= 'Z')||(LA5_17 >= 'a' && LA5_17 <= 'z')) ) {
						alt5=8;
					}

					else {
						alt5=5;
					}

				}

				else {
					alt5=8;
				}

			}

			else {
				alt5=8;
			}

			}
			break;
		case 'o':
			{
			int LA5_4 = input.LA(2);
			if ( (LA5_4=='u') ) {
				int LA5_13 = input.LA(3);
				if ( (LA5_13=='i') ) {
					int LA5_18 = input.LA(4);
					if ( (LA5_18=='!'||(LA5_18 >= '0' && LA5_18 <= '9')||LA5_18=='?'||(LA5_18 >= 'A' && LA5_18 <= 'Z')||(LA5_18 >= 'a' && LA5_18 <= 'z')) ) {
						alt5=8;
					}

					else {
						alt5=6;
					}

				}

				else {
					alt5=8;
				}

			}

			else {
				alt5=8;
			}

			}
			break;
		case 'r':
			{
			int LA5_5 = input.LA(2);
			if ( (LA5_5=='e') ) {
				int LA5_14 = input.LA(3);
				if ( (LA5_14=='a') ) {
					int LA5_19 = input.LA(4);
					if ( (LA5_19=='d') ) {
						int LA5_25 = input.LA(5);
						if ( (LA5_25==' ') ) {
							alt5=7;
						}

						else {
							alt5=8;
						}

					}

					else {
						alt5=8;
					}

				}

				else {
					alt5=8;
				}

			}

			else {
				alt5=8;
			}

			}
			break;
		case 'a':
		case 'b':
		case 'c':
		case 'd':
		case 'e':
		case 'g':
		case 'h':
		case 'i':
		case 'j':
		case 'k':
		case 'l':
		case 'm':
		case 'p':
		case 'q':
		case 's':
		case 't':
		case 'u':
		case 'v':
		case 'w':
		case 'x':
		case 'y':
		case 'z':
			{
			alt5=8;
			}
			break;
		case 'A':
		case 'B':
		case 'C':
		case 'D':
		case 'E':
		case 'F':
		case 'G':
		case 'H':
		case 'I':
		case 'J':
		case 'K':
		case 'L':
		case 'M':
		case 'N':
		case 'O':
		case 'P':
		case 'Q':
		case 'R':
		case 'S':
		case 'T':
		case 'U':
		case 'V':
		case 'W':
		case 'X':
		case 'Y':
		case 'Z':
			{
			alt5=9;
			}
			break;
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
			{
			alt5=10;
			}
			break;
		default:
			NoViableAltException nvae =
				new NoViableAltException("", 5, 0, input);
			throw nvae;
		}
		switch (alt5) {
			case 1 :
				// /home/cody/Git/Project_TLC/grammars/AST.g:1:10: T__7
				{
				mT__7(); 

				}
				break;
			case 2 :
				// /home/cody/Git/Project_TLC/grammars/AST.g:1:15: T__8
				{
				mT__8(); 

				}
				break;
			case 3 :
				// /home/cody/Git/Project_TLC/grammars/AST.g:1:20: T__9
				{
				mT__9(); 

				}
				break;
			case 4 :
				// /home/cody/Git/Project_TLC/grammars/AST.g:1:25: T__10
				{
				mT__10(); 

				}
				break;
			case 5 :
				// /home/cody/Git/Project_TLC/grammars/AST.g:1:31: T__11
				{
				mT__11(); 

				}
				break;
			case 6 :
				// /home/cody/Git/Project_TLC/grammars/AST.g:1:37: T__12
				{
				mT__12(); 

				}
				break;
			case 7 :
				// /home/cody/Git/Project_TLC/grammars/AST.g:1:43: T__13
				{
				mT__13(); 

				}
				break;
			case 8 :
				// /home/cody/Git/Project_TLC/grammars/AST.g:1:49: SYMBOL
				{
				mSYMBOL(); 

				}
				break;
			case 9 :
				// /home/cody/Git/Project_TLC/grammars/AST.g:1:56: VARIABLE
				{
				mVARIABLE(); 

				}
				break;
			case 10 :
				// /home/cody/Git/Project_TLC/grammars/AST.g:1:65: DIGIT
				{
				mDIGIT(); 

				}
				break;

		}
	}



}
