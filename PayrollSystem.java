//Q3. Write a program to implement the Multiple Inheritance kind of framework 
// (Gross Interface, Employee & Salary classes).

interface Gross {
    double calculateGross();
}

class Employee {
    String name;
    
    public Employee(String name) {
        this.name = name;
    }
}

// Salary class inherits Employee and implements Gross
class Salary extends Employee implements Gross {
    double basicPay;
    double hra;
    double da;

    public Salary(String name, double basicPay, double hra, double da) {
        super(name);
        this.basicPay = basicPay;
        this.hra = hra;
        this.da = da;
    }

    @Override
    public double calculateGross() {
        return basicPay + hra + da;
    }

    public void display() {
        System.out.println("Employee Name: " + name);
        System.out.println("Gross Salary: " + calculateGross());
    }
}

public class PayrollSystem {
    public static void main(String[] args) {
        Salary emp = new Salary("Ashish Bohra", 50000, 10000, 5000);
        emp.display();
    }
}