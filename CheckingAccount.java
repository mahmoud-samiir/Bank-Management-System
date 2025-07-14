public class CheckingAccount extends Account
{
    private double overdraftLimit;
    public CheckingAccount(String ownerName, double balance, double overdraftLimit)
    {
        this.accountNumber = nextAccountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
        this.overdraftLimit = overdraftLimit;
        nextAccountNumber++;
    }
    public void withdraw (double amt)
    {
        if (amt > 0 && amt <= (balance + overdraftLimit))
        {
            balance -= amt;
            System.out.println("Withdrawn: " + amt);
        }
        else
        {
            System.out.println("Overdraft limit exceeded.");
        }
    }
    
}
