package shu.cmscb;

import calculator.CalculatorBaseListener;
import calculator.CalculatorParser;

import java.util.ArrayList;
import java.util.Stack;
import org.stringtemplate.v4.*;


public class WorkerTemplated extends CalculatorBaseListener {
        private StringBuilder program;
        public String getProgram() { return program.toString(); }
        private Stack<String> memory = new Stack<>();
        private ArrayList<String> lines = new ArrayList<>();

        @Override
        public void enterProg(CalculatorParser.ProgContext ctx) {
            program = new StringBuilder();
            ST st = new ST("<script>\nfunction calculator() {\n", '$', '$');
            program.append(st.render());

        }
        @Override
        public void exitProg(CalculatorParser.ProgContext ctx) {
            ST st = new ST("document.getElementById('results').innerHTML = result;\n    " +
                    "}\n</script>\n<input type=\"button\" value=\"Calculate\" onClick=\"calculator()\" />\n" +
                    "<br/>\nResult: <span id=\"results\">(click \"Calculate\")</span>\n", '$', '$');

            for (String next : lines)
                program.append(next).append("\n");

            program.append(st.render());
        }

        @Override
        public void enterAssign(CalculatorParser.AssignContext ctx) {
            // System.out.println(ctx.getChild(0).getText());
            memory.push(ctx.getChild(0).getText());

        }

        @Override
        public void exitAssign(CalculatorParser.AssignContext ctx) {
            ST st = new ST("let <op1> = <op2>;");
            st.add("op2", memory.pop());
            st.add("op1", memory.pop());
            lines.add(st.render());
            //String operand2 = memory.pop();
            //String operand1 = memory.pop();
            //lines.add("let "+ operand1 +" = "+ operand2 +";");
        }

        @Override
        public void exitAdd(CalculatorParser.AddContext ctx) {
            ST st = new ST("<op1> + <op2>;");
            st.add("op2", memory.pop());
            st.add("op1", memory.pop());
            lines.add(st.render());
//            String right = memory.pop();
//            String left = memory.pop();
//            String expression = left +" + "+ right;
            //lines.add(expression);
//            memory.push(expression);
        }

        @Override
        public void enterOperand(CalculatorParser.OperandContext ctx) {
//        System.out.println(ctx.getText());
            memory.push(ctx.getText());
        }

//        @Override
//        public void exitBracketed(CalculatorParser.BracketedContext ctx) {
//            String op = memory.pop();
//            String expression = '('+ op + ')';
//            memory.push(expression);
//        }

}

