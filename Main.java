//Q2. Create a class named “Employee” to store information of an employee (emp_no, name, department, basic_pay, DA, HRA and gross_salary). 
// Write a program, which will take as input the  emp_no, name, department, basic_pay for several employees. 
// The program will calculate the DA, HRA and total for each employee and display the details of the employee having the highest gross salary.

import java.util.Scanner;

class Employee{

    int emp_no;
    String name;
    String department;
    double basic_pay;
    double da;
    double hra;
    double gross_salary;

    public void calculate() {
        da = basic_pay * 0.50;
        hra = basic_pay * 0.20;
        gross_salary = basic_pay + da + hra;
    }

    public void display() {
        System.out.println("Employee No : " + emp_no);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Basic Pay: " + basic_pay);
        System.out.println("DA: " + da);
        System.out.println("HRA: " + hra);
        System.out.println("Gross Salary: " + gross_salary);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the number of employees: ");
        int n = scanner.nextInt();
        
        Employee[] employees = new Employee[n];
        Employee highestPaid = null;
        
        for (int i = 0; i < n; i++) {
            employees[i] = new Employee();
            System.out.println("\nEnter details for employee " + (i + 1) + ":");
            
            System.out.print("Employee No: ");
            employees[i].emp_no = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Name: ");
            employees[i].name = scanner.nextLine();
            
            System.out.print("Department: ");
            employees[i].department = scanner.nextLine();
            
            System.out.print("Basic Pay: ");
            employees[i].basic_pay = scanner.nextDouble();
            
            employees[i].calculate();
            
            if (highestPaid == null || employees[i].gross_salary > highestPaid.gross_salary) {
                highestPaid = employees[i];
            }
        }
        
        System.out.println("\nEmployee with the Highest Gross Salary: ");
        if (highestPaid != null) {
            highestPaid.display();
        }
        
        scanner.close();
    }
}