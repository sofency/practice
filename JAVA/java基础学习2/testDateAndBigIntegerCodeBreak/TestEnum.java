package java��ѧϰ;

import java.util.Scanner;

public class TestEnum {
	public static void main(String[] args) {
		
		Scanner  inScanner =new Scanner(System.in);
		System.out.println("enter a size:(SMALL,MEIDUM,LARGE,EXTRA_LARGE)");
		String inputString=inScanner.next().toUpperCase();//ת��Ϊ��д
		Size size=Enum.valueOf(Size.class, inputString);//valueOf���÷� ö�ٵ�����.class ѡ���ö�ٲ���
		System.out.println("size="+size);
		System.out.println("abbreviation="+size.getAbbreviation());
		if(size==Size.EXTRA_LARGE) {
			System.out.println("��ע�����ǳ���ŵ��·�");
		}
		
		//����values���÷�
		Size[] value=Size.values();
		for(int i=0;i<value.length;i++) {
			System.out.println(value[i]+","+value[i].ordinal());//�������ö���������  ordinal()�����������ö�����е�λ��
		}
		
	}
	
	enum Size{
		SMALL("S"),MEDIUM("M"),LARGE("L"),EXTRA_LARGE("XL");  //��������ΪclassName("����")
		private Size(String abbreviation) {
			this.abbreviation=abbreviation;
		}
		public String getAbbreviation() {//���ز���
			return abbreviation;
		}
		private String abbreviation;
	}

}
