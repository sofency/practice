package com.sofency.entity;

public class Employee {
	private Integer employee_id;
	private String employee_name;
	private String employee_sex;
	private Company company=new Company();

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Employee() {
		super();
	}

	public Employee(Integer employee_id, String employee_name, String employee_sex) {
		super();
		this.employee_id = employee_id;
		this.employee_name = employee_name;
		this.employee_sex = employee_sex;
	}

	public Integer getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(Integer employee_id) {
		this.employee_id = employee_id;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getEmployee_sex() {
		return employee_sex;
	}

	public void setEmployee_sex(String employee_sex) {
		this.employee_sex = employee_sex;
	}

	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", employee_name=" + employee_name + ", employee_sex="
				+ employee_sex + "]";
	}
}
