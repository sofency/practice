package com.sofency.springAop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testSpringAop {
	@Test
	public void testDemo() {
		String xmlPath="com/sofency/springAop/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		
		UserService userServiceImpl = (UserService)applicationContext.getBean("UserServiceId");
		userServiceImpl.addUser();
		userServiceImpl.deleteUser();
	}
}
