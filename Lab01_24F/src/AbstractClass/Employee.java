package AbstractClass;

public abstract class Employee {
	
	//Declare variables
	int id;
	String Name;
	String Department;
	String Role;
	double HrsPerWeek;
	double Salary;
	
	//Basic Employee constructor
	public Employee(int id, String name, String department, String role, double hrsPerWeek, double salary) {
		this.id = id;
		this.Name = name;
		this.Department = department;
		this.Role = role;
		this.HrsPerWeek = hrsPerWeek;
		this.Salary = salary;
	}

	//Create basic abstract methods
	public abstract void clockIn();
	
	public abstract void clockOut();
	
	public abstract void trackWorkHours();
	
	
	//Getters and Setters for each variable
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	public double getHrsPerWeek() {
		return HrsPerWeek;
	}

	public void setHrsPerWeek(double hrsPerWeek) {
		HrsPerWeek = hrsPerWeek;
	}

	public double getSalary() {
		return Salary;
	}

	public void setSalary(double salary) {
		Salary = salary;
	}
	
}