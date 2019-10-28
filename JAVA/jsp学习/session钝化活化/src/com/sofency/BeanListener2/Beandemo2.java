package com.sofency.BeanListener2;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * ��������Ķۻ��ͻ
 * @author sofency
 *
 */
public class Beandemo2 implements HttpSessionActivationListener,Serializable{
	
	private String name;
	private String sex;
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	
	public Beandemo2(String name, String sex) {
		super();
		this.name = name;
		this.sex = sex;
		System.out.println("wo");
	}

	//�����ۻ�֮ǰ  �ۻ��ı��ʾ������л��ͷ����л�  ʵ��seriable
	@Override
	public void sessionWillPassivate(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		System.out.println("session���ᱻ�ۻ�����");
	}

	//�ոս����˻֮���
	@Override
	public void sessionDidActivate(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		System.out.println("session�Ѿ��������");
	}
	
}
