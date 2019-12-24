package com.sofency.Dao;

import java.util.List;

import com.sofency.domain.User;
import com.sofency.domain.UserQueryVo;

public interface UserDao {
	List<User> findAllUser();//查询所有的用户
	//根据名字查找
	User findByUsername(String username);
	//查找命里面里有小明的用户
	List<User> fuzzyQuery(String str);
	//插入数据
	void  insertUser(User user);
	//删除数据
	void  deleteUser(int userId);
	//更新数据
	void updateUser(User user);
	
	//根据用户名进行查询
	List<User> findByUsernameAndSex(UserQueryVo userQueryVo);
	
	//查询部分数据  不过返回的是User对象
	List<User> findPartUser(String sex);
	
	List<User> findByUsernameAndIdWithSql(UserQueryVo userQueryVo);
	
	//根据ids进行查询数据
	List<User>  findByIds(UserQueryVo userQueryVo);
	
	User findUserById(String id);
}
