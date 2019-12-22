package com.sofency.domain;

import java.util.List;

public class OrderDetail {
	//订单号 商品号 商品数量
	private int id;//订单明细的编号
	private int itemId;//商品号
	private int orderId;//订单号
	private int itemNum;//商品数量
	
	private item items;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getItemNum() {
		return itemNum;
	}
	public void setItemNum(int itemNum) {
		this.itemNum = itemNum;
	}
	
	public OrderDetail() {
		super();
	}
	public item getItems() {
		return items;
	}
	public void setItems(item items) {
		this.items = items;
	}
	public OrderDetail(int id, int itemId, int orderId, int itemNum, item items) {
		super();
		this.id = id;
		this.itemId = itemId;
		this.orderId = orderId;
		this.itemNum = itemNum;
		this.items = items;
	}
	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", itemId=" + itemId + ", orderId=" + orderId + ", itemNum=" + itemNum
				+ ", items=" + items + "]";
	}
	
}
