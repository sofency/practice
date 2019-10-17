package com.sofency.g_setter.a_spel;

public class Person {
	private String Pname;//="sofency";
	private int age;
	
	
	
	public Person() {
		super();
	}
	public Person(String pname, int age) {
		super();
		Pname = pname;
		this.age = age;
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
	@Override
	public String toString() {
		return "Person [Pname=" + Pname + ", age=" + age + "]";
	}

}
