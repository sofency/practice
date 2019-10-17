package com.sofency.f_lifeCircle;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 在Spring容器中Bean的作用域分为singleton、prototype。
 * 对于这两种Bean的作用域简单谈一下个人的认识，
 * singleton的对象为单例模式，这样的对象在Spring的容器中只维持一个，需要的时候可以来取，
 * 也就是说这个对象将自己的控制权交给了Spring容器，
 * 那么他什么时候创建(单例的对象在加载配置文件的时候创建)与销毁取决于Spring容器而不是取决于Bean类本身。
 * 而prototype类型的对象，并不是完全交给Spring容器进行管理的，
 * 创建的时候需要Spring容器进行创建，但是销毁的时候并不取决于Spring容器，取决于客户端，
 * 当客户端访问的时候由Spring创建对象，客户端访问完成后，Bean对象处于未引用的状态下，就会被JVM自动回收。
 */
public class TestFactory {
	@Test
	public void demo() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		String xmlPath="com/sofency/f_lifeCircle/beans.xml";
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		
		UserService userService = (UserService) applicationContext.getBean("UserServiceId");
		
		userService.addUser();//不会调用方法结束
		//如果要执行销毁函数  容器必须关闭close
		//applicationContext.getClass().getMethod("close").invoke(applicationContext);
		//applicationContext.close();
		//当范围是单例时  close方法执行结束后会执行销毁函数  但是在多例模式中  close方法执行结束后容器不会关闭
//		System.out.println("-------------------------");
//		
//		BookDao book = (BookServiceImpl) applicationContext.getBean("BookServiceId");
//		
//		book.addBook();//不会调用方法结束
		//如果要执行销毁函数  容器必须关闭close
		//applicationContext.getClass().getMethod("close").invoke(applicationContext);
		applicationContext.close();
		
	}

}
