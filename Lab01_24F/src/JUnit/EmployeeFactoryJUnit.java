package JUnit;

import Factory.*;
import AbstractClass.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeFactoryJUnit {

    private EmployeeFactory factory;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        // Set up to capture System.out
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    // Helper method to simulate user input
    private void simulateInput(String data) {
        ByteArrayInputStream simulatedIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(simulatedIn);
    }

    @Test
    public void testCreateFullTimeEmployee() {
        // Simulate input for creating a full-time employee
        simulateInput("full-time\n1\nJohn Doe\nEngineering\nSoftware Engineer\n40\n80000\n");

        // Initialize the Scanner with the simulated input stream and pass it to the factory
        factory = new EmployeeFactory(new Scanner(System.in));

        // Use the factory to create an employee
        Employee employee = factory.createEmployee();

        // Assertions for full-time employee
        assertNotNull(employee, "Employee should not be null.");
        assertTrue(employee instanceof FullTimeEmployee, "Employee should be an instance of FullTimeEmployee.");
        assertEquals("John Doe", employee.getName(), "Employee name should be John Doe.");
        assertEquals(80000, employee.getSalary(), 0.001, "Salary should be 80000.");
        assertEquals(40, employee.getHrsPerWeek(), "Working hours per week should be 40.");

        // Display captured output, which will now include the entered values like "John Doe"
        System.out.println("Captured output:\n" + outputStreamCaptor.toString().trim());
    }

    @Test
    public void testCreatePartTimeEmployee() {
        // Simulate input for creating a part-time employee
        simulateInput("part-time\n2\nJane Smith\nHR\nHR Manager\n20\n40000\n");

        // Initialize the Scanner with the simulated input stream and pass it to the factory
        factory = new EmployeeFactory(new Scanner(System.in));

        // Use the factory to create an employee
        Employee employee = factory.createEmployee();

        // Assertions for part-time employee
        assertNotNull(employee, "Employee should not be null.");
        assertTrue(employee instanceof PartTimeEmployee, "Employee should be an instance of PartTimeEmployee.");
        assertEquals("Jane Smith", employee.getName(), "Employee name should be Jane Smith.");
        assertEquals(40000, employee.getSalary(), 0.001, "Salary should be 40000.");
        assertEquals(20, employee.getHrsPerWeek(), "Working hours per week should be 20.");

        // Display captured output, which will now include the entered values like "Jane Smith"
        System.out.println("Captured output:\n" + outputStreamCaptor.toString().trim());
    }
}

