//Q2.	Create an abstract class Accounts with the following details: 
//Data Members: 
//(a) Balance (b) accountNumber (c) accountHoldersName (d) address 

//Methods: 
//(a) withdrawl()- abstract 
//(b) deposit()- abstract 
//(c) display() to show the balance of the account number 

//Create a subclass of this class SavingsAccount and add the following details: 
//Data Members: 
//(a) rateOfInterest 

//Methods: 
//(a)	calculateAmount() 
//Write the Java program to implement this classes

abstract class Accounts {

    protected double balance;
    protected String accountNumber;
    protected String accountHoldersName;
    protected String address;


    public Accounts(double balance, String accountNumber, String accountHoldersName, String address) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.accountHoldersName = accountHoldersName;
        this.address = address;
    }


    public abstract void withdrawl(double amount);
    public abstract void deposit(double amount);


    public void display() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder's Name: " + accountHoldersName);
        System.out.println("Address: " + address);
        System.out.println("Current Balance: $" + String.format("%.2f", balance));
        System.out.println("\n");
    }
}


class SavingsAccount extends Accounts {
    private double rateOfInterest;


    public SavingsAccount(double balance, String accountNumber, String accountHoldersName, String address, double rateOfInterest) {
        super(balance, accountNumber, accountHoldersName, address);
        this.rateOfInterest = rateOfInterest;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: $" + String.format("%.2f", amount));
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    @Override
    public void withdrawl(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrawn: $" + String.format("%.2f", amount));
        } else if (amount > balance) {
            System.out.println("Withdrawal failed: Insufficient balance.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    public double calculateAmount() {
        double interest = (balance * rateOfInterest) / 100.0;
        double totalAmount = balance + interest;
        System.out.println("Annual Interest (@ " + rateOfInterest + "%): $" + String.format("%.2f", interest));
        System.out.println("Total Amount after 1 Year: $" + String.format("%.2f", totalAmount));
        return totalAmount;
    }
}

public class Main {
    public static void main(String[] args) {
        SavingsAccount myAccount = new SavingsAccount(
            5000.00,
            "SA-654321",
            "Aaron Brooks",
            "123 Elm Street, Springfield",
            4.5
        );

        myAccount.display();

        myAccount.deposit(1500.00);

        myAccount.withdrawl(2000.00);

        myAccount.display();

        myAccount.calculateAmount();
    }
}