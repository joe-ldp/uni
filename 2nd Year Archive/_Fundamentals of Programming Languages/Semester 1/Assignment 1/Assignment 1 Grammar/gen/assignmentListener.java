// Generated from C:/Users/joeki/OneDrive - Sheffield Hallam University/_Fundamentals of Programming Languages/Assignment 1/Assignment 1 Grammar\assignment.g4 by ANTLR 4.9

    package com.assignment;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link assignmentParser}.
 */
public interface assignmentListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link assignmentParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(assignmentParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link assignmentParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(assignmentParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link assignmentParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(assignmentParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link assignmentParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(assignmentParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link assignmentParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(assignmentParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link assignmentParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(assignmentParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link assignmentParser#stat_assignment}.
	 * @param ctx the parse tree
	 */
	void enterStat_assignment(assignmentParser.Stat_assignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link assignmentParser#stat_assignment}.
	 * @param ctx the parse tree
	 */
	void exitStat_assignment(assignmentParser.Stat_assignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link assignmentParser#stat_assign_array}.
	 * @param ctx the parse tree
	 */
	void enterStat_assign_array(assignmentParser.Stat_assign_arrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link assignmentParser#stat_assign_array}.
	 * @param ctx the parse tree
	 */
	void exitStat_assign_array(assignmentParser.Stat_assign_arrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link assignmentParser#stat_input}.
	 * @param ctx the parse tree
	 */
	void enterStat_input(assignmentParser.Stat_inputContext ctx);
	/**
	 * Exit a parse tree produced by {@link assignmentParser#stat_input}.
	 * @param ctx the parse tree
	 */
	void exitStat_input(assignmentParser.Stat_inputContext ctx);
	/**
	 * Enter a parse tree produced by {@link assignmentParser#stat_output}.
	 * @param ctx the parse tree
	 */
	void enterStat_output(assignmentParser.Stat_outputContext ctx);
	/**
	 * Exit a parse tree produced by {@link assignmentParser#stat_output}.
	 * @param ctx the parse tree
	 */
	void exitStat_output(assignmentParser.Stat_outputContext ctx);
	/**
	 * Enter a parse tree produced by {@link assignmentParser#stat_if}.
	 * @param ctx the parse tree
	 */
	void enterStat_if(assignmentParser.Stat_ifContext ctx);
	/**
	 * Exit a parse tree produced by {@link assignmentParser#stat_if}.
	 * @param ctx the parse tree
	 */
	void exitStat_if(assignmentParser.Stat_ifContext ctx);
	/**
	 * Enter a parse tree produced by {@link assignmentParser#stat_for}.
	 * @param ctx the parse tree
	 */
	void enterStat_for(assignmentParser.Stat_forContext ctx);
	/**
	 * Exit a parse tree produced by {@link assignmentParser#stat_for}.
	 * @param ctx the parse tree
	 */
	void exitStat_for(assignmentParser.Stat_forContext ctx);
	/**
	 * Enter a parse tree produced by {@link assignmentParser#stat_while}.
	 * @param ctx the parse tree
	 */
	void enterStat_while(assignmentParser.Stat_whileContext ctx);
	/**
	 * Exit a parse tree produced by {@link assignmentParser#stat_while}.
	 * @param ctx the parse tree
	 */
	void exitStat_while(assignmentParser.Stat_whileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OPVALUE}
	 * labeled alternative in {@link assignmentParser#value}.
	 * @param ctx the parse tree
	 */
	void enterOPVALUE(assignmentParser.OPVALUEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OPVALUE}
	 * labeled alternative in {@link assignmentParser#value}.
	 * @param ctx the parse tree
	 */
	void exitOPVALUE(assignmentParser.OPVALUEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EXPRESSION}
	 * labeled alternative in {@link assignmentParser#value}.
	 * @param ctx the parse tree
	 */
	void enterEXPRESSION(assignmentParser.EXPRESSIONContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EXPRESSION}
	 * labeled alternative in {@link assignmentParser#value}.
	 * @param ctx the parse tree
	 */
	void exitEXPRESSION(assignmentParser.EXPRESSIONContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VARVAL}
	 * labeled alternative in {@link assignmentParser#value}.
	 * @param ctx the parse tree
	 */
	void enterVARVAL(assignmentParser.VARVALContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VARVAL}
	 * labeled alternative in {@link assignmentParser#value}.
	 * @param ctx the parse tree
	 */
	void exitVARVAL(assignmentParser.VARVALContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ARRAY}
	 * labeled alternative in {@link assignmentParser#value}.
	 * @param ctx the parse tree
	 */
	void enterARRAY(assignmentParser.ARRAYContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ARRAY}
	 * labeled alternative in {@link assignmentParser#value}.
	 * @param ctx the parse tree
	 */
	void exitARRAY(assignmentParser.ARRAYContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FUNCRETURN}
	 * labeled alternative in {@link assignmentParser#value}.
	 * @param ctx the parse tree
	 */
	void enterFUNCRETURN(assignmentParser.FUNCRETURNContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FUNCRETURN}
	 * labeled alternative in {@link assignmentParser#value}.
	 * @param ctx the parse tree
	 */
	void exitFUNCRETURN(assignmentParser.FUNCRETURNContext ctx);
	/**
	 * Enter a parse tree produced by {@link assignmentParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(assignmentParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link assignmentParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(assignmentParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VAL}
	 * labeled alternative in {@link assignmentParser#operand}.
	 * @param ctx the parse tree
	 */
	void enterVAL(assignmentParser.VALContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VAL}
	 * labeled alternative in {@link assignmentParser#operand}.
	 * @param ctx the parse tree
	 */
	void exitVAL(assignmentParser.VALContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VARNAME}
	 * labeled alternative in {@link assignmentParser#operand}.
	 * @param ctx the parse tree
	 */
	void enterVARNAME(assignmentParser.VARNAMEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VARNAME}
	 * labeled alternative in {@link assignmentParser#operand}.
	 * @param ctx the parse tree
	 */
	void exitVARNAME(assignmentParser.VARNAMEContext ctx);
	/**
	 * Enter a parse tree produced by {@link assignmentParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArray(assignmentParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link assignmentParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArray(assignmentParser.ArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link assignmentParser#expr_boolean}.
	 * @param ctx the parse tree
	 */
	void enterExpr_boolean(assignmentParser.Expr_booleanContext ctx);
	/**
	 * Exit a parse tree produced by {@link assignmentParser#expr_boolean}.
	 * @param ctx the parse tree
	 */
	void exitExpr_boolean(assignmentParser.Expr_booleanContext ctx);
	/**
	 * Enter a parse tree produced by {@link assignmentParser#bool_operand}.
	 * @param ctx the parse tree
	 */
	void enterBool_operand(assignmentParser.Bool_operandContext ctx);
	/**
	 * Exit a parse tree produced by {@link assignmentParser#bool_operand}.
	 * @param ctx the parse tree
	 */
	void exitBool_operand(assignmentParser.Bool_operandContext ctx);
	/**
	 * Enter a parse tree produced by {@link assignmentParser#function_definition}.
	 * @param ctx the parse tree
	 */
	void enterFunction_definition(assignmentParser.Function_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link assignmentParser#function_definition}.
	 * @param ctx the parse tree
	 */
	void exitFunction_definition(assignmentParser.Function_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link assignmentParser#function_signature}.
	 * @param ctx the parse tree
	 */
	void enterFunction_signature(assignmentParser.Function_signatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link assignmentParser#function_signature}.
	 * @param ctx the parse tree
	 */
	void exitFunction_signature(assignmentParser.Function_signatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link assignmentParser#funcblock}.
	 * @param ctx the parse tree
	 */
	void enterFuncblock(assignmentParser.FuncblockContext ctx);
	/**
	 * Exit a parse tree produced by {@link assignmentParser#funcblock}.
	 * @param ctx the parse tree
	 */
	void exitFuncblock(assignmentParser.FuncblockContext ctx);
	/**
	 * Enter a parse tree produced by {@link assignmentParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterFunction_call(assignmentParser.Function_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link assignmentParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitFunction_call(assignmentParser.Function_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link assignmentParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(assignmentParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link assignmentParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(assignmentParser.ArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link assignmentParser#return}.
	 * @param ctx the parse tree
	 */
	void enterReturn(assignmentParser.ReturnContext ctx);
	/**
	 * Exit a parse tree produced by {@link assignmentParser#return}.
	 * @param ctx the parse tree
	 */
	void exitReturn(assignmentParser.ReturnContext ctx);
}