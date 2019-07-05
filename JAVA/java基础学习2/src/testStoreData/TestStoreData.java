package testStoreData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestStoreData {
	public static void main(String[] args) {
		
		User user1=new User(1001,"sofency",20000,"2018.5.5");
		User user2=new User(1002,"alice",10000,"2008.4.4");
		User user3=new User(1003,"ahoj",30000,"2020.5.5");
		
		//List存储
		List<User> list=new ArrayList<>();
		list.add(user1);
		list.add(user2);
		list.add(user3);
		for (User user : list) {
			System.out.println(user);
		}
		
		//Map存储
		Map<Integer, User> map=new HashMap<Integer, User>();
		map.put(1001, user1);
		map.put(1002, user2);
		map.put(1003, user3);
		
		Set<Integer> set=map.keySet();//获取键集合
		for (Integer integer : set) {
			System.out.println(integer+"==="+map.get(integer));
		}
		
		
		
		
		
		
	}
	
	
	
}

class User{
	
	private int id;
	private String nameString;
	private int salary;
	private String dateString;
	

	//一个完整的Javabean 要有一个完整的无参构造器
	public User(){
		
	}
	public User(int id, String nameString, int salary, String dateString) {
		super();
		this.id = id;
		this.nameString = nameString;
		this.salary = salary;
		this.dateString = dateString;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getDateString() {
		return dateString;
	}
	public void setDateString(String dateString) {
		this.dateString = dateString;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id:"+id+",name:"+nameString+",salary:"+salary+",date:"+dateString;
	}
	
}
