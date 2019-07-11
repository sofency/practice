package 迭代器;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 迭代器提供了统一的遍历容器的方式
 * @author sofency
 *
 */

public class TestIterator {
	
	
	
	public static void main(String[] args) {
		//testIteratorList();//使用迭代器遍历List
		
		
		//testIteratorSet();//使用迭代器遍历Set
		
		testIteratorMap2();//使用迭代器遍历Map
	}
	
	
	
	public static void testIteratorList() {
		List<String> list=new ArrayList<String>();//
		
		list.add("sofency");
		list.add("alaice");
		list.add("ahoj");

		for(Iterator<String> iterator=list.iterator();iterator.hasNext();) {
	
			String temp=iterator.next();
			System.out.println(temp);
		}
		
		
	}
	
	
	public static void testIteratorSet() {
        Set<String> list=new HashSet<String>();//无序 不重复
		
		list.add("sofency");
		list.add("alaice");
		list.add("ahoj");
		list.add("aho");

		for(Iterator<String> iterator=list.iterator();iterator.hasNext();) {
	
			String temp=iterator.next();
			System.out.println(temp);
		}
	}
	
	public static void testIteratorMap() {
        Map<Integer,String> list=new HashMap<>();//无序 不重复
		
		list.put(10,"sofency");//放入元素用put
		list.put(11,"alaice");
		list.put(12,"ahoj");
		list.put(13,"aho");

		Set<Entry<Integer, String>> ss=list.entrySet();
		
		for(Iterator<Entry<Integer, String>> iter=ss.iterator();iter.hasNext();) {
			Entry<Integer, String> temp=iter.next();
			System.out.println(temp.getKey()+"--"+temp.getValue());
		}
	}
	
	
	//遍历Map方式2
	public static void testIteratorMap2() {
		Map<Integer, String> map=new HashMap<Integer, String>();//
		map.put(10,"sofency");//放入元素用put
		map.put(11,"alaice");
		map.put(12,"ahoj");
		map.put(13,"aho");
		
		
		Set<Integer> ssSet=map.keySet();//获取key键的集合  然后根据集合进行遍历获取value值
		
		for(Iterator<Integer> iterator=ssSet.iterator();iterator.hasNext();) {
			Integer key=iterator.next();//获取key的指向
			System.out.println(key+"--"+map.get(key));
			
		}
	}

}
