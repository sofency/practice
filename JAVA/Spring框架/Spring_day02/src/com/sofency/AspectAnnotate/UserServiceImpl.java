package com.sofency.AspectAnnotate;

import org.springframework.stereotype.Service;

@Service("UserServiceId")
public class UserServiceImpl implements UserService {
	@Override
	public  String   addUser() {
		System.out.println("add user");
		int i=1/0;
		return "sofency";
	}
	
	@Override
	public String deleteUser() {
		System.out.println("delete User");	
		return "delete";
	}
}
