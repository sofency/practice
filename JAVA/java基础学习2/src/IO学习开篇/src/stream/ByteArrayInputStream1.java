package stream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ByteArrayInputStream1 {
	public static void main(String[] args) throws IOException {
		//����Դ
		byte[] array="talk is cheap show me the code".getBytes();//"�ϻ���˵ ���ô���"
		
		//ѡ����
		InputStream is=null;
		//����
		is=new ByteArrayInputStream(array);//�ֽ�����������
		byte[] flush=new byte[5];//��ʩ������  ���׹���
		
		int len=-1;
		
		while((len=is.read(flush))!=-1) {
			//��ȡ�ַ�
			String string=new String(flush,0,len);
			System.out.println(string);
			
		}
		is.close();
		
	}

}
