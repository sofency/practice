package com.sofency.test;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.sofency.Dao.OrderDao;
import com.sofency.domain.Orders;
import com.sofency.domain.User;
import com.sofency.domain.UserCustom;

public class OrderDaoTest {
    private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void setUp() throws Exception{
		InputStream   in = Resources.getResourceAsStream("mybatis-config.xml");
		this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
	}
	
	@Test
	public void test() {
		SqlSession session = sqlSessionFactory.openSession();
		OrderDao  orderDao = session.getMapper(OrderDao.class);//获取代理对象
		List<Orders> list = orderDao.findOrderAndUserWithLazyLoad();
		for(Orders order:list) {
			System.out.println(order.getUser());
		}
		session.close();
	}

}
