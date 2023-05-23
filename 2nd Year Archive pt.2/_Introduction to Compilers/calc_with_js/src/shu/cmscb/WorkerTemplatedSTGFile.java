package shu.cmscb;

import calculator.CalculatorBaseListener;
import calculator.CalculatorParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.antlr.v4.runtime.tree.ParseTree;
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
    public void enterHead(CalculatorParser.HeadContext ctx) {
        ST st = stg.getInstanceOf("funchead");
//        for(int i=0; i<ctx.getChildCount(); ++i)
//            System.out.println(i+" "+ ctx.getChild(i).getText());
        st.add("v", ctx.getChild(1).getText());

        List<String> args = new ArrayList<String>();
        if(ctx.getChildCount() > 4) {
            for (int i=3; i < ctx.getChildCount()-1; ++i)
                args.add(ctx.getChild(i).getText());
            st.add("values", args);
        }

        program.append(st.render());
    }

    @Override
    public void enterRetstat(CalculatorParser.RetstatContext ctx) {
        ST st = stg.getInstanceOf("retstat");
        st.add("v", ctx.getChild(1).getText());
        program.append(st.render());
    }

    @Override
    public void enterFuncall(CalculatorParser.FuncallContext ctx) {
        ST st = stg.getInstanceOf("funcall");
        st.add("v", ctx.getChild(0).getText());
        ParseTree argt = ctx.getChild(2).getChild(0);

// in the following (commented code) I'm trying to figure out which children I want from which node
//        for(int i=0; i<ctx.getChildCount(); ++i)
//          System.out.println(i+": "+ ctx.getChild(i).getText());
//        System.out.println("2: "+ ctx.getChild(2).getChild(0).getChildCount());
//        for(int i=0; i<argt.getChildCount(); ++i)
//            System.out.println(i+": "+ argt.getChild(i).getText());

        List<String> args = new ArrayList<String>();
        if(ctx.getChildCount() > 3) {
            for (int i=0; i < argt.getChildCount(); ++i)
                args.add(argt.getChild(i).getText());
            st.add("values", args);
        }

        program.append(st.render());
    }

}

