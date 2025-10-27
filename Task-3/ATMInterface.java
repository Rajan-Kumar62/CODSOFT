import java.util.Scanner;


class BankAccount {
    private double balance;

    
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(" Deposit successful! Amount: Rs." + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Withdraw method
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(" Withdrawal successful! Amount: Rs." + amount);
            return true;
        } else if (amount > balance) {
            System.out.println(" Insufficient balance!");
            return false;
        } else {
            System.out.println("Invalid withdrawal amount!");
            return false;
        }
    }

    public double checkBalance() {
        return balance;
    }
}


class ATM {
    private BankAccount account;
    private Scanner scanner;

    
    public ATM(BankAccount account) {
        this.account = account;
        scanner = new Scanner(System.in);
    }

    
    public void start() {
        int choice;
        do {
            System.out.println("\n========== ATM INTERFACE ==========");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using our ATM!");
                    break;
                default:
                    System.out.println(" Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    
    private void checkBalance() {
        System.out.println(" Your current balance is: Rs." + account.checkBalance());
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: Rs.");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: Rs.");
        double amount = scanner.nextDouble();

        
        account.withdraw(amount);
    }
}


public class ATMInterface {
    public static void main(String[] args) {
        System.out.println(" WELCOME TO THE ATM MACHINE!");

        
        BankAccount account = new BankAccount(5000.00);

        ATM atm = new ATM(account);
        atm.start();
    }
}