package com.sofency.d_Factory;

/**
 * ʵ������
 * @author sofency
 * ���з����Ǿ�̬
 * 1.�����з���ֵ
 */
public class MyTestFactory {
	
	//����д��̬��
	public UserService createBeanFactory() {
		return new UserServiceImpl();
	}
	//����������д  ��дһ��Ľӿ�ʵ�ַ��ظ�spring ���е��ýӿ�����ķ��� ������������bean
//	public String sayHelloSpring() {
//		System.out.println("Say Hello Spring");
//		return "sofency";
//	}
}
