package com.sofency.AspectAnnotate;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testAspectjAnnotate {
	@Test
	public void testDemo() {
		String xmlPath="com/sofency/AspectAnnotate/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		UserService userService = (UserService) applicationContext.getBean("UserServiceId");
		userService.addUser();
		userService.deleteUser();
	}
}
