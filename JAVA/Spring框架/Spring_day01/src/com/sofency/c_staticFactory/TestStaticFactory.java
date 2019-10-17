package com.sofency.c_staticFactory;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStaticFactory {
	@Test
	public void demo() {
		//ʹ��spring���ƵĹ���  ��̬�������õ�spring��
		String xmlPath="com/sofency/infect/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		UserService user = (UserService) applicationContext.getBean("UserServiceId");
		user.addUser();
		
	}

}
