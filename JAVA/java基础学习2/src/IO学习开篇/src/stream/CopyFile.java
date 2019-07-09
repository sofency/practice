package stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * �ļ��Ŀ���
 * @author sofency
 * ���ǽ�����������������кϲ�
 *  ֻ�ܴ�����ļ�
 */
public class CopyFile {
	public static void main(String[] args)  {
		
		copy("test.txt", "test1.txt");//ʵ��copy����
			
	}
	
	public static void copy(String srcPath,String destPath) {
		//��������Դ�ļ�
				File source=new File(srcPath);//ԭ�ļ�
				File destination=new File(destPath);//�������ļ�
				
				//ѡ����
				InputStream in=null;
				OutputStream out=null;
				int temp=0;
				//����
				try {
					//��ԭ�ļ���ȡ����
					in=new FileInputStream(source);//������
					out=new FileOutputStream(destination);//�����
					
					byte[] flush=new byte[1024*1024];//�����С
					int len=-1;//
					while((len=in.read(flush))!=-1) {
//						String string=new String(flush,0,len);//��ȡ�ַ���
//						
//						byte[] src=string.getBytes();//ת��Ϊ�ֽ�����
						System.out.println(len);
						out.write(flush,0,len);
						temp++;
					}
					out.flush();
				}catch (Exception e) {
					e.printStackTrace();
				}finally {
					System.out.println(temp);
					try {
						if(out!=null) {
						  out.close();
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					try {
						if(in!=null) {
						  in.close();
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						
				}
	}
}
