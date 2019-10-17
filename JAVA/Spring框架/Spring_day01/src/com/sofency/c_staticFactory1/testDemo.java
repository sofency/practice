package com.sofency.c_staticFactory1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testDemo {
	@Test
	public void test(){
		String xmlPath="com/sofency/c_staticFactory1/applicationContext.xml";
        ApplicationContext  applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        Factory window = (CarWindow)applicationContext.getBean("getWindowId");
		window.make();//制造了玻璃
		Factory tyre = (CarTyre)applicationContext.getBean("getTyreId");
		tyre.make();//制造了轮胎
	}
}
