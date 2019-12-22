package com.sofency.domain;

import java.util.Date;
import java.util.List;

public class User {
	private int userId;
	private String username;
	private Date birthday;
	private String sex;
	private String address;
	
	private List<Orders> orders;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Orders> getOrders() {
		return orders;
	}
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	public User() {
		super();
	}
	public User(int userId, String username, Date birthday, String sex, String address, List<Orders> orders) {
		super();
		this.userId = userId;
		this.username = username;
		this.birthday = birthday;
		this.sex = sex;
		this.address = address;
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", birthday=" + birthday + ", sex=" + sex
				+ ", address=" + address + ", orders=" + orders + "]";
	}
	
}
