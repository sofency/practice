package com.sofency.h_annotate_web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

public class studentAction {
	
	@Autowired  //根据类型加载  写在加载类的上面
	private stuentService stuService;
	
	
	public void sayHello() {
		stuService.say();
	}
}