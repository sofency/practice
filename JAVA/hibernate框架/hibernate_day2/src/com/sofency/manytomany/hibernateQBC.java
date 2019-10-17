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
	//������ѯ

	public void testSelectAll() {
		Session session = hibernateUtils.openSession();
		
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(User.class);
		//��ѯidΪ3������Ϊsofency�ļ�¼
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
	
	
	//�����ѯ

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
	
	
	
	//��ҳ��ѯ

	public void testPage() {
		Configuration cfg  = new Configuration();
		cfg.configure();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();//��������
		//��������
		Transaction transaction = session.beginTransaction();
		//��ѯ����
		Criteria criteria = session.createCriteria(User.class);
		
		//���ÿ�ʼλ��
		criteria.setFirstResult(0);
		//����ÿҳ�ļ�¼��
		criteria.setMaxResults(2);
		
		//���÷����õ����
		List<User> list = criteria.list();
		
		for(User user:list) {
			System.out.println(user);
		}
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	//��ѯ��¼��  �ۼ�����
	@Test
	public void testCount() {
		Session session = hibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(User.class);
		
		criteria.setProjection(Projections.rowCount());//��ѯ������
		
		Object obj = criteria.uniqueResult();
		
		Long lobj = (Long) obj;
		int count = lobj.intValue();
		
		System.out.println(count);
		
		transaction.commit();
		session.close();
		hibernateUtils.closeSessionFactory();
		
	}
}
