package com.sofency.entries;

public class student {
	private String nameString;
	private String snoString;
	private int age;
	
	public student() {
	}
	
	public student(String nameString, String snoString, int age) {
		super();
		this.nameString = nameString;
		this.snoString = snoString;
		this.age = age;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public String getSnoString() {
		return snoString;
	}
	public void setSnoString(String snoString) {
		this.snoString = snoString;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "student [nameString=" + nameString + ", snoString=" + snoString + ", age=" + age + "]";
	}
	
	
}
