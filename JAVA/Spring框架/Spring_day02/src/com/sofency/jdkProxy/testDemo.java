package com.sofency.jdkProxy;

import org.junit.Test;

public class testDemo {
	@Test
	public void  test() {
		
		UserService userService = MyBeanFactory.createService();//��ȡ�������
		userService.addUser();
	}
}
