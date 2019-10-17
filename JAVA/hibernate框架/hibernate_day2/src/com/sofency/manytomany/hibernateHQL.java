package com.sofency.manytomany;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.sofency.entity.Customer;
import com.sofency.entity.linkMan;
import com.sofency.hibernateTest.hibernateUtils;

public class hibernateHQL {
	//条件查询

	public void  testQuery() {
		
		Session session = hibernateUtils.openSession();
		Transaction tra  = session.beginTransaction();
		
		Query query = session.createQuery("from User where user_id = ?");
		//向？里面赋值
		query.setParameter(0, 3); //下标从零开始
		@SuppressWarnings("unchecked")
		List<User> list = query.list();
		
		for(User user:list) {
			System.out.println(user.getUser_name()+"--"+user.getUser_age()+"--"+user.getUser_sex());
		}
		
		tra.commit();
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
		Query query = session.createQuery("from User");
		
		//设置开始位置
		query.setFirstResult(0);
		//设置每页的记录数
		query.setMaxResults(2);
		
		//调用方法得到结果
		List<User> list = query.list();
		
		for(User user:list) {
			System.out.println(user);
		}
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	
	//投影查询  查询部分字段的值

	public void  testSelect() {
		
		Configuration cfg = new Configuration().configure();
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction tra = session.beginTransaction();
		
		Query query = session.createQuery("select user_name,user_sex from User");
		
		List<Object[]> list = query.list();
		
		for(Object[] objects:list) {
			System.out.println(Arrays.toString(objects));
			
		}
		
		tra.commit();
		session.close();
		sessionFactory.close();
		
	}
	
	
	
	//聚集函数的使用

	public  void testSelect1() {
		Configuration cfg = new Configuration().configure();
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();//开启事务
		
		//测试count(*)
		
		Query query = session.createQuery("select count(*) from User");
		Object obj = query.uniqueResult();
		
		
		//int count = (int) obj;
		//对象类型不能直接变为int类型   先变成Long 类型 再变成int类型
		
		Long lobj = (Long) obj;
		
		int count = lobj.intValue();//将long型数字便曾int类型
		System.out.println(count);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	//hql内连接  以实体类对象的形式输出
	
	public void testInnerJoin() {
		Session session = hibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from Customer c inner join c.setLinkMan");//会将相同的字段cid进行连接
		List<Object[]> list = query.list();
		
		for(Object[] objects :list) {
			System.out.println(Arrays.toString(objects));
		}
		
		transaction.commit();
		session.close();
		hibernateUtils.closeSessionFactory();
	}
	
	//迫切内连接

	public void testInnerQuickJoin() {
		Session session = hibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from Customer c inner join fetch c.setLinkMan");//会将相同的字段cid进行连接
		List<Customer> list = query.list();
		
		for(Customer objects :list) {
			System.out.println(objects);
		}
		
		transaction.commit();
		session.close();
		hibernateUtils.closeSessionFactory();
	}
	
	//左外链接 返回数组
	
	public void testLeftOuterJoin() {
		Session session = hibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from Customer c left outer join  c.setLinkMan");//会将相同的字段cid进行连接
		List<Object[]> list = query.list();
		
		//取出想要的值需要强转到指定的类型
		for(Object[] objects :list) {
			System.out.println(((Customer)objects[0]).getCustName()+"--"+((linkMan)objects[1]).getLkm_name());
		}
		
		transaction.commit();
		session.close();
		hibernateUtils.closeSessionFactory();
		
	}
	//迫切左外链接
	@Test
	public void testLeftOuterFetchJoin() {
		Session session = hibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from Customer c left outer join fetch c.setLinkMan");//会将相同的字段cid进行连接
		List<Customer> list = query.list();
		
		for(Customer objects :list) {
			System.out.println(objects.getCustName());
		}
		
		transaction.commit();
		session.close();
		hibernateUtils.closeSessionFactory();
		
	}
	
	
}
