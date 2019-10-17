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
	//������ѯ

	public void  testQuery() {
		
		Session session = hibernateUtils.openSession();
		Transaction tra  = session.beginTransaction();
		
		Query query = session.createQuery("from User where user_id = ?");
		//�����渳ֵ
		query.setParameter(0, 3); //�±���㿪ʼ
		@SuppressWarnings("unchecked")
		List<User> list = query.list();
		
		for(User user:list) {
			System.out.println(user.getUser_name()+"--"+user.getUser_age()+"--"+user.getUser_sex());
		}
		
		tra.commit();
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
		Query query = session.createQuery("from User");
		
		//���ÿ�ʼλ��
		query.setFirstResult(0);
		//����ÿҳ�ļ�¼��
		query.setMaxResults(2);
		
		//���÷����õ����
		List<User> list = query.list();
		
		for(User user:list) {
			System.out.println(user);
		}
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	
	//ͶӰ��ѯ  ��ѯ�����ֶε�ֵ

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
	
	
	
	//�ۼ�������ʹ��

	public  void testSelect1() {
		Configuration cfg = new Configuration().configure();
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();//��������
		
		//����count(*)
		
		Query query = session.createQuery("select count(*) from User");
		Object obj = query.uniqueResult();
		
		
		//int count = (int) obj;
		//�������Ͳ���ֱ�ӱ�Ϊint����   �ȱ��Long ���� �ٱ��int����
		
		Long lobj = (Long) obj;
		
		int count = lobj.intValue();//��long�����ֱ���int����
		System.out.println(count);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	//hql������  ��ʵ����������ʽ���
	
	public void testInnerJoin() {
		Session session = hibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from Customer c inner join c.setLinkMan");//�Ὣ��ͬ���ֶ�cid��������
		List<Object[]> list = query.list();
		
		for(Object[] objects :list) {
			System.out.println(Arrays.toString(objects));
		}
		
		transaction.commit();
		session.close();
		hibernateUtils.closeSessionFactory();
	}
	
	//����������

	public void testInnerQuickJoin() {
		Session session = hibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from Customer c inner join fetch c.setLinkMan");//�Ὣ��ͬ���ֶ�cid��������
		List<Customer> list = query.list();
		
		for(Customer objects :list) {
			System.out.println(objects);
		}
		
		transaction.commit();
		session.close();
		hibernateUtils.closeSessionFactory();
	}
	
	//�������� ��������
	
	public void testLeftOuterJoin() {
		Session session = hibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from Customer c left outer join  c.setLinkMan");//�Ὣ��ͬ���ֶ�cid��������
		List<Object[]> list = query.list();
		
		//ȡ����Ҫ��ֵ��Ҫǿת��ָ��������
		for(Object[] objects :list) {
			System.out.println(((Customer)objects[0]).getCustName()+"--"+((linkMan)objects[1]).getLkm_name());
		}
		
		transaction.commit();
		session.close();
		hibernateUtils.closeSessionFactory();
		
	}
	//������������
	@Test
	public void testLeftOuterFetchJoin() {
		Session session = hibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from Customer c left outer join fetch c.setLinkMan");//�Ὣ��ͬ���ֶ�cid��������
		List<Customer> list = query.list();
		
		for(Customer objects :list) {
			System.out.println(objects.getCustName());
		}
		
		transaction.commit();
		session.close();
		hibernateUtils.closeSessionFactory();
		
	}
	
	
}
