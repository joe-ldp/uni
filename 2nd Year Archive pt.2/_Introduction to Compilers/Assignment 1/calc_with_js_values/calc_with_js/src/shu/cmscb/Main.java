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
        WorkerDirectPrint worker = new WorkerDirectPrint();
        //WorkerTemplatedSTGFile worker = new WorkerTemplatedSTGFile();
        walker.walk(worker, tree);
        walker.toString();
        System.out.println( "\n\n"+ worker.getProgram() );
    }
}