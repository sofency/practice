package testMap;
/**
 * ����Hash
 * @author sofency
 *
 */
public class TestHash {

	public static void main(String[] args) {
		
		int h=25860399;
		int length=16;
		myHsah(h, length);
	}
	
	
	public static int myHsah(int h,int length) {
		
		System.out.println(h&(length-1));//Լ������ĳ���Ϊ2�������� ��������λ���㼴��ʵ��ȡ���Ч��
		System.out.println(h%length);
		return 0;
	}
	
}
