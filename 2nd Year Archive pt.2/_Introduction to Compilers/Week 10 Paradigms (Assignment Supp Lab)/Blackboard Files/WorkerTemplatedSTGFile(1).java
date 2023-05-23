package shu.cmscb;

import calculator.CalculatorBaseListener;
import calculator.CalculatorParser;

import java.util.ArrayList;
import java.util.Stack;
import org.stringtemplate.v4.*;


public class WorkerTemplatedSTGFile extends CalculatorBaseListener {
    private StringBuilder program;
    public String getProgram() { return program.toString(); }
    private Stack<String> memory = new Stack<>();
    private ArrayList<String> lines = new ArrayList<>();

    STGroup stg = new STGroupFile("./calculator.stg");

    @Override
    public void enterProg(CalculatorParser.ProgContext ctx) {
        program = new StringBuilder();
        ST st = stg.getInstanceOf("enterProgram");
        program.append(st.render());

    }
    @Override
    public void exitProg(CalculatorParser.ProgContext ctx) {
        ST st = stg.getInstanceOf("exitProgram");

        for (String next : lines)
            program.append(next);

        program.append(st.render());
    }

    @Override
    public void enterAssign(CalculatorParser.AssignContext ctx) {
        // System.out.println(ctx.getChild(0).getText());
        memory.push(ctx.getChild(0).getText());
        ST st = stg.getInstanceOf("assignment");
        //System.out.println("children "+ ctx.getChild(2).getChildCount());
        st.add("ident", ctx.getChild(0).getText());
        if (ctx.getChild(2).getChildCount() == 1)
            st.add("value", ctx.getChild(2).getText());
        program.append(st.render());
    }

    @Override
    public void exitAssign(CalculatorParser.AssignContext ctx) {
        program.append(';');
    }

    public void exitAdd(CalculatorParser.AddContext ctx) {
        ST st = stg.getInstanceOf("add");
        st.add("op2", memory.pop());
        st.add("op1", memory.pop());
        program.append(st.render());
    }

    @Override
    public void enterOperand(CalculatorParser.OperandContext ctx) {
        memory.push(ctx.getText());
    }

    @Override
    public void enterDefn(CalculatorParser.DefnContext ctx) {
        ST st = stg.getInstanceOf("enterDefn");
        st.add("v", ctx.getChild(1).getText());
        program.append(st.render());
    }

//    @Override
//    public void exitDefn(CalculatorParser.DefnContext ctx) {
//        program.append('}');
//    }

    @Override
    public void enterRetstat(CalculatorParser.RetstatContext ctx) {
        ST st = stg.getInstanceOf("return");
        st.add("v", ctx.getChild(1).getText());
        program.append(st.render());
    }

    @Override
    public void exitFuncall(CalculatorParser.FuncallContext ctx){
        ST st = stg.getInstanceOf("funcall");
        st.add("v", ctx.getChild(0).getText());
        program.append(st.render());
    }


}

