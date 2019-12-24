package com.sofency.domain;

public class OrderCustom  extends Orders{ //继承字段较多的字段
	//将用户的数据填写进来
	private String username;
	private String address;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "OrderCustom [username=" + username + ", address=" + address + ", toString()=" + super.toString() + "]";
	}
	
}
