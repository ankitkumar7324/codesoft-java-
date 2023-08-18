import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double checkBalance() {
        return balance;
    }
}

class ATM {
    private BankAccount bankAccount;
    private Scanner sc;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        this.sc = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void run() {
        while (true) {
            displayMenu();
            System.out.print("Please select an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    withdrawMenu();
                    break;
                case 2:
                    depositMenu();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void withdrawMenu() {
        System.out.print("Enter the amount to withdraw: ");
        double amount = sc.nextDouble();
        if (bankAccount.withdraw(amount)) {
            System.out.printf("Withdrawal of Rs.%.2f successful.%n", amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void depositMenu() {
        System.out.print("Enter the amount to deposit: ");
        double amount = sc.nextDouble();
        if (bankAccount.deposit(amount)) {
            System.out.printf("Deposit of RS.%.2f successful.%n", amount);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    public void checkBalance() {
        double balance = bankAccount.checkBalance();
        System.out.printf("Your account balance is $%.2f%n", balance);
    }
}

public class TASK4 {
    public static void main(String[] args) {
        // Creating a bank account instance
        BankAccount userAccount = new BankAccount(0);

        // Creating an ATM instance and connecting it to the bank account
        ATM atm = new ATM(userAccount);

        // Running the ATM
        atm.run();
    }
}
