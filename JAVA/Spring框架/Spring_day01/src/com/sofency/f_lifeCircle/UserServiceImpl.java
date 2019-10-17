package com.sofency.f_lifeCircle;

public class UserServiceImpl implements UserService {

	@Override
	public void addUser() {
		// TODO Auto-generated method stub
		System.out.println("生命周期测试 add user");
	}
	
	public void initMethod() {
		System.out.println("初始化方法开始");
	}
	
	public void destoryMethod() {
		System.out.println("结束方法");
	}
}
