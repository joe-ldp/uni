public class Factorial
{
    public int iterativeFactorial(int n)
    {
        if (n <= 1) return 1;

        int res = 1;
        for (int i = 1; i <= n; i++)
        {
            res = res * i;
        }

        return res;
    }

    public int recursiveFactorial(int n)
    {
        if (n <= 1) return 1;

        return n * recursiveFactorial(n-1);
    }
}
