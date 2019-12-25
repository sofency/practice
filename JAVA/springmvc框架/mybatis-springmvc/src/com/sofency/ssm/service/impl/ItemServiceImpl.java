package com.sofency.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sofency.ssm.mapper.ItemMapperCustom;
import com.sofency.ssm.pojo.ItemCustom;
import com.sofency.ssm.pojo.ItemCustomVo;
import com.sofency.ssm.service.ItemService;

public class ItemServiceImpl implements ItemService{
	@Autowired
	private ItemMapperCustom itemMapperCustom; 
	@Override
	public List<ItemCustom> findByTomatoName(ItemCustomVo itemCustomVo) {
		return itemMapperCustom.findByTomatoName(itemCustomVo);
	}
}
