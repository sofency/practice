package ����;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * �̰߳�ȫ�����  ��������
 * @author sofency
 *
 */
public class SynTest3 {
	public static void main(String[] args) {
		
		 List<String> list=new ArrayList<String>();
		 
		 //CopyOnWriteArrayList<String> list2=new CopyOnWriteArrayList<String>();//�ڲ��Զ�������
		 for(int i=0;i<10000;i++) {
			 new Thread(()->{
				 synchronized (list) {					
					 list.add(Thread.currentThread().getName());
				}
			 }).start();
		 }
		 
		 //�ȴ�һ��
		 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
		 System.out.println(list.size());//�̲߳���ȫ��ʧ����
		
	}
}