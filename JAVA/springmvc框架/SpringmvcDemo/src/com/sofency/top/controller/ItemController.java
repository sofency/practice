package com.sofency.top.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.sofency.top.pojo.Item;

public class ItemController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//����service�������ݿ�  ��ѯ��Ʒ�б� ����ʹ�õ��Ǿ�̬���ݽ���ģ��
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
		
		//����modelAndView
		ModelAndView model = new ModelAndView();
		
		model.addObject("itemList", itemList);
		model.setViewName("/WEB-INF/jsp/items/itemList.jsp");
		
		return model;
	}

}
