package com.sofency.domain;

import java.util.List;

public class UserQueryVo {
	
	//传入多个id
	private List<Integer> ids;
	
	//用户查询条件的整合  如果涉及到多个表的话可以这样整合
	private UserCustom userCustom;

	public UserCustom getUserCustom() {
		return userCustom;
	}

	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
}
