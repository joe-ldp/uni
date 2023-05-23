import java.util.Scanner;

public class Main
{
    private static int options = 0;
    private static int queueID = 0;
    private static Queue customerQueue =  new Queue();
    private static Customer holder;

    public static void main(String[] args) {
        Scanner inputNum = new Scanner(System.in);
        System.out.println("=============================");
        System.out.println("Telephone Bank Control System");
        System.out.println("=============================");

        while(options!=4){

            System.out.println("1. Queueing a customer");
            System.out.println("2. Get next customer");
            System.out.println("3. Check the queue");
            System.out.println("4. Close the System");

            options =  inputNum.nextInt();
            if (options==1){
                System.out.println("---A new customer joined the line");
                holder = new Customer(queueID++);
                customerQueue.Push(holder);
            }
            if (options==2){
                System.out.println("---Customer information:");
                holder = customerQueue.Pop();
                if (holder != null)
                    holder.PrintInfo();
                else
                    System.out.println("---The queue is empty");
            }
            if (options==3) {
                System.out.println("---There are "+ customerQueue.LengthOfQueue()+" people in the queue:");
                customerQueue.PrintQueue();
            }
        }

    }
}
