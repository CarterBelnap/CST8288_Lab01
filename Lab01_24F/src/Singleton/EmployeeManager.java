package Singleton;

import java.util.ArrayList;
import java.util.List;
import AbstractClass.Employee;

public class EmployeeManager {

    // Eager initialize instance
    private static EmployeeManager empManager = new EmployeeManager();

    // Create list of employees
    private List<Employee> employeeList;

    private EmployeeManager() {
        employeeList = new ArrayList<>();
    }

    // Public method to provide access to the single instance
    public static EmployeeManager getInstance() {
        return empManager;
    }

    // Add an employee
    public void addEmployee(Employee employee) {
        employeeList.add(employee);
        System.out.println("Employee " + employee.getName() + " added.");
    }

    // Remove an employee
    public void removeEmployee(int id) {
        employeeList.removeIf(employee -> employee.getId() == id);
        System.out.println("Employee removed with ID: " + id);
    }

    // Retrieve an employee by ID
    public Employee getEmployee(int id) {
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        System.out.println("Employee not found with ID: " + id);
        return null;
    }

    // Retrieve all employees
    public List<Employee> getAllEmployees() {
        return employeeList;
    }
}

