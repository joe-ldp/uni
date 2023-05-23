// Generated from C:/Users/joeki/OneDrive - Sheffield Hallam University/_Fundamentals of Programming Languages/Assignment 2/FoPL Assignment Two/src/AssignmentTwo\assignmentGrammar.g4 by ANTLR 4.9.1
package AssignmentTwo;

    package com.AssignmentTwo;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link assignmentGrammarParser}.
 */
public interface assignmentGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link assignmentGrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(assignmentGrammarParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link assignmentGrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(assignmentGrammarParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link assignmentGrammarParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(assignmentGrammarParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link assignmentGrammarParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(assignmentGrammarParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link assignmentGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(assignmentGrammarParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link assignmentGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(assignmentGrammarParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link assignmentGrammarParser#stat_assignment}.
	 * @param ctx the parse tree
	 */
	void enterStat_assignment(assignmentGrammarParser.Stat_assignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link assignmentGrammarParser#stat_assignment}.
	 * @param ctx the parse tree
	 */
	void exitStat_assignment(assignmentGrammarParser.Stat_assignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link assignmentGrammarParser#stat_assign_array}.
	 * @param ctx the parse tree
	 */
	void enterStat_assign_array(assignmentGrammarParser.Stat_assign_arrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link assignmentGrammarParser#stat_assign_array}.
	 * @param ctx the parse tree
	 */
	void exitStat_assign_array(assignmentGrammarParser.Stat_assign_arrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link assignmentGrammarParser#stat_input}.
	 * @param ctx the parse tree
	 */
	void enterStat_input(assignmentGrammarParser.Stat_inputContext ctx);
	/**
	 * Exit a parse tree produced by {@link assignmentGrammarParser#stat_input}.
	 * @param ctx the parse tree
	 */
	void exitStat_input(assignmentGrammarParser.Stat_inputContext ctx);
	/**
	 * Enter a parse tree produced by {@link assignmentGrammarParser#stat_output}.
	 * @param ctx the parse tree
	 */
	void enterStat_output(assignmentGrammarParser.Stat_outputContext ctx);
	/**
	 * Exit a parse tree produced by {@link assignmentGrammarParser#stat_output}.
	 * @param ctx the parse tree
	 */
	void exitStat_output(assignmentGrammarParser.Stat_outputContext ctx);
	/**
	 * Enter a parse tree produced by {@link assignmentGrammarParser#stat_if}.
	 * @param ctx the parse tree
	 */
	void enterStat_if(assignmentGrammarParser.Stat_ifContext ctx);
	/**
	 * Exit a parse tree produced by {@link assignmentGrammarParser#stat_if}.
	 * @param ctx the parse tree
	 */
	void exitStat_if(assignmentGrammarParser.Stat_ifContext ctx);
	/**
	 * Enter a parse tree produced by {@link assignmentGrammarParser#stat_for}.
	 * @param ctx the parse tree
	 */
	void enterStat_for(assignmentGrammarParser.Stat_forContext ctx);
	/**
	 * Exit a parse tree produced by {@link assignmentGrammarParser#stat_for}.
	 * @param ctx the parse tree
	 */
	void exitStat_for(assignmentGrammarParser.Stat_forContext ctx);
	/**
	 * Enter a parse tree produced by {@link assignmentGrammarParser#stat_while}.
	 * @param ctx the parse tree
	 */
	void enterStat_while(assignmentGrammarParser.Stat_whileContext ctx);
	/**
	 * Exit a parse tree produced by {@link assignmentGrammarParser#stat_while}.
	 * @param ctx the parse tree
	 */
	void exitStat_while(assignmentGrammarParser.Stat_whileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OPVALUE}
	 * labeled alternative in {@link assignmentGrammarParser#value}.
	 * @param ctx the parse tree
	 */
	void enterOPVALUE(assignmentGrammarParser.OPVALUEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OPVALUE}
	 * labeled alternative in {@link assignmentGrammarParser#value}.
	 * @param ctx the parse tree
	 */
	void exitOPVALUE(assignmentGrammarParser.OPVALUEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EXPRESSION}
	 * labeled alternative in {@link assignmentGrammarParser#value}.
	 * @param ctx the parse tree
	 */
	void enterEXPRESSION(assignmentGrammarParser.EXPRESSIONContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EXPRESSION}
	 * labeled alternative in {@link assignmentGrammarParser#value}.
	 * @param ctx the parse tree
	 */
	void exitEXPRESSION(assignmentGrammarParser.EXPRESSIONContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VARVAL}
	 * labeled alternative in {@link assignmentGrammarParser#value}.
	 * @param ctx the parse tree
	 */
	void enterVARVAL(assignmentGrammarParser.VARVALContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VARVAL}
	 * labeled alternative in {@link assignmentGrammarParser#value}.
	 * @param ctx the parse tree
	 */
	void exitVARVAL(assignmentGrammarParser.VARVALContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ARRAY}
	 * labeled alternative in {@link assignmentGrammarParser#value}.
	 * @param ctx the parse tree
	 */
	void enterARRAY(assignmentGrammarParser.ARRAYContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ARRAY}
	 * labeled alternative in {@link assignmentGrammarParser#value}.
	 * @param ctx the parse tree
	 */
	void exitARRAY(assignmentGrammarParser.ARRAYContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FUNCRETURN}
	 * labeled alternative in {@link assignmentGrammarParser#value}.
	 * @param ctx the parse tree
	 */
	void enterFUNCRETURN(assignmentGrammarParser.FUNCRETURNContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FUNCRETURN}
	 * labeled alternative in {@link assignmentGrammarParser#value}.
	 * @param ctx the parse tree
	 */
	void exitFUNCRETURN(assignmentGrammarParser.FUNCRETURNContext ctx);
	/**
	 * Enter a parse tree produced by {@link assignmentGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(assignmentGrammarParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link assignmentGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(assignmentGrammarParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VAL}
	 * labeled alternative in {@link assignmentGrammarParser#operand}.
	 * @param ctx the parse tree
	 */
	void enterVAL(assignmentGrammarParser.VALContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VAL}
	 * labeled alternative in {@link assignmentGrammarParser#operand}.
	 * @param ctx the parse tree
	 */
	void exitVAL(assignmentGrammarParser.VALContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VARNAME}
	 * labeled alternative in {@link assignmentGrammarParser#operand}.
	 * @param ctx the parse tree
	 */
	void enterVARNAME(assignmentGrammarParser.VARNAMEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VARNAME}
	 * labeled alternative in {@link assignmentGrammarParser#operand}.
	 * @param ctx the parse tree
	 */
	void exitVARNAME(assignmentGrammarParser.VARNAMEContext ctx);
	/**
	 * Enter a parse tree produced by {@link assignmentGrammarParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArray(assignmentGrammarParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link assignmentGrammarParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArray(assignmentGrammarParser.ArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link assignmentGrammarParser#expr_boolean}.
	 * @param ctx the parse tree
	 */
	void enterExpr_boolean(assignmentGrammarParser.Expr_booleanContext ctx);
	/**
	 * Exit a parse tree produced by {@link assignmentGrammarParser#expr_boolean}.
	 * @param ctx the parse tree
	 */
	void exitExpr_boolean(assignmentGrammarParser.Expr_booleanContext ctx);
	/**
	 * Enter a parse tree produced by {@link assignmentGrammarParser#bool_operand}.
	 * @param ctx the parse tree
	 */
	void enterBool_operand(assignmentGrammarParser.Bool_operandContext ctx);
	/**
	 * Exit a parse tree produced by {@link assignmentGrammarParser#bool_operand}.
	 * @param ctx the parse tree
	 */
	void exitBool_operand(assignmentGrammarParser.Bool_operandContext ctx);
	/**
	 * Enter a parse tree produced by {@link assignmentGrammarParser#function_definition}.
	 * @param ctx the parse tree
	 */
	void enterFunction_definition(assignmentGrammarParser.Function_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link assignmentGrammarParser#function_definition}.
	 * @param ctx the parse tree
	 */
	void exitFunction_definition(assignmentGrammarParser.Function_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link assignmentGrammarParser#function_signature}.
	 * @param ctx the parse tree
	 */
	void enterFunction_signature(assignmentGrammarParser.Function_signatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link assignmentGrammarParser#function_signature}.
	 * @param ctx the parse tree
	 */
	void exitFunction_signature(assignmentGrammarParser.Function_signatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link assignmentGrammarParser#funcblock}.
	 * @param ctx the parse tree
	 */
	void enterFuncblock(assignmentGrammarParser.FuncblockContext ctx);
	/**
	 * Exit a parse tree produced by {@link assignmentGrammarParser#funcblock}.
	 * @param ctx the parse tree
	 */
	void exitFuncblock(assignmentGrammarParser.FuncblockContext ctx);
	/**
	 * Enter a parse tree produced by {@link assignmentGrammarParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterFunction_call(assignmentGrammarParser.Function_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link assignmentGrammarParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitFunction_call(assignmentGrammarParser.Function_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link assignmentGrammarParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(assignmentGrammarParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link assignmentGrammarParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(assignmentGrammarParser.ArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link assignmentGrammarParser#return}.
	 * @param ctx the parse tree
	 */
	void enterReturn(assignmentGrammarParser.ReturnContext ctx);
	/**
	 * Exit a parse tree produced by {@link assignmentGrammarParser#return}.
	 * @param ctx the parse tree
	 */
	void exitReturn(assignmentGrammarParser.ReturnContext ctx);
}