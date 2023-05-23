public class Customer
{
    private String ID;
    private float balance;

    public String getID()
    {
        return this.ID;
    }

    public float getBalance()
    {
        return this.balance;
    }

    public void displayBalance()
    {
        System.out.println("Customer " + this.ID + " has a balance of " + this.balance);
    }

    public void setBalance(float balance)
    {
        this.balance = balance;
    }

    public void Save(float amount)
    {
        if (amount > 0) this.balance += amount;
    }

    public void Withdraw(float amount)
    {
        if (amount > 0) this.balance -= amount;
    }

    public Customer(String ID, float balance)
    {
        this.ID = ID;
        this.balance = balance;
    }

    @Override
    public String toString()
    {
        return  ("Customer ID: " + ID + ", balance: " + balance);
    }
}