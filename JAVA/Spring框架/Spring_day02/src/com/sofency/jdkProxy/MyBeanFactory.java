package com.sofency.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.omg.CORBA.SystemException;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.InvokeHandler;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.ResponseHandler;

//����Ŀ�����������
public class MyBeanFactory {
	
	public static UserService createService() {
		
		//Ŀ����
		final UserService userService = new UserServiceImpl();
		//������
		final InsertDemo insert = new InsertDemo();
		
		/**
		 * 3.������ ��Ŀ����������� ���   
		 *           Proxy.newProxyInstance
		 *           ����1�� loader  �������  ��̬������  ����ʱ���� �κ��඼��Ҫ������ص��ڴ�
		 *           һ�������  ��ǰ��.class.getClassLoader();  Ҳ����Ŀ��ʵ����
		 * 			 ����2��interfaces  ��������Ҫʵ�ֵ����нӿ�
		 * 				��ʽ1��Ŀ����ʵ��.getClass().getInterfaces()  ֻ�ܻ�õ�ǰ���еĽӿ�  ���ܻ�ø�Ԫ�صĽӿ�
		 * 			 ����3��InvocationHandler  ������ �ӿ�  �������ʵ���� һ����������ڲ���  
		 * 			 �ṩinvoke()����  �������е�ÿ������ִ��ʱ ��������һ��invoke()
		 *            ����31  Obejct �������
		 *            ����32  Method  �������ǰִ�еķ������������󣨷��䣩
		 *            			����ʱ method.getName()  
		 *            ����33  object[] args ����ʵ�ʲ���
		 *            
		 *            
		 *            
		 */
		UserService proxyUser = (UserService)Proxy.newProxyInstance(
				MyBeanFactory.class.getClassLoader(),
				userService.getClass().getInterfaces(),
				new InvocationHandler() {
					
					@Override
					public Object invoke(Object arg0, Method method, Object[] arg2) throws Throwable {
						insert.before();
						Object object = method.invoke(userService);
						insert.after();
						return object;
					}
				});
		
		return proxyUser;
		
	}
}
