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
            System.out.println("3. Exit");
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
}
