public abstract class Account
{
    protected int accountNumber;
    protected String ownerName;
    protected double balance;
    static int nextAccountNumber = 0;

    public void deposit(double amt)
    {
        if(amt > 0)
        {
            balance += amt;
            System.out.println("Deposited: " + amt);
        }
        else
        
            System.out.println("Invalid deposit amount.");
    }
    public void withdraw(double amt)
    {
        if(amt > 0 && amt <= balance)
        {
            balance -= amt;
            System.out.println("Withdrawn: " + amt);
        }
        else
        {
            System.out.println("Invalid withdrawal amount.");
        }
    }
    @Override
    public String toString() {
        return "Account [accountNumber=" + accountNumber + ", ownerName=" + ownerName + ", balance=" + balance + "]";
    }
    
}