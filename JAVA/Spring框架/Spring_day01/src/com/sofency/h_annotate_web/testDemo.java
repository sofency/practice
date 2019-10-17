package com.sofency.h_annotate_web;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class testDemo {
	
	@Test
	public void testAnnotate() {
		
		String xmlPath ="com/sofency/h_annotate_web/beans.xml";
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		
		studentAction student = (studentAction) applicationContext.getBean("studentActionId");
		student.sayHello();
	}

}
