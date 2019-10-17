package com.sofency.AspectjXML;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * ����֪ͨ
 * @author sofency
 *
 */
public class MyAspectjXML {

	
	//ǰ��֪ͨ
	public void before(JoinPoint joinPoint) {
		System.out.println("ǰ�÷���"+joinPoint.getSignature().getName());
	}
	
	//����֪ͨ
	public void after(Object object) {//�в��������
//		System.out.println("���÷���"+joinPoint.getSignature().getName());
		System.out.println("���÷���"+object);
	
	}
	
	//����֪ͨ ������ProceedJoinPoint ���� try
	
	public Object MyAround(ProceedingJoinPoint joinPoint) throws Throwable{
		
		System.out.println("ǰ��֪ͨ");
		Object obj = joinPoint.proceed();//������ֵ����Object
		System.out.println("����֪ͨ"+obj);
		return obj;
	}
	
	//�׳��쳣֪ͨ  catch
	public void MyThrowable(JoinPoint joinPoint,Throwable e) {
		System.out.println("�����쳣");
		System.out.println(e.getMessage());
	}
	
	//����֪ͨfinally
	public void MyFinally() {
		System.out.println("����֪ͨ");
		
	}

}
