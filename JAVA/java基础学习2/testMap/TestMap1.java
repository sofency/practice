package testMap;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试Map的方法
 * @author sofency
 *
 */
public class TestMap1 {

	public static void main(String[] args) {
		
		Employee e1=new Employee(001, "sofency", 20000);
		Employee e2=new Employee(002, "alice", 10000);
		Employee e3=new Employee(003, "sophia", 2000);
		Employee e4=new Employee(004, "jack", 200000);
		
		
		
		Map<Integer, Employee> employee=new HashMap<Integer, Employee>();
		employee.put(001,e1);
		employee.put(002,e2);
		employee.put(003,e3);
		employee.put(004,e4);
		
		Employee emp=employee.get(001);//拿出的就是对象
		System.out.println(emp.getEname());
		
		
	}
}


class Employee{
	private int id;
	private String ename;
	private double salary;
	
	public Employee(int id, String ename, double salary) {
		super();
		this.id = id;
		this.ename = ename;
		this.salary = salary;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	
	
}