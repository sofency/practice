package ������;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * �������ṩ��ͳһ�ı��������ķ�ʽ
 * @author sofency
 *
 */

public class TestIterator {
	
	
	
	public static void main(String[] args) {
		//testIteratorList();//ʹ�õ���������List
		
		
		//testIteratorSet();//ʹ�õ���������Set
		
		testIteratorMap2();//ʹ�õ���������Map
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
        Set<String> list=new HashSet<String>();//���� ���ظ�
		
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
        Map<Integer,String> list=new HashMap<>();//���� ���ظ�
		
		list.put(10,"sofency");//����Ԫ����put
		list.put(11,"alaice");
		list.put(12,"ahoj");
		list.put(13,"aho");

		Set<Entry<Integer, String>> ss=list.entrySet();
		
		for(Iterator<Entry<Integer, String>> iter=ss.iterator();iter.hasNext();) {
			Entry<Integer, String> temp=iter.next();
			System.out.println(temp.getKey()+"--"+temp.getValue());
		}
	}
	
	
	//����Map��ʽ2
	public static void testIteratorMap2() {
		Map<Integer, String> map=new HashMap<Integer, String>();//
		map.put(10,"sofency");//����Ԫ����put
		map.put(11,"alaice");
		map.put(12,"ahoj");
		map.put(13,"aho");
		
		
		Set<Integer> ssSet=map.keySet();//��ȡkey���ļ���  Ȼ����ݼ��Ͻ��б�����ȡvalueֵ
		
		for(Iterator<Integer> iterator=ssSet.iterator();iterator.hasNext();) {
			Integer key=iterator.next();//��ȡkey��ָ��
			System.out.println(key+"--"+map.get(key));
			
		}
	}

}
