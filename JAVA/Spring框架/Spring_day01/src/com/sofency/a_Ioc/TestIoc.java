package com.sofency.a_Ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIoc {
	public void demo01() {
		//֮ǰ����UserService ��Ҫnew
		UserService user = new UserServiceImpl();
		user.addUser();
	}
	
	@Test
	public void demo02() {
		//ʹ��spring����Ҫ�ӹ����л�ȡʵ������
		String xmlPath = "com.sofency.Spring_day01.beans.xml";
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		
		UserService userService = (UserServiceImpl)applicationContext.getBean("userServiceId");
		//�����������Ȩ������spring���л�ȡ   ���Ʒ�ת
		userService.addUser();
		
	}
	

}
