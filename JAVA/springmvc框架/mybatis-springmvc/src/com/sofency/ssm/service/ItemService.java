package com.sofency.ssm.service;

import java.util.List;

import com.sofency.ssm.pojo.ItemCustom;
import com.sofency.ssm.pojo.ItemCustomVo;

public interface ItemService {
	//��ѯ��ѯ�����д�����������Ʒ
	//������mapper�е�ItemMapperCustom�еĽӿ�һ��
	public   List<ItemCustom> findByTomatoName(ItemCustomVo itemCustomVo);
}
