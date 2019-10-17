package com.sofency.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class MyBeanFactory {
	public static UserServiceImpl createProxy() {
		//目标类
		final UserServiceImpl  user = new UserServiceImpl();
		//切入类
		final MyAspect myAspect = new MyAspect();
		
		//核心类  
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(user.getClass());//设置父类
		
		//设置回调函数  MethodInterceptor 接口等效于jdk  InvocationHandler接口
		
		enhancer.setCallback(new MethodInterceptor() {
			
			@Override
			public Object intercept(Object arg0, Method method, Object[] args, MethodProxy arg3) throws Throwable {
				//上面的参数和jdk动态代理一样
				
				myAspect.before();//增强前方法
				Object object = method.invoke(user, args);
				myAspect.after();//增强后方法
				return object;
			}
		});
		
		
		UserServiceImpl userProxy = (UserServiceImpl) enhancer.create();//创建代理类
		return userProxy;
	}
	
}
