package com.sofency.f_lifeCircle;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ��Spring������Bean���������Ϊsingleton��prototype��
 * ����������Bean���������̸һ�¸��˵���ʶ��
 * singleton�Ķ���Ϊ����ģʽ�������Ķ�����Spring��������ֻά��һ������Ҫ��ʱ�������ȡ��
 * Ҳ����˵��������Լ��Ŀ���Ȩ������Spring������
 * ��ô��ʲôʱ�򴴽�(�����Ķ����ڼ��������ļ���ʱ�򴴽�)������ȡ����Spring����������ȡ����Bean�౾��
 * ��prototype���͵Ķ��󣬲�������ȫ����Spring�������й���ģ�
 * ������ʱ����ҪSpring�������д������������ٵ�ʱ�򲢲�ȡ����Spring������ȡ���ڿͻ��ˣ�
 * ���ͻ��˷��ʵ�ʱ����Spring�������󣬿ͻ��˷�����ɺ�Bean������δ���õ�״̬�£��ͻᱻJVM�Զ����ա�
 */
public class TestFactory {
	@Test
	public void demo() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		String xmlPath="com/sofency/f_lifeCircle/beans.xml";
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		
		UserService userService = (UserService) applicationContext.getBean("UserServiceId");
		
		userService.addUser();//������÷�������
		//���Ҫִ�����ٺ���  ��������ر�close
		//applicationContext.getClass().getMethod("close").invoke(applicationContext);
		//applicationContext.close();
		//����Χ�ǵ���ʱ  close����ִ�н������ִ�����ٺ���  �����ڶ���ģʽ��  close����ִ�н�������������ر�
//		System.out.println("-------------------------");
//		
//		BookDao book = (BookServiceImpl) applicationContext.getBean("BookServiceId");
//		
//		book.addBook();//������÷�������
		//���Ҫִ�����ٺ���  ��������ر�close
		//applicationContext.getClass().getMethod("close").invoke(applicationContext);
		applicationContext.close();
		
	}

}
