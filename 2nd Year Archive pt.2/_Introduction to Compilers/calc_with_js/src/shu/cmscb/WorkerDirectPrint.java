package shu.cmscb;

import calculator.CalculatorBaseListener;
import calculator.CalculatorParser;

import java.util.ArrayList;
import java.util.Stack;

public class WorkerDirectPrint extends CalculatorBaseListener {
    private StringBuilder program;
    public String getProgram() { return program.toString(); }
    private Stack<String> memory = new Stack<>();
    private ArrayList<String> lines = new ArrayList<>();

    @Override
    public void enterProg(CalculatorParser.ProgContext ctx) {
        program = new StringBuilder("<script>\n function calculator() {\n");

        }
    @Override
    public void exitProg(CalculatorParser.ProgContext ctx) {
        for (String next : lines)
            program.append(next).append("\n");

        program.append(
                "        document.getElementById('results').innerHTML = result;\n" +
                "    }\n" +
                "</script>\n" +
                "\n" +
                "<input type=\"button\" value=\"Calculate\" onClick=\"calculator()\" />\n" +
                "<br/>\n" +
                "Result: <span id=\"results\">(click \"Calculate\")</span>\n");
    }

    @Override
    public void enterAssign(CalculatorParser.AssignContext ctx) {
//        System.out.println(ctx.getText());
        System.out.println(ctx.getChild(0).getText());
        memory.push(ctx.getChild(0).getText());

    }

    @Override
    public void exitAssign(CalculatorParser.AssignContext ctx) {
        String operand2 = memory.pop();
        String operand1 = memory.pop();
        lines.add("let "+ operand1 +" = "+ operand2 +";");
    }

    @Override
    public void exitAdd(CalculatorParser.AddContext ctx) {
        String right = memory.pop();
        String left = memory.pop();
        String expression = left +" + "+ right;
        //lines.add(expression);
        memory.push(expression);
    }

    @Override
    public void enterOperand(CalculatorParser.OperandContext ctx) {
//        System.out.println(ctx.getText());
        memory.push(ctx.getText());
    }
}
