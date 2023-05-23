package MyPackage;

public class Main
{
    public static void main(String[] args)
    {
        /*
        HelloWorld hw = new HelloWorld();
        hw.hello("Chris");
        hw.farewell("Jeff");
        */

        /*
        Quotient q = new Quotient();
        q.calculateQuotient();
        System.out.printf("The quotient is %d and the remainder is %d\n", q.getQuotient(), q.getRemainder());
        */

        /*
        TimeConverter tc = new TimeConverter();
        System.out.println(tc.convertToSeconds());
        */

        /*
        Reminder rc = new Reminder();
        rc.showMessage2(args);
        rc.showMessage(args);
        */

        /*
        TimeConverter2 tc2 = new TimeConverter2();

        for (int x = 0; x < 5; x++)
        {
            tc2.inputTimeInHMS();
            tc2.convert();
            System.out.println(tc2.formatOutput());
        }
        */

        Rainfall1 rf1 = new Rainfall1();

        rf1.recordRainfallValues();
        rf1.displayRainfallValues();
        rf1.countRainyDaysInWeek();
    }
}