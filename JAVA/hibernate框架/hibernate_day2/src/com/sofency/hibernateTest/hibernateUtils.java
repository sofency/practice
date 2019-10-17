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
	
	//获取本地线程的session
	public static Session getCurrentSession() {
		return sessionFactory.getCurrentSession();//获取本地线程的session
	}
	
	//获取session
	public  static Session openSession() {
		return sessionFactory.openSession();
	}
	
	//关闭sessionFactory
	public  static void closeSessionFactory() {
		sessionFactory.close();
	}
}
