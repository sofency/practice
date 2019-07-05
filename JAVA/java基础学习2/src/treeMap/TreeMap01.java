package treeMap;

import java.util.Map;
import java.util.TreeMap;

/**
 * TreeMap��HashMap������ 1. HashMap����ͨ��hashcode���п��ٵĲ���   �ǻ���hashcodeʵ�ֵ�
 * ��treemap��ÿ��Ԫ�ض�������һ����˳��  �����Ҫ�õ�һ��˳���Ԫ�صĻ�ʹ��treeMap  �ǻ��ں�����γɵ�
 * @author sofency
 *
 */

public class TreeMap01 {
	public static void main(String[] args) {
		
		Map<Integer, String> treemap=new TreeMap<>();
		treemap.put(11, "sofency");
		treemap.put(12, "alice");
		treemap.put(16, "hello");
		
		//����key�����ķ�ʽ����  
		for (Integer key:treemap.keySet()) {
			System.out.println(key+"---"+treemap.get(key));
		}
		
		Map<Employee, String> map1=new TreeMap<Employee, String>();
		map1.put(new Employee(001, "sofency", 20000), "����sofency");
		map1.put(new Employee(002, "alice", 5000), "����alice");
		map1.put(new Employee(003, "hello", 10000), "����sofy");
		map1.put(new Employee(004, "wq", 20000), "����fency");
		
		//����key�����ķ�ʽ����
		for (Employee key:map1.keySet()) {
			System.out.println(key+"---"+map1.get(key));
		}				
	}
}

class Employee implements Comparable<Employee>{
	private int id;
	private String ename;
	private int salary;//нˮ
	
	public Employee(int id, String ename, int salary) {
		super();
		this.id = id;
		this.ename = ename;
		this.salary = salary;
	}

	@Override
	public int compareTo(Employee o) {
		if(this.salary==o.salary) {
			return this.id-o.id;
		}else {
			return this.salary-o.salary;//����ķ�ʽ			
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id:"+id+",ename:"+ename+",salary:"+salary;
	}
	
}
