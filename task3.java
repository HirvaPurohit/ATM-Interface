import java.util.Scanner;

class Bankaccount {
    double balance;

    public Bankaccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + balance);
        } else if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

class ATM {
    private Bankaccount account;

    public ATM(Bankaccount account) {
        this.account = account;
    }

    public void checkBalance() {
        System.out.println("Your current balance is: $" + account.getBalance());
    }

    public void deposit(double amount) {
        account.deposit(amount);
    }

    public void withdraw(double amount) {
        account.withdraw(amount);
    }
}

public class task3 {
    public static void main(String[] args) {
        Bankaccount userAccount = new Bankaccount(1000.0);
        ATM atm = new ATM(userAccount);
        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = s.nextInt();

            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter the withdrawal amount: $");
                    double withdrawAmount = s.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter the deposit amount: $");
                    double depositAmount = s.nextDouble();
                    atm.deposit(depositAmount);
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM.");
                    s.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please select  valid option.");
            }
        }
    }
}
