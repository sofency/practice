package testCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collections�������ʹ��
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
		
		Collections.shuffle(list);//����˳��
		System.out.println(list);
		
		Collections.reverse(list);//ת��
		System.out.println(list);
		
		Collections.sort(list);//����
		System.out.println(list);
		
		
		int i=Collections.binarySearch(list, "sofency3");//���ֲ���
		System.out.println(i);
		
		
	}
}
