package com.sofency.h_annotate_web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

public class studentAction {
	
	@Autowired  //�������ͼ���  д�ڼ����������
	private stuentService stuService;
	
	
	public void sayHello() {
		stuService.say();
	}
}