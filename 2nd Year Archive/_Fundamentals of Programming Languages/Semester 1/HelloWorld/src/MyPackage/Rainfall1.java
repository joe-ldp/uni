package MyPackage;

import java.util.Scanner;

public class Rainfall1
{
    double rain[] = new double[7];
    Scanner in = new Scanner(System.in);


    public void recordRainfallValues()
    {
        int dayNo = 0;

        System.out.println("\nEnter the rainfall values: ");
        while (dayNo < 7)
        {
            System.out.printf("\nFor day #%d: ", dayNo);
            rain[dayNo] = in.nextInt();
            ++dayNo;
        }
    }

    public void displayRainfallValues()
    {
        System.out.println();
        int dayNo = 0;
        while (dayNo < 7)
        {
            System.out.printf("\nDay #%d: \t %4.4f mm", dayNo, rain[dayNo]);
            ++dayNo;
        }
    }

    public void countRainyDaysInWeek()
    {
        int dayNo = 0;
        int count = 0;
        while ( dayNo < 7)
        {
            if ( rain[dayNo] > 0.0)
                ++count;
            ++dayNo;
        }
        System.out.printf("\nThere were %d rainy days in the week.", count);
    }
}
