package com.sofency.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.sofency.Entity.User;


public class ognlList extends ActionSupport{
	
	private List<User> list=new ArrayList<User>();
	
	public List<User> getList() {
		return list;
	}

	@Override
	public String execute() throws Exception {
		User u1 = new User("sofency","12212");//放入list集合中		
		User u2 = new User("alice","2121");		
		User u3 = new User("吴婷","298021");
		
		list.add(u1);
		list.add(u2);
		list.add(u3);
		return SUCCESS;
	}

}
