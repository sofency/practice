package com.sofency.User;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testDemo {
	@Test
	public void Demo() {
		String xmlpath ="com/sofency/User/applicationContect.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlpath);
		
		User user=new User();
		user.setUsername("ahoj");
		user.setPassword("0120");
		
		TestDao testDao = (TestDao)applicationContext.getBean("UserDaoId");
		testDao.AddUser(user);
	}

}
