package com.sofency.listenertype;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class ContextSessionRequestListener implements
		ServletRequestListener,HttpSessionListener,ServletContextListener{

	//application的监听初始化方法
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("监听application的初始化"+sce);
	}
	//application的监听销毁方法
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("监听application的销毁"+sce);
	}
	//监听request的销毁
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		System.out.println("监听application的销毁"+sre);
	}
	//监听request的初始化
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		System.out.println("监听request的初始化"+sre);
	}
	//session的创建监听
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		System.out.println("监听session的创建"+se);
	}
	//session的销毁监听
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		System.out.println("监听session的销毁"+se);
	}

}
