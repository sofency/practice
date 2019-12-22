package com.sofency.Dao;

import java.util.List;

import com.sofency.domain.OrderCustom;
import com.sofency.domain.Orders;
import com.sofency.domain.User;
import com.sofency.domain.UserCustom;

public interface OrderDao {
	//һ��һ������ѯ�����������û�
	public List<OrderCustom> findOrdersUser();
	
	public List<OrderCustom> findOrdersUserByMap();
	
	//��ѯһ�Զ�
	public List<Orders> findOrdersAndOrderDetail();
	
	
	//��ѯ�����û��Ĺ�����Ʒ���
	List<User> findUserAndItems();
	
	List<UserCustom> findUserAndItemsByType();
	
	
	//�����صĹ���
	List<Orders> findOrderAndUserWithLazyLoad();
}
