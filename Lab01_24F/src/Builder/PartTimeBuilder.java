package Builder;

import AbstractClass.Employee;
import Factory.PartTimeEmployee;

public class PartTimeBuilder implements EmployeeBuilder {

	private int Id;
    private String Name;
    private String Department;
    private String Role;
    private double HrsPerWeek;
    private double Salary;
    
	@Override
	public EmployeeBuilder setId(int id) {
		this.Id = id;
		return this;
	}

	@Override
	public EmployeeBuilder setName(String name) {
		this.Name = name;
		return this;
	}

	@Override
	public EmployeeBuilder setDepartment(String department) {
		this.Department = department;
		return this;
	}

	@Override
	public EmployeeBuilder setRole(String role) {
		this.Role = role;
		return this;
	}

	@Override
	public EmployeeBuilder setWorkingHoursPerWeek(double hoursperweek) {
		this.HrsPerWeek = hoursperweek;
		return this;
	}

	@Override
	public EmployeeBuilder setSalary(double salary) {
		this.Salary = salary;
		return this;
	}

	@Override
	public Employee build() {
		return new PartTimeEmployee(Id, Name, Department, Role, HrsPerWeek, Salary);
	}
}
