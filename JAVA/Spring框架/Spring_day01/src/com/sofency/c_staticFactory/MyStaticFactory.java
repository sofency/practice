package com.sofency.c_staticFactory;

public class MyStaticFactory {
	
	
	public static UserService createStaticFactory() {
		return new UserServiceImpl();
	}
}
