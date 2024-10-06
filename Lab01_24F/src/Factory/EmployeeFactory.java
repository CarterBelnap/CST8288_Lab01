package Factory;

import AbstractClass.Employee;

import java.util.Scanner;

public class EmployeeFactory {
    private Scanner scanner;

    // Constructor that initializes the scanner
    public EmployeeFactory(Scanner scanner) {
        this.scanner = scanner;
    }

    // Method to prompt the user for input and create an employee based on type
    public Employee createEmployee() {
    	 String employeeType = "";
    
    	 while (!(employeeType.equalsIgnoreCase("full-time") || employeeType.equalsIgnoreCase("part-time"))) {
             System.out.println("Enter employee type (full-time/part-time): ");
             employeeType = scanner.nextLine();

             // If invalid input, print an error message and ask again
             if (!(employeeType.equalsIgnoreCase("full-time") || employeeType.equalsIgnoreCase("part-time"))) {
                 System.out.println("Invalid employee type. Please enter 'full-time' or 'part-time'.");
             }
         }

         // Once the correct type is entered, continue with the other inputs
         System.out.println("Enter employee ID: ");
         int id = scanner.nextInt();

         System.out.println("Enter employee name: ");
         scanner.nextLine();
         String name = scanner.nextLine();

         System.out.println("Enter department: ");
         String department = scanner.nextLine();

         System.out.println("Enter role: ");
         String role = scanner.nextLine();

         System.out.println("Enter working hours per week: ");
         double hoursPerWeek = scanner.nextDouble();

         System.out.println("Enter salary: ");
         double salary = scanner.nextDouble();
         scanner.nextLine();

         // Factory logic to create and return an Employee based on valid input
         if (employeeType.equalsIgnoreCase("full-time")) {
             return new FullTimeEmployee(id, name, department, role, hoursPerWeek, salary);
         } else { // Must be part-time due to the validation in the while loop
             return new PartTimeEmployee(id, name, department, role, hoursPerWeek, salary);
         }
     }
 }

