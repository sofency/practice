package java��ѧϰ;

import java.util.Date;

/**
 * 
 * @author sofency
 * ��ʽ��������ڵĸ�ʽ�÷�
 *
 */
public class testFormatDate {
	public static void main(String[] args) {
		Date  date=new Date();
		String year=String.format("%tY", date);
		String month=String.format("%tB", date);//��ʾ�������ĵ��·� eg:һ��  ����
		String day=String.format("%td", date);
		
		System.out.println("������������"+date);
		System.out.println("������"+year+"��");
		System.out.println("�·���"+month);
		System.out.println("������"+day+"��");
		
		
		
		
	}
}
