package com.sofency.jdkProxy;

public class UserServiceImpl implements UserService{

	//下面的就是连接点
	@Override
	public void addUser() {
		// TODO Auto-generated method stub
		System.out.println("add User sofency");
	}

	@Override
	public void UpdateUser() {
		// TODO Auto-generated method stub
		System.out.println("Update User sofency");
	}

	@Override
	public void deleteUser() {
		// TODO Auto-generated method stub
		System.out.println("Delete User sofency");
	}
	
	
}
