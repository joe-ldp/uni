package shu.cmscb;

import calculator.CalculatorBaseListener;
import calculator.CalculatorParser;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;
import java.util.Stack;

public class Worker extends CalculatorBaseListener {
    private StringBuilder builder;
    public String getProgram() { return builder.toString(); }

    private ArrayList<String> lines;
    private Stack<String> memory = new Stack<>();

    @Override
    public void enterProg(CalculatorParser.ProgContext ctx) {
        builder = new StringBuilder("<script>\n" +
                "    function calculator() {\n");
        lines = new ArrayList<>();
    }

    @Override
    public void exitProg(CalculatorParser.ProgContext ctx) {
        for ( String next : lines )
            builder.append(next).append("\n");

        builder.append("document.getElementById('results').innerHTML = result;\n" +
                "    }\n" +
                "</script>\n" +
                "\n" +
                "<input type=\"button\" value=\"Calculate\" onClick=\"calculator()\" />\n" +
                "<br/>\n" +
                "Result: <span id=\"results\">(click \"Calculate\")</span>\n");
    }

    @Override
    public void exitAdd(CalculatorParser.AddContext ctx) {
        String right = memory.pop();
        String left = memory.pop();
        String expr = left +" + "+ right;
        //lines.add(expr);
        memory.push(expr);
    }

    @Override
    public void enterOperand(CalculatorParser.OperandContext ctx) {
        //System.out.println(ctx.getText());
        memory.push(ctx.getText());
    }

    @Override
    public void exitAssign(CalculatorParser.AssignContext ctx) {
        //System.out.println(ctx.getChildCount());
        //String left = ctx.getChild(0).getText();
        //String right = ctx.getChild(2).getText();//memory.pop();
        String expr = ctx.getText();
        //lines.add( "let "+ left +" = "+ right +";");
        lines.add( "let "+ expr +";");
    }

    @Override
    public void exitBrackets(CalculatorParser.BracketsContext ctx) {
        String expr = memory.pop();
        memory.push( "( "+ expr + " )");
    }

}
