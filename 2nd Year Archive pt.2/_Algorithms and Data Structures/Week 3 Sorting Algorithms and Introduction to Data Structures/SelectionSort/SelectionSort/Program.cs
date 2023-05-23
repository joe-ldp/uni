using System;

namespace SelectionSort
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] a = new int[] { 3, 7, 4, 9, 5, 2, 6, 1 };
            PrintArray(ref a);
            SelectionSort(ref a, a.Length);
            PrintArray(ref a);
        }

        static void SelectionSort(ref int[] a, int n)
        {
            int minimum;

            for (int i = 0; i < n; i++)
            {
                minimum = i; // effective size of unsorted array

                for (int j = i + 1; j < n; j++)
                {
                    if (a[j] < a[minimum])
                    {
                        minimum = j;
                    }
                }

                swap(ref a[minimum], ref a[i]);
            }
        }

        static void swap(ref int a, ref int b)
        {
            int temp = a;
            a = b;
            b = temp;
        }

        static void PrintArray(ref int[] a)
        {
            foreach (int i in a)
            {
                Console.Write(i + ", ");
            }
            Console.WriteLine();
        }
    }
}
