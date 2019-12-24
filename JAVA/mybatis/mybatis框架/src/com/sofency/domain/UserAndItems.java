package com.sofency.domain;

public class UserAndItems {
	private String username;
	private String address;
	private int itemId;
	private String itemName;
	private int itemPrice;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	@Override
	public String toString() {
		return "UserAndItems [username=" + username + ", address=" + address + ", itemId=" + itemId + ", itemName="
				+ itemName + ", itemPrice=" + itemPrice + "]";
	}

}
