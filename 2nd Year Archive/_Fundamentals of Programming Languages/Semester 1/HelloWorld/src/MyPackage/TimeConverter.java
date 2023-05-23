package MyPackage;

import java.util.Scanner;

public class TimeConverter
{
    //    cout << "Enter the time to be converted: ";
    //
    //    int hrs, mins, secs;
    //    cin >> hrs >> mins >> secs;
    //
    //    const int time( (((60 * hrs) + mins) * 60) + secs);
    //    cout << "The original time of ";
    //    cout << hrs << ":" << mins << ":" << secs;
    //    cout << " converts to " << time << " seconds\n";
    //    return( 0);

    public String convertToSeconds()
    {
        int hrs, mins, secs;
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the time to be converted: ");

        hrs = in.nextInt();
        mins = in.nextInt();
        secs = in.nextInt();

        int time = (((60 * hrs) + mins) * 60) + secs;

        StringBuilder sb = new StringBuilder("The original time of ");
        sb.append(hrs).append(" ").append(mins).append(" ").append(secs);
        sb.append(" converts to ");
        sb.append(time);
        sb.append(" seconds");

        return sb.toString();
    }
}
