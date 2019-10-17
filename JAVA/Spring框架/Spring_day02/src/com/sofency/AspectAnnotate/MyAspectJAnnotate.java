package com.sofency.AspectAnnotate;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 配置通知
 * @author sofency
 *
 */
@Component
//声明切面
@Aspect
public class MyAspectJAnnotate {

	
	//前置通知
	//@Before("execution(* com.sofency.AspectAnnotate.UserServiceImpl.*(..))")//针对该包下的所有方法
	public void before(JoinPoint joinPoint) {
		System.out.println("前置方法"+joinPoint.getSignature().getName());
	}
	
	//声明公共切入点
	@Pointcut("execution(* com.sofency.AspectAnnotate.UserServiceImpl.*(..))")
	private void myPointCut() {
		
	}
	//带返回值的后置通知
	//@AfterReturning(value="myPointCut()",returning="name")
	public void after(JoinPoint joinPoint ,Object name) {//有参数的情况
//		System.out.println("后置方法"+joinPoint.getSignature().getName());
		System.out.println("后置方法"+name);
	
	}
	
	//环绕通知 必须是ProceedJoinPoint 类型 try
	//@Around(value="myPointCut()")
	public Object MyAround(ProceedingJoinPoint joinPoint) throws Throwable{
		
		System.out.println("前置通知");
		Object obj = joinPoint.proceed();//将返回值赋给Object
		System.out.println("后置通知"+obj);
		return obj;
	}
//	
	//抛出异常通知  catch
	//@AfterThrowing(value="myPointCut()",throwing="e")
	@AfterThrowing(value="execution(* com.sofency.AspectAnnotate.UserServiceImpl.*(..))",throwing="e")
	public void MyThrowable(JoinPoint joinPoint,Throwable e) {
		System.out.println("捕获到异常");
		System.out.println(e.getMessage());
	}
//	
//	//最终通知finally最终通知
	@After(value="execution(* com.sofency.AspectAnnotate.UserServiceImpl.*(..))")
	public void MyFinally() {
		System.out.println("最终通知");
		
	}

}
