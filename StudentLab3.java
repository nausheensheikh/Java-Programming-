//Q1. Create a Student class with the following data members: roll number, name, and marks. Define methods to accept the student's details, calculate their grade, and display the information.

import java.util.Scanner;

public class Student {
    int roll;
    String name;
    double marks;
    String grade;

    public void acceptDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Roll Number: ");
        roll = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Name: ");
        name = scanner.nextLine();
        System.out.print("Enter Marks: ");
        marks = scanner.nextDouble();
    }

    public void calculateGrade() {
        if (marks >= 90) {
            grade = "A";
        } else if (marks >= 80) {
            grade = "B";
        } else if (marks >= 70) {
            grade = "C";
        } else if (marks >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }
    }

    public void displayDetails() {
        System.out.println("\n--- Student Details ---");
        System.out.println("Roll No: " + roll);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + grade);
    }




public static void main(String[] args) {
        Student student = new Student();
        student.acceptDetails();
        student.calculateGrade();
        student.displayDetails();
    }
}
