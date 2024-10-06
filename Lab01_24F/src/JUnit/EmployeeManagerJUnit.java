package JUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Singleton.EmployeeManager;
import Factory.FullTimeEmployee;
import AbstractClass.Employee;




class EmployeeManagerJUnit {

    private EmployeeManager manager;

    @BeforeEach
    public void setUp() {
        // Get the instance of EmployeeManager before each test
        manager = EmployeeManager.getInstance();
        // Clear any previous employees in the list
        manager.getAllEmployees().clear();
    }

    @Test
    public void testSingletonBehavior() {
        EmployeeManager anotherManager = EmployeeManager.getInstance();
        assertSame(manager, anotherManager, "EmployeeManager should be a singleton instance");
    }

    @Test
    public void testAddEmployee() {
        Employee emp = new FullTimeEmployee(1, "John Doe", "Engineering", "Software Engineer", 40, 80000);
        manager.addEmployee(emp);
        assertEquals(1, manager.getAllEmployees().size(), "There should be one employee added.");
    }

    @Test
    public void testRemoveEmployee() {
        Employee emp = new FullTimeEmployee(1, "John Doe", "Engineering", "Software Engineer", 40, 80000);
        manager.addEmployee(emp);
        assertEquals(1, manager.getAllEmployees().size(), "Employee list should contain one employee before removal.");

        manager.removeEmployee(1);
        assertEquals(0, manager.getAllEmployees().size(), "Employee list should be empty after removal.");
    }

    @Test
    public void testGetEmployee() {
        Employee emp = new FullTimeEmployee(1, "John Doe", "Engineering", "Software Engineer", 40, 80000);
        manager.addEmployee(emp);

        Employee retrievedEmp = manager.getEmployee(1);
        assertNotNull(retrievedEmp, "Employee should be found with ID 1.");
        assertEquals("John Doe", retrievedEmp.getName(), "Employee name should be John Doe.");
    }

    @Test
    public void testGetEmployeeNotFound() {
        Employee emp = manager.getEmployee(999);
        assertNull(emp, "Employee with invalid ID should return null.");
    }
}