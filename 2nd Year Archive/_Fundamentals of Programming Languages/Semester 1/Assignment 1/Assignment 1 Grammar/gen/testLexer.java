// Generated from C:/Users/joeki/OneDrive - Sheffield Hallam University/_Fundamentals of Programming Languages/Assignment 1 Grammar\assignment.g4 by ANTLR 4.9

    package assignment;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class testLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, PROGBEGIN=7, PROGEND=8, 
		IDENTIFIER=9, LPARENS=10, RPARENS=11, LCURLY=12, RCURLY=13, SCOLON=14, 
		SPEECHMARKS=15, QUOTEMARKS=16, OR=17, AND=18, OP=19, ADD=20, SUB=21, MUL=22, 
		DIV=23, EQUALS=24, FLOAT=25, POINT=26, STRING=27, LETTER=28, UPPERCASE=29, 
		LOWERCASE=30, NUMBER=31, WHITESPACE=32;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "PROGBEGIN", "PROGEND", 
			"IDENTIFIER", "SYMBOL", "LPARENS", "RPARENS", "LCURLY", "RCURLY", "SCOLON", 
			"SPEECHMARKS", "QUOTEMARKS", "OR", "AND", "OP", "ADD", "SUB", "MUL", 
			"DIV", "EQUALS", "FLOAT", "POINT", "STRING", "LETTER", "UPPERCASE", "LOWERCASE", 
			"NUMBER", "WHITESPACE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'input'", "'print'", "'if'", "'then'", "'else if'", "'else'", 
			"'In the beginning...'", "'Amen'", null, "'('", "')'", "'{'", "'}'", 
			"';'", "'\"'", "'''", "'||'", "'&&'", null, "'+'", "'-'", "'*'", "'/'", 
			"'='", null, "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "PROGBEGIN", "PROGEND", "IDENTIFIER", 
			"LPARENS", "RPARENS", "LCURLY", "RCURLY", "SCOLON", "SPEECHMARKS", "QUOTEMARKS", 
			"OR", "AND", "OP", "ADD", "SUB", "MUL", "DIV", "EQUALS", "FLOAT", "POINT", 
			"STRING", "LETTER", "UPPERCASE", "LOWERCASE", "NUMBER", "WHITESPACE"
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


	public testLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "assignment.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\"\u00e1\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3"+
		"\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7"+
		"\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\6\n\u0081\n\n\r\n\16\n\u0082\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u008e\n\13\3\f\3\f\3"+
		"\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\23"+
		"\3\24\3\24\3\24\3\25\3\25\3\25\3\25\5\25\u00a8\n\25\3\26\3\26\3\27\3\27"+
		"\3\30\3\30\3\31\3\31\3\32\3\32\3\33\7\33\u00b5\n\33\f\33\16\33\u00b8\13"+
		"\33\3\33\3\33\7\33\u00bc\n\33\f\33\16\33\u00bf\13\33\3\34\3\34\3\35\3"+
		"\35\3\35\3\35\3\35\3\35\3\35\3\35\6\35\u00cb\n\35\r\35\16\35\u00cc\3\35"+
		"\3\35\3\36\3\36\5\36\u00d3\n\36\3\37\3\37\3 \3 \3!\3!\3\"\6\"\u00dc\n"+
		"\"\r\"\16\"\u00dd\3\"\3\"\2\2#\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\2\27\f\31\r\33\16\35\17\37\20!\21#\22%\23\'\24)\25+\26-\27/\30\61"+
		"\31\63\32\65\33\67\349\35;\36=\37? A!C\"\3\2\6\3\2C\\\3\2c|\3\2\62;\5"+
		"\2\13\f\17\17\"\"\2\u00f6\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2"+
		"\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2"+
		"\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3"+
		"\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\3E\3\2\2"+
		"\2\5K\3\2\2\2\7Q\3\2\2\2\tT\3\2\2\2\13Y\3\2\2\2\ra\3\2\2\2\17f\3\2\2\2"+
		"\21z\3\2\2\2\23\u0080\3\2\2\2\25\u008d\3\2\2\2\27\u008f\3\2\2\2\31\u0091"+
		"\3\2\2\2\33\u0093\3\2\2\2\35\u0095\3\2\2\2\37\u0097\3\2\2\2!\u0099\3\2"+
		"\2\2#\u009b\3\2\2\2%\u009d\3\2\2\2\'\u00a0\3\2\2\2)\u00a7\3\2\2\2+\u00a9"+
		"\3\2\2\2-\u00ab\3\2\2\2/\u00ad\3\2\2\2\61\u00af\3\2\2\2\63\u00b1\3\2\2"+
		"\2\65\u00b6\3\2\2\2\67\u00c0\3\2\2\29\u00c2\3\2\2\2;\u00d2\3\2\2\2=\u00d4"+
		"\3\2\2\2?\u00d6\3\2\2\2A\u00d8\3\2\2\2C\u00db\3\2\2\2EF\7k\2\2FG\7p\2"+
		"\2GH\7r\2\2HI\7w\2\2IJ\7v\2\2J\4\3\2\2\2KL\7r\2\2LM\7t\2\2MN\7k\2\2NO"+
		"\7p\2\2OP\7v\2\2P\6\3\2\2\2QR\7k\2\2RS\7h\2\2S\b\3\2\2\2TU\7v\2\2UV\7"+
		"j\2\2VW\7g\2\2WX\7p\2\2X\n\3\2\2\2YZ\7g\2\2Z[\7n\2\2[\\\7u\2\2\\]\7g\2"+
		"\2]^\7\"\2\2^_\7k\2\2_`\7h\2\2`\f\3\2\2\2ab\7g\2\2bc\7n\2\2cd\7u\2\2d"+
		"e\7g\2\2e\16\3\2\2\2fg\7K\2\2gh\7p\2\2hi\7\"\2\2ij\7v\2\2jk\7j\2\2kl\7"+
		"g\2\2lm\7\"\2\2mn\7d\2\2no\7g\2\2op\7i\2\2pq\7k\2\2qr\7p\2\2rs\7p\2\2"+
		"st\7k\2\2tu\7p\2\2uv\7i\2\2vw\7\60\2\2wx\7\60\2\2xy\7\60\2\2y\20\3\2\2"+
		"\2z{\7C\2\2{|\7o\2\2|}\7g\2\2}~\7p\2\2~\22\3\2\2\2\177\u0081\5;\36\2\u0080"+
		"\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2"+
		"\2\u0083\24\3\2\2\2\u0084\u008e\5\27\f\2\u0085\u008e\5\31\r\2\u0086\u008e"+
		"\5\33\16\2\u0087\u008e\5\35\17\2\u0088\u008e\5\37\20\2\u0089\u008e\5!"+
		"\21\2\u008a\u008e\5#\22\2\u008b\u008e\5%\23\2\u008c\u008e\5\'\24\2\u008d"+
		"\u0084\3\2\2\2\u008d\u0085\3\2\2\2\u008d\u0086\3\2\2\2\u008d\u0087\3\2"+
		"\2\2\u008d\u0088\3\2\2\2\u008d\u0089\3\2\2\2\u008d\u008a\3\2\2\2\u008d"+
		"\u008b\3\2\2\2\u008d\u008c\3\2\2\2\u008e\26\3\2\2\2\u008f\u0090\7*\2\2"+
		"\u0090\30\3\2\2\2\u0091\u0092\7+\2\2\u0092\32\3\2\2\2\u0093\u0094\7}\2"+
		"\2\u0094\34\3\2\2\2\u0095\u0096\7\177\2\2\u0096\36\3\2\2\2\u0097\u0098"+
		"\7=\2\2\u0098 \3\2\2\2\u0099\u009a\7$\2\2\u009a\"\3\2\2\2\u009b\u009c"+
		"\7)\2\2\u009c$\3\2\2\2\u009d\u009e\7~\2\2\u009e\u009f\7~\2\2\u009f&\3"+
		"\2\2\2\u00a0\u00a1\7(\2\2\u00a1\u00a2\7(\2\2\u00a2(\3\2\2\2\u00a3\u00a8"+
		"\5+\26\2\u00a4\u00a8\5-\27\2\u00a5\u00a8\5/\30\2\u00a6\u00a8\5\61\31\2"+
		"\u00a7\u00a3\3\2\2\2\u00a7\u00a4\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a6"+
		"\3\2\2\2\u00a8*\3\2\2\2\u00a9\u00aa\7-\2\2\u00aa,\3\2\2\2\u00ab\u00ac"+
		"\7/\2\2\u00ac.\3\2\2\2\u00ad\u00ae\7,\2\2\u00ae\60\3\2\2\2\u00af\u00b0"+
		"\7\61\2\2\u00b0\62\3\2\2\2\u00b1\u00b2\7?\2\2\u00b2\64\3\2\2\2\u00b3\u00b5"+
		"\5A!\2\u00b4\u00b3\3\2\2\2\u00b5\u00b8\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6"+
		"\u00b7\3\2\2\2\u00b7\u00b9\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b9\u00bd\5\67"+
		"\34\2\u00ba\u00bc\5A!\2\u00bb\u00ba\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd"+
		"\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\66\3\2\2\2\u00bf\u00bd\3\2\2"+
		"\2\u00c0\u00c1\7\60\2\2\u00c18\3\2\2\2\u00c2\u00ca\5!\21\2\u00c3\u00cb"+
		"\5;\36\2\u00c4\u00cb\5A!\2\u00c5\u00cb\5\67\34\2\u00c6\u00cb\5C\"\2\u00c7"+
		"\u00cb\5\63\32\2\u00c8\u00cb\5)\25\2\u00c9\u00cb\5\25\13\2\u00ca\u00c3"+
		"\3\2\2\2\u00ca\u00c4\3\2\2\2\u00ca\u00c5\3\2\2\2\u00ca\u00c6\3\2\2\2\u00ca"+
		"\u00c7\3\2\2\2\u00ca\u00c8\3\2\2\2\u00ca\u00c9\3\2\2\2\u00cb\u00cc\3\2"+
		"\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce"+
		"\u00cf\5!\21\2\u00cf:\3\2\2\2\u00d0\u00d3\5=\37\2\u00d1\u00d3\5? \2\u00d2"+
		"\u00d0\3\2\2\2\u00d2\u00d1\3\2\2\2\u00d3<\3\2\2\2\u00d4\u00d5\t\2\2\2"+
		"\u00d5>\3\2\2\2\u00d6\u00d7\t\3\2\2\u00d7@\3\2\2\2\u00d8\u00d9\t\4\2\2"+
		"\u00d9B\3\2\2\2\u00da\u00dc\t\5\2\2\u00db\u00da\3\2\2\2\u00dc\u00dd\3"+
		"\2\2\2\u00dd\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00df\3\2\2\2\u00df"+
		"\u00e0\b\"\2\2\u00e0D\3\2\2\2\f\2\u0082\u008d\u00a7\u00b6\u00bd\u00ca"+
		"\u00cc\u00d2\u00dd\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}