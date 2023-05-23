package AssignmentTwo;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        ANTLRInputStream input;
        try {
            input = new ANTLRInputStream(System.in);

            assignmentGrammarLexer lexer = new assignmentGrammarLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            assignmentGrammarParser parser = new assignmentGrammarParser(tokens);
            ParseTree tree = parser.program();
            //System.out.println(tree.toStringTree(parser));

            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(new ShortToUnicodeString(), tree);
            System.out.println();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

