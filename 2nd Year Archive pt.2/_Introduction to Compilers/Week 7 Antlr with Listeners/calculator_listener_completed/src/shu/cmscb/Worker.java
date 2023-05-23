package shu.cmscb;

import calculator.*;
import java.util.Stack;

public class Worker extends CalculatorBaseListener {

    private final Stack<Float> memory = new Stack<>();
    private float result;
    public float getResult() { return result; }

    @Override public void exitProg(CalculatorParser.ProgContext ctx) {
        result = memory.pop();
    }

    @Override public void exitAdd(CalculatorParser.AddContext ctx) {
        float result = memory.pop() + memory.pop();
        memory.push(result);
    }

    @Override public void enterOperand(CalculatorParser.OperandContext ctx) {
        if ( ctx.getChildCount() == 1 )
           memory.push(Float.parseFloat( ctx.getText() ));
        else {
            String num = ctx.getChild(0).getText() +"."+ ctx.getChild(2).getText();
            memory.push( Float.parseFloat(num) );
        }
    }
}
