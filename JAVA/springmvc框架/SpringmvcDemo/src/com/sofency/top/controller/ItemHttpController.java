package com.sofency.top.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;

import com.sofency.top.pojo.Item;

public class ItemHttpController implements HttpRequestHandler{

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		
		//类似于servlet的实现
		//设置模型数据
		request.setAttribute("itemList", itemList);
		//设置转发的视图
		request.getRequestDispatcher("/WEB-INF/jsp/items/itemList.jsp").forward(request, response);
		
	}

}
