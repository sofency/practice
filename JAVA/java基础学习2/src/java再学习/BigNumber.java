package java��ѧϰ;

import java.math.BigInteger;
import java.util.Scanner;

public class BigNumber {
	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {
		//ʹ�ô�����������n�Ľ׳�
		Scanner in=new Scanner(System.in);
		System.out.println("��������Խ׳���");
		int number=in.nextInt();//����Ҫ����Ľ׳˵�����
		BigInteger size=computeSize(number);
		System.out.println(size);
		System.out.println();
		int cnt=count3(size);
		System.out.println(cnt);
		
	}
	public static BigInteger computeSize(int number) {
		BigInteger bigInteger=BigInteger.valueOf(1);//����1000�Ľ׳�
		for(int i=1;i<number;i++) {
			bigInteger=bigInteger.multiply(BigInteger.valueOf(i));//��
		}
		return bigInteger;
	}
	
	//�鿴�������ж��ٸ�3
	public static int count3(BigInteger bigInteger) {
		int cnt=0;
		while(bigInteger!=BigInteger.ZERO) {
			BigInteger temp=bigInteger.mod(BigInteger.valueOf(10));//ȡ��
//			if(temp.equals(BigInteger.valueOf(3))) {//�����ıȽ���equals    ������==���бȽ�
//				cnt++;
//			}
			//compareTo���ص�������
			if(temp.compareTo(BigInteger.valueOf(3))==0) {//�����ıȽ���equals    ������==���бȽ�
				cnt++;
			}
			bigInteger=bigInteger.divide(BigInteger.valueOf(10));//��  ע����Ҫ��10��int��ת��Ϊ������
		}
		return cnt;
	}

	
}
