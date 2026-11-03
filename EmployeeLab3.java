//Q4. Create an Employee class with data members for employee ID, name, basic salary, HRA, DA, and gross salary. Write a method to calculate the gross salary where HRA is 20% of the basic salary, DA is 10% of the basic salary, and the gross salary is the sum of the basic salary, HRA, and DA.

import java.util.Scanner;

public class Employee {
    int empId;
    String name;
    double basicSalary;
    double hra;
    double da;
    double grossSalary;



public void acceptDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Employee ID: ");
        empId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Employee Name: ");
        name = scanner.nextLine();
        System.out.print("Enter Basic Salary: ");
        basicSalary = scanner.nextDouble();
    }

    public void calculateSalary() {
        hra = 0.20 * basicSalary;
        da = 0.10 * basicSalary;
        grossSalary = basicSalary + hra + da;
    }

    public void displayDetails() {
        System.out.println("\n--- Employee Details ---");
        System.out.println("Employee ID: " + empId);
        System.out.println("Name: " + name);
        System.out.println("Basic Salary: " + basicSalary);
        System.out.println("HRA (20%): " + hra);
        System.out.println("DA (10%): " + da);
        System.out.println("Gross Salary: " + grossSalary);
    }

    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.acceptDetails();
        emp.calculateSalary();
        emp.displayDetails();
    }
}
