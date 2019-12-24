package com.sofency.dao;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sofency.po.User;

public class UserDaoImpl extends SqlSessionDaoSupport implements  UserDao{

	@Override
	public User findUserById(int id) {
		
		SqlSession session = this.getSqlSession();
		UserDao dao = session.getMapper(UserDao.class);
		User user = dao.findUserById(id);
		return user;
	}

}
