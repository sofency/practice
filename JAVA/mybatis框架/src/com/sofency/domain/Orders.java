package com.sofency.domain;

import java.util.Date;
import java.util.List;

public class Orders {
	
	private int orderId;//订单号
	private int user_Id;//用户Id
	private int number;//订单数量
	private Date createtime;//创建的时间
	//使用resultMap时所使用的
	private User user;
	private List<OrderDetail> orderDetail;
	public List<OrderDetail> getOrderDetail() {
		return orderDetail;
	}
	public void setOrderDetail(List<OrderDetail> orderDetail) {
		this.orderDetail = orderDetail;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Orders() {
		super();
	}
	public Orders(int orderId, int user_Id, int number, Date createtime, User user, List<OrderDetail> orderDetail) {
		super();
		this.orderId = orderId;
		this.user_Id = user_Id;
		this.number = number;
		this.createtime = createtime;
		this.user = user;
		this.orderDetail = orderDetail;
	}
	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", user_Id=" + user_Id + ", number=" + number + ", createtime="
				+ createtime + ", user=" + user + ", orderDetail=" + orderDetail + "]";
	}
	
}
