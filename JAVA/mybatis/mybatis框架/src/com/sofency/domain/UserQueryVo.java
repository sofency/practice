package com.sofency.domain;

import java.util.List;

public class UserQueryVo {
	
	//������id
	private List<Integer> ids;
	
	//�û���ѯ����������  ����漰�������Ļ�������������
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
