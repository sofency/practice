package java��ѧϰ;

public class codePoint {
	public static void main(String[] args) {
		String string="hello";
		int  n=string.length();//��ȡ�ַ����ĳ���
		
		System.out.println(n);//������� �����ַ����ĳ��ȶ��� ��Щ�ַ������޷�ʹ������unicode���б�ʾ�������ֱ�����ʽ
		int cpCount=string.codePointCount(0,n);
		int aCount=string.codePointAt(1);
		System.out.println(string.charAt(1)+","+cpCount);
		System.out.println(aCount);
		
	}

}
