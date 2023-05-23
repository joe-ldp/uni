using System;

namespace Postfix
{
    class Program
    {
        static void Main(string[] args)
        {

        }

        static int ISP(string op)
        {
            switch(op)
            {
                case "+":
                case "-":
                    return 1;
                case "*":
                case "/":
                    return 2;
                case "**":
                    return 3;
                case "(":
                    return 0;
                default:
                    return -1;
            }
        }

        static int ICP(string op)
        {
            switch (op)
            {
                case "+":
                case "-":
                    return 1;
                case "*":
                case "/":
                    return 2;
                case "**":
                    return 3;
                case "(":
                    return 4;
                default:
                    return -1;
            }
        }
    }
}
