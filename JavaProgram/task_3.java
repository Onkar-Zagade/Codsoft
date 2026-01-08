//task 3 :
// ATM Interface

import java.util.Scanner;

class BankAccount {
    private double balance;   

    // Constructor
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(" Successfully deposited ₹" + amount);
        } else {
            System.out.println(" Invalid deposit amount!");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println(" Successfully withdrawn ₹" + amount);
            } else {
                System.out.println(" Insufficient balance! Cannot withdraw ₹" + amount);
            }
        } else {
            System.out.println(" Invalid withdrawal amount!");
        }
    }

    // Method to check balance
    public void checkBalance() {
        System.out.println(" Current Balance: ₹" + balance);
    }
}

// Class representing the ATM Machine
class ATM {
    private BankAccount account;
    private Scanner scanner;

    // Constructor
    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    // Method to display menu and handle user choices
    public void start() {
        while (true) {
            System.out.println("\n Welcome to the ATM");
            System.out.println("1 Withdraw Money");
            System.out.println("2 Deposit Money");
            System.out.println("3 Check Balance");
            System.out.println("4 Exit");
            System.out.print("Please choose an option (1-4): ");
            
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(" Invalid input! Please enter a number between 1 and 4.");
                continue;
            }

            switch (choice) {
                case 1:
                    handleWithdraw();
                    break;
                case 2:
                    handleDeposit();
                    break;
                case 3:
                    account.checkBalance();
                    break;
                case 4:
                    System.out.println(" Thank you for using the ATM. Goodbye!");
                    return; // Exit the loop
                default:
                    System.out.println(" Invalid choice! Please select between 1 and 4.");
            }
        }
    }

    private void handleWithdraw() {
        System.out.print("Enter amount to withdraw: ₹");
        double amount;
        try {
            amount = Double.parseDouble(scanner.nextLine());
            account.withdraw(amount);
        } catch (NumberFormatException e) {
            System.out.println(" Invalid amount entered!");
        }
    }

    private void handleDeposit() {
        System.out.print("Enter amount to deposit: ₹");
        double amount;
        try {
            amount = Double.parseDouble(scanner.nextLine());
            account.deposit(amount);
        } catch (NumberFormatException e) {
            System.out.println(" Invalid amount entered!");
        }
    }
}

// Main class
public class task_3 {
    public static void main(String[] args) {
        // Create a bank account with initial balance (e.g., ₹1000)
        BankAccount userAccount = new BankAccount(1000.0);

        // Create ATM and pass the user account
        ATM atmMachine = new ATM(userAccount);

        // Start the ATM interface
        atmMachine.start();
    }
}