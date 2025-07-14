public class SavingsAccount extends Account {
    private double interestRate;
    public SavingsAccount(String ownerName, double balance, double interestRate)
    {
        this.accountNumber = nextAccountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
        this.interestRate = interestRate;
        nextAccountNumber++;
    }
    public void applyInterest()
    {
        if (interestRate > 0 && interestRate  < 1) {
            double interest= balance * interestRate;
            balance += interest;
            System.out.println("Your balance after applying interest is: " + balance);
        }
        else
            System.out.println("Invalid interest rate.");
    }

}
