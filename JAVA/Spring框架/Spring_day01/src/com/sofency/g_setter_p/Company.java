package com.sofency.g_setter_p;

public class Company {
	private String cname;
	private String CNumber;
	
	
	public Company() {
		super();
	}
	public Company(String cname, String cNumber) {
		super();
		this.cname = cname;
		CNumber = cNumber;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCNumber() {
		return CNumber;
	}
	public void setCNumber(String cNumber) {
		CNumber = cNumber;
	}
	@Override
	public String toString() {
		return "Company [cname=" + cname + ", CNumber=" + CNumber + "]";
	}
	
	
}
