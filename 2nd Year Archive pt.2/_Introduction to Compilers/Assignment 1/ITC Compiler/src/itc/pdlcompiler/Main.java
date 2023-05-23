package itc.pdlcompiler;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import itc.pdl.*;

public class Main {

    public static void main(String[] args) throws Exception {
        ANTLRInputStream input = new ANTLRInputStream(System.in);
        pdlLexer lexer = new pdlLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        pdlParser parser = new pdlParser(tokens);

        ParseTree tree = parser.program();
        ParseTreeWalker walker = new ParseTreeWalker();
        Worker worker = new Worker();
        walker.walk(worker, tree);
        System.out.println("\n\n"+ worker.getProgram());
    }
}
