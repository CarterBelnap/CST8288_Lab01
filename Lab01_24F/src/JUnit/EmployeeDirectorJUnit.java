package JUnit;

import Builder.*;
import Singleton.EmployeeManager;
import AbstractClass.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeDirectorJUnit {

    private EmployeeManager manager;

    @BeforeEach
    public void setUp() {
        // Get the instance of EmployeeManager and clear the list before each test
        manager = EmployeeManager.getInstance();
        manager.getAllEmployees().clear(); // Ensure we start with an empty list
    }

    @Test
    public void testEmployeeConstructionAndAddition() {
        // Create the builder and director
    	
    	
        FullTimeBuilder builder = new FullTimeBuilder();
        builder.setId(1)
        .setName("John Doe")
        .setDepartment("Engineering")
        .setRole("Software Engineer")
        .setWorkingHoursPerWeek(40)
        .setSalary(80000);
        
        EmployeeDirector director = new EmployeeDirector(builder);

        // Use the director to construct an employee
        Employee employee = director.constructEmployee();
        
        
        
        // Ensure the employee is not null and has the expected attributes
        assertNotNull(employee, "The employee should not be null after construction.");
        assertEquals("John Doe", employee.getName(), "Employee name should be John Doe.");
        assertEquals("Engineering", employee.getDepartment(), "Employee department should be Engineering.");
        assertEquals("Software Engineer", employee.getRole(), "Employee role should be Software Engineer.");
        assertEquals(40, employee.getHrsPerWeek(), "Working hours should be 40.");
        assertEquals(80000, employee.getSalary(), 0.001, "Salary should be 80000.");

        // Add the employee to the EmployeeManager
        manager.addEmployee(employee);

        // Ensure that the employee was added to the list in EmployeeManager
        assertEquals(1, manager.getAllEmployees().size(), "There should be one employee added to the manager.");
        Employee retrievedEmployee = manager.getEmployee(employee.getId());
        assertNotNull(retrievedEmployee, "Employee should be found in the EmployeeManager.");
        assertEquals(employee.getId(), retrievedEmployee.getId(), "Retrieved employee should match the added employee.");
    }
}