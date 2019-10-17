package com.sofency.b_DI;


import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class testDI {

	
	public void demo() {
		
		String xmlPath = "com/sofency/DI/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		//从xmlpath中加载配置信息  我不需要知道注入的是什么Dao层的代码 我只需要调用Service的方法
		
		BookService book = (BookServiceImpl) applicationContext.getBean("BookServiceId");
		book.addBookService();
	}
	
	
	//使用BeanFactory
	@Test
	public void  demo1() {
		String xmlPath =  "com/sofency/DI/beans.xml";
		
		@SuppressWarnings("deprecation")
		BeanFactory beanFactory =new ClassPathXmlApplicationContext(xmlPath);
		
		BookService book = (BookService)beanFactory.getBean("BookServiceId");
		book.addBookService();
		
	}

}
