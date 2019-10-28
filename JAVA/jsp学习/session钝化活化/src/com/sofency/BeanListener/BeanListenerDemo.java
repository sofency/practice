package com.sofency.BeanListener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
public class BeanListenerDemo implements HttpSessionBindingListener{

	//bean 实现自己的监听
	private String nameString;
	private String passwordString;
	
	public String getNameString() {
		return nameString;
	}

	public void setNameString(String nameString) {
		this.nameString = nameString;
	}

	public String getPasswordString() {
		return passwordString;
	}

	public void setPasswordString(String passwordString) {
		this.passwordString = passwordString;
	}
	
	public BeanListenerDemo(String nameString, String passwordString) {
		super();
		this.nameString = nameString;
		this.passwordString = passwordString;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("绑定beanlistener对象  将beanlistener对象增加到session域中绑定的对象"+this+"--sessionId:"+event.getSession().getId());
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("解绑beanlistener对象  将beanlistener对象从session域中移除"+this+"--sessionId:"+event.getSession().getId());
		
	}

}
