package testCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collections辅助类的使用
 * @author sofency
 *
 */
public class TestCollections {
	public static void main(String[] args) {
		
		List<String> list=new ArrayList<String>();
		
		for(int i=0;i<10;i++) {
			list.add("sofency"+i);
		}
		System.out.println(list);
		
		Collections.shuffle(list);//打乱顺序
		System.out.println(list);
		
		Collections.reverse(list);//转置
		System.out.println(list);
		
		Collections.sort(list);//排序
		System.out.println(list);
		
		
		int i=Collections.binarySearch(list, "sofency3");//二分查找
		System.out.println(i);
		
		
	}
}
