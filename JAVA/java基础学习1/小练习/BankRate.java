package practice;

import java.util.Scanner;
public class BankRate {
	public static void main(String[] args) {
		int totalMoney=0;
		System.out.println("������Ŀ                                             ����(%)");
		System.out.println("���ڴ��                                            0.35");
		System.out.println("�����¶��ڴ��                                1.10");
		System.out.println("���궨�ڴ��                                    1.30");
		System.out.println("һ�궨�ڴ��                                    1.50");
		System.out.println("���궨�ڴ��                                     2.10");
		Scanner input=new Scanner(System.in);
		System.out.print("����������  ");
		double money=input.nextDouble();
		System.out.print("������ѡ��������:  1:���ڡ�2:����");
		int keepType=input.nextInt();
		System.out.print("������������  ");
		double keepAge=input.nextDouble();
		int Age=(int)(keepAge*10);
		if(keepType==1){
			totalMoney=(int)(money*Math.pow((100+0.35)/100, keepAge));
		}
		else{
			switch(Age){
			case 3: totalMoney=(int)(money*Math.pow((100+1.10)/100, 0.3));break;
			case 5: totalMoney=(int)(money*Math.pow((100+1.30)/100, 0.5));break;
			case 10: totalMoney=(int)(money*Math.pow((100+1.50)/100, 1));break;
			case 20: totalMoney=(int)(money*Math.pow((100+2.10)/100, 2));break;
			}
		}
		System.out.println(keepAge+"year you can get"+totalMoney);
		
	}

}
