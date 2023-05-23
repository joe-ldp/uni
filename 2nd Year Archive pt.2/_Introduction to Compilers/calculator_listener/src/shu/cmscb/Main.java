package shu.cmscb;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import calculator.*;

public class Main {
    public static void main(String[] args) throws Exception {
        ANTLRInputStream input = new ANTLRInputStream(System.in);
        CalculatorLexer lexer = new CalculatorLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CalculatorParser parser = new CalculatorParser(tokens);

        ParseTree tree = parser.prog(); 
        ParseTreeWalker walker = new ParseTreeWalker();

        Worker worker = new Worker();
        walker.walk(worker, tree);
        //System.out.printf("The result is %.2f\n", worker.getAnswer());
        System.out.printf("%s\n", worker.getProgram());
    }
}