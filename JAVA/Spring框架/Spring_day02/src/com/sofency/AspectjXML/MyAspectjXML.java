package com.sofency.AspectjXML;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 配置通知
 * @author sofency
 *
 */
public class MyAspectjXML {

	
	//前置通知
	public void before(JoinPoint joinPoint) {
		System.out.println("前置方法"+joinPoint.getSignature().getName());
	}
	
	//后置通知
	public void after(Object object) {//有参数的情况
//		System.out.println("后置方法"+joinPoint.getSignature().getName());
		System.out.println("后置方法"+object);
	
	}
	
	//环绕通知 必须是ProceedJoinPoint 类型 try
	
	public Object MyAround(ProceedingJoinPoint joinPoint) throws Throwable{
		
		System.out.println("前置通知");
		Object obj = joinPoint.proceed();//将返回值赋给Object
		System.out.println("后置通知"+obj);
		return obj;
	}
	
	//抛出异常通知  catch
	public void MyThrowable(JoinPoint joinPoint,Throwable e) {
		System.out.println("捕获到异常");
		System.out.println(e.getMessage());
	}
	
	//最终通知finally
	public void MyFinally() {
		System.out.println("最终通知");
		
	}

}
