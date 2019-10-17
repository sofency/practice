package com.sofency.g_setter_p;

public class School {

	private String Sname;
	private String Saddress;
	
	
	
	public School() {
		super();
	}
	public School(String sname, String saddress) {
		super();
		Sname = sname;
		Saddress = saddress;
	}
	public String getSname() {
		return Sname;
	}
	public void setSname(String sname) {
		Sname = sname;
	}
	public String getSaddress() {
		return Saddress;
	}
	public void setSaddress(String saddress) {
		Saddress = saddress;
	}
	@Override
	public String toString() {
		return "School [Sname=" + Sname + ", Saddress=" + Saddress + "]";
	}
	
}
