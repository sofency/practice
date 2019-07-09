package stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *  �ļ��ֽ������
 *  @author sofency
 *  1.����Դ
 *  2.ѡ����
 *  3 ����
 *  4.�ر�
 */
public class ByteOutputStream1 {
	public static void main(String[] args) {
		//����Դ
		File file=new File("hha.txt");//  û������ļ��Ļ����Զ����д���
		
		//2.ѡ����
		OutputStream out=null;
		
		try {
			out =new FileOutputStream(file);//����ټӲ��� true �ͱ�ʾ���ļ���׷������  ��Ȼ�Ļ�����ˢ������
			
			String message="sofency will be the IT ��ţ";
			
			byte[] datas=message.getBytes();//ת���ֽ������������   �ַ���--->�ֽ����飨���룩
			
			out.write(datas, 0, datas.length);//������д��file�ļ���

			out.flush();//ˢ��������ֽ�
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			 if(null!=out) {
				 try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
		}
		
		
		
	}
}
