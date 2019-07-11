package treeMap;

import java.util.Map;
import java.util.TreeMap;

/**
 * TreeMap和HashMap的区别 1. HashMap可以通过hashcode进行快速的查找   是基于hashcode实现的
 * 而treemap的每个元素都保持者一定的顺序  如果想要得到一定顺序的元素的话使用treeMap  是基于红黑树形成的
 * @author sofency
 *
 */

public class TreeMap01 {
	public static void main(String[] args) {
		
		Map<Integer, String> treemap=new TreeMap<>();
		treemap.put(11, "sofency");
		treemap.put(12, "alice");
		treemap.put(16, "hello");
		
		//按照key递增的方式排序  
		for (Integer key:treemap.keySet()) {
			System.out.println(key+"---"+treemap.get(key));
		}
		
		Map<Employee, String> map1=new TreeMap<Employee, String>();
		map1.put(new Employee(001, "sofency", 20000), "我是sofency");
		map1.put(new Employee(002, "alice", 5000), "我是alice");
		map1.put(new Employee(003, "hello", 10000), "我是sofy");
		map1.put(new Employee(004, "wq", 20000), "我是fency");
		
		//按照key递增的方式排序
		for (Employee key:map1.keySet()) {
			System.out.println(key+"---"+map1.get(key));
		}				
	}
}

class Employee implements Comparable<Employee>{
	private int id;
	private String ename;
	private int salary;//薪水
	
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
			return this.salary-o.salary;//排序的方式			
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id:"+id+",ename:"+ename+",salary:"+salary;
	}
	
}
