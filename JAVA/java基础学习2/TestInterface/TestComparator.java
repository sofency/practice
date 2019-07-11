package TestInterface;

import java.util.Arrays;
import java.util.Comparator;

public class TestComparator {
	public static void main(String[] args) {
		String[] friends= {"Peter","Paul","Mary"};
		lengthComparator leng=new lengthComparator();
		Arrays.sort(friends,leng::compare);//第二个参数是比较的类型
		for(int  i=0;i<friends.length;i++) {
			System.out.println(friends[i]);
		}
	}
}
class lengthComparator implements Comparator<String>{//比较器 Comparator的实现决定了 要根据什么进行比较

	@Override
	public  int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return o1.length()-o2.length();
	}
	
}
