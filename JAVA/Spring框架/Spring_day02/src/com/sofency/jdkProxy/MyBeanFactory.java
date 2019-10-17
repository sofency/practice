package com.sofency.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.omg.CORBA.SystemException;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.InvokeHandler;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.ResponseHandler;

//整合目标类和切面类
public class MyBeanFactory {
	
	public static UserService createService() {
		
		//目标类
		final UserService userService = new UserServiceImpl();
		//切面类
		final InsertDemo insert = new InsertDemo();
		
		/**
		 * 3.代理类 将目标类和切面类 结合   
		 *           Proxy.newProxyInstance
		 *           参数1： loader  类加载器  动态代理类  运行时创建 任何类都需要将其加载到内存
		 *           一般情况下  当前类.class.getClassLoader();  也可以目标实例类
		 * 			 参数2：interfaces  代理类需要实现的所有接口
		 * 				方式1：目标类实例.getClass().getInterfaces()  只能获得当前类中的接口  不能获得父元素的接口
		 * 			 参数3：InvocationHandler  处理类 接口  必须进行实现类 一般采用您名内部类  
		 * 			 提供invoke()方法  代理类中的每个方法执行时 都将调用一次invoke()
		 *            参数31  Obejct 代理对象
		 *            参数32  Method  代理对象当前执行的方法的描述对象（反射）
		 *            			过滤时 method.getName()  
		 *            参数33  object[] args 方法实际参数
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
