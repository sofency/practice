package ����;

import java.util.ArrayList;
import java.util.List;

public class TestGeneric {
	public static void main(String[] args) {
		MyCollection<String> mc=new MyCollection<>();
		//�����������������
		mc.set("����", 0);
		//mc.set(8888, 1);//�����ԭ�������String��ǩ���治���ҷ�
		//������������ȡ����
		
		//Integer a=(Integer)mc.get(1);//��ȡ�Ļ�����ת��Ϊ��Ӧ�Ķ���
		
		String name=(String)mc.get(0);
		
	}

}
class MyCollection<E>{
	Object[] objects=new Object[5];
	
	public void set(E e,int index) {
		objects[index]=e;
	}
	public E get(int index) {
		return (E)objects[index];
	}
}
