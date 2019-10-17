package com.sofency.Entity;

public class User {

	private String userName;
	private String userAge;
	public User() {
		super();
	}
	
	public User(String userName, String userAge) {
		super();
		this.userName = userName;
		this.userAge = userAge;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserAge() {
		return userAge;
	}
	public void setUserAge(String userAge) {
		this.userAge = userAge;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", userAge=" + userAge + "]";
	}
	
	
	
	


}
