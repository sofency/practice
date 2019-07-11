package TestInterface;

import java.awt.Toolkit;
import java.util.Arrays;

public class TestSortByObject {
	public static void main(String[] args) {
		Employee[] staff=new Employee[3];//设置数组对象
		
		staff[0]=new Employee("sofency",15000);
		staff[1]=new Employee("ahoj",25000);
		staff[2]=new Employee("alice",10000);
		
		Arrays.sort(staff);//根据CompareTo进行排序的
		//Arrays.sort必须实现CompareTo类		
		
		for (Employee employee : staff) {
			System.out.println(employee.getName()+":"+employee.getSalary());
		}
		
		Toolkit.getDefaultToolkit().beep();//响
	}
}
