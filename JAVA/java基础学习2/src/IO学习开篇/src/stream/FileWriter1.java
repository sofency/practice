package stream;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


/**
 *  ʹ���ַ����������  FileWriter  ��������
 *  @author sofency
 *  1.����Դ
 *  2.ѡ����
 *  3 ����
 *  4.�ر�
 */
public class FileWriter1 {
	public static void main(String[] args) {
		//����Դ
		File file=new File("hha.txt");//  û������ļ��Ļ����Զ����д���
		
		//2.ѡ����
		FileWriter writer=null;
		
		try {
			writer =new FileWriter(file);//����ټӲ��� true �ͱ�ʾ���ļ���׷������  ��Ȼ�Ļ�����ˢ������
			
			String message="sofency will be the IT ��ţ";
			char[] datas=message.toCharArray();//ת���ֽ������������   �ַ���--->�ַ�����
			writer.write(datas, 0, datas.length);//������д��file�ļ���

			writer.flush();//ˢ��������ֽ�
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			 if(null!=writer) {
				 try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
		}
		
		
		
	}
}
