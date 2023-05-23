using System;

namespace Pascal_s_Triangle
{
    class Program
    {
        static void Main(string[] args)
        {
            PascalsTriangle pt = new PascalsTriangle(25);
            pt.Display();
        }
    }

    class PascalsTriangle
    {
        int[][] rows;

        public PascalsTriangle(int height)
        {
            rows = new int[height][];
            for (int i = 0; i < height; i++) {
                rows[i] = new int[i + 1];
            }
            
            rows[0][0] = 1;

            for (int i = 1; i < height; i++) {
                PopulateRow(i);
            }
        }

        private int Get(int row, int index)
        {
            try {
                return rows[row][index];
            } catch {
                return 0;
            }
        }

        private void PopulateRow(int rowNum)
        {
            for (int i = 0; i < rows[rowNum].Length; i++) {
                int left = Get(rowNum - 1, i - 1);
                int right = Get(rowNum - 1, i);

                rows[rowNum][i] = left + right;
            }
        }

        public void Display()
        {
            for (int i = 0; i < rows.Length; i++) {
                string write = "";
                for (int k = 0; k < rows[i].Length; k++) {
                    write += rows[i][k] + (k < rows[i].Length-1 ? " | " : "");
                }

                Console.SetCursorPosition((Console.WindowWidth - write.Length) / 2, Console.CursorTop);
                Console.WriteLine(write);
            }
        }
    }
}