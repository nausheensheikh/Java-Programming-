//Q1. Create a class called Employee. Employee has three private data members name, department and salary. 
// Initialize these data members via constructor. Display all information for employee of same company. 
// Also display name of their company. Use static member cocept to implement this code.

class Employee {
    private String name;
    private String department;
    private double salary;

    private static String companyName = "Apple Inc.";

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    
    public void displayInfo(){
        System.out.println("Company: " + companyName);
        System.out.println("Name: " + this.name);
        System.out.println("Department: " + this.department);
        System.out.println("Salary: " + this.salary + " USD");

    }
    
    public static void main(String args[]){
    Employee emp1 = new Employee("Ashish Bohra", "Accounts", 50000.00);
    Employee emp2 = new Employee("Bharti Chaudhary", "Branding", 45000.00);
    Employee emp3 = new Employee("Chris Lang", "Cafeteria", 55000.00); 

    emp1.displayInfo();
    emp2.displayInfo();
    emp3.displayInfo();

}

    
    

}

