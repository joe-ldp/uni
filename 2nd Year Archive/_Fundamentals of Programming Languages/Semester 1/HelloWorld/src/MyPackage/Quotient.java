package MyPackage;

import java.util.Scanner;

public class Quotient {
    private int remainder;
    private int quotient;

    public void calculateQuotient()
    {
        int num1, num2;
        num1 = getIntValue("Enter your first integer: ");
        num2 = getIntValue("Enter your second integer: ");

        setQuotient(num1 / num2);
        setRemainder(num1 % num2);

        //System.out.println("The quotient is " + getQuotient() + " and the remainder is " + getRemainder());
    }

    private int getIntValue(String prompt)
    {
        int val = -1;
        Scanner in = new Scanner(System.in);

        do
        {
            try
            {
                System.out.println(prompt);
                val = Integer.parseInt(in.nextLine());
            }
            catch (NumberFormatException e)
            {
                System.out.println("Please only enter a valid positive integer");
                val = -1;
            }
        } while(val == -1);

        return val;
    }

    public int getRemainder() {
        return remainder;
    }

    public void setRemainder(int remainder) {
        this.remainder = remainder;
    }

    public int getQuotient() {
        return quotient;
    }

    public void setQuotient(int quotient) {
        this.quotient = quotient;
    }
}