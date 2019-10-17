package com.sofency.d_Factory;

/**
 * 实例工厂
 * @author sofency
 * 所有方法非静态
 * 1.必须有返回值
 */
public class MyTestFactory {
	
	//不用写静态了
	public UserService createBeanFactory() {
		return new UserServiceImpl();
	}
	//不建议这样写  就写一般的接口实现返回给spring 进行调用接口里面的方法 工厂负责生产bean
//	public String sayHelloSpring() {
//		System.out.println("Say Hello Spring");
//		return "sofency";
//	}
}
