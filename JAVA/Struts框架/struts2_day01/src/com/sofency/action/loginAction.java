package com.sofency.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

public class loginAction extends ActionSupport{
	
	//list 方法封装数据
	private List<UserLogin> list;
	
	public List<UserLogin> getList() {
		return list;
	}


	public void setList(List<UserLogin> list) {
		this.list = list;
	}


	@Override
	public String execute() throws Exception {
		
		System.out.println(list);
		return NONE;
	}
	
	
	//map方法封装数据
//	private Map<String, UserLogin>  map;
//
//	public Map<String, UserLogin> getMap() {
//		return map;
//	}
//
//
//	public void setMap(Map<String, UserLogin> map) {
//		this.map = map;
//	}
//	
//    public String execute() throws Exception {
//		
//		System.out.println(map);
//		return NONE;
//	}
	
}
