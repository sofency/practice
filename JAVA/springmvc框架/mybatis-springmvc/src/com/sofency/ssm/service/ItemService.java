package com.sofency.ssm.service;

import java.util.List;

import com.sofency.ssm.pojo.ItemCustom;
import com.sofency.ssm.pojo.ItemCustomVo;

public interface ItemService {
	//查询查询名字中带有土豆的商品
	//和上面mapper中的ItemMapperCustom中的接口一样
	public   List<ItemCustom> findByTomatoName(ItemCustomVo itemCustomVo);
}
