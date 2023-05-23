// Generated from C:/Users/joeki/OneDrive - Sheffield Hallam University/_Fundamentals of Programming Languages/Assignment 1/Assignment 1 Grammar\assignment.g4 by ANTLR 4.9

    package com.assignment;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link assignmentParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface assignmentVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link assignmentParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(assignmentParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link assignmentParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(assignmentParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link assignmentParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(assignmentParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link assignmentParser#stat_assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_assignment(assignmentParser.Stat_assignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link assignmentParser#stat_assign_array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_assign_array(assignmentParser.Stat_assign_arrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link assignmentParser#stat_input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_input(assignmentParser.Stat_inputContext ctx);
	/**
	 * Visit a parse tree produced by {@link assignmentParser#stat_output}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_output(assignmentParser.Stat_outputContext ctx);
	/**
	 * Visit a parse tree produced by {@link assignmentParser#stat_if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_if(assignmentParser.Stat_ifContext ctx);
	/**
	 * Visit a parse tree produced by {@link assignmentParser#stat_for}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_for(assignmentParser.Stat_forContext ctx);
	/**
	 * Visit a parse tree produced by {@link assignmentParser#stat_while}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_while(assignmentParser.Stat_whileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OPVALUE}
	 * labeled alternative in {@link assignmentParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOPVALUE(assignmentParser.OPVALUEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EXPRESSION}
	 * labeled alternative in {@link assignmentParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEXPRESSION(assignmentParser.EXPRESSIONContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VARVAL}
	 * labeled alternative in {@link assignmentParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVARVAL(assignmentParser.VARVALContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ARRAY}
	 * labeled alternative in {@link assignmentParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitARRAY(assignmentParser.ARRAYContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FUNCRETURN}
	 * labeled alternative in {@link assignmentParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFUNCRETURN(assignmentParser.FUNCRETURNContext ctx);
	/**
	 * Visit a parse tree produced by {@link assignmentParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(assignmentParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VAL}
	 * labeled alternative in {@link assignmentParser#operand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVAL(assignmentParser.VALContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VARNAME}
	 * labeled alternative in {@link assignmentParser#operand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVARNAME(assignmentParser.VARNAMEContext ctx);
	/**
	 * Visit a parse tree produced by {@link assignmentParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(assignmentParser.ArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link assignmentParser#expr_boolean}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_boolean(assignmentParser.Expr_booleanContext ctx);
	/**
	 * Visit a parse tree produced by {@link assignmentParser#bool_operand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool_operand(assignmentParser.Bool_operandContext ctx);
	/**
	 * Visit a parse tree produced by {@link assignmentParser#function_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_definition(assignmentParser.Function_definitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link assignmentParser#function_signature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_signature(assignmentParser.Function_signatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link assignmentParser#funcblock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncblock(assignmentParser.FuncblockContext ctx);
	/**
	 * Visit a parse tree produced by {@link assignmentParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_call(assignmentParser.Function_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link assignmentParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(assignmentParser.ArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link assignmentParser#return}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn(assignmentParser.ReturnContext ctx);
}