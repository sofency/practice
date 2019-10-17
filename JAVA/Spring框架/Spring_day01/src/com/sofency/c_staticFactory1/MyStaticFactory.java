package com.sofency.c_staticFactory1;

public class MyStaticFactory {
	public static Factory makeFactory(String thing){
		if("window".equals(thing)){
			return new CarWindow();
		}else if("Tyre".equals(thing)){
			return new CarTyre();
		}else {
			return null;
		}
	}
}
