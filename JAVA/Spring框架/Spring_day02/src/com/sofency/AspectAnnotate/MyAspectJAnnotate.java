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
 * ����֪ͨ
 * @author sofency
 *
 */
@Component
//��������
@Aspect
public class MyAspectJAnnotate {

	
	//ǰ��֪ͨ
	//@Before("execution(* com.sofency.AspectAnnotate.UserServiceImpl.*(..))")//��Ըð��µ����з���
	public void before(JoinPoint joinPoint) {
		System.out.println("ǰ�÷���"+joinPoint.getSignature().getName());
	}
	
	//�������������
	@Pointcut("execution(* com.sofency.AspectAnnotate.UserServiceImpl.*(..))")
	private void myPointCut() {
		
	}
	//������ֵ�ĺ���֪ͨ
	//@AfterReturning(value="myPointCut()",returning="name")
	public void after(JoinPoint joinPoint ,Object name) {//�в��������
//		System.out.println("���÷���"+joinPoint.getSignature().getName());
		System.out.println("���÷���"+name);
	
	}
	
	//����֪ͨ ������ProceedJoinPoint ���� try
	//@Around(value="myPointCut()")
	public Object MyAround(ProceedingJoinPoint joinPoint) throws Throwable{
		
		System.out.println("ǰ��֪ͨ");
		Object obj = joinPoint.proceed();//������ֵ����Object
		System.out.println("����֪ͨ"+obj);
		return obj;
	}
//	
	//�׳��쳣֪ͨ  catch
	//@AfterThrowing(value="myPointCut()",throwing="e")
	@AfterThrowing(value="execution(* com.sofency.AspectAnnotate.UserServiceImpl.*(..))",throwing="e")
	public void MyThrowable(JoinPoint joinPoint,Throwable e) {
		System.out.println("�����쳣");
		System.out.println(e.getMessage());
	}
//	
//	//����֪ͨfinally����֪ͨ
	@After(value="execution(* com.sofency.AspectAnnotate.UserServiceImpl.*(..))")
	public void MyFinally() {
		System.out.println("����֪ͨ");
		
	}

}
