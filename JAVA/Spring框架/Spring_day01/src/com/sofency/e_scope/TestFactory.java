package com.sofency.e_scope;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFactory {
	@Test
	public void demo() {
		//使用spring控制的工厂  静态工厂配置到spring中
		String xmlPath="com/sofency/e_scope/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		//scope的默认值是单例的 即singleton  下面两个对象的地址是一样的  
		//当scope是prototype时  下面两个地址是不同的
		//当scope是request时 每次http请求都会创建一个新的bean 该作用域仅适合于WebApplicationContext环境
		//当scope是session时 同一个http  Session
		
		UserService user = (UserService) applicationContext.getBean("UserServiceId");//控制反转将bean交给Spring
		UserService user1 = (UserService) applicationContext.getBean("UserServiceId");
		System.out.println(user);
		System.out.println(user1);
		


	}

}
