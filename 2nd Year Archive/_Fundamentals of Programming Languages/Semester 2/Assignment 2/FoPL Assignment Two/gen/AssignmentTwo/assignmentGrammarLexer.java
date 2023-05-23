// Generated from C:/Users/joeki/OneDrive - Sheffield Hallam University/_Fundamentals of Programming Languages/Assignment 2/FoPL Assignment Two/src/AssignmentTwo\assignmentGrammar.g4 by ANTLR 4.9.1
package AssignmentTwo;

    package com.AssignmentTwo;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class assignmentGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, PROGBEGIN=16, 
		PROGEND=17, IDENTIFIER=18, VALUE=19, STRING=20, LETTER=21, UPPERCASE=22, 
		LOWERCASE=23, FLOAT=24, NUMBER=25, DIGIT=26, OP=27, ADD=28, SUB=29, MUL=30, 
		DIV=31, POW=32, EQUALS=33, BOOL_OP=34, COMPEQUALS=35, OR=36, AND=37, GTHAN=38, 
		LTHAN=39, LPARENS=40, RPARENS=41, LCURLY=42, RCURLY=43, LSQUARE=44, RSQUARE=45, 
		SCOLON=46, COLON=47, COMMA=48, POINT=49, SPEECHMARK=50, QUOTEMARK=51, 
		TRUE=52, FALSE=53, WHITESPACE=54;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "PROGBEGIN", "PROGEND", 
			"IDENTIFIER", "VALUE", "STRING", "LETTER", "UPPERCASE", "LOWERCASE", 
			"FLOAT", "NUMBER", "DIGIT", "OP", "ADD", "SUB", "MUL", "DIV", "POW", 
			"EQUALS", "BOOL_OP", "COMPEQUALS", "OR", "AND", "GTHAN", "LTHAN", "LPARENS", 
			"RPARENS", "LCURLY", "RCURLY", "LSQUARE", "RSQUARE", "SCOLON", "COLON", 
			"COMMA", "POINT", "SPEECHMARK", "QUOTEMARK", "TRUE", "FALSE", "WHITESPACE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'const'", "'input'", "'print'", "'if'", "'then'", "'else if'", 
			"'else'", "'end if'", "'for'", "'in'", "'end for'", "'while'", "'end while'", 
			"'function'", "'return'", "'A long time ago in a galaxy far far away...'", 
			"'The End'", null, null, null, null, null, null, null, null, null, null, 
			"'+'", "'-'", "'*'", "'/'", "'^'", "'='", null, "'=='", "'||'", "'&&'", 
			"'>'", "'<'", "'('", "')'", "'{'", "'}'", "'['", "']'", "';'", "':'", 
			"','", "'.'", "'\"'", "'''", "'true'", "'false'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "PROGBEGIN", "PROGEND", "IDENTIFIER", "VALUE", 
			"STRING", "LETTER", "UPPERCASE", "LOWERCASE", "FLOAT", "NUMBER", "DIGIT", 
			"OP", "ADD", "SUB", "MUL", "DIV", "POW", "EQUALS", "BOOL_OP", "COMPEQUALS", 
			"OR", "AND", "GTHAN", "LTHAN", "LPARENS", "RPARENS", "LCURLY", "RCURLY", 
			"LSQUARE", "RSQUARE", "SCOLON", "COLON", "COMMA", "POINT", "SPEECHMARK", 
			"QUOTEMARK", "TRUE", "FALSE", "WHITESPACE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public assignmentGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "assignmentGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\28\u017c\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23"+
		"\6\23\u0102\n\23\r\23\16\23\u0103\3\24\3\24\5\24\u0108\n\24\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\6\25\u0113\n\25\r\25\16\25\u0114\3"+
		"\25\3\25\3\26\3\26\5\26\u011b\n\26\3\27\3\27\3\30\3\30\3\31\3\31\3\31"+
		"\3\31\3\32\6\32\u0126\n\32\r\32\16\32\u0127\3\33\3\33\3\34\3\34\3\34\3"+
		"\34\3\34\5\34\u0131\n\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\""+
		"\3\"\3#\3#\3#\3#\3#\5#\u0144\n#\3$\3$\3$\3%\3%\3%\3&\3&\3&\3\'\3\'\3("+
		"\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62"+
		"\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\66"+
		"\3\66\3\66\3\67\6\67\u0177\n\67\r\67\16\67\u0178\3\67\3\67\2\28\3\3\5"+
		"\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!"+
		"A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8\3\2\6"+
		"\3\2C\\\3\2c|\3\2\62;\5\2\13\f\17\17\"\"\2\u0190\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3"+
		"\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2"+
		"\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2"+
		"Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3"+
		"\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\3o\3\2\2\2\5u\3\2\2"+
		"\2\7{\3\2\2\2\t\u0081\3\2\2\2\13\u0084\3\2\2\2\r\u0089\3\2\2\2\17\u0091"+
		"\3\2\2\2\21\u0096\3\2\2\2\23\u009d\3\2\2\2\25\u00a1\3\2\2\2\27\u00a4\3"+
		"\2\2\2\31\u00ac\3\2\2\2\33\u00b2\3\2\2\2\35\u00bc\3\2\2\2\37\u00c5\3\2"+
		"\2\2!\u00cc\3\2\2\2#\u00f8\3\2\2\2%\u0101\3\2\2\2\'\u0107\3\2\2\2)\u0109"+
		"\3\2\2\2+\u011a\3\2\2\2-\u011c\3\2\2\2/\u011e\3\2\2\2\61\u0120\3\2\2\2"+
		"\63\u0125\3\2\2\2\65\u0129\3\2\2\2\67\u0130\3\2\2\29\u0132\3\2\2\2;\u0134"+
		"\3\2\2\2=\u0136\3\2\2\2?\u0138\3\2\2\2A\u013a\3\2\2\2C\u013c\3\2\2\2E"+
		"\u0143\3\2\2\2G\u0145\3\2\2\2I\u0148\3\2\2\2K\u014b\3\2\2\2M\u014e\3\2"+
		"\2\2O\u0150\3\2\2\2Q\u0152\3\2\2\2S\u0154\3\2\2\2U\u0156\3\2\2\2W\u0158"+
		"\3\2\2\2Y\u015a\3\2\2\2[\u015c\3\2\2\2]\u015e\3\2\2\2_\u0160\3\2\2\2a"+
		"\u0162\3\2\2\2c\u0164\3\2\2\2e\u0166\3\2\2\2g\u0168\3\2\2\2i\u016a\3\2"+
		"\2\2k\u016f\3\2\2\2m\u0176\3\2\2\2op\7e\2\2pq\7q\2\2qr\7p\2\2rs\7u\2\2"+
		"st\7v\2\2t\4\3\2\2\2uv\7k\2\2vw\7p\2\2wx\7r\2\2xy\7w\2\2yz\7v\2\2z\6\3"+
		"\2\2\2{|\7r\2\2|}\7t\2\2}~\7k\2\2~\177\7p\2\2\177\u0080\7v\2\2\u0080\b"+
		"\3\2\2\2\u0081\u0082\7k\2\2\u0082\u0083\7h\2\2\u0083\n\3\2\2\2\u0084\u0085"+
		"\7v\2\2\u0085\u0086\7j\2\2\u0086\u0087\7g\2\2\u0087\u0088\7p\2\2\u0088"+
		"\f\3\2\2\2\u0089\u008a\7g\2\2\u008a\u008b\7n\2\2\u008b\u008c\7u\2\2\u008c"+
		"\u008d\7g\2\2\u008d\u008e\7\"\2\2\u008e\u008f\7k\2\2\u008f\u0090\7h\2"+
		"\2\u0090\16\3\2\2\2\u0091\u0092\7g\2\2\u0092\u0093\7n\2\2\u0093\u0094"+
		"\7u\2\2\u0094\u0095\7g\2\2\u0095\20\3\2\2\2\u0096\u0097\7g\2\2\u0097\u0098"+
		"\7p\2\2\u0098\u0099\7f\2\2\u0099\u009a\7\"\2\2\u009a\u009b\7k\2\2\u009b"+
		"\u009c\7h\2\2\u009c\22\3\2\2\2\u009d\u009e\7h\2\2\u009e\u009f\7q\2\2\u009f"+
		"\u00a0\7t\2\2\u00a0\24\3\2\2\2\u00a1\u00a2\7k\2\2\u00a2\u00a3\7p\2\2\u00a3"+
		"\26\3\2\2\2\u00a4\u00a5\7g\2\2\u00a5\u00a6\7p\2\2\u00a6\u00a7\7f\2\2\u00a7"+
		"\u00a8\7\"\2\2\u00a8\u00a9\7h\2\2\u00a9\u00aa\7q\2\2\u00aa\u00ab\7t\2"+
		"\2\u00ab\30\3\2\2\2\u00ac\u00ad\7y\2\2\u00ad\u00ae\7j\2\2\u00ae\u00af"+
		"\7k\2\2\u00af\u00b0\7n\2\2\u00b0\u00b1\7g\2\2\u00b1\32\3\2\2\2\u00b2\u00b3"+
		"\7g\2\2\u00b3\u00b4\7p\2\2\u00b4\u00b5\7f\2\2\u00b5\u00b6\7\"\2\2\u00b6"+
		"\u00b7\7y\2\2\u00b7\u00b8\7j\2\2\u00b8\u00b9\7k\2\2\u00b9\u00ba\7n\2\2"+
		"\u00ba\u00bb\7g\2\2\u00bb\34\3\2\2\2\u00bc\u00bd\7h\2\2\u00bd\u00be\7"+
		"w\2\2\u00be\u00bf\7p\2\2\u00bf\u00c0\7e\2\2\u00c0\u00c1\7v\2\2\u00c1\u00c2"+
		"\7k\2\2\u00c2\u00c3\7q\2\2\u00c3\u00c4\7p\2\2\u00c4\36\3\2\2\2\u00c5\u00c6"+
		"\7t\2\2\u00c6\u00c7\7g\2\2\u00c7\u00c8\7v\2\2\u00c8\u00c9\7w\2\2\u00c9"+
		"\u00ca\7t\2\2\u00ca\u00cb\7p\2\2\u00cb \3\2\2\2\u00cc\u00cd\7C\2\2\u00cd"+
		"\u00ce\7\"\2\2\u00ce\u00cf\7n\2\2\u00cf\u00d0\7q\2\2\u00d0\u00d1\7p\2"+
		"\2\u00d1\u00d2\7i\2\2\u00d2\u00d3\7\"\2\2\u00d3\u00d4\7v\2\2\u00d4\u00d5"+
		"\7k\2\2\u00d5\u00d6\7o\2\2\u00d6\u00d7\7g\2\2\u00d7\u00d8\7\"\2\2\u00d8"+
		"\u00d9\7c\2\2\u00d9\u00da\7i\2\2\u00da\u00db\7q\2\2\u00db\u00dc\7\"\2"+
		"\2\u00dc\u00dd\7k\2\2\u00dd\u00de\7p\2\2\u00de\u00df\7\"\2\2\u00df\u00e0"+
		"\7c\2\2\u00e0\u00e1\7\"\2\2\u00e1\u00e2\7i\2\2\u00e2\u00e3\7c\2\2\u00e3"+
		"\u00e4\7n\2\2\u00e4\u00e5\7c\2\2\u00e5\u00e6\7z\2\2\u00e6\u00e7\7{\2\2"+
		"\u00e7\u00e8\7\"\2\2\u00e8\u00e9\7h\2\2\u00e9\u00ea\7c\2\2\u00ea\u00eb"+
		"\7t\2\2\u00eb\u00ec\7\"\2\2\u00ec\u00ed\7h\2\2\u00ed\u00ee\7c\2\2\u00ee"+
		"\u00ef\7t\2\2\u00ef\u00f0\7\"\2\2\u00f0\u00f1\7c\2\2\u00f1\u00f2\7y\2"+
		"\2\u00f2\u00f3\7c\2\2\u00f3\u00f4\7{\2\2\u00f4\u00f5\7\60\2\2\u00f5\u00f6"+
		"\7\60\2\2\u00f6\u00f7\7\60\2\2\u00f7\"\3\2\2\2\u00f8\u00f9\7V\2\2\u00f9"+
		"\u00fa\7j\2\2\u00fa\u00fb\7g\2\2\u00fb\u00fc\7\"\2\2\u00fc\u00fd\7G\2"+
		"\2\u00fd\u00fe\7p\2\2\u00fe\u00ff\7f\2\2\u00ff$\3\2\2\2\u0100\u0102\5"+
		"+\26\2\u0101\u0100\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0101\3\2\2\2\u0103"+
		"\u0104\3\2\2\2\u0104&\3\2\2\2\u0105\u0108\5)\25\2\u0106\u0108\5\61\31"+
		"\2\u0107\u0105\3\2\2\2\u0107\u0106\3\2\2\2\u0108(\3\2\2\2\u0109\u0112"+
		"\5e\63\2\u010a\u0113\5+\26\2\u010b\u0113\5\65\33\2\u010c\u0113\5c\62\2"+
		"\u010d\u0113\5m\67\2\u010e\u0113\5C\"\2\u010f\u0113\5M\'\2\u0110\u0113"+
		"\5O(\2\u0111\u0113\5g\64\2\u0112\u010a\3\2\2\2\u0112\u010b\3\2\2\2\u0112"+
		"\u010c\3\2\2\2\u0112\u010d\3\2\2\2\u0112\u010e\3\2\2\2\u0112\u010f\3\2"+
		"\2\2\u0112\u0110\3\2\2\2\u0112\u0111\3\2\2\2\u0113\u0114\3\2\2\2\u0114"+
		"\u0112\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u0117\5e"+
		"\63\2\u0117*\3\2\2\2\u0118\u011b\5-\27\2\u0119\u011b\5/\30\2\u011a\u0118"+
		"\3\2\2\2\u011a\u0119\3\2\2\2\u011b,\3\2\2\2\u011c\u011d\t\2\2\2\u011d"+
		".\3\2\2\2\u011e\u011f\t\3\2\2\u011f\60\3\2\2\2\u0120\u0121\5\63\32\2\u0121"+
		"\u0122\5c\62\2\u0122\u0123\5\63\32\2\u0123\62\3\2\2\2\u0124\u0126\5\65"+
		"\33\2\u0125\u0124\3\2\2\2\u0126\u0127\3\2\2\2\u0127\u0125\3\2\2\2\u0127"+
		"\u0128\3\2\2\2\u0128\64\3\2\2\2\u0129\u012a\t\4\2\2\u012a\66\3\2\2\2\u012b"+
		"\u0131\59\35\2\u012c\u0131\5;\36\2\u012d\u0131\5=\37\2\u012e\u0131\5?"+
		" \2\u012f\u0131\5A!\2\u0130\u012b\3\2\2\2\u0130\u012c\3\2\2\2\u0130\u012d"+
		"\3\2\2\2\u0130\u012e\3\2\2\2\u0130\u012f\3\2\2\2\u01318\3\2\2\2\u0132"+
		"\u0133\7-\2\2\u0133:\3\2\2\2\u0134\u0135\7/\2\2\u0135<\3\2\2\2\u0136\u0137"+
		"\7,\2\2\u0137>\3\2\2\2\u0138\u0139\7\61\2\2\u0139@\3\2\2\2\u013a\u013b"+
		"\7`\2\2\u013bB\3\2\2\2\u013c\u013d\7?\2\2\u013dD\3\2\2\2\u013e\u0144\5"+
		"G$\2\u013f\u0144\5I%\2\u0140\u0144\5K&\2\u0141\u0144\5M\'\2\u0142\u0144"+
		"\5O(\2\u0143\u013e\3\2\2\2\u0143\u013f\3\2\2\2\u0143\u0140\3\2\2\2\u0143"+
		"\u0141\3\2\2\2\u0143\u0142\3\2\2\2\u0144F\3\2\2\2\u0145\u0146\7?\2\2\u0146"+
		"\u0147\7?\2\2\u0147H\3\2\2\2\u0148\u0149\7~\2\2\u0149\u014a\7~\2\2\u014a"+
		"J\3\2\2\2\u014b\u014c\7(\2\2\u014c\u014d\7(\2\2\u014dL\3\2\2\2\u014e\u014f"+
		"\7@\2\2\u014fN\3\2\2\2\u0150\u0151\7>\2\2\u0151P\3\2\2\2\u0152\u0153\7"+
		"*\2\2\u0153R\3\2\2\2\u0154\u0155\7+\2\2\u0155T\3\2\2\2\u0156\u0157\7}"+
		"\2\2\u0157V\3\2\2\2\u0158\u0159\7\177\2\2\u0159X\3\2\2\2\u015a\u015b\7"+
		"]\2\2\u015bZ\3\2\2\2\u015c\u015d\7_\2\2\u015d\\\3\2\2\2\u015e\u015f\7"+
		"=\2\2\u015f^\3\2\2\2\u0160\u0161\7<\2\2\u0161`\3\2\2\2\u0162\u0163\7."+
		"\2\2\u0163b\3\2\2\2\u0164\u0165\7\60\2\2\u0165d\3\2\2\2\u0166\u0167\7"+
		"$\2\2\u0167f\3\2\2\2\u0168\u0169\7)\2\2\u0169h\3\2\2\2\u016a\u016b\7v"+
		"\2\2\u016b\u016c\7t\2\2\u016c\u016d\7w\2\2\u016d\u016e\7g\2\2\u016ej\3"+
		"\2\2\2\u016f\u0170\7h\2\2\u0170\u0171\7c\2\2\u0171\u0172\7n\2\2\u0172"+
		"\u0173\7u\2\2\u0173\u0174\7g\2\2\u0174l\3\2\2\2\u0175\u0177\t\5\2\2\u0176"+
		"\u0175\3\2\2\2\u0177\u0178\3\2\2\2\u0178\u0176\3\2\2\2\u0178\u0179\3\2"+
		"\2\2\u0179\u017a\3\2\2\2\u017a\u017b\b\67\2\2\u017bn\3\2\2\2\f\2\u0103"+
		"\u0107\u0112\u0114\u011a\u0127\u0130\u0143\u0178\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}