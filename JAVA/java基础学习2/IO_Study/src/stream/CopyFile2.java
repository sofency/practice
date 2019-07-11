package stream;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * �ļ��Ŀ���
 * @author sofency
 * ���ǽ��ַ����������ַ���������кϲ�  
 * ����BufferedReader ��BufferedWriter����ʱ�������
 *  
 */
public class CopyFile2 {
	
	public static void main(String[] args)  {
		copy("hha.txt", "hha-copy2.txt");//ʵ��copy����
	}
	
	public static void copy(String srcPath,String destPath) {
		//��������Դ�ļ�
		File source=new File(srcPath);//ԭ�ļ�
		File destination=new File(destPath);//�������ļ�
		//ѡ����
		BufferedReader reader=null;
		BufferedWriter writer=null;
	    //����
		try {
			//��ԭ�ļ���ȡ����  //����BufferedInput
			reader=new BufferedReader(new  FileReader(source));//������
			writer=new BufferedWriter(new FileWriter(destination));//�����
			
			String line=null;
			while((line=reader.readLine())!=null) {
				writer.append(line);//д��writer
				writer.newLine();
			}
			writer.flush();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(writer!=null) {
				  writer.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				if(reader!=null) {
				  reader.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
	}
}
