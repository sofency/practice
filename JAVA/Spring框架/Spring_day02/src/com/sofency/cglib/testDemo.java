package com.sofency.cglib;

public class testDemo {
	public static void main(String[] args) {
		UserServiceImpl userService = MyBeanFactory.createProxy();
		userService.addUser();
		userService.deleteUser();
	}

	
	//������ǿ�ķ����Ƚ�
	/**
	 * 1. jdk��̬�����õ���  ��cglib��Ҫ��Spring-core��jar��
	 * 2. jdk��̬�����Ŀ������ýӿڵķ�ʽ   ��cglib ���õĽڼ̳и���(Ŀ����)�ķ�ʽ
	 * 
	 */
}
