package com.sofency.ssm.mapper;

import java.util.List;

import com.sofency.ssm.pojo.ItemCustom;
import com.sofency.ssm.pojo.ItemCustomVo;

//ʵ�ָ��ӵ�������ѯ
public interface ItemMapperCustom {
   List<ItemCustom> findByTomatoName(ItemCustomVo itemCustomVo);
}