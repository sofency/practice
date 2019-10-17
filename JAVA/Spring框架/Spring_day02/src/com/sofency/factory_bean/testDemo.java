package com.sofency.factory_bean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testDemo {

	@Test
	public  void test() {
		String xmlPath="com/sofency/factory_bean/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		
		UserService user = (UserService)applicationContext.getBean("proxyServiceId");
		
		user.addUser();
		
	}
}
