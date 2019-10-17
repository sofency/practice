package com.sofency.g_setter_p;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSetter {
	@Test
	public void testDemo() {
		//≈‰÷√xmlSpring µƒŒª÷√
		String xmlPath = "com/sofency/g_setter_p/beans.xml";
		//º”‘ÿspring»›∆˜
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		Person person = (Person) applicationContext.getBean("PersonId");
		System.out.println(person);
		
		
		
	} 
}
