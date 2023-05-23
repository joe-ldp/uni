import java.io.File;
import java.io.FileNotFoundException;
import java.util.Queue;
import java.util.Scanner;

public class CustomerData
{
    CustomerData() throws FileNotFoundException
    {
        try (Scanner scanner = new Scanner(new File("BankUserDataset100.csv")))
        {
            //Initialise your members here. After this point, you should already
            //have a ready-to-use "database" for user account information
            scanner.useDelimiter("\r\n");

            while(scanner.hasNext())
            {
                String[] currentLine = scanner.next().split(",");
                String currentID = currentLine[0];
                float currentBalance = Float.parseFloat(currentLine[1]);

                //System.out.println("Loading..."+currentID+"\t£"+currentBalance);

                Customer newCust = new Customer(currentID, currentBalance);
                Main.queue.Push(newCust);

                //Load currentID and currentBalance into your underlying data structure
                //one by one inside the loop. The loop will stop after reading the
                //last data point in the file.

            }

            //System.out.println(queue.toString());
        }
        catch (FileNotFoundException e)
        {
            System.err.println(e.getLocalizedMessage());
        }
    }

    void OpenAccount(String id, float balance)
    {
        if (Main.queue.validID(id) && balance >= 0)
        {
            Main.queue.Push(new Customer(id, balance));
        }
        else
        {
            return;
        }
    }

    void CloseAccount(String id)
    {
        Main.queue.Remove(id);
    }

    void IncreaseBalance(String id, float amount)
    {

    }

    void DecreaseBalance(String id, float amount)
    {

    }

    void DisplayBalance(String id)
    {
        System.out.println();
    }
}