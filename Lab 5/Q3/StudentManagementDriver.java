//Q3.	Create an interface Department containing attributes deptName and deptHead. 
// It also has abstract methods for printing the attributes. 
// Create a class hostel containing hostelName, hostelLocation and numberofRooms. 
// The class contains methods for getting and printing the attributes. 
// Then write Student class extending the Hostel class and implementing the Department interface. 
// This class contains attributes studentName, regdNo, electiveSubject and avgMarks. 
// Write suitable getData and printData methods for this class. 
// Also implement the abstract methods of the Department interface. 
// Write a driver class to test the Student class. 
// The program should be menu driven containing the options: 
//i) Admit new student 
//ii) Migrate a student 
//iii) Display details 
//For the second option a search is to be made on the basis of the entered registration number

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Department {
    String deptName = "Department Name";
    String deptHead = "Department Head";

    void printDeptName();
    void printDeptHead();
}

class Hostel {
    protected String hostelName;
    protected String hostelLocation;
    protected int numberOfRooms;

    public Hostel() {}

    public Hostel(String hostelName, String hostelLocation, int numberOfRooms) {
        this.hostelName = hostelName;
        this.hostelLocation = hostelLocation;
        this.numberOfRooms = numberOfRooms;
    }

    protected static int readInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }

    protected static double readDouble(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }

    public void getHostelData(Scanner sc) {
        System.out.print("Enter Hostel Name: ");
        this.hostelName = sc.nextLine();
        System.out.print("Enter Hostel Location: ");
        this.hostelLocation = sc.nextLine();
        this.numberOfRooms = readInt(sc, "Enter Total Number of Rooms: ");
    }

    public void printHostelData() {
        System.out.println("Hostel Name: " + hostelName);
        System.out.println("Hostel Location: " + hostelLocation);
        System.out.println("Number of Rooms: " + numberOfRooms);
    }

    public String getHostelName() { return hostelName; }
    public String getHostelLocation() { return hostelLocation; }
    public int getNumberOfRooms() { return numberOfRooms; }
}

class Student extends Hostel implements Department {
    private String studentName;
    private String regdNo;
    private String electiveSubject;
    private double avgMarks;

    private String dName;
    private String dHead;

    public Student() {
        super();
    }

    public void getData(Scanner sc) {
        System.out.print("Enter Student Name: ");
        this.studentName = sc.nextLine();
        System.out.print("Enter Elective Subject: ");
        this.electiveSubject = sc.nextLine();
        this.avgMarks = readDouble(sc, "Enter Average Marks: ");
        getDepartmentData(sc);
        super.getHostelData(sc);
    }

    public void getDepartmentData(Scanner sc) {
        System.out.print("Enter Department Name: ");
        this.dName = sc.nextLine();
        System.out.print("Enter Department Head: ");
        this.dHead = sc.nextLine();
    }

    @Override
    public void printDeptName() {
        System.out.println("Department: " + dName);
    }

    @Override
    public void printDeptHead() {
        System.out.println("Department Head: " + dHead);
    }

    public void printData() {
        System.out.println("Student Name: " + studentName);
        System.out.println("Registration No: " + regdNo);
        System.out.println("Elective Subject: " + electiveSubject);
        System.out.println("Average Marks: " + avgMarks);
        printDeptName();
        printDeptHead();
        super.printHostelData();
        System.out.println();
    }

    public String getRegdNo() { return regdNo; }
    public void setRegdNo(String regdNo) { this.regdNo = regdNo; }
    public String getStudentName() { return studentName; }
}

public class StudentManagementDriver {
    static Student find(List<Student> list, String regd) {
        for (Student s : list) {
            if (s.getRegdNo().equalsIgnoreCase(regd)) {
                return s;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> studentList = new ArrayList<>();

        while (true) {
            System.out.println("\nSTUDENT MANAGEMENT SYSTEM");
            System.out.println("1. Admit new student");
            System.out.println("2. Migrate a student");
            System.out.println("3. Display details");
            System.out.println("4. Exit");
            System.out.print("Select an option (1-4): ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("\nAdmit New Student");
                    System.out.print("Enter Registration Number: ");
                    String regd = sc.nextLine().trim();
                    if (find(studentList, regd) != null) {
                        System.out.println("A student with this Registration Number already exists.");
                        break;
                    }
                    Student newStudent = new Student();
                    newStudent.setRegdNo(regd);
                    newStudent.getData(sc);
                    studentList.add(newStudent);
                    System.out.println("Student successfully admitted!");
                    break;

                case 2:
                    System.out.println("\nMigrate a Student");
                    if (studentList.isEmpty()) {
                        System.out.println("No students registered yet.");
                        break;
                    }

                    System.out.print("Enter Registration Number to search: ");
                    String searchRegd = sc.nextLine().trim();
                    Student studentToMigrate = find(studentList, searchRegd);

                    if (studentToMigrate == null) {
                        System.out.println("Student with Registration Number '" + searchRegd + "' not found.");
                        break;
                    }

                    System.out.println("Student found: " + studentToMigrate.getStudentName());
                    System.out.println("1. Migrate Department");
                    System.out.println("2. Migrate Hostel");
                    int migOption = Hostel.readInt(sc, "Choose migration type (1 or 2): ");

                    if (migOption == 1) {
                        studentToMigrate.getDepartmentData(sc);
                        System.out.println("Department details updated successfully.");
                    } else if (migOption == 2) {
                        studentToMigrate.getHostelData(sc);
                        System.out.println("Hostel details updated successfully.");
                    } else {
                        System.out.println("Invalid migration option.");
                    }
                    break;

                case 3:
                    System.out.println("\nDisplay Student Details");
                    if (studentList.isEmpty()) {
                        System.out.println("No student records available.");
                    } else {
                        for (Student s : studentList) {
                            s.printData();
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please choose between 1 and 4.");
            }
        }
    }
}