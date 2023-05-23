package MyPackage;

import java.util.Scanner;

public class TimeConverter2
{
    private int hrs;
    private int mins;
    private int secs;
    private int time;
    private Scanner in = new Scanner(System.in);

    public void inputTimeInHMS()
    {
        boolean done = false;
        do
        {
            System.out.println("Enter the time to be converted in HH:MM:SS: ");

            String input = in.nextLine();
            String[] split = input.split(":");

            hrs = Integer.parseInt(split[0]);
            mins = Integer.parseInt(split[1]);
            secs = Integer.parseInt(split[2]);

            done = validateRange(hrs, 0, 23) && validateRange(mins, 0, 59) && validateRange(secs, 0, 59);
        } while (!done);


    }

    public String formatOutput()
    {
        /*StringBuilder sb = new StringBuilder("The original time of ");
        sb.append(getHrs()).append(" ").append(getMins()).append(" ").append(getSecs());
        sb.append(" converts to ");
        sb.append(getTime());
        sb.append(" seconds");*/

        String s = String.format("The original time of %d:%d:%d converts to %d seconds", getHrs(), getMins(), getSecs(), getTime());
        return s;

        //return sb.toString();
    }

    private boolean validateRange(int num, int min, int max)
    {
        return (num > min && num < max);
    }

    public void convert()
    {
        setTime((((60 * getHrs()) + getMins()) * 60) + getSecs());
    }

    public int getHrs() {
        return hrs;
    }

    public void setHrs(int hrs) {
        this.hrs = hrs;
    }

    public int getMins() {
        return mins;
    }

    public void setMins(int mins) {
        this.mins = mins;
    }

    public int getSecs() {
        return secs;
    }

    public void setSecs(int secs) {
        this.secs = secs;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
