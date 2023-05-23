// Generated from C:/Users/joeki/OneDrive - Sheffield Hallam University/_Fundamentals of Programming Languages\JustBasic.g4 by ANTLR 4.9
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JustBasicParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JustBasicVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JustBasicParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(JustBasicParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link JustBasicParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(JustBasicParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link JustBasicParser#goto_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGoto_stat(JustBasicParser.Goto_statContext ctx);
	/**
	 * Visit a parse tree produced by {@link JustBasicParser#block_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock_stat(JustBasicParser.Block_statContext ctx);
	/**
	 * Visit a parse tree produced by {@link JustBasicParser#input_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInput_stat(JustBasicParser.Input_statContext ctx);
	/**
	 * Visit a parse tree produced by {@link JustBasicParser#if_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_stat(JustBasicParser.If_statContext ctx);
	/**
	 * Visit a parse tree produced by {@link JustBasicParser#bool_join}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool_join(JustBasicParser.Bool_joinContext ctx);
	/**
	 * Visit a parse tree produced by {@link JustBasicParser#bool_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool_expr(JustBasicParser.Bool_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link JustBasicParser#bool_operand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool_operand(JustBasicParser.Bool_operandContext ctx);
	/**
	 * Visit a parse tree produced by {@link JustBasicParser#cast}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCast(JustBasicParser.CastContext ctx);
	/**
	 * Visit a parse tree produced by {@link JustBasicParser#assign_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_stat(JustBasicParser.Assign_statContext ctx);
	/**
	 * Visit a parse tree produced by {@link JustBasicParser#print_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint_stat(JustBasicParser.Print_statContext ctx);
	/**
	 * Visit a parse tree produced by {@link JustBasicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(JustBasicParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link JustBasicParser#operand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperand(JustBasicParser.OperandContext ctx);
}