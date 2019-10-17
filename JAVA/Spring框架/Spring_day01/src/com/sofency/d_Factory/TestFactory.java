package com.sofency.d_Factory;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFactory {
	@Test
	public void demo() {
		//使用spring控制的工厂  静态工厂配置到spring中
		String xmlPath="com/sofency/d_Factory/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		UserService user = (UserService) applicationContext.getBean("SayHelloId");
		user.addUser();
		
		//这样写污染了实体类工厂的实体类工厂一般写
//		MyTestFactory my = (MyTestFactory) applicationContext.getBean("sayHelloId");
//		my.sayHelloSpring();
	}

}
