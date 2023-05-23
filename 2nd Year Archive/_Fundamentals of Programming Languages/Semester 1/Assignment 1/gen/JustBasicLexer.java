// Generated from C:/Users/joeki/OneDrive - Sheffield Hallam University/_Fundamentals of Programming Languages\JustBasic.g4 by ANTLR 4.9
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JustBasicLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, STRING=11, OP=12, LPARENS=13, RPARENS=14, BOOL_OP=15, LABEL=16, 
		LSQBR=17, RSQBR=18, SEMI=19, EQUALS=20, GT=21, LT=22, SPEECHMARK=23, QUOTE=24, 
		COMMA=25, COLON=26, ID=27, NUMBER=28, DECIMAL=29, INTEGER=30, DOT=31, 
		DIGIT=32, UPPERCASE=33, LOWERCASE=34, MUL=35, DIV=36, ADD=37, SUB=38, 
		POW=39, WS=40, COMMENT=41;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "STRING", "OP", "LPARENS", "RPARENS", "BOOL_OP", "LABEL", "LSQBR", 
			"RSQBR", "SEMI", "EQUALS", "GT", "LT", "SPEECHMARK", "QUOTE", "COMMA", 
			"COLON", "ID", "NUMBER", "DECIMAL", "INTEGER", "DOT", "DIGIT", "UPPERCASE", 
			"LOWERCASE", "MUL", "DIV", "ADD", "SUB", "POW", "WS", "COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'cls'", "'goto'", "'input'", "'if'", "'then'", "'or'", "'and'", 
			"'int'", "'decimal'", "'print'", null, null, "'('", "')'", null, null, 
			"'['", "']'", "';'", "'='", "'>'", "'<'", "'\"'", "'''", "','", "':'", 
			null, null, null, null, "'.'", null, null, null, "'*'", "'/'", "'+'", 
			"'-'", "'^'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "STRING", 
			"OP", "LPARENS", "RPARENS", "BOOL_OP", "LABEL", "LSQBR", "RSQBR", "SEMI", 
			"EQUALS", "GT", "LT", "SPEECHMARK", "QUOTE", "COMMA", "COLON", "ID", 
			"NUMBER", "DECIMAL", "INTEGER", "DOT", "DIGIT", "UPPERCASE", "LOWERCASE", 
			"MUL", "DIV", "ADD", "SUB", "POW", "WS", "COMMENT"
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


	public JustBasicLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "JustBasic.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2+\u00f7\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\3\2\3\2"+
		"\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3"+
		"\6\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\7\f\u0090\n\f\f\f\16\f\u0093\13\f\3\f\3\f\3\r\3\r"+
		"\3\r\3\r\3\r\5\r\u009c\n\r\3\16\3\16\3\17\3\17\3\20\3\20\5\20\u00a4\n"+
		"\20\3\21\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3"+
		"\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\6\34\u00bf"+
		"\n\34\r\34\16\34\u00c0\3\35\3\35\5\35\u00c5\n\35\3\36\7\36\u00c8\n\36"+
		"\f\36\16\36\u00cb\13\36\3\36\3\36\6\36\u00cf\n\36\r\36\16\36\u00d0\3\37"+
		"\6\37\u00d4\n\37\r\37\16\37\u00d5\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3"+
		"%\3&\3&\3\'\3\'\3(\3(\3)\6)\u00eb\n)\r)\16)\u00ec\3)\3)\3*\3*\7*\u00f3"+
		"\n*\f*\16*\u00f6\13*\3\u00f4\2+\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31"+
		"\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+\3\2\6\3\2\62"+
		";\3\2C\\\3\2c|\5\2\13\f\17\17\"\"\2\u010b\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2"+
		"\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2"+
		"\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2"+
		"\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2"+
		"\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M"+
		"\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\3U\3\2\2\2\5Y\3\2\2\2\7^\3\2"+
		"\2\2\td\3\2\2\2\13g\3\2\2\2\rl\3\2\2\2\17o\3\2\2\2\21s\3\2\2\2\23w\3\2"+
		"\2\2\25\177\3\2\2\2\27\u0085\3\2\2\2\31\u009b\3\2\2\2\33\u009d\3\2\2\2"+
		"\35\u009f\3\2\2\2\37\u00a3\3\2\2\2!\u00a5\3\2\2\2#\u00a9\3\2\2\2%\u00ab"+
		"\3\2\2\2\'\u00ad\3\2\2\2)\u00af\3\2\2\2+\u00b1\3\2\2\2-\u00b3\3\2\2\2"+
		"/\u00b5\3\2\2\2\61\u00b7\3\2\2\2\63\u00b9\3\2\2\2\65\u00bb\3\2\2\2\67"+
		"\u00be\3\2\2\29\u00c4\3\2\2\2;\u00c9\3\2\2\2=\u00d3\3\2\2\2?\u00d7\3\2"+
		"\2\2A\u00d9\3\2\2\2C\u00db\3\2\2\2E\u00dd\3\2\2\2G\u00df\3\2\2\2I\u00e1"+
		"\3\2\2\2K\u00e3\3\2\2\2M\u00e5\3\2\2\2O\u00e7\3\2\2\2Q\u00ea\3\2\2\2S"+
		"\u00f0\3\2\2\2UV\7e\2\2VW\7n\2\2WX\7u\2\2X\4\3\2\2\2YZ\7i\2\2Z[\7q\2\2"+
		"[\\\7v\2\2\\]\7q\2\2]\6\3\2\2\2^_\7k\2\2_`\7p\2\2`a\7r\2\2ab\7w\2\2bc"+
		"\7v\2\2c\b\3\2\2\2de\7k\2\2ef\7h\2\2f\n\3\2\2\2gh\7v\2\2hi\7j\2\2ij\7"+
		"g\2\2jk\7p\2\2k\f\3\2\2\2lm\7q\2\2mn\7t\2\2n\16\3\2\2\2op\7c\2\2pq\7p"+
		"\2\2qr\7f\2\2r\20\3\2\2\2st\7k\2\2tu\7p\2\2uv\7v\2\2v\22\3\2\2\2wx\7f"+
		"\2\2xy\7g\2\2yz\7e\2\2z{\7k\2\2{|\7o\2\2|}\7c\2\2}~\7n\2\2~\24\3\2\2\2"+
		"\177\u0080\7r\2\2\u0080\u0081\7t\2\2\u0081\u0082\7k\2\2\u0082\u0083\7"+
		"p\2\2\u0083\u0084\7v\2\2\u0084\26\3\2\2\2\u0085\u0091\5/\30\2\u0086\u0090"+
		"\5C\"\2\u0087\u0090\5E#\2\u0088\u0090\5? \2\u0089\u0090\5Q)\2\u008a\u0090"+
		"\5)\25\2\u008b\u0090\5+\26\2\u008c\u0090\5M\'\2\u008d\u0090\5A!\2\u008e"+
		"\u0090\5\61\31\2\u008f\u0086\3\2\2\2\u008f\u0087\3\2\2\2\u008f\u0088\3"+
		"\2\2\2\u008f\u0089\3\2\2\2\u008f\u008a\3\2\2\2\u008f\u008b\3\2\2\2\u008f"+
		"\u008c\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u008e\3\2\2\2\u0090\u0093\3\2"+
		"\2\2\u0091\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0094\3\2\2\2\u0093"+
		"\u0091\3\2\2\2\u0094\u0095\5/\30\2\u0095\30\3\2\2\2\u0096\u009c\5G$\2"+
		"\u0097\u009c\5I%\2\u0098\u009c\5K&\2\u0099\u009c\5M\'\2\u009a\u009c\5"+
		"O(\2\u009b\u0096\3\2\2\2\u009b\u0097\3\2\2\2\u009b\u0098\3\2\2\2\u009b"+
		"\u0099\3\2\2\2\u009b\u009a\3\2\2\2\u009c\32\3\2\2\2\u009d\u009e\7*\2\2"+
		"\u009e\34\3\2\2\2\u009f\u00a0\7+\2\2\u00a0\36\3\2\2\2\u00a1\u00a4\5+\26"+
		"\2\u00a2\u00a4\5-\27\2\u00a3\u00a1\3\2\2\2\u00a3\u00a2\3\2\2\2\u00a4 "+
		"\3\2\2\2\u00a5\u00a6\5#\22\2\u00a6\u00a7\5\67\34\2\u00a7\u00a8\5%\23\2"+
		"\u00a8\"\3\2\2\2\u00a9\u00aa\7]\2\2\u00aa$\3\2\2\2\u00ab\u00ac\7_\2\2"+
		"\u00ac&\3\2\2\2\u00ad\u00ae\7=\2\2\u00ae(\3\2\2\2\u00af\u00b0\7?\2\2\u00b0"+
		"*\3\2\2\2\u00b1\u00b2\7@\2\2\u00b2,\3\2\2\2\u00b3\u00b4\7>\2\2\u00b4."+
		"\3\2\2\2\u00b5\u00b6\7$\2\2\u00b6\60\3\2\2\2\u00b7\u00b8\7)\2\2\u00b8"+
		"\62\3\2\2\2\u00b9\u00ba\7.\2\2\u00ba\64\3\2\2\2\u00bb\u00bc\7<\2\2\u00bc"+
		"\66\3\2\2\2\u00bd\u00bf\5E#\2\u00be\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2"+
		"\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c18\3\2\2\2\u00c2\u00c5\5"+
		"=\37\2\u00c3\u00c5\5;\36\2\u00c4\u00c2\3\2\2\2\u00c4\u00c3\3\2\2\2\u00c5"+
		":\3\2\2\2\u00c6\u00c8\5A!\2\u00c7\u00c6\3\2\2\2\u00c8\u00cb\3\2\2\2\u00c9"+
		"\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cc\3\2\2\2\u00cb\u00c9\3\2"+
		"\2\2\u00cc\u00ce\5? \2\u00cd\u00cf\5A!\2\u00ce\u00cd\3\2\2\2\u00cf\u00d0"+
		"\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1<\3\2\2\2\u00d2"+
		"\u00d4\5A!\2\u00d3\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d3\3\2\2"+
		"\2\u00d5\u00d6\3\2\2\2\u00d6>\3\2\2\2\u00d7\u00d8\7\60\2\2\u00d8@\3\2"+
		"\2\2\u00d9\u00da\t\2\2\2\u00daB\3\2\2\2\u00db\u00dc\t\3\2\2\u00dcD\3\2"+
		"\2\2\u00dd\u00de\t\4\2\2\u00deF\3\2\2\2\u00df\u00e0\7,\2\2\u00e0H\3\2"+
		"\2\2\u00e1\u00e2\7\61\2\2\u00e2J\3\2\2\2\u00e3\u00e4\7-\2\2\u00e4L\3\2"+
		"\2\2\u00e5\u00e6\7/\2\2\u00e6N\3\2\2\2\u00e7\u00e8\7`\2\2\u00e8P\3\2\2"+
		"\2\u00e9\u00eb\t\5\2\2\u00ea\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ea"+
		"\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00ef\b)\2\2\u00ef"+
		"R\3\2\2\2\u00f0\u00f4\5\61\31\2\u00f1\u00f3\13\2\2\2\u00f2\u00f1\3\2\2"+
		"\2\u00f3\u00f6\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f5T"+
		"\3\2\2\2\u00f6\u00f4\3\2\2\2\16\2\u008f\u0091\u009b\u00a3\u00c0\u00c4"+
		"\u00c9\u00d0\u00d5\u00ec\u00f4\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}