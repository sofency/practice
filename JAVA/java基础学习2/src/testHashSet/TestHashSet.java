package testHashSet;
/**
 * Set 没有顺序 HashSet的基本用法
 * set 有顺序  不可重复
 * List 有顺序 可重复 
 */
import java.util.HashSet;
import java.util.Set;

public class TestHashSet {

	public static void main(String[] args) {
		
		Set<String> set1=new HashSet<String>();
		
		set1.add("aa");
		set1.add("bb");
		set1.add("aa");
		System.out.println(set1);
	}
}
