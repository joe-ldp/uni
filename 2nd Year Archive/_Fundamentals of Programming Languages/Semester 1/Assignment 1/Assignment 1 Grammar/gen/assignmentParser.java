// Generated from C:/Users/joeki/OneDrive - Sheffield Hallam University/_Fundamentals of Programming Languages/Assignment 1/Assignment 1 Grammar\assignment.g4 by ANTLR 4.9

    package com.assignment;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class assignmentParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

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
	public static final int
		RULE_program = 0, RULE_block = 1, RULE_statement = 2, RULE_stat_assignment = 3, 
		RULE_stat_assign_array = 4, RULE_stat_input = 5, RULE_stat_output = 6, 
		RULE_stat_if = 7, RULE_stat_for = 8, RULE_stat_while = 9, RULE_value = 10, 
		RULE_expression = 11, RULE_operand = 12, RULE_array = 13, RULE_expr_boolean = 14, 
		RULE_bool_operand = 15, RULE_function_definition = 16, RULE_function_signature = 17, 
		RULE_funcblock = 18, RULE_function_call = 19, RULE_args = 20, RULE_return = 21;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "block", "statement", "stat_assignment", "stat_assign_array", 
			"stat_input", "stat_output", "stat_if", "stat_for", "stat_while", "value", 
			"expression", "operand", "array", "expr_boolean", "bool_operand", "function_definition", 
			"function_signature", "funcblock", "function_call", "args", "return"
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

	@Override
	public String getGrammarFileName() { return "assignment.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public assignmentParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode PROGBEGIN() { return getToken(assignmentParser.PROGBEGIN, 0); }
		public TerminalNode PROGEND() { return getToken(assignmentParser.PROGEND, 0); }
		public List<Stat_assignmentContext> stat_assignment() {
			return getRuleContexts(Stat_assignmentContext.class);
		}
		public Stat_assignmentContext stat_assignment(int i) {
			return getRuleContext(Stat_assignmentContext.class,i);
		}
		public List<Stat_assign_arrayContext> stat_assign_array() {
			return getRuleContexts(Stat_assign_arrayContext.class);
		}
		public Stat_assign_arrayContext stat_assign_array(int i) {
			return getRuleContext(Stat_assign_arrayContext.class,i);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public List<Function_definitionContext> function_definition() {
			return getRuleContexts(Function_definitionContext.class);
		}
		public Function_definitionContext function_definition(int i) {
			return getRuleContext(Function_definitionContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof assignmentListener ) ((assignmentListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof assignmentListener ) ((assignmentListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof assignmentVisitor ) return ((assignmentVisitor<? extends T>)visitor).visitProgram(this);
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
			setState(44);
			match(PROGBEGIN);
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0 || _la==IDENTIFIER) {
				{
				setState(47);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(45);
					stat_assignment();
					}
					break;
				case 2:
					{
					setState(46);
					stat_assign_array();
					}
					break;
				}
				}
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__13 || _la==LCURLY) {
				{
				setState(54);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LCURLY:
					{
					setState(52);
					block();
					}
					break;
				case T__13:
					{
					setState(53);
					function_definition();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(59);
			match(PROGEND);
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
		public TerminalNode LCURLY() { return getToken(assignmentParser.LCURLY, 0); }
		public TerminalNode RCURLY() { return getToken(assignmentParser.RCURLY, 0); }
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
			if ( listener instanceof assignmentListener ) ((assignmentListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof assignmentListener ) ((assignmentListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof assignmentVisitor ) return ((assignmentVisitor<? extends T>)visitor).visitBlock(this);
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
			setState(61);
			match(LCURLY);
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__8) | (1L << T__11) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(62);
				statement();
				}
				}
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(68);
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
		public Stat_assignmentContext stat_assignment() {
			return getRuleContext(Stat_assignmentContext.class,0);
		}
		public Stat_assign_arrayContext stat_assign_array() {
			return getRuleContext(Stat_assign_arrayContext.class,0);
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
		public Stat_forContext stat_for() {
			return getRuleContext(Stat_forContext.class,0);
		}
		public Stat_whileContext stat_while() {
			return getRuleContext(Stat_whileContext.class,0);
		}
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public TerminalNode SCOLON() { return getToken(assignmentParser.SCOLON, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof assignmentListener ) ((assignmentListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof assignmentListener ) ((assignmentListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof assignmentVisitor ) return ((assignmentVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(70);
				stat_assignment();
				}
				break;
			case 2:
				{
				setState(71);
				stat_assign_array();
				}
				break;
			case 3:
				{
				setState(72);
				stat_input();
				}
				break;
			case 4:
				{
				setState(73);
				stat_output();
				}
				break;
			case 5:
				{
				setState(74);
				stat_if();
				}
				break;
			case 6:
				{
				setState(75);
				stat_for();
				}
				break;
			case 7:
				{
				setState(76);
				stat_while();
				}
				break;
			case 8:
				{
				setState(77);
				function_call();
				setState(78);
				match(SCOLON);
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

	public static class Stat_assignmentContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(assignmentParser.IDENTIFIER, 0); }
		public TerminalNode EQUALS() { return getToken(assignmentParser.EQUALS, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode SCOLON() { return getToken(assignmentParser.SCOLON, 0); }
		public Stat_assignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof assignmentListener ) ((assignmentListener)listener).enterStat_assignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof assignmentListener ) ((assignmentListener)listener).exitStat_assignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof assignmentVisitor ) return ((assignmentVisitor<? extends T>)visitor).visitStat_assignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Stat_assignmentContext stat_assignment() throws RecognitionException {
		Stat_assignmentContext _localctx = new Stat_assignmentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_stat_assignment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(82);
				match(T__0);
				}
			}

			setState(85);
			match(IDENTIFIER);
			setState(86);
			match(EQUALS);
			setState(87);
			value();
			setState(88);
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

	public static class Stat_assign_arrayContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(assignmentParser.IDENTIFIER, 0); }
		public TerminalNode EQUALS() { return getToken(assignmentParser.EQUALS, 0); }
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public TerminalNode SCOLON() { return getToken(assignmentParser.SCOLON, 0); }
		public Stat_assign_arrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat_assign_array; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof assignmentListener ) ((assignmentListener)listener).enterStat_assign_array(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof assignmentListener ) ((assignmentListener)listener).exitStat_assign_array(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof assignmentVisitor ) return ((assignmentVisitor<? extends T>)visitor).visitStat_assign_array(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Stat_assign_arrayContext stat_assign_array() throws RecognitionException {
		Stat_assign_arrayContext _localctx = new Stat_assign_arrayContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_stat_assign_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(90);
				match(T__0);
				}
			}

			setState(93);
			match(IDENTIFIER);
			setState(94);
			match(EQUALS);
			setState(95);
			array();
			setState(96);
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

	public static class Stat_inputContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode SCOLON() { return getToken(assignmentParser.SCOLON, 0); }
		public Stat_inputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat_input; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof assignmentListener ) ((assignmentListener)listener).enterStat_input(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof assignmentListener ) ((assignmentListener)listener).exitStat_input(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof assignmentVisitor ) return ((assignmentVisitor<? extends T>)visitor).visitStat_input(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Stat_inputContext stat_input() throws RecognitionException {
		Stat_inputContext _localctx = new Stat_inputContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_stat_input);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(T__1);
			setState(99);
			value();
			setState(100);
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

	public static class Stat_outputContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode SCOLON() { return getToken(assignmentParser.SCOLON, 0); }
		public Stat_outputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat_output; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof assignmentListener ) ((assignmentListener)listener).enterStat_output(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof assignmentListener ) ((assignmentListener)listener).exitStat_output(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof assignmentVisitor ) return ((assignmentVisitor<? extends T>)visitor).visitStat_output(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Stat_outputContext stat_output() throws RecognitionException {
		Stat_outputContext _localctx = new Stat_outputContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_stat_output);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(T__2);
			setState(103);
			value();
			setState(104);
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

	public static class Stat_ifContext extends ParserRuleContext {
		public List<Expr_booleanContext> expr_boolean() {
			return getRuleContexts(Expr_booleanContext.class);
		}
		public Expr_booleanContext expr_boolean(int i) {
			return getRuleContext(Expr_booleanContext.class,i);
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
			if ( listener instanceof assignmentListener ) ((assignmentListener)listener).enterStat_if(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof assignmentListener ) ((assignmentListener)listener).exitStat_if(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof assignmentVisitor ) return ((assignmentVisitor<? extends T>)visitor).visitStat_if(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Stat_ifContext stat_if() throws RecognitionException {
		Stat_ifContext _localctx = new Stat_ifContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_stat_if);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(T__3);
			setState(107);
			expr_boolean();
			setState(108);
			match(T__4);
			setState(109);
			block();
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5 || _la==T__6) {
				{
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
					{
					setState(110);
					match(T__5);
					setState(111);
					expr_boolean();
					setState(112);
					match(T__4);
					setState(113);
					block();
					}
					}
					setState(119);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(120);
				match(T__6);
				setState(121);
				block();
				}
			}

			setState(124);
			match(T__7);
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

	public static class Stat_forContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(assignmentParser.IDENTIFIER, 0); }
		public List<TerminalNode> NUMBER() { return getTokens(assignmentParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(assignmentParser.NUMBER, i);
		}
		public TerminalNode COMMA() { return getToken(assignmentParser.COMMA, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Stat_forContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat_for; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof assignmentListener ) ((assignmentListener)listener).enterStat_for(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof assignmentListener ) ((assignmentListener)listener).exitStat_for(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof assignmentVisitor ) return ((assignmentVisitor<? extends T>)visitor).visitStat_for(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Stat_forContext stat_for() throws RecognitionException {
		Stat_forContext _localctx = new Stat_forContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_stat_for);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(T__8);
			setState(127);
			match(IDENTIFIER);
			setState(128);
			match(T__9);
			setState(129);
			match(NUMBER);
			setState(130);
			match(COMMA);
			setState(131);
			match(NUMBER);
			setState(132);
			block();
			setState(133);
			match(T__10);
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

	public static class Stat_whileContext extends ParserRuleContext {
		public Expr_booleanContext expr_boolean() {
			return getRuleContext(Expr_booleanContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Stat_whileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat_while; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof assignmentListener ) ((assignmentListener)listener).enterStat_while(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof assignmentListener ) ((assignmentListener)listener).exitStat_while(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof assignmentVisitor ) return ((assignmentVisitor<? extends T>)visitor).visitStat_while(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Stat_whileContext stat_while() throws RecognitionException {
		Stat_whileContext _localctx = new Stat_whileContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_stat_while);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(T__11);
			setState(136);
			expr_boolean();
			setState(137);
			block();
			setState(138);
			match(T__12);
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

	public static class ValueContext extends ParserRuleContext {
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
	 
		public ValueContext() { }
		public void copyFrom(ValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VARVALContext extends ValueContext {
		public TerminalNode IDENTIFIER() { return getToken(assignmentParser.IDENTIFIER, 0); }
		public VARVALContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof assignmentListener ) ((assignmentListener)listener).enterVARVAL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof assignmentListener ) ((assignmentListener)listener).exitVARVAL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof assignmentVisitor ) return ((assignmentVisitor<? extends T>)visitor).visitVARVAL(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ARRAYContext extends ValueContext {
		public TerminalNode IDENTIFIER() { return getToken(assignmentParser.IDENTIFIER, 0); }
		public TerminalNode LSQUARE() { return getToken(assignmentParser.LSQUARE, 0); }
		public TerminalNode RSQUARE() { return getToken(assignmentParser.RSQUARE, 0); }
		public List<TerminalNode> NUMBER() { return getTokens(assignmentParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(assignmentParser.NUMBER, i);
		}
		public ARRAYContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof assignmentListener ) ((assignmentListener)listener).enterARRAY(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof assignmentListener ) ((assignmentListener)listener).exitARRAY(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof assignmentVisitor ) return ((assignmentVisitor<? extends T>)visitor).visitARRAY(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FUNCRETURNContext extends ValueContext {
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public FUNCRETURNContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof assignmentListener ) ((assignmentListener)listener).enterFUNCRETURN(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof assignmentListener ) ((assignmentListener)listener).exitFUNCRETURN(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof assignmentVisitor ) return ((assignmentVisitor<? extends T>)visitor).visitFUNCRETURN(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OPVALUEContext extends ValueContext {
		public OperandContext operand() {
			return getRuleContext(OperandContext.class,0);
		}
		public OPVALUEContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof assignmentListener ) ((assignmentListener)listener).enterOPVALUE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof assignmentListener ) ((assignmentListener)listener).exitOPVALUE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof assignmentVisitor ) return ((assignmentVisitor<? extends T>)visitor).visitOPVALUE(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EXPRESSIONContext extends ValueContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public EXPRESSIONContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof assignmentListener ) ((assignmentListener)listener).enterEXPRESSION(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof assignmentListener ) ((assignmentListener)listener).exitEXPRESSION(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof assignmentVisitor ) return ((assignmentVisitor<? extends T>)visitor).visitEXPRESSION(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_value);
		int _la;
		try {
			setState(152);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new OPVALUEContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(140);
				operand();
				}
				break;
			case 2:
				_localctx = new EXPRESSIONContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(141);
				expression(0);
				}
				break;
			case 3:
				_localctx = new VARVALContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(142);
				match(IDENTIFIER);
				}
				break;
			case 4:
				_localctx = new ARRAYContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(143);
				match(IDENTIFIER);
				setState(144);
				match(LSQUARE);
				setState(146); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(145);
					match(NUMBER);
					}
					}
					setState(148); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NUMBER );
				setState(150);
				match(RSQUARE);
				}
				break;
			case 5:
				_localctx = new FUNCRETURNContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(151);
				function_call();
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

	public static class ExpressionContext extends ParserRuleContext {
		public List<OperandContext> operand() {
			return getRuleContexts(OperandContext.class);
		}
		public OperandContext operand(int i) {
			return getRuleContext(OperandContext.class,i);
		}
		public TerminalNode OP() { return getToken(assignmentParser.OP, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LPARENS() { return getToken(assignmentParser.LPARENS, 0); }
		public TerminalNode RPARENS() { return getToken(assignmentParser.RPARENS, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof assignmentListener ) ((assignmentListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof assignmentListener ) ((assignmentListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof assignmentVisitor ) return ((assignmentVisitor<? extends T>)visitor).visitExpression(this);
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
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(155);
				operand();
				setState(156);
				match(OP);
				setState(157);
				operand();
				}
				break;
			case 2:
				{
				setState(159);
				operand();
				setState(160);
				match(OP);
				setState(161);
				expression(5);
				}
				break;
			case 3:
				{
				setState(163);
				match(LPARENS);
				setState(164);
				expression(0);
				setState(165);
				match(RPARENS);
				}
				break;
			case 4:
				{
				setState(167);
				match(LPARENS);
				setState(168);
				operand();
				setState(169);
				match(OP);
				setState(170);
				expression(0);
				setState(171);
				match(RPARENS);
				}
				break;
			case 5:
				{
				setState(173);
				match(LPARENS);
				setState(174);
				expression(0);
				setState(175);
				match(OP);
				setState(176);
				operand();
				setState(177);
				match(RPARENS);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(186);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expression);
					setState(181);
					if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
					setState(182);
					match(OP);
					setState(183);
					operand();
					}
					} 
				}
				setState(188);
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
		public OperandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operand; }
	 
		public OperandContext() { }
		public void copyFrom(OperandContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VALContext extends OperandContext {
		public TerminalNode VALUE() { return getToken(assignmentParser.VALUE, 0); }
		public VALContext(OperandContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof assignmentListener ) ((assignmentListener)listener).enterVAL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof assignmentListener ) ((assignmentListener)listener).exitVAL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof assignmentVisitor ) return ((assignmentVisitor<? extends T>)visitor).visitVAL(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VARNAMEContext extends OperandContext {
		public TerminalNode IDENTIFIER() { return getToken(assignmentParser.IDENTIFIER, 0); }
		public VARNAMEContext(OperandContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof assignmentListener ) ((assignmentListener)listener).enterVARNAME(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof assignmentListener ) ((assignmentListener)listener).exitVARNAME(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof assignmentVisitor ) return ((assignmentVisitor<? extends T>)visitor).visitVARNAME(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperandContext operand() throws RecognitionException {
		OperandContext _localctx = new OperandContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_operand);
		try {
			setState(191);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VALUE:
				_localctx = new VALContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(189);
				match(VALUE);
				}
				break;
			case IDENTIFIER:
				_localctx = new VARNAMEContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(190);
				match(IDENTIFIER);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ArrayContext extends ParserRuleContext {
		public TerminalNode LSQUARE() { return getToken(assignmentParser.LSQUARE, 0); }
		public List<TerminalNode> VALUE() { return getTokens(assignmentParser.VALUE); }
		public TerminalNode VALUE(int i) {
			return getToken(assignmentParser.VALUE, i);
		}
		public TerminalNode RSQUARE() { return getToken(assignmentParser.RSQUARE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(assignmentParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(assignmentParser.COMMA, i);
		}
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof assignmentListener ) ((assignmentListener)listener).enterArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof assignmentListener ) ((assignmentListener)listener).exitArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof assignmentVisitor ) return ((assignmentVisitor<? extends T>)visitor).visitArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			match(LSQUARE);
			setState(194);
			match(VALUE);
			setState(199);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(195);
				match(COMMA);
				setState(196);
				match(VALUE);
				}
				}
				setState(201);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(202);
			match(RSQUARE);
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
		public List<TerminalNode> BOOL_OP() { return getTokens(assignmentParser.BOOL_OP); }
		public TerminalNode BOOL_OP(int i) {
			return getToken(assignmentParser.BOOL_OP, i);
		}
		public Expr_booleanContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_boolean; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof assignmentListener ) ((assignmentListener)listener).enterExpr_boolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof assignmentListener ) ((assignmentListener)listener).exitExpr_boolean(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof assignmentVisitor ) return ((assignmentVisitor<? extends T>)visitor).visitExpr_boolean(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_booleanContext expr_boolean() throws RecognitionException {
		Expr_booleanContext _localctx = new Expr_booleanContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_expr_boolean);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			bool_operand();
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BOOL_OP) {
				{
				{
				setState(205);
				match(BOOL_OP);
				setState(206);
				bool_operand();
				}
				}
				setState(211);
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
		public TerminalNode TRUE() { return getToken(assignmentParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(assignmentParser.FALSE, 0); }
		public Bool_operandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool_operand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof assignmentListener ) ((assignmentListener)listener).enterBool_operand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof assignmentListener ) ((assignmentListener)listener).exitBool_operand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof assignmentVisitor ) return ((assignmentVisitor<? extends T>)visitor).visitBool_operand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bool_operandContext bool_operand() throws RecognitionException {
		Bool_operandContext _localctx = new Bool_operandContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_bool_operand);
		try {
			setState(216);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(212);
				operand();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(213);
				expression(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(214);
				match(TRUE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(215);
				match(FALSE);
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

	public static class Function_definitionContext extends ParserRuleContext {
		public Function_signatureContext function_signature() {
			return getRuleContext(Function_signatureContext.class,0);
		}
		public FuncblockContext funcblock() {
			return getRuleContext(FuncblockContext.class,0);
		}
		public Function_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof assignmentListener ) ((assignmentListener)listener).enterFunction_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof assignmentListener ) ((assignmentListener)listener).exitFunction_definition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof assignmentVisitor ) return ((assignmentVisitor<? extends T>)visitor).visitFunction_definition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_definitionContext function_definition() throws RecognitionException {
		Function_definitionContext _localctx = new Function_definitionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_function_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			function_signature();
			setState(219);
			funcblock();
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

	public static class Function_signatureContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(assignmentParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(assignmentParser.IDENTIFIER, i);
		}
		public TerminalNode LPARENS() { return getToken(assignmentParser.LPARENS, 0); }
		public TerminalNode RPARENS() { return getToken(assignmentParser.RPARENS, 0); }
		public List<TerminalNode> COMMA() { return getTokens(assignmentParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(assignmentParser.COMMA, i);
		}
		public Function_signatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_signature; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof assignmentListener ) ((assignmentListener)listener).enterFunction_signature(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof assignmentListener ) ((assignmentListener)listener).exitFunction_signature(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof assignmentVisitor ) return ((assignmentVisitor<? extends T>)visitor).visitFunction_signature(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_signatureContext function_signature() throws RecognitionException {
		Function_signatureContext _localctx = new Function_signatureContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_function_signature);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			match(T__13);
			setState(222);
			match(IDENTIFIER);
			setState(223);
			match(LPARENS);
			{
			setState(225);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(224);
				match(IDENTIFIER);
				}
			}

			setState(231);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(227);
				match(COMMA);
				setState(228);
				match(IDENTIFIER);
				}
				}
				setState(233);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(234);
			match(RPARENS);
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

	public static class FuncblockContext extends ParserRuleContext {
		public TerminalNode LCURLY() { return getToken(assignmentParser.LCURLY, 0); }
		public TerminalNode RCURLY() { return getToken(assignmentParser.RCURLY, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ReturnContext return() {
			return getRuleContext(ReturnContext.class,0);
		}
		public FuncblockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcblock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof assignmentListener ) ((assignmentListener)listener).enterFuncblock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof assignmentListener ) ((assignmentListener)listener).exitFuncblock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof assignmentVisitor ) return ((assignmentVisitor<? extends T>)visitor).visitFuncblock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncblockContext funcblock() throws RecognitionException {
		FuncblockContext _localctx = new FuncblockContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_funcblock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			match(LCURLY);
			setState(238); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(237);
				statement();
				}
				}
				setState(240); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__8) | (1L << T__11) | (1L << IDENTIFIER))) != 0) );
			setState(243);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(242);
				return();
				}
			}

			setState(245);
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

	public static class Function_callContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(assignmentParser.IDENTIFIER, 0); }
		public TerminalNode LPARENS() { return getToken(assignmentParser.LPARENS, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public TerminalNode RPARENS() { return getToken(assignmentParser.RPARENS, 0); }
		public Function_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof assignmentListener ) ((assignmentListener)listener).enterFunction_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof assignmentListener ) ((assignmentListener)listener).exitFunction_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof assignmentVisitor ) return ((assignmentVisitor<? extends T>)visitor).visitFunction_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_callContext function_call() throws RecognitionException {
		Function_callContext _localctx = new Function_callContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_function_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			match(IDENTIFIER);
			setState(248);
			match(LPARENS);
			setState(249);
			args();
			setState(250);
			match(RPARENS);
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

	public static class ArgsContext extends ParserRuleContext {
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(assignmentParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(assignmentParser.COMMA, i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof assignmentListener ) ((assignmentListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof assignmentListener ) ((assignmentListener)listener).exitArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof assignmentVisitor ) return ((assignmentVisitor<? extends T>)visitor).visitArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			value();
			setState(257);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(253);
				match(COMMA);
				setState(254);
				value();
				}
				}
				setState(259);
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

	public static class ReturnContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode SCOLON() { return getToken(assignmentParser.SCOLON, 0); }
		public ReturnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof assignmentListener ) ((assignmentListener)listener).enterReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof assignmentListener ) ((assignmentListener)listener).exitReturn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof assignmentVisitor ) return ((assignmentVisitor<? extends T>)visitor).visitReturn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnContext return() throws RecognitionException {
		ReturnContext _localctx = new ReturnContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_return);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			match(T__14);
			setState(261);
			value();
			setState(262);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 11:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\38\u010b\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\7\2\62"+
		"\n\2\f\2\16\2\65\13\2\3\2\3\2\7\29\n\2\f\2\16\2<\13\2\3\2\3\2\3\3\3\3"+
		"\7\3B\n\3\f\3\16\3E\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\5\4S\n\4\3\5\5\5V\n\5\3\5\3\5\3\5\3\5\3\5\3\6\5\6^\n\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\7\tv\n\t\f\t\16\ty\13\t\3\t\3\t\5\t}\n\t\3\t\3\t\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\6\f\u0095\n\f\r\f\16\f\u0096\3\f\3\f\5\f\u009b\n\f\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\5\r\u00b6\n\r\3\r\3\r\3\r\7\r\u00bb\n\r\f\r\16\r\u00be"+
		"\13\r\3\16\3\16\5\16\u00c2\n\16\3\17\3\17\3\17\3\17\7\17\u00c8\n\17\f"+
		"\17\16\17\u00cb\13\17\3\17\3\17\3\20\3\20\3\20\7\20\u00d2\n\20\f\20\16"+
		"\20\u00d5\13\20\3\21\3\21\3\21\3\21\5\21\u00db\n\21\3\22\3\22\3\22\3\23"+
		"\3\23\3\23\3\23\5\23\u00e4\n\23\3\23\3\23\7\23\u00e8\n\23\f\23\16\23\u00eb"+
		"\13\23\3\23\3\23\3\24\3\24\6\24\u00f1\n\24\r\24\16\24\u00f2\3\24\5\24"+
		"\u00f6\n\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\7\26\u0102"+
		"\n\26\f\26\16\26\u0105\13\26\3\27\3\27\3\27\3\27\3\27\2\3\30\30\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,\2\2\2\u0119\2.\3\2\2\2\4?\3"+
		"\2\2\2\6R\3\2\2\2\bU\3\2\2\2\n]\3\2\2\2\fd\3\2\2\2\16h\3\2\2\2\20l\3\2"+
		"\2\2\22\u0080\3\2\2\2\24\u0089\3\2\2\2\26\u009a\3\2\2\2\30\u00b5\3\2\2"+
		"\2\32\u00c1\3\2\2\2\34\u00c3\3\2\2\2\36\u00ce\3\2\2\2 \u00da\3\2\2\2\""+
		"\u00dc\3\2\2\2$\u00df\3\2\2\2&\u00ee\3\2\2\2(\u00f9\3\2\2\2*\u00fe\3\2"+
		"\2\2,\u0106\3\2\2\2.\63\7\22\2\2/\62\5\b\5\2\60\62\5\n\6\2\61/\3\2\2\2"+
		"\61\60\3\2\2\2\62\65\3\2\2\2\63\61\3\2\2\2\63\64\3\2\2\2\64:\3\2\2\2\65"+
		"\63\3\2\2\2\669\5\4\3\2\679\5\"\22\28\66\3\2\2\28\67\3\2\2\29<\3\2\2\2"+
		":8\3\2\2\2:;\3\2\2\2;=\3\2\2\2<:\3\2\2\2=>\7\23\2\2>\3\3\2\2\2?C\7,\2"+
		"\2@B\5\6\4\2A@\3\2\2\2BE\3\2\2\2CA\3\2\2\2CD\3\2\2\2DF\3\2\2\2EC\3\2\2"+
		"\2FG\7-\2\2G\5\3\2\2\2HS\5\b\5\2IS\5\n\6\2JS\5\f\7\2KS\5\16\b\2LS\5\20"+
		"\t\2MS\5\22\n\2NS\5\24\13\2OP\5(\25\2PQ\7\60\2\2QS\3\2\2\2RH\3\2\2\2R"+
		"I\3\2\2\2RJ\3\2\2\2RK\3\2\2\2RL\3\2\2\2RM\3\2\2\2RN\3\2\2\2RO\3\2\2\2"+
		"S\7\3\2\2\2TV\7\3\2\2UT\3\2\2\2UV\3\2\2\2VW\3\2\2\2WX\7\24\2\2XY\7#\2"+
		"\2YZ\5\26\f\2Z[\7\60\2\2[\t\3\2\2\2\\^\7\3\2\2]\\\3\2\2\2]^\3\2\2\2^_"+
		"\3\2\2\2_`\7\24\2\2`a\7#\2\2ab\5\34\17\2bc\7\60\2\2c\13\3\2\2\2de\7\4"+
		"\2\2ef\5\26\f\2fg\7\60\2\2g\r\3\2\2\2hi\7\5\2\2ij\5\26\f\2jk\7\60\2\2"+
		"k\17\3\2\2\2lm\7\6\2\2mn\5\36\20\2no\7\7\2\2o|\5\4\3\2pq\7\b\2\2qr\5\36"+
		"\20\2rs\7\7\2\2st\5\4\3\2tv\3\2\2\2up\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3"+
		"\2\2\2xz\3\2\2\2yw\3\2\2\2z{\7\t\2\2{}\5\4\3\2|w\3\2\2\2|}\3\2\2\2}~\3"+
		"\2\2\2~\177\7\n\2\2\177\21\3\2\2\2\u0080\u0081\7\13\2\2\u0081\u0082\7"+
		"\24\2\2\u0082\u0083\7\f\2\2\u0083\u0084\7\33\2\2\u0084\u0085\7\62\2\2"+
		"\u0085\u0086\7\33\2\2\u0086\u0087\5\4\3\2\u0087\u0088\7\r\2\2\u0088\23"+
		"\3\2\2\2\u0089\u008a\7\16\2\2\u008a\u008b\5\36\20\2\u008b\u008c\5\4\3"+
		"\2\u008c\u008d\7\17\2\2\u008d\25\3\2\2\2\u008e\u009b\5\32\16\2\u008f\u009b"+
		"\5\30\r\2\u0090\u009b\7\24\2\2\u0091\u0092\7\24\2\2\u0092\u0094\7.\2\2"+
		"\u0093\u0095\7\33\2\2\u0094\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0094"+
		"\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u009b\7/\2\2\u0099"+
		"\u009b\5(\25\2\u009a\u008e\3\2\2\2\u009a\u008f\3\2\2\2\u009a\u0090\3\2"+
		"\2\2\u009a\u0091\3\2\2\2\u009a\u0099\3\2\2\2\u009b\27\3\2\2\2\u009c\u009d"+
		"\b\r\1\2\u009d\u009e\5\32\16\2\u009e\u009f\7\35\2\2\u009f\u00a0\5\32\16"+
		"\2\u00a0\u00b6\3\2\2\2\u00a1\u00a2\5\32\16\2\u00a2\u00a3\7\35\2\2\u00a3"+
		"\u00a4\5\30\r\7\u00a4\u00b6\3\2\2\2\u00a5\u00a6\7*\2\2\u00a6\u00a7\5\30"+
		"\r\2\u00a7\u00a8\7+\2\2\u00a8\u00b6\3\2\2\2\u00a9\u00aa\7*\2\2\u00aa\u00ab"+
		"\5\32\16\2\u00ab\u00ac\7\35\2\2\u00ac\u00ad\5\30\r\2\u00ad\u00ae\7+\2"+
		"\2\u00ae\u00b6\3\2\2\2\u00af\u00b0\7*\2\2\u00b0\u00b1\5\30\r\2\u00b1\u00b2"+
		"\7\35\2\2\u00b2\u00b3\5\32\16\2\u00b3\u00b4\7+\2\2\u00b4\u00b6\3\2\2\2"+
		"\u00b5\u009c\3\2\2\2\u00b5\u00a1\3\2\2\2\u00b5\u00a5\3\2\2\2\u00b5\u00a9"+
		"\3\2\2\2\u00b5\u00af\3\2\2\2\u00b6\u00bc\3\2\2\2\u00b7\u00b8\f\6\2\2\u00b8"+
		"\u00b9\7\35\2\2\u00b9\u00bb\5\32\16\2\u00ba\u00b7\3\2\2\2\u00bb\u00be"+
		"\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\31\3\2\2\2\u00be"+
		"\u00bc\3\2\2\2\u00bf\u00c2\7\25\2\2\u00c0\u00c2\7\24\2\2\u00c1\u00bf\3"+
		"\2\2\2\u00c1\u00c0\3\2\2\2\u00c2\33\3\2\2\2\u00c3\u00c4\7.\2\2\u00c4\u00c9"+
		"\7\25\2\2\u00c5\u00c6\7\62\2\2\u00c6\u00c8\7\25\2\2\u00c7\u00c5\3\2\2"+
		"\2\u00c8\u00cb\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cc"+
		"\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cc\u00cd\7/\2\2\u00cd\35\3\2\2\2\u00ce"+
		"\u00d3\5 \21\2\u00cf\u00d0\7$\2\2\u00d0\u00d2\5 \21\2\u00d1\u00cf\3\2"+
		"\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4"+
		"\37\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d6\u00db\5\32\16\2\u00d7\u00db\5\30"+
		"\r\2\u00d8\u00db\7\66\2\2\u00d9\u00db\7\67\2\2\u00da\u00d6\3\2\2\2\u00da"+
		"\u00d7\3\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00d9\3\2\2\2\u00db!\3\2\2\2"+
		"\u00dc\u00dd\5$\23\2\u00dd\u00de\5&\24\2\u00de#\3\2\2\2\u00df\u00e0\7"+
		"\20\2\2\u00e0\u00e1\7\24\2\2\u00e1\u00e3\7*\2\2\u00e2\u00e4\7\24\2\2\u00e3"+
		"\u00e2\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e9\3\2\2\2\u00e5\u00e6\7\62"+
		"\2\2\u00e6\u00e8\7\24\2\2\u00e7\u00e5\3\2\2\2\u00e8\u00eb\3\2\2\2\u00e9"+
		"\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00ec\3\2\2\2\u00eb\u00e9\3\2"+
		"\2\2\u00ec\u00ed\7+\2\2\u00ed%\3\2\2\2\u00ee\u00f0\7,\2\2\u00ef\u00f1"+
		"\5\6\4\2\u00f0\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f2"+
		"\u00f3\3\2\2\2\u00f3\u00f5\3\2\2\2\u00f4\u00f6\5,\27\2\u00f5\u00f4\3\2"+
		"\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f8\7-\2\2\u00f8"+
		"\'\3\2\2\2\u00f9\u00fa\7\24\2\2\u00fa\u00fb\7*\2\2\u00fb\u00fc\5*\26\2"+
		"\u00fc\u00fd\7+\2\2\u00fd)\3\2\2\2\u00fe\u0103\5\26\f\2\u00ff\u0100\7"+
		"\62\2\2\u0100\u0102\5\26\f\2\u0101\u00ff\3\2\2\2\u0102\u0105\3\2\2\2\u0103"+
		"\u0101\3\2\2\2\u0103\u0104\3\2\2\2\u0104+\3\2\2\2\u0105\u0103\3\2\2\2"+
		"\u0106\u0107\7\21\2\2\u0107\u0108\5\26\f\2\u0108\u0109\7\60\2\2\u0109"+
		"-\3\2\2\2\31\61\638:CRU]w|\u0096\u009a\u00b5\u00bc\u00c1\u00c9\u00d3\u00da"+
		"\u00e3\u00e9\u00f2\u00f5\u0103";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}