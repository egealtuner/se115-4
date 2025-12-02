import java.util.Scanner;

// Scenario 2
public class BankAccount {
    private String accountID;
    private double balance;

    // Parameterized constructor
    public BankAccount(String accountID, double balance) {
        this.accountID = accountID;
        this.balance = balance;
    }

    public String getAccountID() {
        return accountID;
    }
    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }


    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Deposit amount must be greater than zero.");
        }
    }

    public void withdraw(double amount, Scanner in) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance! Trying to withdraw " + amount +
                    ". Current Balance: " + balance);
            System.out.print("Do you want to borrow and go negative? (y/n): ");
            String choice = in.nextLine();
            if (choice.equalsIgnoreCase("y")) {
                balance -= amount;
                System.out.println("Borrowing allowed. Withdrawn: " + amount );
            } else {
                System.out.println("Transaction cancelled. Insufficient balance!");
            }
        }
    }

    public void accountDetailsSingleCurrency(){
        System.out.println(
                "Account ID: " + getAccountID() +
                        "| Balance: " + getBalance()
        );
    }
}