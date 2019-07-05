package 容器;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TestList {
	public static void main(String[] args) {
		
		test03();
	}
	
	public static void test01(){
        Collection<String> collection=new ArrayList<>();//定义一个String的泛型  String 可以用哪个对象来丰富功能
		
		System.out.println(collection.size());//泛型里面元素的多少
		
		
		System.out.println(collection.isEmpty());
		
		collection.add("sofency");//添加元素
		collection.add("ahoj");
		System.out.println(collection.size());
		System.out.println(collection);
		
		System.out.println("容器内是否含有元素ahoj:"+collection.contains("ahoj"));
		
		Object[] obj=collection.toArray();//转化为数组
		for (int i = 0; i < obj.length; i++) {
			System.out.println(obj[i]);
		}
		
		collection.remove("ahoj");//清除容器内的ahoj 元素
		System.out.println(collection.size());
		collection.clear();//清除容器内的所有元素
		System.out.println(collection.size());
}

	
	public static void test02() {
		
		List<String> list01=new ArrayList<String>();
		list01.add("aa");
		list01.add("bb");
		list01.add("cc");
		
		List<String> list02=new ArrayList<String>();
		list02.add("aa");
		list02.add("bb");
		list02.add("dd");
		
		//list01.addAll(list02); 添加所有的元素 aa  bb  cc  aa  bb  dd
		//list01.removeAll(list02); 去除相同的元素 cc
		
		//System.out.println(list01.containsAll(list02));//显示是否包含list02里面的所有元素 boolean false
		
		//list01.retainAll(list02);//保留相同的元素  aa bb 
		
		System.out.println(list01);//不排除相同的元素
		
				
		
		
	}


	public static void test03() {
		List<String> list=new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		System.out.println(list);
		
		list.add(2,"sofency");//在2的下标出添加元素  后面的元素向后移动
		System.out.println(list);
		
		list.remove(2);//移除下标2处的元素
		System.out.println(list);
		
		list.set(2, "sofency");//在下标2出覆盖元素
		System.out.println(list);
		
		
		list.add("D");
		list.add("C");
		list.add("B");
		System.out.println(list);
		
		System.out.println(list.indexOf("B"));  //返回第一次出现的下标
		System.out.println(list.lastIndexOf("B"));//返回最后一次出现的下标
	}
}
