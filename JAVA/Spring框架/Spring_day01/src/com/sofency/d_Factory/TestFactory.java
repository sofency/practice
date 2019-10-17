package com.sofency.d_Factory;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFactory {
	@Test
	public void demo() {
		//ʹ��spring���ƵĹ���  ��̬�������õ�spring��
		String xmlPath="com/sofency/d_Factory/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		UserService user = (UserService) applicationContext.getBean("SayHelloId");
		user.addUser();
		
		//����д��Ⱦ��ʵ���๤����ʵ���๤��һ��д
//		MyTestFactory my = (MyTestFactory) applicationContext.getBean("sayHelloId");
//		my.sayHelloSpring();
	}

}
