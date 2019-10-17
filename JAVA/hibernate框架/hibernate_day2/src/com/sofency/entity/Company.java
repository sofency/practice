package com.sofency.entity;

import java.util.HashSet;
import java.util.Set;

public class Company {
	private Integer company_id ;
	private Integer company_level;
	private String company_position;
	private String company_name;
	
	private Set<Employee> setEmployee = new HashSet<Employee>();
	
	public Set<Employee> getSetEmployee() {
		return setEmployee;
	}
	public void setSetEmployee(Set<Employee> setEmployee) {
		this.setEmployee = setEmployee;
	}
	public Company() {
		super();
	}
	public Company(Integer company_id, Integer company_level, String company_position, String company_name) {
		super();
		this.company_id = company_id;
		this.company_level = company_level;
		this.company_position = company_position;
		this.company_name = company_name;
	}
	public Integer getCompany_id() {
		return company_id;
	}
	public void setCompany_id(Integer company_id) {
		this.company_id = company_id;
	}
	public Integer getCompany_level() {
		return company_level;
	}
	public void setCompany_level(Integer company_level) {
		this.company_level = company_level;
	}
	public String getCompany_position() {
		return company_position;
	}
	public void setCompany_position(String company_position) {
		this.company_position = company_position;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	@Override
	public String toString() {
		return "Company [company_id=" + company_id + ", company_level=" + company_level + ", company_position="
				+ company_position + ", company_name=" + company_name + "]";
	}
}
