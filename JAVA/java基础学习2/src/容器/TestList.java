package ����;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TestList {
	public static void main(String[] args) {
		
		test03();
	}
	
	public static void test01(){
        Collection<String> collection=new ArrayList<>();//����һ��String�ķ���  String �������ĸ��������ḻ����
		
		System.out.println(collection.size());//��������Ԫ�صĶ���
		
		
		System.out.println(collection.isEmpty());
		
		collection.add("sofency");//���Ԫ��
		collection.add("ahoj");
		System.out.println(collection.size());
		System.out.println(collection);
		
		System.out.println("�������Ƿ���Ԫ��ahoj:"+collection.contains("ahoj"));
		
		Object[] obj=collection.toArray();//ת��Ϊ����
		for (int i = 0; i < obj.length; i++) {
			System.out.println(obj[i]);
		}
		
		collection.remove("ahoj");//��������ڵ�ahoj Ԫ��
		System.out.println(collection.size());
		collection.clear();//��������ڵ�����Ԫ��
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
		
		//list01.addAll(list02); ������е�Ԫ�� aa  bb  cc  aa  bb  dd
		//list01.removeAll(list02); ȥ����ͬ��Ԫ�� cc
		
		//System.out.println(list01.containsAll(list02));//��ʾ�Ƿ����list02���������Ԫ�� boolean false
		
		//list01.retainAll(list02);//������ͬ��Ԫ��  aa bb 
		
		System.out.println(list01);//���ų���ͬ��Ԫ��
		
				
		
		
	}


	public static void test03() {
		List<String> list=new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		System.out.println(list);
		
		list.add(2,"sofency");//��2���±�����Ԫ��  �����Ԫ������ƶ�
		System.out.println(list);
		
		list.remove(2);//�Ƴ��±�2����Ԫ��
		System.out.println(list);
		
		list.set(2, "sofency");//���±�2������Ԫ��
		System.out.println(list);
		
		
		list.add("D");
		list.add("C");
		list.add("B");
		System.out.println(list);
		
		System.out.println(list.indexOf("B"));  //���ص�һ�γ��ֵ��±�
		System.out.println(list.lastIndexOf("B"));//�������һ�γ��ֵ��±�
	}
}
