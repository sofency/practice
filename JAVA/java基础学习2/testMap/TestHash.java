package testMap;
/**
 * 测试Hash
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
		
		System.out.println(h&(length-1));//约定数组的长度为2的整数幂 这样采用位运算即可实现取余的效果
		System.out.println(h%length);
		return 0;
	}
	
}
