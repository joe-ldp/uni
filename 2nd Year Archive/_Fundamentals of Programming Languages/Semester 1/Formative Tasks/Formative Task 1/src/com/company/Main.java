package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    static ArrayList<Record> records = new ArrayList<Record>();
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args)
    {
        boolean run = true;
        while (run)
        {
            System.out.println(new String(new char[50]).replace("\0", "\r\n"));

            System.out.println(
                    "Welcome to Phonebook 9000™ Ultimate Enterprise Edition" +
                            "\nPlease select an option from the menu:" +
                            "\n1. List records" +
                            "\n2. Query records by name" +
                            "\n3. Add a record" +
                            "\n4. Edit a record" +
                            "\n5. Delete a record" +
                            "\n6. Exit"
            );

            int choice = Integer.parseInt(in.nextLine());
            System.out.println(new String(new char[50]).replace("\0", "\r\n"));

            switch (choice)
            {
                case 1:
                    List();
                    break;
                case 2:
                    Query();
                    break;
                case 3:
                    AddRecord();
                    break;
                case 4:
                    EditRecord();
                    break;
                case 5:
                    DeleteRecord();
                    break;
                case 6:
                    run = false;
                    break;
            }
        }
    }

    public static int QueryIndex(ArrayList<Record> records, String name)
    {
        for (Record r : records)
        {
            if (r.GetName().equals(name))
            {
                return records.indexOf(r);
            }
        }

        return -1;
    }

    public static void List()
    {
        System.out.println("Records:");
        for (Record r : records)
        {
            System.out.println(r);
        }
        in.nextLine();
    }

    public static void Query()
    {
        System.out.println("Enter a name to look up: ");
        String name = in.nextLine();
        Record r = records.get(QueryIndex(records, name));
        System.out.println(r.toString());
        in.nextLine();
    }

    public static void AddRecord()
    {
        System.out.println("Creating a new record...\nEnter a name:");
        String name = in.nextLine();

        System.out.println("Enter phone number: ");
        String number = in.nextLine();

        Record r = new Record(name, number);
        records.add(r);
    }

    public static void EditRecord()
    {
        System.out.println("Enter a name to find a record to edit:");
        String name = in.nextLine();
        Record r = records.get(QueryIndex(records, name));
        System.out.println("Enter the new phone number:");
        String number = in.nextLine();
        r.EditNumber(number);
        records.set(records.indexOf(r), r);
    }

    public static void DeleteRecord()
    {
        System.out.println("Enter a name to delete its corresponding record");
        String name = in.nextLine();
        records.remove(QueryIndex(records, name));
    }
}