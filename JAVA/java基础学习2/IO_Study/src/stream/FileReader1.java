package stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.io.Reader;

/**
 * 1.ʹ���ַ������ж�ȡ�ļ�   ���ÿ����Ƿ����ĵ�����
 * @author sofency
 * 1.����Դ
 * 2.ѡ����
 * 3.����
 * 4.�ͷ���Դ
 * 5.��Ҫ��ȡ���ַ����������Ķ�  
 */
public class FileReader1 {
	public static void main(String[] args) throws FileNotFoundException {
		//����Դ
		File src=new File("destination.txt");
		
		//ѡ����
		Reader reader=null;
		//����(�ֶζ�ȡ)
		
		try {
			reader=new FileReader(src);//������
			
			//1K  1k�Ķ�ȡ
			char[] flush=new char[1024];//������������30  ��ÿ�ض�ȡ30���ַ�  ������һ���Ӿͽ��������
			int len=-1;//���ܵĳ���
			while((len=reader.read(flush))!=-1) {//�Ƚ�is.read()��ֵ��temp Ȼ��temp��-1���бȽ�
				//�ַ�����--->�ַ���  ����
				String string=new String(flush,0,len);//֤�������������ַ�
				System.out.println(string);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(null!=reader) {
					reader.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
