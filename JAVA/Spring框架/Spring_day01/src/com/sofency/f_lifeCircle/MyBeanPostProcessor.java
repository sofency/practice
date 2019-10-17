package com.sofency.f_lifeCircle;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import jdk.nashorn.internal.ir.ReturnNode;

public class MyBeanPostProcessor implements BeanPostProcessor{//只要实现了BeanPostProcessor接口在以后的代码执行过程中 Spring
	//就会执行后处理Bean

	@Override
	public Object postProcessBeforeInitialization(Object bean, String arg1) throws BeansException {
		System.out.println("前方法:"+arg1);
		return bean;//如果return null 的话就会将bean赋值为null  那样之后的方法就无法运行了
	}
	@Override
	public Object postProcessAfterInitialization(Object bean, String arg1) throws BeansException {
		System.out.println("后方法:"+arg1);
		
		//bean对象
		//生成jdk代理
		return Proxy.newProxyInstance(
				MyBeanPostProcessor.class.getClassLoader(), 
				bean.getClass().getInterfaces(),
				new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println("--开启事务");
						
						Object obj = method.invoke(bean, args);
						
						System.out.println("---更新事务");
						return obj;
					}
				});
		
	}

	

}
