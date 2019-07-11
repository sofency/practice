package java再学习;

/**
 * break跳出多层循环
 */
public class testBreak {
	public static void main(String[] args) {
		
		//break 跳出单层循环
		System.out.println("break跳出单层循环");
		for (int i = 0; i < 5; i++) {
			for(int j=0;j<10;j++) {
				if(j>4) {
					break;
				}else {
					System.out.println(i+","+j);
				}
			}
		}
		
		//break 跳出多层循环
		System.out.println("break 跳出多层循环");
		break_point:
		for (int i = 0; i < 5; i++) {
			for(int j=0;j<10;j++) {
				if(j>4) {
					break break_point;
				}else {
					System.out.println(i+","+j);
				}
			}
		}
		
	}
}
