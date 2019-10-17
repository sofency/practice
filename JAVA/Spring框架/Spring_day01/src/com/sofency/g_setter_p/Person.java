package com.sofency.g_setter_p;

public class Person {
	private String Pname;
	private int age;
	
	private Company company;
	private School school;
	
	
	public Person() {
		super();
	}
	public Person(String pname, int age, Company company, School school) {
		super();
		Pname = pname;
		this.age = age;
		this.company = company;
		this.school = school;
	}
	public String getPname() {
		return Pname;
	}
	public void setPname(String pname) {
		Pname = pname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	@Override
	public String toString() {
		return "Person [Pname=" + Pname + ", age=" + age + ", company=" + company + ", school=" + school + "]";
	}

}
