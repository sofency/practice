package com.sofency.a_Ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIoc {
	public void demo01() {
		//之前调用UserService 需要new
		UserService user = new UserServiceImpl();
		user.addUser();
	}
	
	@Test
	public void demo02() {
		//使用spring后需要从工厂中获取实例对象
		String xmlPath = "com.sofency.Spring_day01.beans.xml";
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		
		UserService userService = (UserServiceImpl)applicationContext.getBean("userServiceId");
		//将创建对象的权利交给spring进行获取   控制反转
		userService.addUser();
		
	}
	

}
