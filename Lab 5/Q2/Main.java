//Q1. Write a program to implement the Multiple Inheritance kind of framework (Bank Interface, Customer & Account classes).

interface Bank {
    void displayBankDetails();
}

class Customer implements Bank {
    private String customerName;
    private String customerId;

    public Customer(String customerName, String customerId) {
        this.customerName = customerName;
        this.customerId = customerId;
    }

    @Override
    public void displayBankDetails() {
        System.out.println("Bank: ICICI Bank Ltd.");
        System.out.println("Customer ID: " + customerId);
        System.out.println("Customer Name: " + customerName);
    }
}

class Account implements Bank {
    private long accountNumber;
    private double balance;

    public Account(long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    @Override
    public void displayBankDetails() {
        System.out.println("Bank: ICICI Bank Ltd.");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Balance: Rs " + balance);
    }
}

public class Main {
    public static void main(String[] args) {
        Bank customer = new Customer("Bhavya Patel", "100025");
        Bank account = new Account(70512100007L, 85000.0);

        System.out.println("Customer Information: \n");
        customer.displayBankDetails();

        System.out.println("\nAccount Information: \n");
        account.displayBankDetails();
    }
}