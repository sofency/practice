package com.sofency.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sofency.ssm.pojo.ItemCustom;
import com.sofency.ssm.pojo.ItemCustomVo;
import com.sofency.ssm.service.ItemService;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;//����service��
	
	@RequestMapping("/queryItem")
	public ModelAndView findItemListByName() {
		ItemCustom item= new ItemCustom();
		item.setItemname("����");
		ItemCustomVo itemCustom = new ItemCustomVo();
		itemCustom.setItemCustom(item);
		List<ItemCustom> itemList = itemService.findByTomatoName(itemCustom);
		//����modelAndView
		ModelAndView model = new ModelAndView();
		
		model.addObject("itemList", itemList);
		//ǰ׺�ͺ�׺����ͼ������������
		model.setViewName("items/itemList");
		
		return model;
	}

}
