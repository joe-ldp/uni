// Generated from C:/Users/joeki/OneDrive - Sheffield Hallam University/_Fundamentals of Programming Languages/Assignment 1 Grammar\assignment.g4 by ANTLR 4.9

    package assignment;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class testParser extends Parser {
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
	public static final int
		RULE_program = 0, RULE_block = 1, RULE_statement = 2, RULE_stat_assignment = 3, 
		RULE_stat_input = 4, RULE_stat_output = 5, RULE_stat_if = 6, RULE_expression = 7, 
		RULE_bool_join = 8, RULE_expr_boolean = 9, RULE_bool_operand = 10, RULE_operand = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "block", "statement", "stat_assignment", "stat_input", "stat_output", 
			"stat_if", "expression", "bool_join", "expr_boolean", "bool_operand", 
			"operand"
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

	@Override
	public String getGrammarFileName() { return "assignment.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public testParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof testVisitor ) return ((testVisitor<? extends T>)visitor).visitProgram(this);
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
			setState(27);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LCURLY) {
				{
				{
				setState(24);
				block();
				}
				}
				setState(29);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LCURLY() { return getToken(testParser.LCURLY, 0); }
		public TerminalNode RCURLY() { return getToken(testParser.RCURLY, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof testVisitor ) return ((testVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			match(LCURLY);
			setState(32); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(31);
				statement();
				}
				}
				setState(34); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << IDENTIFIER))) != 0) );
			setState(36);
			match(RCURLY);
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

	public static class StatementContext extends ParserRuleContext {
		public TerminalNode SCOLON() { return getToken(testParser.SCOLON, 0); }
		public Stat_assignmentContext stat_assignment() {
			return getRuleContext(Stat_assignmentContext.class,0);
		}
		public Stat_inputContext stat_input() {
			return getRuleContext(Stat_inputContext.class,0);
		}
		public Stat_outputContext stat_output() {
			return getRuleContext(Stat_outputContext.class,0);
		}
		public Stat_ifContext stat_if() {
			return getRuleContext(Stat_ifContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof testVisitor ) return ((testVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(38);
				stat_assignment();
				}
				break;
			case T__0:
				{
				setState(39);
				stat_input();
				}
				break;
			case T__1:
				{
				setState(40);
				stat_output();
				}
				break;
			case T__2:
				{
				setState(41);
				stat_if();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(44);
			match(SCOLON);
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

	public static class Stat_assignmentContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(testParser.IDENTIFIER, 0); }
		public TerminalNode EQUALS() { return getToken(testParser.EQUALS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Stat_assignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).enterStat_assignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).exitStat_assignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof testVisitor ) return ((testVisitor<? extends T>)visitor).visitStat_assignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Stat_assignmentContext stat_assignment() throws RecognitionException {
		Stat_assignmentContext _localctx = new Stat_assignmentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_stat_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(IDENTIFIER);
			setState(47);
			match(EQUALS);
			setState(48);
			expression(0);
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

	public static class Stat_inputContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Stat_inputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat_input; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).enterStat_input(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).exitStat_input(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof testVisitor ) return ((testVisitor<? extends T>)visitor).visitStat_input(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Stat_inputContext stat_input() throws RecognitionException {
		Stat_inputContext _localctx = new Stat_inputContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_stat_input);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(T__0);
			setState(51);
			expression(0);
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

	public static class Stat_outputContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Stat_outputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat_output; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).enterStat_output(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).exitStat_output(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof testVisitor ) return ((testVisitor<? extends T>)visitor).visitStat_output(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Stat_outputContext stat_output() throws RecognitionException {
		Stat_outputContext _localctx = new Stat_outputContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_stat_output);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(T__1);
			setState(54);
			expression(0);
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

	public static class Stat_ifContext extends ParserRuleContext {
		public Expr_booleanContext expr_boolean() {
			return getRuleContext(Expr_booleanContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public Stat_ifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat_if; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).enterStat_if(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).exitStat_if(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof testVisitor ) return ((testVisitor<? extends T>)visitor).visitStat_if(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Stat_ifContext stat_if() throws RecognitionException {
		Stat_ifContext _localctx = new Stat_ifContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_stat_if);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(T__2);
			setState(57);
			expr_boolean();
			setState(58);
			match(T__3);
			setState(59);
			block();
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4 || _la==T__5) {
				{
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(60);
					match(T__4);
					setState(61);
					block();
					}
					}
					setState(66);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(67);
				match(T__5);
				setState(68);
				block();
				}
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

	public static class ExpressionContext extends ParserRuleContext {
		public List<OperandContext> operand() {
			return getRuleContexts(OperandContext.class);
		}
		public OperandContext operand(int i) {
			return getRuleContext(OperandContext.class,i);
		}
		public TerminalNode OP() { return getToken(testParser.OP, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LPARENS() { return getToken(testParser.LPARENS, 0); }
		public TerminalNode RPARENS() { return getToken(testParser.RPARENS, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof testVisitor ) return ((testVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(72);
				operand();
				setState(73);
				match(OP);
				setState(74);
				operand();
				}
				break;
			case 2:
				{
				setState(76);
				operand();
				setState(77);
				match(OP);
				setState(78);
				expression(6);
				}
				break;
			case 3:
				{
				setState(80);
				match(LPARENS);
				setState(81);
				expression(0);
				setState(82);
				match(RPARENS);
				}
				break;
			case 4:
				{
				setState(84);
				match(LPARENS);
				setState(85);
				operand();
				setState(86);
				match(OP);
				setState(87);
				expression(0);
				setState(88);
				match(RPARENS);
				}
				break;
			case 5:
				{
				setState(90);
				match(LPARENS);
				setState(91);
				expression(0);
				setState(92);
				match(OP);
				setState(93);
				operand();
				setState(94);
				match(RPARENS);
				}
				break;
			case 6:
				{
				setState(96);
				operand();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(104);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expression);
					setState(99);
					if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
					setState(100);
					match(OP);
					setState(101);
					operand();
					}
					} 
				}
				setState(106);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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

	public static class Bool_joinContext extends ParserRuleContext {
		public TerminalNode OR() { return getToken(testParser.OR, 0); }
		public TerminalNode AND() { return getToken(testParser.AND, 0); }
		public Bool_joinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool_join; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).enterBool_join(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).exitBool_join(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof testVisitor ) return ((testVisitor<? extends T>)visitor).visitBool_join(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bool_joinContext bool_join() throws RecognitionException {
		Bool_joinContext _localctx = new Bool_joinContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_bool_join);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			_la = _input.LA(1);
			if ( !(_la==OR || _la==AND) ) {
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

	public static class Expr_booleanContext extends ParserRuleContext {
		public List<Bool_operandContext> bool_operand() {
			return getRuleContexts(Bool_operandContext.class);
		}
		public Bool_operandContext bool_operand(int i) {
			return getRuleContext(Bool_operandContext.class,i);
		}
		public List<Bool_joinContext> bool_join() {
			return getRuleContexts(Bool_joinContext.class);
		}
		public Bool_joinContext bool_join(int i) {
			return getRuleContext(Bool_joinContext.class,i);
		}
		public Expr_booleanContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_boolean; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).enterExpr_boolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).exitExpr_boolean(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof testVisitor ) return ((testVisitor<? extends T>)visitor).visitExpr_boolean(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_booleanContext expr_boolean() throws RecognitionException {
		Expr_booleanContext _localctx = new Expr_booleanContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_expr_boolean);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			bool_operand();
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR || _la==AND) {
				{
				{
				setState(110);
				bool_join();
				setState(111);
				bool_operand();
				}
				}
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class Bool_operandContext extends ParserRuleContext {
		public OperandContext operand() {
			return getRuleContext(OperandContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Bool_operandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool_operand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).enterBool_operand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).exitBool_operand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof testVisitor ) return ((testVisitor<? extends T>)visitor).visitBool_operand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bool_operandContext bool_operand() throws RecognitionException {
		Bool_operandContext _localctx = new Bool_operandContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_bool_operand);
		try {
			setState(120);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(118);
				operand();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(119);
				expression(0);
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

	public static class OperandContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(testParser.IDENTIFIER, 0); }
		public TerminalNode FLOAT() { return getToken(testParser.FLOAT, 0); }
		public TerminalNode STRING() { return getToken(testParser.STRING, 0); }
		public OperandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).enterOperand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).exitOperand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof testVisitor ) return ((testVisitor<? extends T>)visitor).visitOperand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperandContext operand() throws RecognitionException {
		OperandContext _localctx = new OperandContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_operand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IDENTIFIER) | (1L << FLOAT) | (1L << STRING))) != 0)) ) {
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
		case 7:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\"\177\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13"+
		"\4\f\t\f\4\r\t\r\3\2\7\2\34\n\2\f\2\16\2\37\13\2\3\3\3\3\6\3#\n\3\r\3"+
		"\16\3$\3\3\3\3\3\4\3\4\3\4\3\4\5\4-\n\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3"+
		"\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\7\bA\n\b\f\b\16\bD\13\b\3\b"+
		"\3\b\5\bH\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\td\n\t\3\t\3\t\3\t"+
		"\7\ti\n\t\f\t\16\tl\13\t\3\n\3\n\3\13\3\13\3\13\3\13\7\13t\n\13\f\13\16"+
		"\13w\13\13\3\f\3\f\5\f{\n\f\3\r\3\r\3\r\2\3\20\16\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\2\4\3\2\23\24\5\2\13\13\33\33\35\35\2\u0081\2\35\3\2\2\2\4 "+
		"\3\2\2\2\6,\3\2\2\2\b\60\3\2\2\2\n\64\3\2\2\2\f\67\3\2\2\2\16:\3\2\2\2"+
		"\20c\3\2\2\2\22m\3\2\2\2\24o\3\2\2\2\26z\3\2\2\2\30|\3\2\2\2\32\34\5\4"+
		"\3\2\33\32\3\2\2\2\34\37\3\2\2\2\35\33\3\2\2\2\35\36\3\2\2\2\36\3\3\2"+
		"\2\2\37\35\3\2\2\2 \"\7\16\2\2!#\5\6\4\2\"!\3\2\2\2#$\3\2\2\2$\"\3\2\2"+
		"\2$%\3\2\2\2%&\3\2\2\2&\'\7\17\2\2\'\5\3\2\2\2(-\5\b\5\2)-\5\n\6\2*-\5"+
		"\f\7\2+-\5\16\b\2,(\3\2\2\2,)\3\2\2\2,*\3\2\2\2,+\3\2\2\2-.\3\2\2\2./"+
		"\7\20\2\2/\7\3\2\2\2\60\61\7\13\2\2\61\62\7\32\2\2\62\63\5\20\t\2\63\t"+
		"\3\2\2\2\64\65\7\3\2\2\65\66\5\20\t\2\66\13\3\2\2\2\678\7\4\2\289\5\20"+
		"\t\29\r\3\2\2\2:;\7\5\2\2;<\5\24\13\2<=\7\6\2\2=G\5\4\3\2>?\7\7\2\2?A"+
		"\5\4\3\2@>\3\2\2\2AD\3\2\2\2B@\3\2\2\2BC\3\2\2\2CE\3\2\2\2DB\3\2\2\2E"+
		"F\7\b\2\2FH\5\4\3\2GB\3\2\2\2GH\3\2\2\2H\17\3\2\2\2IJ\b\t\1\2JK\5\30\r"+
		"\2KL\7\25\2\2LM\5\30\r\2Md\3\2\2\2NO\5\30\r\2OP\7\25\2\2PQ\5\20\t\bQd"+
		"\3\2\2\2RS\7\f\2\2ST\5\20\t\2TU\7\r\2\2Ud\3\2\2\2VW\7\f\2\2WX\5\30\r\2"+
		"XY\7\25\2\2YZ\5\20\t\2Z[\7\r\2\2[d\3\2\2\2\\]\7\f\2\2]^\5\20\t\2^_\7\25"+
		"\2\2_`\5\30\r\2`a\7\r\2\2ad\3\2\2\2bd\5\30\r\2cI\3\2\2\2cN\3\2\2\2cR\3"+
		"\2\2\2cV\3\2\2\2c\\\3\2\2\2cb\3\2\2\2dj\3\2\2\2ef\f\7\2\2fg\7\25\2\2g"+
		"i\5\30\r\2he\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2k\21\3\2\2\2lj\3\2\2"+
		"\2mn\t\2\2\2n\23\3\2\2\2ou\5\26\f\2pq\5\22\n\2qr\5\26\f\2rt\3\2\2\2sp"+
		"\3\2\2\2tw\3\2\2\2us\3\2\2\2uv\3\2\2\2v\25\3\2\2\2wu\3\2\2\2x{\5\30\r"+
		"\2y{\5\20\t\2zx\3\2\2\2zy\3\2\2\2{\27\3\2\2\2|}\t\3\2\2}\31\3\2\2\2\13"+
		"\35$,BGcjuz";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}