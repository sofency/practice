package testHashSet;
/**
 * Set û��˳�� HashSet�Ļ����÷�
 * set ��˳��  �����ظ�
 * List ��˳�� ���ظ� 
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
