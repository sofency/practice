package com.sofency.hibernateTest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class hibernateUtils {

	private static SessionFactory sessionFactory =null;
	static {
		Configuration cfg = new Configuration();
		cfg.configure();
		sessionFactory = cfg.buildSessionFactory();
	}
	
	//��ȡ�����̵߳�session
	public static Session getCurrentSession() {
		return sessionFactory.getCurrentSession();//��ȡ�����̵߳�session
	}
	
	//��ȡsession
	public  static Session openSession() {
		return sessionFactory.openSession();
	}
	
	//�ر�sessionFactory
	public  static void closeSessionFactory() {
		sessionFactory.close();
	}
}
