package com.sofency.hibernateTest;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.sofency.entity.User;

public class hibernateQuery {
	

	public void testQuery() {
		Session session = hibernateUtils.getCurrentSession();
		
		//��������
		Transaction tra = session.beginTransaction();
		
		Query query = session.createQuery("from User");//hql���   from ����д����  ʵ���������
		@SuppressWarnings("unchecked")
		List<User> list = query.list();
		
		//Criteria criteria = session.createCriteria(User.class);
		//List<User> list = criteria.list();  ����һ��
		for(User user:list) {
			System.out.println(user);
		}
		
		tra.commit();
		hibernateUtils.closeSessionFactory();
	}
	
	@Test
	public void testSQLQuery() {
		Session session = hibernateUtils.getCurrentSession();
		
		//��������
		Transaction tra = session.beginTransaction();
		
		
		SQLQuery sqlQuery = session.createSQLQuery("select * from t_user where uid = 1");
		
		sqlQuery.addEntity(User.class);//������ŵ�ʵ������
		
		List<User> list = sqlQuery.list();
		for(User user:list) {
			System.out.println(user);
		}
	
//		List<Object[]> list = sqlQuery.list();//���ص����������ʽ
//		for(Object[] objects:list) {
//			System.out.println(Arrays.toString(objects));
//		}
		tra.commit();
		hibernateUtils.closeSessionFactory();
	}
}
