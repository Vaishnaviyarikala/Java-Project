import java.util.Scanner;

// Class to represent a bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited $" + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew $" + amount);
            return true;
        } else if (amount > balance) {
            System.out.println("Insufficient balance. Transaction failed.");
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
        return false;
    }
}

// Class to represent the ATM machine
class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        System.out.println("\n--- ATM Menu ---");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void performOperation(int choice) {
        Scanner scanner = new Scanner(System.in);
        switch (choice) {
            case 1:
                System.out.print("Enter amount to withdraw: $");
                double withdrawAmount = scanner.nextDouble();
                account.withdraw(withdrawAmount);
                break;

            case 2:
                System.out.print("Enter amount to deposit: $");
                double depositAmount = scanner.nextDouble();
                account.deposit(depositAmount);
                break;

            case 3:
                System.out.println("Your current balance is: $" + account.getBalance());
                break;

            case 4:
                System.out.println("Thank you for using the ATM. Goodbye!");
                break;

            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}

// Main class to test the implementation
public class ATMSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize the bank account with an initial balance
        BankAccount userAccount = new BankAccount(1000.00); // Starting balance of $1000
        ATM atm = new ATM(userAccount);

        boolean exit = false;
        while (!exit) {
            atm.displayMenu();
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            if (choice == 4) {
                exit = true;
            } else {
                atm.performOperation(choice);
            }
        }

        scanner.close();
    }
}