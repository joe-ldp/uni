package GrammarUser;

import java.io.IOException;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import hello.*;

public class Main {

    public static void main(String[] args) {
        ANTLRInputStream input;
        try {
            System.out.println("Enter your greeting ");
            input = new ANTLRInputStream(System.in);

            HelloLexer lexer = new HelloLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            HelloParser parser = new HelloParser(tokens);
            ParseTree tree = parser.r(); // begin parsing at rule 'r'
            System.out.println(tree.toStringTree(parser));

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

