package com.sofency.action;

public class UserLogin {
	private String uaccount;
	private String upwd;
	
	
	public UserLogin() {
		super();
	}
	public UserLogin(String uaccount, String upwd) {
		super();
		this.uaccount = uaccount;
		this.upwd = upwd;
	}
	public String getUaccount() {
		return uaccount;
	}
	public void setUaccount(String uaccount) {
		this.uaccount = uaccount;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	@Override
	public String toString() {
		return "UserLogin [uaccount=" + uaccount + ", upwd=" + upwd + "]";
	}

}
