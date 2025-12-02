import java.util.Scanner;

// Scenario 2
public class BankAccountDemo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        BankAccount acc = new BankAccount("101", 50);
        boolean s2 = true;
        while (s2) {
            System.out.println("\n=== Account " + acc.getAccountID() + "===");
            System.out.println("1) Deposit");
            System.out.println("2) Withdraw");
            System.out.println("3) Account Details");
            System.out.println("4) Exit");
            System.out.print("Choice: ");

            int choice = in.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter deposit amount: ");
                    double amount = in.nextDouble();
                    in.nextLine();
                    if (amount <= 0) {
                        System.out.println("Amount must be greater than zero.");
                        break;
                    }
                    acc.deposit(amount);
                }
                case 2 -> {
                    System.out.print("Enter withdraw amount: ");
                    double amt = in.nextDouble();
                    in.nextLine();
                    if (amt <= 0) {
                        System.out.println("Amount must be greater than zero.");
                        break;
                    }
                    acc.withdraw(amt, in); // ask to borrow if needed
                }
                case 3 -> {
                    acc.accountDetailsSingleCurrency();
                }
                case 4 -> {
                    s2 = false;
                }

                default -> System.out.println("Invalid choice. Try 1â€“4.");
            }
        }

        acc.setAccountID("000009");

        acc.accountDetailsSingleCurrency();

        in.close();
    }
}