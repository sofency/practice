package com.sofency.dao;

import com.sofency.po.User;


public interface UserDao {

	//根据id进行查找
	User findUserById(int id);
}
