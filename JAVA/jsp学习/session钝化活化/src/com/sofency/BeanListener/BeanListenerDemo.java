package com.sofency.BeanListener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
public class BeanListenerDemo implements HttpSessionBindingListener{

	//bean ʵ���Լ��ļ���
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
		System.out.println("��beanlistener����  ��beanlistener�������ӵ�session���а󶨵Ķ���"+this+"--sessionId:"+event.getSession().getId());
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("���beanlistener����  ��beanlistener�����session�����Ƴ�"+this+"--sessionId:"+event.getSession().getId());
		
	}

}
