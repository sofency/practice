package ����;

import java.util.ArrayList;
import java.util.List;

/**
 * �̰߳�ȫ�����  ��������
 * @author sofency
 *
 */
public class UnsafeTest3 {
	public static void main(String[] args) {
		
		 List<String> list=new ArrayList<String>();
		 
		 for(int i=0;i<10000;i++) {
			 new Thread(()->{
				 list.add(Thread.currentThread().getName());
			 }).start();
		 }
	 
		 System.out.println(list.size());//�̲߳���ȫ��ʧ����
		
	}
}