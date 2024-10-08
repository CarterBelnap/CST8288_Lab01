package Builder;

import AbstractClass.*;

//Abstract class EmployeeBuilder
public interface EmployeeBuilder {
    EmployeeBuilder setId(int id); 
    EmployeeBuilder setName(String name);
    EmployeeBuilder setDepartment(String department);
    EmployeeBuilder setRole(String role);
    EmployeeBuilder setWorkingHoursPerWeek(double hoursperweek);
    EmployeeBuilder setSalary(double salary);
	
    Employee build();
	
}
