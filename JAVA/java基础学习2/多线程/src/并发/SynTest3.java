package 并发;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 线程安全的理解  操作容器
 * @author sofency
 *
 */
public class SynTest3 {
	public static void main(String[] args) {
		
		 List<String> list=new ArrayList<String>();
		 
		 //CopyOnWriteArrayList<String> list2=new CopyOnWriteArrayList<String>();//内部自动加了锁
		 for(int i=0;i<10000;i++) {
			 new Thread(()->{
				 synchronized (list) {					
					 list.add(Thread.currentThread().getName());
				}
			 }).start();
		 }
		 
		 //等待一会
		 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
		 System.out.println(list.size());//线程不安全丢失数据
		
	}
}