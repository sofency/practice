package com.sofency.factory_bean;



import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * ������ȷ��֪ͨ ��Ҫʵ�ֲ�ͬ�ӿ� �ӿھ��ǹ淶 �Ӷ�ȷ����������
 * ���û���֪ͨ MethodIntercpetor
 * @author sofency
 *
 */

public class MyAspect implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation method) throws Throwable {
	
		System.out.println("ǰ����");
		//�ֶ�ִ�з���
		Object obj = method.proceed();
		//�����  ����ǿ�ķ���  �������Ŀ�������ϵ�һ����springȥ����	
		
		System.out.println("�󷽷�");
		return null;
	}
}
