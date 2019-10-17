package com.sofency.e_scope;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFactory {
	@Test
	public void demo() {
		//ʹ��spring���ƵĹ���  ��̬�������õ�spring��
		String xmlPath="com/sofency/e_scope/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		//scope��Ĭ��ֵ�ǵ����� ��singleton  ������������ĵ�ַ��һ����  
		//��scope��prototypeʱ  ����������ַ�ǲ�ͬ��
		//��scope��requestʱ ÿ��http���󶼻ᴴ��һ���µ�bean ����������ʺ���WebApplicationContext����
		//��scope��sessionʱ ͬһ��http  Session
		
		UserService user = (UserService) applicationContext.getBean("UserServiceId");//���Ʒ�ת��bean����Spring
		UserService user1 = (UserService) applicationContext.getBean("UserServiceId");
		System.out.println(user);
		System.out.println(user1);
		


	}

}
