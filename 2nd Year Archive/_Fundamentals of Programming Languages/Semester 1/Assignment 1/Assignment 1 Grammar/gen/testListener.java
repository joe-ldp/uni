// Generated from C:/Users/joeki/OneDrive - Sheffield Hallam University/_Fundamentals of Programming Languages/Assignment 1 Grammar\assignment.g4 by ANTLR 4.9

    package assignment;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link testParser}.
 */
public interface testListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link testParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(testParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link testParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(testParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link testParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(testParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link testParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(testParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link testParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(testParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link testParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(testParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link testParser#stat_assignment}.
	 * @param ctx the parse tree
	 */
	void enterStat_assignment(testParser.Stat_assignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link testParser#stat_assignment}.
	 * @param ctx the parse tree
	 */
	void exitStat_assignment(testParser.Stat_assignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link testParser#stat_input}.
	 * @param ctx the parse tree
	 */
	void enterStat_input(testParser.Stat_inputContext ctx);
	/**
	 * Exit a parse tree produced by {@link testParser#stat_input}.
	 * @param ctx the parse tree
	 */
	void exitStat_input(testParser.Stat_inputContext ctx);
	/**
	 * Enter a parse tree produced by {@link testParser#stat_output}.
	 * @param ctx the parse tree
	 */
	void enterStat_output(testParser.Stat_outputContext ctx);
	/**
	 * Exit a parse tree produced by {@link testParser#stat_output}.
	 * @param ctx the parse tree
	 */
	void exitStat_output(testParser.Stat_outputContext ctx);
	/**
	 * Enter a parse tree produced by {@link testParser#stat_if}.
	 * @param ctx the parse tree
	 */
	void enterStat_if(testParser.Stat_ifContext ctx);
	/**
	 * Exit a parse tree produced by {@link testParser#stat_if}.
	 * @param ctx the parse tree
	 */
	void exitStat_if(testParser.Stat_ifContext ctx);
	/**
	 * Enter a parse tree produced by {@link testParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(testParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link testParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(testParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link testParser#bool_join}.
	 * @param ctx the parse tree
	 */
	void enterBool_join(testParser.Bool_joinContext ctx);
	/**
	 * Exit a parse tree produced by {@link testParser#bool_join}.
	 * @param ctx the parse tree
	 */
	void exitBool_join(testParser.Bool_joinContext ctx);
	/**
	 * Enter a parse tree produced by {@link testParser#expr_boolean}.
	 * @param ctx the parse tree
	 */
	void enterExpr_boolean(testParser.Expr_booleanContext ctx);
	/**
	 * Exit a parse tree produced by {@link testParser#expr_boolean}.
	 * @param ctx the parse tree
	 */
	void exitExpr_boolean(testParser.Expr_booleanContext ctx);
	/**
	 * Enter a parse tree produced by {@link testParser#bool_operand}.
	 * @param ctx the parse tree
	 */
	void enterBool_operand(testParser.Bool_operandContext ctx);
	/**
	 * Exit a parse tree produced by {@link testParser#bool_operand}.
	 * @param ctx the parse tree
	 */
	void exitBool_operand(testParser.Bool_operandContext ctx);
	/**
	 * Enter a parse tree produced by {@link testParser#operand}.
	 * @param ctx the parse tree
	 */
	void enterOperand(testParser.OperandContext ctx);
	/**
	 * Exit a parse tree produced by {@link testParser#operand}.
	 * @param ctx the parse tree
	 */
	void exitOperand(testParser.OperandContext ctx);
}