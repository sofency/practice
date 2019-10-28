package com.sofency.BeanListener2;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * 监听对象的钝化和活化
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

	//监听钝化之前  钝化的本质就是序列化和反序列化  实现seriable
	@Override
	public void sessionWillPassivate(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		System.out.println("session将会被钝化处理");
	}

	//刚刚进行了活化之后的
	@Override
	public void sessionDidActivate(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		System.out.println("session已经被活化处理");
	}
	
}
