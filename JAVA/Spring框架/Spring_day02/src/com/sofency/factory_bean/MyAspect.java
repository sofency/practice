package com.sofency.factory_bean;



import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 切面类确定通知 需要实现不同接口 接口就是规范 从而确定方法名称
 * 采用环绕通知 MethodIntercpetor
 * @author sofency
 *
 */

public class MyAspect implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation method) throws Throwable {
	
		System.out.println("前方法");
		//手动执行方法
		Object obj = method.proceed();
		//切入点  即增强的方法  切面类和目标类整合到一起让spring去整合	
		
		System.out.println("后方法");
		return null;
	}
}
