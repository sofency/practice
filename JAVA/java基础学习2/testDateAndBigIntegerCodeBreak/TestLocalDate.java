package java��ѧϰ;

import java.time.LocalDate;

public class TestLocalDate {
	public static void main(String[] args) {
		LocalDate localDate=LocalDate.now();//��ȡ��ǰ��ʱ��
		System.out.println("��ǰ������ǣ�"+localDate.getYear());
		System.out.println("��ǰ���·��ǣ�"+localDate.getMonth());//���ص���Ӣ�ĵ��·�
		System.out.println("��ǰ���գ�"+localDate.getDayOfMonth());
		
		
		System.out.println("��ǰʱ�����1000��������");
		LocalDate aThousandDate=localDate.plusDays(1000);
		System.out.println("1000�������ǣ�"+aThousandDate.getYear());
		System.out.println("1000����·��ǣ�"+aThousandDate.getMonth());
		System.out.println("1000����գ�"+aThousandDate.getDayOfMonth());
		
		//�����ض�������
		LocalDate passDate=LocalDate.of(1998, 01, 20);
		
		System.out.println(passDate.getMonth());//�Զ���������
		
	}
}
