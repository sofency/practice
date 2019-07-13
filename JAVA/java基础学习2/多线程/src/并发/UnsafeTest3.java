package 并发;

import java.util.ArrayList;
import java.util.List;

/**
 * 线程安全的理解  操作容器
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
	 
		 System.out.println(list.size());//线程不安全丢失数据
		
	}
}