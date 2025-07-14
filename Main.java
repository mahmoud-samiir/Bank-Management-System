import java.util.Scanner;

public class Main {
    private static int findAccountNumber(int accountNumber, Account[] accounts) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null && accounts[i].accountNumber == accountNumber) {
                return i; // Return the index of the found account
            }
        }
        return -1; // Not found
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account[] savingAccounts = new Account[10];
        Account[] checkingAccounts = new Account[10];
        int savingCount = 0;
        int checkingCount = 0;
        
        System.out.println("\tWelcome to the Bank Management System");
        while (true) {
            System.out.println("\n1. Savings Account");
            System.out.println("2. Checking Account");
            System.out.println("3. Display Accounts");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            
            switch(choice) 
            {
                case 1:
                    System.out.println("\tSavings Account");
                    System.out.println("1- Create Savings Account");
                    System.out.println("2- Apply Interest to Savings Account");
                    System.out.println("3- Withdraw from Savings Account");
                    System.out.println("4- Deposit to Savings Account");
                    System.out.println("5- Back to Main Menu");
                    System.out.print("Choose an option: ");
                    int savingOption = scanner.nextInt();
                    switch (savingOption)
                    {
                        case 1:
                            System.out.print("Enter owner name: ");
                            String savingOwner = scanner.next();
                            System.out.print("Enter initial balance: ");
                            double savingBalance = scanner.nextDouble();
                            System.out.print("Enter interest rate (0-1): ");
                            double interestRate = scanner.nextDouble();
                            savingAccounts[savingCount++] = new SavingsAccount(savingOwner, savingBalance, interestRate);
                            System.out.println("Savings Account created successfully and your account number is " + savingAccounts[savingCount - 1].accountNumber + ".");
                            break;
                        case 2:
                            System.out.print("Enter account number: ");
                            int accountNumber = scanner.nextInt();
                            int accountIndex = findAccountNumber(accountNumber, savingAccounts);
                            if (accountIndex != -1) {
                                ((SavingsAccount)savingAccounts[accountIndex]).applyInterest();
                            } else {
                                System.out.println("Savings Account not found.");
                            }
                            break;
                        case 3:
                            System.out.println("Enter account number to withdraw from: ");
                            int withdrawAccountNumber = scanner.nextInt();
                            int withdrawIndex = findAccountNumber(withdrawAccountNumber, savingAccounts);
                            if (withdrawIndex != -1) {
                                System.out.println("Enter amount to withdraw: ");
                                double withdrawAmount = scanner.nextDouble();
                                savingAccounts[withdrawIndex].withdraw(withdrawAmount);
                            } else {
                                System.out.println("Savings Account not found.");
                            }
                            break;
                        case 4:
                            System.out.println("Enter account number to deposit to: ");
                            int depositAccountNumber = scanner.nextInt();
                            int depositIndex = findAccountNumber(depositAccountNumber, savingAccounts);
                            if (depositIndex != -1) {
                                System.out.println("Enter amount to deposit: ");
                                double depositAmount = scanner.nextDouble();
                                savingAccounts[depositIndex].deposit(depositAmount);
                            } else {
                                System.out.println("Savings Account not found.");
                            }
                            break;
                        case 5:
                            System.out.println("Exiting Savings Account.");
                            break;
                        default:
                            System.out.println("Invalid option.");
                            break;
                        
                    }
                    break;
                case 2:
                    System.out.println("\tChecking Account");
                    System.out.println("1- Create Checking Account");
                    System.out.println("2- Withdraw from Checking Account");
                    System.out.println("3- Deposit to Checking Account");
                    System.out.println("4- Back to Main Menu");
                    System.out.print("Choose an option: ");
                    int CheckingOption = scanner.nextInt();
                    switch (CheckingOption)
                    {
                        case 1:
                            System.out.print("Enter owner name: ");
                            String checkingOwner = scanner.next();
                            System.out.print("Enter initial balance: ");
                            double checkingBalance = scanner.nextDouble();
                            System.out.print("Enter overdraft limit: ");
                            double overdraftLimit = scanner.nextDouble();
                            checkingAccounts[checkingCount++] = new CheckingAccount(checkingOwner, checkingBalance, overdraftLimit);
                            System.out.println("Checking Account created successfully and your account number is " + checkingAccounts[checkingCount - 1].accountNumber + ".");
                            break;
                        case 2:
                            System.out.println("Enter account number to withdraw from: ");
                            int withdrawAccountNumber = scanner.nextInt();
                            int withdrawIndex = findAccountNumber(withdrawAccountNumber, checkingAccounts);
                            if (withdrawIndex != -1) {
                                System.out.println("Enter amount to withdraw: ");
                                double withdrawAmount = scanner.nextDouble();
                                checkingAccounts[withdrawIndex].withdraw(withdrawAmount);
                            } else {
                                System.out.println("Checking Account not found.");
                            }
                            break;
                        case 3:
                            System.out.println("Enter account number to deposit to: ");
                            int depositAccountNumber = scanner.nextInt();
                            int depositIndex = findAccountNumber(depositAccountNumber, savingAccounts);
                            if (depositIndex != -1) {
                                System.out.println("Enter amount to deposit: ");
                                double depositAmount = scanner.nextDouble();
                                savingAccounts[depositIndex].deposit(depositAmount);
                            } else {
                                System.out.println("Savings Account not found.");
                            }
                            break;
                        case 4:
                            System.out.println("Exiting Checking Account.");
                            break;
                        default:
                            System.out.println("Invalid option.");
                            break;
                        
                    }
                    break;
                case 3:
                    System.out.println("\tDisplay Accounts");
                    System.out.println("Savings Accounts:");
                    for (Account account : savingAccounts) {
                        if (account != null) {
                            System.out.println(account.toString());
                        }
                    }
                    System.out.println("Checking Accounts:");
                    for (Account account : checkingAccounts) {
                        if (account != null) {
                            System.out.println(account.toString());
                        }
                    }
                    break;
                case 4:
                    System.out.println("Exiting the Bank Management System.");
                    scanner.close();
                    return;
                }
            }
            
        }
    }

