package com.sofency.entity;

import java.util.HashSet;
import java.util.Set;

public class Customer {
	//客户id
	private Integer cid;
	//客户名字
	private String custName;
	//客户级别
	private String custLevel;
	//客户来源
	private String custSource;
	//联系电话
	private String custPhone;
	//手机
	private String custMobile;
	
    private Set<linkMan> setLinkMan = new HashSet<linkMan>();
	
	public Set<linkMan> getSetLinkMan() {
		return setLinkMan;
	}
	public void setSetLinkMan(Set<linkMan> setLinkMan) {
		this.setLinkMan = setLinkMan;
	}
	
	
	public Customer() {
		super();
	}
	public Customer(Integer cid, String custName, String custLevel, String custSource, String custPhone,
			String custMobile) {
		super();
		this.cid = cid;
		this.custName = custName;
		this.custLevel = custLevel;
		this.custSource = custSource;
		this.custPhone = custPhone;
		this.custMobile = custMobile;
	}
	
	//一个客户有多个联系人
	
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustLevel() {
		return custLevel;
	}
	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel;
	}
	public String getCustSource() {
		return custSource;
	}
	public void setCustSource(String custSource) {
		this.custSource = custSource;
	}
	public String getCustPhone() {
		return custPhone;
	}
	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}
	public String getCustMobile() {
		return custMobile;
	}
	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", custName=" + custName + ", custLevel=" + custLevel + ", custSource="
				+ custSource + ", custPhone=" + custPhone + ", custMobile=" + custMobile + "]";
	}
	
	
}
