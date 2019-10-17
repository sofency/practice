package com.sofency.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class MyBeanFactory {
	public static UserServiceImpl createProxy() {
		//Ŀ����
		final UserServiceImpl  user = new UserServiceImpl();
		//������
		final MyAspect myAspect = new MyAspect();
		
		//������  
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(user.getClass());//���ø���
		
		//���ûص�����  MethodInterceptor �ӿڵ�Ч��jdk  InvocationHandler�ӿ�
		
		enhancer.setCallback(new MethodInterceptor() {
			
			@Override
			public Object intercept(Object arg0, Method method, Object[] args, MethodProxy arg3) throws Throwable {
				//����Ĳ�����jdk��̬����һ��
				
				myAspect.before();//��ǿǰ����
				Object object = method.invoke(user, args);
				myAspect.after();//��ǿ�󷽷�
				return object;
			}
		});
		
		
		UserServiceImpl userProxy = (UserServiceImpl) enhancer.create();//����������
		return userProxy;
	}
	
}
