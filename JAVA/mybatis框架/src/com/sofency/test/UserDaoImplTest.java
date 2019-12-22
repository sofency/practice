package com.sofency.test;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.sofency.Dao.UserDao;
import com.sofency.Dao.UserDaoImpl;
import com.sofency.domain.User;

public class UserDaoImplTest {
	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void setUp() throws Exception{
		InputStream   in = Resources.getResourceAsStream("mybatis-config.xml");
		this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
	}
	
	
	@Test
	public void testFindAllUser() {
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		List<User> list = userDao.findAllUser();
		for(User user:list) {
			System.out.println(user.toString());
		}
		
	}

}
