package java��ѧϰ;

/**
 * break�������ѭ��
 */
public class testBreak {
	public static void main(String[] args) {
		
		//break ��������ѭ��
		System.out.println("break��������ѭ��");
		for (int i = 0; i < 5; i++) {
			for(int j=0;j<10;j++) {
				if(j>4) {
					break;
				}else {
					System.out.println(i+","+j);
				}
			}
		}
		
		//break �������ѭ��
		System.out.println("break �������ѭ��");
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
