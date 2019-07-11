package TestInterface;

public class Employee implements Comparable<Employee>{
	private String name;
	private double salary;
	
	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void raiseSalary(double byPercent) {
		double raise=salary*byPercent/100;
		salary+=raise;
	}

	//ʵ��Comparable�ӿ�
	public int compareTo(Employee other) {
		return  Double.compare(salary, other.salary);
	}
}
