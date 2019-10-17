package com.sofency.cglib;

public class testDemo {
	public static void main(String[] args) {
		UserServiceImpl userService = MyBeanFactory.createProxy();
		userService.addUser();
		userService.deleteUser();
	}

	
	//两种增强的方法比较
	/**
	 * 1. jdk动态代理不用导包  而cglib需要导Spring-core的jar包
	 * 2. jdk动态代理的目标类采用接口的方式   而cglib 采用的节继承父类(目标类)的方式
	 * 
	 */
}
