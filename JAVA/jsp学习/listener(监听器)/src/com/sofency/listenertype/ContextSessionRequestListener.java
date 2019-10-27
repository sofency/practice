package com.sofency.listenertype;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class ContextSessionRequestListener implements
		ServletRequestListener,HttpSessionListener,ServletContextListener{

	//application�ļ�����ʼ������
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("����application�ĳ�ʼ��"+sce);
	}
	//application�ļ������ٷ���
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("����application������"+sce);
	}
	//����request������
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		System.out.println("����application������"+sre);
	}
	//����request�ĳ�ʼ��
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		System.out.println("����request�ĳ�ʼ��"+sre);
	}
	//session�Ĵ�������
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		System.out.println("����session�Ĵ���"+se);
	}
	//session�����ټ���
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		System.out.println("����session������"+se);
	}

}
