package com.sofency.po;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.sun.xml.internal.ws.api.model.SEIModel;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userId;
	private String username;
	private Date birthday;
	private String sex;
	private String address;
	
	
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
	
	public User() {
		super();
	}
	public User(int userId, String username, Date birthday, String sex, String address) {
		super();
		this.userId = userId;
		this.username = username;
		this.birthday = birthday;
		this.sex = sex;
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", birthday=" + birthday + ", sex=" + sex
				+ ", address=" + address + "]";
	}
	
}
