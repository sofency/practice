package com.sofency.f_lifeCircle;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import jdk.nashorn.internal.ir.ReturnNode;

public class MyBeanPostProcessor implements BeanPostProcessor{//ֻҪʵ����BeanPostProcessor�ӿ����Ժ�Ĵ���ִ�й����� Spring
	//�ͻ�ִ�к���Bean

	@Override
	public Object postProcessBeforeInitialization(Object bean, String arg1) throws BeansException {
		System.out.println("ǰ����:"+arg1);
		return bean;//���return null �Ļ��ͻὫbean��ֵΪnull  ����֮��ķ������޷�������
	}
	@Override
	public Object postProcessAfterInitialization(Object bean, String arg1) throws BeansException {
		System.out.println("�󷽷�:"+arg1);
		
		//bean����
		//����jdk����
		return Proxy.newProxyInstance(
				MyBeanPostProcessor.class.getClassLoader(), 
				bean.getClass().getInterfaces(),
				new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println("--��������");
						
						Object obj = method.invoke(bean, args);
						
						System.out.println("---��������");
						return obj;
					}
				});
		
	}

	

}
