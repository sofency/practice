package com.sofency.mapper;

import com.sofency.po.User;


public interface UserDao {

	//����id���в���
	User findUserById(int id);
}
