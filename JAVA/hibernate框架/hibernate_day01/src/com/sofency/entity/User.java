package com.sofency.entity;

public class User {
	/*hibernate  要求实体实体类有一个属性是唯一的*/
	private int uid;
	private String username;
	private String upassword;
	private String uaddress;
	
	
	public User() {
		super();
	}
	public User(int uid, String username, String upassword, String uaddress) {
		super();
		this.uid = uid;
		this.username = username;
		this.upassword = upassword;
		this.uaddress = uaddress;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public String getUaddress() {
		return uaddress;
	}
	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", usernme=" + username + ", upassword=" + upassword + ", uaddress=" + uaddress
				+ "]";
	}
}
