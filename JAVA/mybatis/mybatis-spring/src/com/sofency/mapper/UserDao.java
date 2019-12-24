package com.sofency.mapper;

import com.sofency.po.User;


public interface UserDao {

	//根据id进行查找
	User findUserById(int id);
}
