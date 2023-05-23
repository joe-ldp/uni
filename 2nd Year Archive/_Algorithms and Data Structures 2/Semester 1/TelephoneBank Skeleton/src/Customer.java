import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Random;

public class Customer
{
    private static final Random RANDOM = new Random();//For generating random request
    private static final String[] Request  = new String[]
    {
        "Check Balance",
        "Pay Credit Card",
        "Transfer money",
        "Set up Direct Debit",
        "Open new account",
        "Close my account",
        "Change personal information"
    };
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss");

    private int queueID;
    private String time;
    private String request;

    public Customer(int queueID)
    {
        this.queueID = queueID;
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        time = sdf.format(timestamp);
        request = Request[RANDOM.nextInt(Request.length)];
    }

    public void PrintInfo()
    {
        System.out.println("Queue ID:"+queueID+" Time:"+time+" Request:"+request);
    }
}
