// Generated from C:/Users/joeki/OneDrive - Sheffield Hallam University/_Fundamentals of Programming Languages\JustBasic.g4 by ANTLR 4.9
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JustBasicParser}.
 */
public interface JustBasicListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JustBasicParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(JustBasicParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link JustBasicParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(JustBasicParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link JustBasicParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(JustBasicParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link JustBasicParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(JustBasicParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link JustBasicParser#goto_stat}.
	 * @param ctx the parse tree
	 */
	void enterGoto_stat(JustBasicParser.Goto_statContext ctx);
	/**
	 * Exit a parse tree produced by {@link JustBasicParser#goto_stat}.
	 * @param ctx the parse tree
	 */
	void exitGoto_stat(JustBasicParser.Goto_statContext ctx);
	/**
	 * Enter a parse tree produced by {@link JustBasicParser#block_stat}.
	 * @param ctx the parse tree
	 */
	void enterBlock_stat(JustBasicParser.Block_statContext ctx);
	/**
	 * Exit a parse tree produced by {@link JustBasicParser#block_stat}.
	 * @param ctx the parse tree
	 */
	void exitBlock_stat(JustBasicParser.Block_statContext ctx);
	/**
	 * Enter a parse tree produced by {@link JustBasicParser#input_stat}.
	 * @param ctx the parse tree
	 */
	void enterInput_stat(JustBasicParser.Input_statContext ctx);
	/**
	 * Exit a parse tree produced by {@link JustBasicParser#input_stat}.
	 * @param ctx the parse tree
	 */
	void exitInput_stat(JustBasicParser.Input_statContext ctx);
	/**
	 * Enter a parse tree produced by {@link JustBasicParser#if_stat}.
	 * @param ctx the parse tree
	 */
	void enterIf_stat(JustBasicParser.If_statContext ctx);
	/**
	 * Exit a parse tree produced by {@link JustBasicParser#if_stat}.
	 * @param ctx the parse tree
	 */
	void exitIf_stat(JustBasicParser.If_statContext ctx);
	/**
	 * Enter a parse tree produced by {@link JustBasicParser#bool_join}.
	 * @param ctx the parse tree
	 */
	void enterBool_join(JustBasicParser.Bool_joinContext ctx);
	/**
	 * Exit a parse tree produced by {@link JustBasicParser#bool_join}.
	 * @param ctx the parse tree
	 */
	void exitBool_join(JustBasicParser.Bool_joinContext ctx);
	/**
	 * Enter a parse tree produced by {@link JustBasicParser#bool_expr}.
	 * @param ctx the parse tree
	 */
	void enterBool_expr(JustBasicParser.Bool_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link JustBasicParser#bool_expr}.
	 * @param ctx the parse tree
	 */
	void exitBool_expr(JustBasicParser.Bool_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link JustBasicParser#bool_operand}.
	 * @param ctx the parse tree
	 */
	void enterBool_operand(JustBasicParser.Bool_operandContext ctx);
	/**
	 * Exit a parse tree produced by {@link JustBasicParser#bool_operand}.
	 * @param ctx the parse tree
	 */
	void exitBool_operand(JustBasicParser.Bool_operandContext ctx);
	/**
	 * Enter a parse tree produced by {@link JustBasicParser#cast}.
	 * @param ctx the parse tree
	 */
	void enterCast(JustBasicParser.CastContext ctx);
	/**
	 * Exit a parse tree produced by {@link JustBasicParser#cast}.
	 * @param ctx the parse tree
	 */
	void exitCast(JustBasicParser.CastContext ctx);
	/**
	 * Enter a parse tree produced by {@link JustBasicParser#assign_stat}.
	 * @param ctx the parse tree
	 */
	void enterAssign_stat(JustBasicParser.Assign_statContext ctx);
	/**
	 * Exit a parse tree produced by {@link JustBasicParser#assign_stat}.
	 * @param ctx the parse tree
	 */
	void exitAssign_stat(JustBasicParser.Assign_statContext ctx);
	/**
	 * Enter a parse tree produced by {@link JustBasicParser#print_stat}.
	 * @param ctx the parse tree
	 */
	void enterPrint_stat(JustBasicParser.Print_statContext ctx);
	/**
	 * Exit a parse tree produced by {@link JustBasicParser#print_stat}.
	 * @param ctx the parse tree
	 */
	void exitPrint_stat(JustBasicParser.Print_statContext ctx);
	/**
	 * Enter a parse tree produced by {@link JustBasicParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(JustBasicParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link JustBasicParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(JustBasicParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link JustBasicParser#operand}.
	 * @param ctx the parse tree
	 */
	void enterOperand(JustBasicParser.OperandContext ctx);
	/**
	 * Exit a parse tree produced by {@link JustBasicParser#operand}.
	 * @param ctx the parse tree
	 */
	void exitOperand(JustBasicParser.OperandContext ctx);
}