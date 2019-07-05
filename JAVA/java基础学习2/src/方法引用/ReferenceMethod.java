package 方法引用;

import java.util.Arrays;
import java.util.Comparator;

public class ReferenceMethod {
	public static void main(String[] args) {
		lengthComporator length=new lengthComporator();
		String[] nameStrings= new String[] {"alice","hel","wuha","configure","sofency"};
		
		Arrays.sort(nameStrings,length::compare);//object::instanceMethod  引用对象的实例方法
		for(int i=0;i<nameStrings.length;i++) {
			System.out.println(nameStrings[i]);
		}
		System.out.println("倒序排列");
		//引用类的静态方法		
		String[] name=new String[] {"iron","beer","robit","elephant","monkey"};
		Arrays.sort(name,lengthComporator::compare1);// Class::staticMethod 引用类的静态方法  这样引用方法的优点就是不用写参数或者new对象
		for(int i=0;i<name.length;i++) {
			System.out.println(name[i]);
		}
		
		System.out.println("测试方法引用");
		
	}
}
class lengthComporator implements Comparator<String>{

	@Override
	public  int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return o1.length()-o2.length();
	}
	
	public static int compare1(String o1, String o2) {
		return o2.length()-o1.length();
		
	}
}