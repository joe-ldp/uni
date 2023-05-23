// Generated from C:/Users/joeki/OneDrive - Sheffield Hallam University/_Fundamentals of Programming Languages\JustBasic.g4 by ANTLR 4.9
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JustBasicParser extends Parser {
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
	public static final int
		RULE_program = 0, RULE_stat = 1, RULE_goto_stat = 2, RULE_block_stat = 3, 
		RULE_input_stat = 4, RULE_if_stat = 5, RULE_bool_join = 6, RULE_bool_expr = 7, 
		RULE_bool_operand = 8, RULE_cast = 9, RULE_assign_stat = 10, RULE_print_stat = 11, 
		RULE_expr = 12, RULE_operand = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "stat", "goto_stat", "block_stat", "input_stat", "if_stat", 
			"bool_join", "bool_expr", "bool_operand", "cast", "assign_stat", "print_stat", 
			"expr", "operand"
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

	@Override
	public String getGrammarFileName() { return "JustBasic.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public JustBasicParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JustBasicListener ) ((JustBasicListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JustBasicListener ) ((JustBasicListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JustBasicVisitor ) return ((JustBasicVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(28);
				stat();
				}
				}
				setState(31); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__9) | (1L << LABEL) | (1L << ID))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatContext extends ParserRuleContext {
		public Print_statContext print_stat() {
			return getRuleContext(Print_statContext.class,0);
		}
		public Goto_statContext goto_stat() {
			return getRuleContext(Goto_statContext.class,0);
		}
		public Input_statContext input_stat() {
			return getRuleContext(Input_statContext.class,0);
		}
		public If_statContext if_stat() {
			return getRuleContext(If_statContext.class,0);
		}
		public Block_statContext block_stat() {
			return getRuleContext(Block_statContext.class,0);
		}
		public Assign_statContext assign_stat() {
			return getRuleContext(Assign_statContext.class,0);
		}
		public TerminalNode COLON() { return getToken(JustBasicParser.COLON, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JustBasicListener ) ((JustBasicListener)listener).enterStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JustBasicListener ) ((JustBasicListener)listener).exitStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JustBasicVisitor ) return ((JustBasicVisitor<? extends T>)visitor).visitStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				{
				setState(33);
				match(T__0);
				}
				break;
			case T__9:
				{
				setState(34);
				print_stat();
				}
				break;
			case T__1:
				{
				setState(35);
				goto_stat();
				}
				break;
			case T__2:
				{
				setState(36);
				input_stat();
				}
				break;
			case T__3:
				{
				setState(37);
				if_stat();
				}
				break;
			case LABEL:
				{
				setState(38);
				block_stat();
				}
				break;
			case ID:
				{
				setState(39);
				assign_stat();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(44);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(42);
				match(COLON);
				setState(43);
				stat();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Goto_statContext extends ParserRuleContext {
		public TerminalNode LABEL() { return getToken(JustBasicParser.LABEL, 0); }
		public Goto_statContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_goto_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JustBasicListener ) ((JustBasicListener)listener).enterGoto_stat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JustBasicListener ) ((JustBasicListener)listener).exitGoto_stat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JustBasicVisitor ) return ((JustBasicVisitor<? extends T>)visitor).visitGoto_stat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Goto_statContext goto_stat() throws RecognitionException {
		Goto_statContext _localctx = new Goto_statContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_goto_stat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(T__1);
			setState(47);
			match(LABEL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Block_statContext extends ParserRuleContext {
		public TerminalNode LABEL() { return getToken(JustBasicParser.LABEL, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public Block_statContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JustBasicListener ) ((JustBasicListener)listener).enterBlock_stat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JustBasicListener ) ((JustBasicListener)listener).exitBlock_stat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JustBasicVisitor ) return ((JustBasicVisitor<? extends T>)visitor).visitBlock_stat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Block_statContext block_stat() throws RecognitionException {
		Block_statContext _localctx = new Block_statContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_block_stat);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			match(LABEL);
			setState(51); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(50);
					stat();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(53); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Input_statContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(JustBasicParser.STRING, 0); }
		public TerminalNode SEMI() { return getToken(JustBasicParser.SEMI, 0); }
		public TerminalNode ID() { return getToken(JustBasicParser.ID, 0); }
		public Input_statContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_input_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JustBasicListener ) ((JustBasicListener)listener).enterInput_stat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JustBasicListener ) ((JustBasicListener)listener).exitInput_stat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JustBasicVisitor ) return ((JustBasicVisitor<? extends T>)visitor).visitInput_stat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Input_statContext input_stat() throws RecognitionException {
		Input_statContext _localctx = new Input_statContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_input_stat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(T__2);
			setState(56);
			match(STRING);
			setState(57);
			match(SEMI);
			setState(58);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class If_statContext extends ParserRuleContext {
		public List<Bool_exprContext> bool_expr() {
			return getRuleContexts(Bool_exprContext.class);
		}
		public Bool_exprContext bool_expr(int i) {
			return getRuleContext(Bool_exprContext.class,i);
		}
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public List<Bool_joinContext> bool_join() {
			return getRuleContexts(Bool_joinContext.class);
		}
		public Bool_joinContext bool_join(int i) {
			return getRuleContext(Bool_joinContext.class,i);
		}
		public If_statContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JustBasicListener ) ((JustBasicListener)listener).enterIf_stat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JustBasicListener ) ((JustBasicListener)listener).exitIf_stat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JustBasicVisitor ) return ((JustBasicVisitor<? extends T>)visitor).visitIf_stat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_statContext if_stat() throws RecognitionException {
		If_statContext _localctx = new If_statContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_if_stat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(T__3);
			setState(61);
			bool_expr();
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5 || _la==T__6) {
				{
				{
				setState(62);
				bool_join();
				setState(63);
				bool_expr();
				}
				}
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(70);
			match(T__4);
			setState(71);
			stat();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Bool_joinContext extends ParserRuleContext {
		public Bool_joinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool_join; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JustBasicListener ) ((JustBasicListener)listener).enterBool_join(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JustBasicListener ) ((JustBasicListener)listener).exitBool_join(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JustBasicVisitor ) return ((JustBasicVisitor<? extends T>)visitor).visitBool_join(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bool_joinContext bool_join() throws RecognitionException {
		Bool_joinContext _localctx = new Bool_joinContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_bool_join);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			_la = _input.LA(1);
			if ( !(_la==T__5 || _la==T__6) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Bool_exprContext extends ParserRuleContext {
		public List<Bool_operandContext> bool_operand() {
			return getRuleContexts(Bool_operandContext.class);
		}
		public Bool_operandContext bool_operand(int i) {
			return getRuleContext(Bool_operandContext.class,i);
		}
		public TerminalNode BOOL_OP() { return getToken(JustBasicParser.BOOL_OP, 0); }
		public Bool_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JustBasicListener ) ((JustBasicListener)listener).enterBool_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JustBasicListener ) ((JustBasicListener)listener).exitBool_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JustBasicVisitor ) return ((JustBasicVisitor<? extends T>)visitor).visitBool_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bool_exprContext bool_expr() throws RecognitionException {
		Bool_exprContext _localctx = new Bool_exprContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_bool_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			bool_operand();
			setState(76);
			match(BOOL_OP);
			setState(77);
			bool_operand();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Bool_operandContext extends ParserRuleContext {
		public OperandContext operand() {
			return getRuleContext(OperandContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Bool_operandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool_operand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JustBasicListener ) ((JustBasicListener)listener).enterBool_operand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JustBasicListener ) ((JustBasicListener)listener).exitBool_operand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JustBasicVisitor ) return ((JustBasicVisitor<? extends T>)visitor).visitBool_operand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bool_operandContext bool_operand() throws RecognitionException {
		Bool_operandContext _localctx = new Bool_operandContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_bool_operand);
		try {
			setState(81);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(79);
				operand();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(80);
				expr(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CastContext extends ParserRuleContext {
		public CastContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cast; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JustBasicListener ) ((JustBasicListener)listener).enterCast(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JustBasicListener ) ((JustBasicListener)listener).exitCast(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JustBasicVisitor ) return ((JustBasicVisitor<? extends T>)visitor).visitCast(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CastContext cast() throws RecognitionException {
		CastContext _localctx = new CastContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cast);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			_la = _input.LA(1);
			if ( !(_la==T__7 || _la==T__8) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Assign_statContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(JustBasicParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(JustBasicParser.ID, i);
		}
		public TerminalNode EQUALS() { return getToken(JustBasicParser.EQUALS, 0); }
		public OperandContext operand() {
			return getRuleContext(OperandContext.class,0);
		}
		public CastContext cast() {
			return getRuleContext(CastContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Assign_statContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JustBasicListener ) ((JustBasicListener)listener).enterAssign_stat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JustBasicListener ) ((JustBasicListener)listener).exitAssign_stat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JustBasicVisitor ) return ((JustBasicVisitor<? extends T>)visitor).visitAssign_stat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assign_statContext assign_stat() throws RecognitionException {
		Assign_statContext _localctx = new Assign_statContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_assign_stat);
		int _la;
		try {
			setState(103);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(85);
				match(ID);
				setState(86);
				match(EQUALS);
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__7 || _la==T__8) {
					{
					setState(87);
					cast();
					}
				}

				setState(90);
				operand();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(91);
				match(ID);
				setState(92);
				match(EQUALS);
				setState(94);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__7 || _la==T__8) {
					{
					setState(93);
					cast();
					}
				}

				setState(96);
				expr(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(97);
				match(ID);
				setState(98);
				match(EQUALS);
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__7 || _la==T__8) {
					{
					setState(99);
					cast();
					}
				}

				setState(102);
				match(ID);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Print_statContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(JustBasicParser.STRING, 0); }
		public TerminalNode SEMI() { return getToken(JustBasicParser.SEMI, 0); }
		public TerminalNode ID() { return getToken(JustBasicParser.ID, 0); }
		public Print_statContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JustBasicListener ) ((JustBasicListener)listener).enterPrint_stat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JustBasicListener ) ((JustBasicListener)listener).exitPrint_stat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JustBasicVisitor ) return ((JustBasicVisitor<? extends T>)visitor).visitPrint_stat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Print_statContext print_stat() throws RecognitionException {
		Print_statContext _localctx = new Print_statContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_print_stat);
		try {
			setState(112);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(105);
				match(T__9);
				setState(106);
				match(STRING);
				setState(107);
				match(SEMI);
				setState(108);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(109);
				match(T__9);
				setState(110);
				match(STRING);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(111);
				match(T__9);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public List<OperandContext> operand() {
			return getRuleContexts(OperandContext.class);
		}
		public OperandContext operand(int i) {
			return getRuleContext(OperandContext.class,i);
		}
		public TerminalNode OP() { return getToken(JustBasicParser.OP, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LPARENS() { return getToken(JustBasicParser.LPARENS, 0); }
		public TerminalNode RPARENS() { return getToken(JustBasicParser.RPARENS, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JustBasicListener ) ((JustBasicListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JustBasicListener ) ((JustBasicListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JustBasicVisitor ) return ((JustBasicVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(115);
				operand();
				setState(116);
				match(OP);
				setState(117);
				operand();
				}
				break;
			case 2:
				{
				setState(119);
				operand();
				setState(120);
				match(OP);
				setState(121);
				expr(6);
				}
				break;
			case 3:
				{
				setState(123);
				match(LPARENS);
				setState(124);
				expr(0);
				setState(125);
				match(RPARENS);
				}
				break;
			case 4:
				{
				setState(127);
				match(LPARENS);
				setState(128);
				expr(0);
				setState(129);
				match(OP);
				setState(130);
				operand();
				setState(131);
				match(RPARENS);
				}
				break;
			case 5:
				{
				setState(133);
				match(LPARENS);
				setState(134);
				operand();
				setState(135);
				match(OP);
				setState(136);
				expr(0);
				setState(137);
				match(RPARENS);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(149);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(147);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(141);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(142);
						match(OP);
						setState(143);
						expr(5);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(144);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(145);
						match(OP);
						setState(146);
						operand();
						}
						break;
					}
					} 
				}
				setState(151);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class OperandContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(JustBasicParser.ID, 0); }
		public TerminalNode NUMBER() { return getToken(JustBasicParser.NUMBER, 0); }
		public OperandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JustBasicListener ) ((JustBasicListener)listener).enterOperand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JustBasicListener ) ((JustBasicListener)listener).exitOperand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JustBasicVisitor ) return ((JustBasicVisitor<? extends T>)visitor).visitOperand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperandContext operand() throws RecognitionException {
		OperandContext _localctx = new OperandContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_operand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==NUMBER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 12:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3+\u009d\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\6\2 \n\2\r\2\16\2!\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\5\3+\n\3\3\3\3\3\5\3/\n\3\3\4\3\4\3\4\3\5\3\5\6\5"+
		"\66\n\5\r\5\16\5\67\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\7\7D\n\7\f"+
		"\7\16\7G\13\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\5\nT\n\n\3\13"+
		"\3\13\3\f\3\f\3\f\5\f[\n\f\3\f\3\f\3\f\3\f\5\fa\n\f\3\f\3\f\3\f\3\f\5"+
		"\fg\n\f\3\f\5\fj\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\rs\n\r\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u008e\n\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\7\16\u0096\n\16\f\16\16\16\u0099\13\16\3\17\3\17"+
		"\3\17\2\3\32\20\2\4\6\b\n\f\16\20\22\24\26\30\32\34\2\5\3\2\b\t\3\2\n"+
		"\13\3\2\35\36\2\u00a6\2\37\3\2\2\2\4*\3\2\2\2\6\60\3\2\2\2\b\63\3\2\2"+
		"\2\n9\3\2\2\2\f>\3\2\2\2\16K\3\2\2\2\20M\3\2\2\2\22S\3\2\2\2\24U\3\2\2"+
		"\2\26i\3\2\2\2\30r\3\2\2\2\32\u008d\3\2\2\2\34\u009a\3\2\2\2\36 \5\4\3"+
		"\2\37\36\3\2\2\2 !\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2\"\3\3\2\2\2#+\7\3\2"+
		"\2$+\5\30\r\2%+\5\6\4\2&+\5\n\6\2\'+\5\f\7\2(+\5\b\5\2)+\5\26\f\2*#\3"+
		"\2\2\2*$\3\2\2\2*%\3\2\2\2*&\3\2\2\2*\'\3\2\2\2*(\3\2\2\2*)\3\2\2\2+."+
		"\3\2\2\2,-\7\34\2\2-/\5\4\3\2.,\3\2\2\2./\3\2\2\2/\5\3\2\2\2\60\61\7\4"+
		"\2\2\61\62\7\22\2\2\62\7\3\2\2\2\63\65\7\22\2\2\64\66\5\4\3\2\65\64\3"+
		"\2\2\2\66\67\3\2\2\2\67\65\3\2\2\2\678\3\2\2\28\t\3\2\2\29:\7\5\2\2:;"+
		"\7\r\2\2;<\7\25\2\2<=\7\35\2\2=\13\3\2\2\2>?\7\6\2\2?E\5\20\t\2@A\5\16"+
		"\b\2AB\5\20\t\2BD\3\2\2\2C@\3\2\2\2DG\3\2\2\2EC\3\2\2\2EF\3\2\2\2FH\3"+
		"\2\2\2GE\3\2\2\2HI\7\7\2\2IJ\5\4\3\2J\r\3\2\2\2KL\t\2\2\2L\17\3\2\2\2"+
		"MN\5\22\n\2NO\7\21\2\2OP\5\22\n\2P\21\3\2\2\2QT\5\34\17\2RT\5\32\16\2"+
		"SQ\3\2\2\2SR\3\2\2\2T\23\3\2\2\2UV\t\3\2\2V\25\3\2\2\2WX\7\35\2\2XZ\7"+
		"\26\2\2Y[\5\24\13\2ZY\3\2\2\2Z[\3\2\2\2[\\\3\2\2\2\\j\5\34\17\2]^\7\35"+
		"\2\2^`\7\26\2\2_a\5\24\13\2`_\3\2\2\2`a\3\2\2\2ab\3\2\2\2bj\5\32\16\2"+
		"cd\7\35\2\2df\7\26\2\2eg\5\24\13\2fe\3\2\2\2fg\3\2\2\2gh\3\2\2\2hj\7\35"+
		"\2\2iW\3\2\2\2i]\3\2\2\2ic\3\2\2\2j\27\3\2\2\2kl\7\f\2\2lm\7\r\2\2mn\7"+
		"\25\2\2ns\7\35\2\2op\7\f\2\2ps\7\r\2\2qs\7\f\2\2rk\3\2\2\2ro\3\2\2\2r"+
		"q\3\2\2\2s\31\3\2\2\2tu\b\16\1\2uv\5\34\17\2vw\7\16\2\2wx\5\34\17\2x\u008e"+
		"\3\2\2\2yz\5\34\17\2z{\7\16\2\2{|\5\32\16\b|\u008e\3\2\2\2}~\7\17\2\2"+
		"~\177\5\32\16\2\177\u0080\7\20\2\2\u0080\u008e\3\2\2\2\u0081\u0082\7\17"+
		"\2\2\u0082\u0083\5\32\16\2\u0083\u0084\7\16\2\2\u0084\u0085\5\34\17\2"+
		"\u0085\u0086\7\20\2\2\u0086\u008e\3\2\2\2\u0087\u0088\7\17\2\2\u0088\u0089"+
		"\5\34\17\2\u0089\u008a\7\16\2\2\u008a\u008b\5\32\16\2\u008b\u008c\7\20"+
		"\2\2\u008c\u008e\3\2\2\2\u008dt\3\2\2\2\u008dy\3\2\2\2\u008d}\3\2\2\2"+
		"\u008d\u0081\3\2\2\2\u008d\u0087\3\2\2\2\u008e\u0097\3\2\2\2\u008f\u0090"+
		"\f\6\2\2\u0090\u0091\7\16\2\2\u0091\u0096\5\32\16\7\u0092\u0093\f\7\2"+
		"\2\u0093\u0094\7\16\2\2\u0094\u0096\5\34\17\2\u0095\u008f\3\2\2\2\u0095"+
		"\u0092\3\2\2\2\u0096\u0099\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2"+
		"\2\2\u0098\33\3\2\2\2\u0099\u0097\3\2\2\2\u009a\u009b\t\4\2\2\u009b\35"+
		"\3\2\2\2\20!*.\67ESZ`fir\u008d\u0095\u0097";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}