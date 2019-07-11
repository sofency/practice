package testMap;

import java.util.HashMap;
import java.util.Map;


public class TestMap {
	
	public static void main(String[] args) {
		
		Map<Integer, String> m1=new HashMap<Integer, String>();
		
		m1.put(1,"one");
		m1.put(2, "two");
		m1.put(3,"three");
		System.out.println(m1.get(1));
		
		
		System.out.println(m1.size());
		System.out.println(m1.isEmpty());
		System.out.println(m1.containsKey(1));
		System.out.println(m1.containsValue("sofency"));
		
		
		Map<Integer, String> m2=new HashMap<Integer, String>();
		
		
		//map 中的键是不能重复的 如果重复则新值覆盖旧值
		m2.put(4, "ahoj");
		m2.put(5, "吴婷");
		
		m1.putAll(m2);
		System.out.println(m1);
		
	}

}
