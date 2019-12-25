package com.sofency.ssm.mapper;

import java.util.List;

import com.sofency.ssm.pojo.ItemCustom;
import com.sofency.ssm.pojo.ItemCustomVo;

//实现复杂的条件查询
public interface ItemMapperCustom {
   List<ItemCustom> findByTomatoName(ItemCustomVo itemCustomVo);
}