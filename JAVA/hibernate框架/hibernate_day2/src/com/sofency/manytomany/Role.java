package com.sofency.manytomany;

import java.util.HashSet;
import java.util.Set;

public class Role {
	private Integer role_id;
	private String role_level;//角色的名字
	private String role_desc;//角色描述
	
	private Set<User> setUser = new HashSet<User>(); 
	
	
	
	public Role() {
		super();
	}

	public Role(Integer role_id, String role_level, String role_desc) {
		super();
		this.role_id = role_id;
		this.role_level = role_level;
		this.role_desc = role_desc;
	}
	
	public Set<User> getSetUser() {
		return setUser;
	}


	public void setSetUser(Set<User> setUser) {
		this.setUser = setUser;
	}

	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	public String getRole_level() {
		return role_level;
	}
	public void setRole_level(String role_level) {
		this.role_level = role_level;
	}
	public String getRole_desc() {
		return role_desc;
	}
	public void setRole_desc(String role_desc) {
		this.role_desc = role_desc;
	}
	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", role_level=" + role_level + ", role_desc=" + role_desc + "]";
	}
}
