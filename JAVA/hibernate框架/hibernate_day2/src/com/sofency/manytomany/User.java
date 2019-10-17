package com.sofency.manytomany;

import java.util.HashSet;
import java.util.Set;

public class User {
	private Integer user_id;
	private String user_name;
	private String user_sex;
	private String user_age;
	private Set<Role> setRole = new HashSet<Role>(); 
	
	public User() {
		super();
	}

	public User(Integer user_id, String user_name, String user_sex, String user_age) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_sex = user_sex;
		this.user_age = user_age;
	}
	
	public Set<Role> getSetRole() {
		return setRole;
	}

	public void setSetRole(Set<Role> setRole) {
		this.setRole = setRole;
	}

	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}
	public String getUser_age() {
		return user_age;
	}
	public void setUser_age(String user_age) {
		this.user_age = user_age;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", user_sex=" + user_sex + ", user_age="
				+ user_age + "]";
	}
}
