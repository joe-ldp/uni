// Generated from C:/Users/joeki/OneDrive - Sheffield Hallam University/_Fundamentals of Programming Languages/Assignment 2/FoPL Assignment Two/src/AssignmentTwo\assignmentGrammar.g4 by ANTLR 4.9.1
package AssignmentTwo;

    package com.AssignmentTwo;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link assignmentGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface assignmentGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link assignmentGrammarParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(assignmentGrammarParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link assignmentGrammarParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(assignmentGrammarParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link assignmentGrammarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(assignmentGrammarParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link assignmentGrammarParser#stat_assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_assignment(assignmentGrammarParser.Stat_assignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link assignmentGrammarParser#stat_assign_array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_assign_array(assignmentGrammarParser.Stat_assign_arrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link assignmentGrammarParser#stat_input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_input(assignmentGrammarParser.Stat_inputContext ctx);
	/**
	 * Visit a parse tree produced by {@link assignmentGrammarParser#stat_output}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_output(assignmentGrammarParser.Stat_outputContext ctx);
	/**
	 * Visit a parse tree produced by {@link assignmentGrammarParser#stat_if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_if(assignmentGrammarParser.Stat_ifContext ctx);
	/**
	 * Visit a parse tree produced by {@link assignmentGrammarParser#stat_for}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_for(assignmentGrammarParser.Stat_forContext ctx);
	/**
	 * Visit a parse tree produced by {@link assignmentGrammarParser#stat_while}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_while(assignmentGrammarParser.Stat_whileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OPVALUE}
	 * labeled alternative in {@link assignmentGrammarParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOPVALUE(assignmentGrammarParser.OPVALUEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EXPRESSION}
	 * labeled alternative in {@link assignmentGrammarParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEXPRESSION(assignmentGrammarParser.EXPRESSIONContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VARVAL}
	 * labeled alternative in {@link assignmentGrammarParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVARVAL(assignmentGrammarParser.VARVALContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ARRAY}
	 * labeled alternative in {@link assignmentGrammarParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitARRAY(assignmentGrammarParser.ARRAYContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FUNCRETURN}
	 * labeled alternative in {@link assignmentGrammarParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFUNCRETURN(assignmentGrammarParser.FUNCRETURNContext ctx);
	/**
	 * Visit a parse tree produced by {@link assignmentGrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(assignmentGrammarParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VAL}
	 * labeled alternative in {@link assignmentGrammarParser#operand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVAL(assignmentGrammarParser.VALContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VARNAME}
	 * labeled alternative in {@link assignmentGrammarParser#operand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVARNAME(assignmentGrammarParser.VARNAMEContext ctx);
	/**
	 * Visit a parse tree produced by {@link assignmentGrammarParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(assignmentGrammarParser.ArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link assignmentGrammarParser#expr_boolean}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_boolean(assignmentGrammarParser.Expr_booleanContext ctx);
	/**
	 * Visit a parse tree produced by {@link assignmentGrammarParser#bool_operand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool_operand(assignmentGrammarParser.Bool_operandContext ctx);
	/**
	 * Visit a parse tree produced by {@link assignmentGrammarParser#function_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_definition(assignmentGrammarParser.Function_definitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link assignmentGrammarParser#function_signature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_signature(assignmentGrammarParser.Function_signatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link assignmentGrammarParser#funcblock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncblock(assignmentGrammarParser.FuncblockContext ctx);
	/**
	 * Visit a parse tree produced by {@link assignmentGrammarParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_call(assignmentGrammarParser.Function_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link assignmentGrammarParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(assignmentGrammarParser.ArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link assignmentGrammarParser#return}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn(assignmentGrammarParser.ReturnContext ctx);
}