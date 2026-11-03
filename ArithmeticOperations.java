//Q3. Write a Java program to perform arithmetic operations like addition, subtraction, multiplication and division.

import java.util.Scanner;
public class ArithmeticOperations {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int num1 = input.nextInt();

        System.out.print("Enter the second number: ");
        int num2 = input.nextInt();

        System.out.print("Pick an arithmetic operation:\n1. Addition\n2. Subtraction\n3. Multiplication\n4. Division\n");
        int choice = input.nextInt();
        if (choice == 1) {
            System.out.println("Addition: " + (num1 + num2));
        }
        else if (choice == 2) {
            System.out.println("Subtraction: " + (num1 - num2));
        }
        else if (choice == 3) {
            System.out.println("Multiplication: " + (num1 * num2));
        }
        else if (choice == 4) {
                 if (num2 != 0) {
                System.out.println("Division: " + (num1 / num2));
            } else {
                System.out.println("Cannot divide by zero!");
            }
        }
        else {
            System.out.println("Invalid choice. Please select 1, 2, 3, or 4.");
        }

        input.close();
    }
}
