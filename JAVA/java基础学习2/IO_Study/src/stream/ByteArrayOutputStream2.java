package stream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 
 * @author sofency
 * 1.����Դ �ڲ�ά�� ���ô���
 * 2.ѡ����������Դ  ����ֻ��write��ʱ�����д��Ϳ�����
 * 3.����
 * 4.�����ͷ���Դ
 * 
 */
public class ByteArrayOutputStream2 {
	public static void main(String[] args) throws IOException {
		//����Դ
		byte[] array=null;//"�ϻ���˵ ���ô���"

		//ѡ����
		ByteArrayOutputStream baos=null;
		
		//����
		baos=new ByteArrayOutputStream();//�ֽ�����������
		
		String msgString="talk is cheap show me the code";
		byte[] datas=msgString.getBytes();//ת��Ϊ�ֽ�����
		
		baos.write(datas,0,datas.length);  
		
		//д�����ֽ�  �����̵û��Ƚ��ֽ����鴫�͹�ȥ Ȼ���ڽ��н��봦���ַ�
		
		baos.flush();
		
		//��ȡ����
		
		array=baos.toByteArray();//�����͵��ֽ�ת������
		
		
		System.out.println(array);
		//��ԭ�ַ�
		System.out.println(new String(array));
		
		
	}

}
