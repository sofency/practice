package com.sofency.Dao;

import java.util.List;

import com.sofency.domain.OrderCustom;
import com.sofency.domain.Orders;
import com.sofency.domain.User;
import com.sofency.domain.UserCustom;

public interface OrderDao {
	//一对一关联查询订单关联的用户
	public List<OrderCustom> findOrdersUser();
	
	public List<OrderCustom> findOrdersUserByMap();
	
	//查询一对多
	public List<Orders> findOrdersAndOrderDetail();
	
	
	//查询所有用户的购买商品情况
	List<User> findUserAndItems();
	
	List<UserCustom> findUserAndItemsByType();
	
	
	//懒加载的功能
	List<Orders> findOrderAndUserWithLazyLoad();
}
