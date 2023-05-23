package com.company;

public class Record
{
    private String name;
    private String number;

    public Record(String name_, String number_)
    {
        name = name_;
        number = number_;
    }

    public String GetName()
    {
        return name;
    }

    public String GetNumber()
    {
        return number;
    }

    public void EditNumber(String number_)
    {
        number = number_;
    }

    @Override
    public String toString()
    {
        return "Name: " + name + " | Number: " + number;
    }
}
