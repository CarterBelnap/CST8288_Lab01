package EMS;

import Factory.EmployeeFactory;
import Singleton.EmployeeManager;
import AbstractClass.Employee;

import java.util.Scanner;

public class EMS {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeFactory factory = new EmployeeFactory(scanner);
        EmployeeManager manager = EmployeeManager.getInstance(); // Get the single instance of EmployeeManager

        boolean addMoreEmployees = true;

        // Loop to add employees initially
        while (addMoreEmployees) {
            // Create the employee using the factory
            Employee employee = factory.createEmployee();

            // Add the employee to the EmployeeManager
            manager.addEmployee(employee);

            // Display all employees after addition
            displayEmployees(manager);

            // Ask if they want to add another employee
            System.out.println("\nWould you like to add another employee? (yes/no)");
            String answer = scanner.nextLine();

            // Continue the loop if they say yes, otherwise exit
            if (!answer.equalsIgnoreCase("yes")) {
                addMoreEmployees = false;
            }
        }

        System.out.println("Thank you! All employees have been added.");

        // Alter the employee list (search, remove, or add)
        boolean alterEmployeeList = true;

        while (alterEmployeeList) {
            System.out.println("Would you like to alter the Employee list? (yes/no)");
            String alter = scanner.nextLine();

            if (alter.equalsIgnoreCase("yes")) {
                System.out.println("What would you like to do? (search/remove/add)");
                String action = scanner.nextLine();

                if (action.equalsIgnoreCase("add")) {
                    // Loop again to add employees
                    addMoreEmployees = true;
                    while (addMoreEmployees) {
                        Employee employee = factory.createEmployee();
                        manager.addEmployee(employee);
                        displayEmployees(manager);

                        System.out.println("\nWould you like to add another employee? (yes/no)");
                        String answer = scanner.nextLine();
                        if (!answer.equalsIgnoreCase("yes")) {
                            addMoreEmployees = false;
                        }
                    }
                } else if (action.equalsIgnoreCase("remove")) {
                    System.out.println("Enter the ID of the employee to remove: ");
                    int removeId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    manager.removeEmployee(removeId);
                    displayEmployees(manager);
                } else if (action.equalsIgnoreCase("search")) {
                    System.out.println("Enter the ID of the employee to search for: ");
                    int searchId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    Employee foundEmployee = manager.getEmployee(searchId);
                    if (foundEmployee != null) {
                        System.out.println("Employee found: " +
                                "ID: " + foundEmployee.getId() + ", Name: " + foundEmployee.getName() +
                                ", Department: " + foundEmployee.getDepartment() + ", Role: " + foundEmployee.getRole() +
                                ", Salary: " + foundEmployee.getSalary());
                    }
                } else {
                    System.out.println("Invalid option, please select again.");
                }
            } else {
                alterEmployeeList = false;
                System.out.println("Thank you! Goodbye.");
            }
        }

        scanner.close();
    }

    // Helper method to display all employees
    private static void displayEmployees(EmployeeManager manager) {
        System.out.println("\nCurrent list of employees:");
        for (Employee emp : manager.getAllEmployees()) {
            System.out.println("ID: " + emp.getId() + ", Name: " + emp.getName() +
                    ", Department: " + emp.getDepartment() + ", Role: " + emp.getRole() +
                    ", Salary: " + emp.getSalary());
        }
    }
}


