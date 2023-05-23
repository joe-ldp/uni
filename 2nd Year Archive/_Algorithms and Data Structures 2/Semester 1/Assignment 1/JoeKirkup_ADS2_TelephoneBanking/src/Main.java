import java.io.FileNotFoundException;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The telephone Banking System is an assignment for Algorithms and Data Structure 2
 * @author Jing Wang @ SHU
 * @version 1.1
 */

public class Main
{
    //State Machine parameters
    public enum State{START, STOP, WELCOME, LIST_ALL, PUSH, POP, TASK, REMOVE, NEW, SAVE, WITHDRAW, DISPLAY};
    public static State currentState = State.START;

    //Global variables
    public static Scanner inputOrder = new Scanner(System.in);
    public static Scanner inputID = new Scanner(System.in);
    public static CustomerQueue queue;
    public static CustomerData userData;
    public static CustomerRequest currentRequest = new CustomerRequest();

    public static void main(String[] args) throws FileNotFoundException
    {
        while (currentState != State.STOP)
        {
            switch (currentState)
            {
                default: break;
                case START:     state_start();
                    break;
                case WELCOME:   state_welcome();
                    break;
                case LIST_ALL:  state_Q_listAll();
                    break;
                case PUSH:      state_Q_push();
                    break;
                case POP:       state_Q_pop();
                    break;
                case TASK:      state_task();
                    break;
                case REMOVE:    state_H_remove();
                    break;
                case NEW:       state_H_new();
                    break;
                case SAVE:      state_H_saveMoney();
                    break;
                case WITHDRAW:  state_H_reduceMoney();
                    break;
                case DISPLAY:   state_H_display();
                    break;
            }
        }

        clear();
    }

    private static void state_start() throws FileNotFoundException
    {
        /*CustomerQueue ll = new CustomerQueue();
        ll.Push(new Customer("1", 100));
        Customer jeff = new Customer("7", 106);
        ll.Push(new Customer("2", 101));
        ll.Push(new Customer("3", 102));
        ll.Push(new Customer("4", 103));
        ll.Push(new Customer("5", 104));
        ll.Push(new Customer("6", 105));
        ll.Push(jeff);

        ll.Remove(jeff.getID());

        System.out.println(ll.toString());*/

        System.out.println("System Initialization...");
        System.out.println("Initializing queue...");
        queue = new CustomerQueue();
        System.out.println("Load customer database...");
        userData = new CustomerData();
        currentState = State.WELCOME;
    }

    private static void state_welcome()
    {
        System.out.println("\n\n\n==Telephone Banking Control Centre==");
        System.out.println("Choose the index number from following options:\n1. Get the next customer\n2. Queueing a new customer\n3. Check current queue\n4. Quit");
        if (inputOrder.hasNext("1")) currentState = State.POP;
        if (inputOrder.hasNext("2")) currentState = State.PUSH;
        if (inputOrder.hasNext("3")) currentState = State.LIST_ALL;
        if (inputOrder.hasNext("4")) currentState = State.STOP;
        inputOrder.next();
    }

    private static void state_Q_listAll()
    {
        //System.err.println("'List all the customers' function is not implemented");//Delete this statement after the function is fully developed
        System.out.println(queue.toString());
        currentState = State.WELCOME;
    }

    private static void state_Q_push()
    {
        System.err.println("'Push a new customer to the queue' function is not implemented");//Delete this statement after the function is fully developed
        CustomerRequest newRequest = new CustomerRequest();
        //newRequest.newRequest();//replace this statement by your Push function

        userData.OpenAccount(newRequest.id, (float)newRequest.amountToChange);

        currentState = State.WELCOME;
    }

    private static void state_Q_pop()
    {
        //System.err.println("'Pop a new customer from the queue' function is not implemented");//Delete this statement after the function is fully developed

        currentRequest.newRequest();//replace this statement by your Pop function

        currentState = State.TASK;//Uncomment this statement after the Pop function is fully developed
        //currentState = State.WELCOME;//Delete this statement after the function is fully developed
    }

    private static void state_task()
    {
        System.out.print("This customer want to ");

        switch (currentRequest.request)
        {
            default: break;

            case 0: System.out.println("open a new account");
                System.out.println("Please input a new account ID:");
                currentRequest.id = inputID.nextLine();
                currentState = State.NEW;
                break;
            case 1: System.out.println("close the account");
                System.out.println("Please input the account ID:");
                currentRequest.id = inputID.nextLine();
                currentState = State.REMOVE;
                break;
            case 2: System.out.println("check balance");
                System.out.println("Please input the account ID:");
                currentRequest.id = inputID.nextLine();
                currentState = State.DISPLAY;
                break;
            case 3: System.out.println("save £"+currentRequest.amountToChange);
                System.out.println("Please input the account ID:");
                currentRequest.id = inputID.nextLine();
                currentState = State.SAVE;
                break;
            case 4: System.out.println("withdraw £"+currentRequest.amountToChange);
                System.out.println("Please input the account ID:");
                currentRequest.id = inputID.nextLine();
                currentState = State.WITHDRAW;
                break;
        }
    }

    private static void state_H_remove()
    {
        //System.err.println("'Close Account' function is not implemented");//Delete this statement after the function is fully developed
        //pop from queue and do not save return
        queue.Pop();
        currentState = State.WELCOME;
    }

    private static void state_H_new()
    {
        //System.err.println("'Open New Account' function is not implemented");//Delete this statement after the function is fully developed
        //push to queue
        userData.OpenAccount(currentRequest.id, (float)currentRequest.amountToChange);
        currentState = State.WELCOME;
    }

    private static void state_H_saveMoney()
    {
        //System.err.println("'Save Money' function is not implemented");//Delete this statement after the function is fully developed
        //pop from queue, save, and increase balance by amount
        Customer cust = queue.Pop().GetCust();
        cust.displayBalance();
        cust.Save((float)currentRequest.amountToChange);
        cust.displayBalance();
        currentState =  State.DISPLAY;
    }

    private static void state_H_reduceMoney()
    {
        //System.err.println("'Withdraw Money' function is not implemented");//Delete this statement after the function is fully developed
        //pop from queue, save, and decrease balance by amount
        Customer cust = queue.Pop().GetCust();
        cust.displayBalance();
        cust.Withdraw((float)currentRequest.amountToChange);
        cust.displayBalance();
        currentState = State.DISPLAY;

    }

    private static void state_H_display()
    {
        //System.err.println("'Show Balance' function is not implemented");//Delete this statement after the function is fully developed
        //pop from queue, save, and print balance
        Customer cust = queue.Pop().GetCust();
        cust.displayBalance();
        currentState = State.WELCOME;
    }

    private static void clear()
    {
        System.out.println("Clearing data...");
        //Deleted by the Garbage collector.
        queue = null;
        userData = null;
        System.out.println("===See you next time===");
    }
}