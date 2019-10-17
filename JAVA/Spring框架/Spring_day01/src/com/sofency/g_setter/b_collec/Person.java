package com.sofency.g_setter.b_collec;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Person {

	private String[] friends;
	private List<Object> girlFriend;
	private Set<Object> phone;
	private Map<String, Object> girlAndBoy;
	
	public Person() {
		super();
	}
	public Person(String[] friends, List<Object> girlFriend, Set<Object> phone, Map<String, Object> girlAndBoy) {
		super();
		this.friends = friends;
		this.girlFriend = girlFriend;
		this.phone = phone;
		this.girlAndBoy = girlAndBoy;
	}
	public String[] getFriends() {
		return friends;
	}
	public void setFriends(String[] friends) {
		this.friends = friends;
	}
	public List<Object> getGirlFriend() {
		return girlFriend;
	}
	public void setGirlFriend(List<Object> girlFriend) {
		this.girlFriend = girlFriend;
	}
	public Set<Object> getPhone() {
		return phone;
	}
	public void setPhone(Set<Object> phone) {
		this.phone = phone;
	}
	public Map<String, Object> getGirlAndBoy() {
		return girlAndBoy;
	}
	public void setGirlAndBoy(Map<String, Object> girlAndBoy) {
		this.girlAndBoy = girlAndBoy;
	}
	@Override
	public String toString() {
		return "Person [friends=" + Arrays.toString(friends) + ",\n 高富帅的女朋友们:" + girlFriend + ", \nphone=" + phone
				+ ", \ngirlAndBoy=" + girlAndBoy + "]";
	}
	
	
	
}
