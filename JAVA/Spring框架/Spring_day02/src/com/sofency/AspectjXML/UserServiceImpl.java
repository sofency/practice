package com.sofency.AspectjXML;

import org.springframework.stereotype.Service;

public class UserServiceImpl implements UserService {
	@Override
	public  String   addUser() {
		System.out.println("add user");
		//int i=1/0;
		return "sofency";
	}
	
	@Override
	public void deleteUser() {
		System.out.println("delete User");		
	}
}
