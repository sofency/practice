package stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 1.�ļ��ֽ�������  �ֶζ�ȡ
 * @author sofency
 * 1.����Դ
 * 2.ѡ����
 * 3.����
 * 4.�ͷ���Դ
 * 5.��Ҫ��ȡ���ַ����������Ķ�  
 */
public class ImageStream2 {
	public static void main(String[] args) throws FileNotFoundException {
		//����Դ
		File src=new File("test.txt");
		File test=new File("H:\\\\eclipse_workspace\\\\IOѧϰ��ƪ");
		System.out.println(test.getParent().substring(3));
		//ѡ����
		InputStream  is=null;
		//����(�ֶζ�ȡ)
		
		try {
			is=new FileInputStream(src);//������
			
			//1K  1k�Ķ�ȡ
			byte[] flush=new byte[1024];//������������30  ��ÿ�ض�ȡ30���ַ�  ������һ���Ӿͽ��������
			int len=-1;//���ܵĳ���
			while((len=is.read(flush))!=-1) {//�Ƚ�is.read()��ֵ��temp Ȼ��temp��-1���бȽ�
				//�ֽ�����--->�ַ���  ����
				String string=new String(flush,0,len,"GBK");//֤�������������ַ�
				System.out.println(string);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(null!=is) {
					is.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
