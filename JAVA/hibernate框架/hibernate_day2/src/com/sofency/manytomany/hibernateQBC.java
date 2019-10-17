package com.sofency.manytomany;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.sofency.hibernateTest.hibernateUtils;

public class hibernateQBC {
	//条件查询

	public void testSelectAll() {
		Session session = hibernateUtils.openSession();
		
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(User.class);
		//查询id为3和名字为sofency的记录
		criteria.add(Restrictions.eq("user_id", 3));
		criteria.add(Restrictions.eq("user_name","sofency"));
		
		List<User> list = criteria.list();
		for(User user:list) {
			System.out.println(user);
		}
		transaction.commit();
		session.close();
		hibernateUtils.closeSessionFactory();
		
	}
	
	
	//排序查询

	public void testAsc() {
		
		Session session = hibernateUtils.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(User.class);
	    criteria.addOrder(Order.desc("user_id"));//order.asc  order.desc
		List<User> list = criteria.list();
		
		for(User user:list) {
			System.out.println(user);
		}
		transaction.commit();
		session.close();
		hibernateUtils.closeSessionFactory();
	}
	
	
	
	//分页查询

	public void testPage() {
		Configuration cfg  = new Configuration();
		cfg.configure();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();//创建连接
		//开启事务
		Transaction transaction = session.beginTransaction();
		//查询所有
		Criteria criteria = session.createCriteria(User.class);
		
		//设置开始位置
		criteria.setFirstResult(0);
		//设置每页的记录数
		criteria.setMaxResults(2);
		
		//调用方法得到结果
		List<User> list = criteria.list();
		
		for(User user:list) {
			System.out.println(user);
		}
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	//查询记录数  聚集函数
	@Test
	public void testCount() {
		Session session = hibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(User.class);
		
		criteria.setProjection(Projections.rowCount());//查询多少行
		
		Object obj = criteria.uniqueResult();
		
		Long lobj = (Long) obj;
		int count = lobj.intValue();
		
		System.out.println(count);
		
		transaction.commit();
		session.close();
		hibernateUtils.closeSessionFactory();
		
	}
}
