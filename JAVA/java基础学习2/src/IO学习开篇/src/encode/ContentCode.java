package encode;

import java.io.UnsupportedEncodingException;

public class ContentCode {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String msgString="��������ʹ��q";
		byte[] datas=msgString.getBytes();//Ĭ��ʹ�ù��̵��ַ���
		//���ַ�ת��Ϊ�ֽ�  ��Ϊ����
		System.out.println(datas.length);
	
		datas=msgString.getBytes("utf8");//Ĭ��ÿ���ַ����������ֽ�  ����ַ����벻ͳһ������
		System.out.println(datas.length);
		//���룺���ֽ�ת��Ϊ�ַ�	
//		msgString=new String(datas,0,9,"utf8");
//		System.out.println(msgString);
		msgString=new String(datas,0,datas.length-4,"utf8");
		System.out.println(msgString);
		
		
	}

}
