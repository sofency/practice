package com.sofency.entity;

public class linkMan {
	private Integer lkm_id;//联系人编号
	private String lkm_name;//联系人姓名
	private String lkm_gender;//联系人性别
	private String lkm_phone;//联系人电话
	private Customer customer;//联系人
	

	public linkMan() {
		super();
	}
	public linkMan(Integer lkm_id, String lkm_name, String lkm_gender, String lkm_phone) {
		super();
		this.lkm_id = lkm_id;
		this.lkm_name = lkm_name;
		this.lkm_gender = lkm_gender;
		this.lkm_phone = lkm_phone;
	}
	
	public Integer getLkm_id() {
		return lkm_id;
	}
	public void setLkm_id(Integer lkm_id) {
		this.lkm_id = lkm_id;
	}
	public String getLkm_name() {
		return lkm_name;
	}
	public void setLkm_name(String lkm_name) {
		this.lkm_name = lkm_name;
	}
	public String getLkm_gender() {
		return lkm_gender;
	}
	public void setLkm_gender(String lkm_gender) {
		this.lkm_gender = lkm_gender;
	}
	public String getLkm_phone() {
		return lkm_phone;
	}
	public void setLkm_phone(String lkm_phone) {
		this.lkm_phone = lkm_phone;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "linkMan [lkm_id=" + lkm_id + ", lkm_name=" + lkm_name + ", lkm_gender=" + lkm_gender + ", lkm_phone="
				+ lkm_phone + "]";
	}
	
}
