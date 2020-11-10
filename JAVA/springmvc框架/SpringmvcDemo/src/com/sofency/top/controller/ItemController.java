package com.sofency.top.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.sofency.top.pojo.Item;

@RestController
public class ItemController implements Controller {

	@RequestMapping("/hello")
	public List<Item> handleRequest() throws Exception {
		//调用service操作数据库  查询商品列表 这里使用的是静态数据进行模拟
		List<Item> itemList = new ArrayList<Item>();
		Item item1 = new Item();
		item1.setItemid(1);
		item1.setItemname("sofency");
		item1.setItemprice(12);
		
		Item item2 = new Item();
		item2.setItemid(2);
		item2.setItemname("alice");
		item2.setItemprice(10);
		itemList.add(item1);
		itemList.add(item2);
		return itemList;
	}
	@RequestMapping(value="/rest",method=RequestMethod.PUT)
	public String rest( String username){
		System.out.println("处理rest请求");
		return "success";
	}
	
	/*
		
	*/
	
	@RequestMapping(value="/rest",method=RequestMethod.PUT)
	public String testInject(@RequetParam("username",defaultValue="sofency",require=false) String username){
		System.out.println("处理rest请求");
		return "success";
	}

}
