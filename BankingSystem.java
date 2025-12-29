import java.util.ArrayList;
import java.util.Scanner;

class Account {
    int accountNumber;
    String name;
    double balance;

    Account(int accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }
}

public class BankingSystem {

    static ArrayList<Account> accounts = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== Banking System =====");
            System.out.println("1. Create Account");
            System.out.println("2. View Accounts");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    viewAccounts();
                    break;
                case 3:
                    depositMoney();
                    break;
                case 4:
                    withdrawMoney();
                    break;
                case 5:
                    System.out.println("Thank you for using Banking System");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
    static void createAccount() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        if (balance < 0) {
            System.out.println("Initial balance cannot be negative!");
            return;
        }

        accounts.add(new Account(accNo, name, balance));
        System.out.println("Account created successfully!");
    }
    static void viewAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
            return;
        }

        for (Account a : accounts) {
            System.out.println(
                "Account No: " + a.accountNumber +
                ", Name: " + a.name +
                ", Balance: " + a.balance
            );
        }
    }
    static void depositMoney() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        Account account = findAccount(accNo);

        if (account == null) {
            System.out.println("Account not found!");
            return;
        }

        System.out.print("Enter Deposit Amount: ");
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("Deposit amount must be greater than 0!");
            return;
        }

        account.balance += amount;
        System.out.println("Amount deposited successfully!");
        System.out.println("Current Balance: " + account.balance);
    }
    static void withdrawMoney() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        Account account = findAccount(accNo);

        if (account == null) {
            System.out.println("Account not found!");
            return;
        }

        System.out.print("Enter Withdraw Amount: ");
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("Withdraw amount must be greater than 0!");
            return;
        }

        if (amount > account.balance) {
            System.out.println("Insufficient balance!");
            return;
        }

        account.balance -= amount;
        System.out.println("Amount withdrawn successfully!");
        System.out.println("Remaining Balance: " + account.balance);
    }
    static Account findAccount(int accNo) {
        for (Account a : accounts) {
            if (a.accountNumber == accNo) {
                return a;
            }
        }
        return null;
    }
}
