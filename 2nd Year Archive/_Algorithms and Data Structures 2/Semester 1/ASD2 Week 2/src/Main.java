public class Main
{
    public static void main(String[] args)
    {
        /*
        Factorial fac = new Factorial();
        System.out.println(fac.iterativeFactorial(5));
        System.out.println(fac.recursiveFactorial(5));
        */


        int[] data = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        Search s = new Search();
        System.out.println(s.LinearSearch(data, 50));
        System.out.println(s.BinarySearch(data, 30));
    }
}
