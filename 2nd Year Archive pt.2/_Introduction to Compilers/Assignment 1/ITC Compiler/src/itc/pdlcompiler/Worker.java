package itc.pdlcompiler;

import itc.pdl.pdlBaseListener;
import itc.pdl.pdlParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.antlr.v4.runtime.tree.ParseTree;
import org.stringtemplate.v4.*;

public class Worker extends pdlBaseListener {

    private StringBuilder program;
    private Stack<String> memory = new Stack<>();
    private ArrayList<String> lines = new ArrayList<>();
    public String getProgram() { return program.toString(); }

    STGroup stg = new STGroupFile("./pdl.stg");

    @Override public void enterProgram(pdlParser.ProgramContext ctx) {
        program = new StringBuilder();
        ST st = stg.getInstanceOf("enterProgram");
        program.append(st.render());
    }

    @Override public void exitProgram(pdlParser.ProgramContext ctx) {
        ST st = stg.getInstanceOf("exitProgram");
        program.append(st.render());
    }

    @Override public void enterProgramHeader(pdlParser.ProgramHeaderContext ctx) { }

    @Override public void exitProgramHeader(pdlParser.ProgramHeaderContext ctx) { }

    @Override public void enterGlobals(pdlParser.GlobalsContext ctx) {
        for (int i = 1; i < ctx.getChildCount(); i += 2) {
            ST st = stg.getInstanceOf("globals");
            st.add("ident", ctx.getChild(i).getText());
            program.append(st.render());
        }
    }

    @Override public void exitGlobals(pdlParser.GlobalsContext ctx) { }

    @Override public void enterProgramEnds(pdlParser.ProgramEndsContext ctx) { }

    @Override public void exitProgramEnds(pdlParser.ProgramEndsContext ctx) { }

    @Override public void enterBlock(pdlParser.BlockContext ctx) { }

    @Override public void exitBlock(pdlParser.BlockContext ctx) {
        ST st = stg.getInstanceOf("exitBlock");
        program.append(st.render());
    }

    @Override public void enterProcDefun(pdlParser.ProcDefunContext ctx) {
        ST st = stg.getInstanceOf("enterProcDefun");
        st.add("ident", ctx.getText());
        program.append(st.render());
    }

    @Override public void exitProcDefun(pdlParser.ProcDefunContext ctx) {
        ST st = stg.getInstanceOf("exitProcDefun");
        program.append(st.render());
    }

    @Override public void enterComparator(pdlParser.ComparatorContext ctx) {
        ST st = stg.getInstanceOf("comparator");
        st.add("comparator", ctx.getText());
        program.append(st.render());
    }

    @Override public void exitComparator(pdlParser.ComparatorContext ctx) { }

    @Override public void enterMath(pdlParser.MathContext ctx) {
        ST st = stg.getInstanceOf("math");
        st.add("math", ctx.getText());
        program.append(st.render());
    }

    @Override public void exitMath(pdlParser.MathContext ctx) { }

    @Override public void enterOutputStatement(pdlParser.OutputStatementContext ctx) {
        ST st = stg.getInstanceOf("outputStatement");
        String str = ctx.getChild(2).getText();
        str = str.substring(1, str.length() - 1);
        st.add("string", str);
        for (int i = 4; i < ctx.getChildCount(); i += 2) {
            st.add("idents", ctx.getChild(i));
        }
        program.append(st.render());
    }

    @Override public void exitOutputStatement(pdlParser.OutputStatementContext ctx) { }

    @Override public void enterInputStatement(pdlParser.InputStatementContext ctx) {
        ST st = stg.getInstanceOf("inputStatement");
        st.add("ident", ctx.getChild(2).getText());
        program.append(st.render());
    }

    @Override public void exitInputStatement(pdlParser.InputStatementContext ctx) { }

    @Override public void enterProcedureCall(pdlParser.ProcedureCallContext ctx) {
        ST st = stg.getInstanceOf("procedureCall");
        st.add("ident", ctx.getChild(1).getText());
        for (int i = 2; i < ctx.getChildCount(); i += 2) {
            st.add("args", ctx.getChild(i));
        }
        program.append(st.render());
    }

    @Override public void exitProcedureCall(pdlParser.ProcedureCallContext ctx) { }

    @Override public void enterExpr(pdlParser.ExprContext ctx) {
        ST st = stg.getInstanceOf("expr");
        if (ctx.getChildCount() == 1)
            st.add("ident", ctx.getChild(0).getText());
        else {
            st.add("ident", ctx.getChild(1).getText());
            st.add("math", ctx.getChild(3).getText());
            st.add("value", ctx.getChild(4).getText());
        }
        program.append(st.render());
    }

    @Override public void exitExpr(pdlParser.ExprContext ctx) { }

    @Override public void enterAssignment(pdlParser.AssignmentContext ctx) {
        ST st = stg.getInstanceOf("assignment");
        st.add("ident", ctx.getChild(1).getText());
        st.add("expr", ctx.getChild(3).getText());
        program.append(st.render());
    }

    @Override public void exitAssignment(pdlParser.AssignmentContext ctx) { }

    @Override public void enterWhileLoop(pdlParser.WhileLoopContext ctx) {
        ST st = stg.getInstanceOf("enterWhileLoop");
        st.add("ident", ctx.getChild(0).getText());
        st.add("comparator", ctx.getChild(1).getText());
        st.add("value", ctx.getChild(2).getText());
        program.append(st.render());
    }

    @Override public void exitWhileLoop(pdlParser.WhileLoopContext ctx) {
        ST st = stg.getInstanceOf("exitWhileLoop");
        program.append(st.render());
    }

    @Override public void enterIfElse(pdlParser.IfElseContext ctx) {
        ST st = stg.getInstanceOf("enterIfElse");
        st.add("ident", ctx.getChild(2).getText());
        st.add("comparator", ctx.getChild(3).getText());
        st.add("value", ctx.getChild(4).getText());
        for (int i = 7; i < ctx.getChildCount(); i++) {
            st.add("ifBlocks", ctx.getChild(i).getText());
        }
        program.append(st.render());
    }

    @Override public void exitIfElse(pdlParser.IfElseContext ctx) {
        ST st = stg.getInstanceOf("exitIfElse");
        program.append(st.render());
    }

    @Override public void enterValue(pdlParser.ValueContext ctx) {
        ST st = stg.getInstanceOf("value");
        st.add("value", ctx.getText());
        program.append(st.render());
    }

    @Override public void exitValue(pdlParser.ValueContext ctx) { }
}
