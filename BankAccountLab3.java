//Q3. Create a BankAccount class containing data members for the account number, account holder's name, and balance. Implement methods for making deposits, making withdrawals, and displaying account details. Do not allow a withdrawal if the requested amount exceeds the available balance.

import java.util.Scanner;

public class BankAccount {
    int accountNumber;
    String accountHolderName;
    double balance;

    public void acceptDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Account Number: ");
        accountNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Account Holder Name: ");
        accountHolderName = scanner.nextLine();
        System.out.print("Enter Initial Balance: ");
        balance = scanner.nextDouble();
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: " + amount);
        }
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Withdrawal failed! Amount is greater than available balance.");
        } else if (amount > 0) {
            balance -= amount;
            System.out.println("Successfully withdrawn: " + amount);
        }
    }



public void displayDetails() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Current Balance: " + balance);
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.acceptDetails();
        account.displayDetails();

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter amount to deposit: ");
        double depAmount = scanner.nextDouble();
        account.deposit(depAmount);

        System.out.print("Enter amount to withdraw: ");
        double withAmount = scanner.nextDouble();
        account.withdraw(withAmount);

        account.displayDetails();
        scanner.close();
    }
}
