// Generated from C:/Users/joeki/OneDrive - Sheffield Hallam University/_Fundamentals of Programming Languages/Assignment 1 Grammar\assignment.g4 by ANTLR 4.9

    package assignment;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link testParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface testVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link testParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(testParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link testParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(testParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link testParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(testParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link testParser#stat_assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_assignment(testParser.Stat_assignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link testParser#stat_input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_input(testParser.Stat_inputContext ctx);
	/**
	 * Visit a parse tree produced by {@link testParser#stat_output}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_output(testParser.Stat_outputContext ctx);
	/**
	 * Visit a parse tree produced by {@link testParser#stat_if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_if(testParser.Stat_ifContext ctx);
	/**
	 * Visit a parse tree produced by {@link testParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(testParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link testParser#bool_join}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool_join(testParser.Bool_joinContext ctx);
	/**
	 * Visit a parse tree produced by {@link testParser#expr_boolean}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_boolean(testParser.Expr_booleanContext ctx);
	/**
	 * Visit a parse tree produced by {@link testParser#bool_operand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool_operand(testParser.Bool_operandContext ctx);
	/**
	 * Visit a parse tree produced by {@link testParser#operand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperand(testParser.OperandContext ctx);
}