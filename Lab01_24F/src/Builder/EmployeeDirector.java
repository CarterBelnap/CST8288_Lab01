package Builder;

import AbstractClass.Employee;


public class EmployeeDirector {
    
    private EmployeeBuilder builder;

    // Constructor that takes an EmployeeBuilder
    public EmployeeDirector(EmployeeBuilder builder) {
        this.builder = builder;
    }

    // Method that directs the building of an employee
    public Employee constructEmployee() {
        return builder
                .build();
    }
}
