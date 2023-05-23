package Main;

import DOM.DOMAsTree;
import DOM.DomToList;

public class Main
{
    private String file;

    public static void main(String[] args)
    {
        Main main = new Main();
        main.run();
    }

    Main()
    {
        file = "poem.xml";
    }

    public void run()
    {
        try
        {
            DOMAsTree domParser = new DOMAsTree(file);
            domParser.parse();

            DomToList toList = new DomToList(file);

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}