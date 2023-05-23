using System;

namespace Singly_Linked_List
{
    class Program
    {
        static int[] data;
        static int[] link;
        static int LIST_LENGTH = 100;
        static int AV;

        static void Main(string[] args)
        {
            init(LIST_LENGTH);
            create1(ref AV, 1);
            print(data, link, AV);
        }

        static void init(int n)
        {
            data = new int[LIST_LENGTH + 1];
            link = new int[LIST_LENGTH + 1];

            for (int i = 0; i < n; i++)
            {
                link[i] = i + 1;
                //data[i] = i;
            }
            link[n-1] = 0;
            AV = 1;
        }

        static int getNode(ref int x)
        {
            if (AV == 0)
            {
                Console.WriteLine("Warning: getNode was called when AV is 0");
                return -1;
            }
            x = AV;
            AV = link[AV];
            
            return -1;
        }
        
        static void print(int[] data, int[] link, int start)
        {
            /*for (int pointer = start; pointer != 0; pointer = link[pointer])
            {
                Console.WriteLine(data[pointer]);
            }*/
            int pointer = start;
            do
            {
                Console.WriteLine(data[pointer]);
                pointer = link[pointer];
            } while (pointer != 0);
        }

        static void create1(ref int start, int item)
        {
            int pointer = 0;
            getNode(ref pointer);
            start = pointer;
            data[pointer] = item;
            link[pointer] = 0;
        }
    }
}
