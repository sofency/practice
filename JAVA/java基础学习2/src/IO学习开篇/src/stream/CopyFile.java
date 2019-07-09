package stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * �ļ��Ŀ���
 * @author sofency
 * ���ǽ��ֽ�����������������кϲ�  ����BufferedInputStream ��BufferedOutputStream����ʱ�������
 *  ֻ�ܴ�����ļ�
 */
public class CopyFile {
	public static void main(String[] args)  {
		long t1=System.currentTimeMillis();
		copy("test001.mp4", "test002.mp4");//ʵ��copy����
		long t2=System.currentTimeMillis();
		System.out.println(t2-t1);
	}
	
	public static void copy(String srcPath,String destPath) {
		//��������Դ�ļ�
		File source=new File(srcPath);//ԭ�ļ�
		File destination=new File(destPath);//�������ļ�
		
		//ѡ����
		InputStream in=null;
		OutputStream out=null;
	    //����
		try {
			//��ԭ�ļ���ȡ����  //����BufferedInput
			in=new BufferedInputStream(new FileInputStream(source));//������
			out=new BufferedOutputStream(new FileOutputStream(destination));//�����
			
			byte[] flush=new byte[1024];//�����С
			int len=-1;//
			while((len=in.read(flush))!=-1) {
				out.write(flush,0,len);
			}
			out.flush();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
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
