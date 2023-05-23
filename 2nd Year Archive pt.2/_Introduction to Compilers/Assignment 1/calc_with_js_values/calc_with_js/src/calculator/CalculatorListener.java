// Generated from /home/chris/code/fopl/calc_with_js/Calculator.g4 by ANTLR 4.9.1

package calculator;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalculatorParser}.
 */
public interface CalculatorListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(CalculatorParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(CalculatorParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#defn}.
	 * @param ctx the parse tree
	 */
	void enterDefn(CalculatorParser.DefnContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#defn}.
	 * @param ctx the parse tree
	 */
	void exitDefn(CalculatorParser.DefnContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#head}.
	 * @param ctx the parse tree
	 */
	void enterHead(CalculatorParser.HeadContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#head}.
	 * @param ctx the parse tree
	 */
	void exitHead(CalculatorParser.HeadContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(CalculatorParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(CalculatorParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#arg}.
	 * @param ctx the parse tree
	 */
	void enterArg(CalculatorParser.ArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#arg}.
	 * @param ctx the parse tree
	 */
	void exitArg(CalculatorParser.ArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#retstat}.
	 * @param ctx the parse tree
	 */
	void enterRetstat(CalculatorParser.RetstatContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#retstat}.
	 * @param ctx the parse tree
	 */
	void exitRetstat(CalculatorParser.RetstatContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(CalculatorParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(CalculatorParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(CalculatorParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(CalculatorParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Add}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAdd(CalculatorParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Add}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAdd(CalculatorParser.AddContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Sub}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSub(CalculatorParser.SubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Sub}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSub(CalculatorParser.SubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Mul}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMul(CalculatorParser.MulContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Mul}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMul(CalculatorParser.MulContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Div}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDiv(CalculatorParser.DivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Div}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDiv(CalculatorParser.DivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Mod}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMod(CalculatorParser.ModContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Mod}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMod(CalculatorParser.ModContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#funcall}.
	 * @param ctx the parse tree
	 */
	void enterFuncall(CalculatorParser.FuncallContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#funcall}.
	 * @param ctx the parse tree
	 */
	void exitFuncall(CalculatorParser.FuncallContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#operand}.
	 * @param ctx the parse tree
	 */
	void enterOperand(CalculatorParser.OperandContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#operand}.
	 * @param ctx the parse tree
	 */
	void exitOperand(CalculatorParser.OperandContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(CalculatorParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(CalculatorParser.ValueContext ctx);
}