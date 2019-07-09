package stream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Ŀ�Ľ�ͼƬת��Ϊ�ֽ�����
 * �ٽ��ֽ�����ת��ΪͼƬ  ����������ͼƬ�Ĵ���
 * @author sofency
 *
 */


public class CopyPng {
	
	public static void main(String[] args) throws IOException {
		byte[] array=fileToByte("copy.jpg");//���ļ�ת��Ϊ�ֽ�����
		byteTofile(array, "copy-byte.jpg");//���ֽ���ת��Ϊ�ļ�
	}
	
	
	public static byte[] fileToByte(String filePath) throws IOException {
		/**
		 * 1.ͼƬ������  ʹ��FileInputStream ��
		 * 2.�����ֽ�����  ʹ��ByteArrayOutStream  
		 */
		
		//����Դ
		File src=new File(filePath);
		//ѡ����  ���ļ�ͨ��FIleInputStream ת��Ϊ�ֽ�����  �ٴ��͸��ֽ������
		
		InputStream in=null;//ʹ�ö�̬
		ByteArrayOutputStream baos=null;
		
		
		//����
		try {
			in=new FileInputStream(src);
			baos=new ByteArrayOutputStream();
			
			int len=-1;
			byte[] flush=new byte[1024*10];//���û�����
			while((len=in.read(flush))!=-1) {
				baos.write(flush,0,len);
			}
			baos.flush();
			return  baos.toByteArray();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			baos.close();
			in.close();
		}
		return null;
	}
	
	public static void byteTofile(byte[] src,String filePath) {
		//���ֽ�����ͨ������
		//����ת��ΪͼƬ 
		//1.����Դ
		
		File file=new File(filePath);
		//ѡ����
		InputStream isInputStream=null;
		OutputStream os=null;
		
		try {
			isInputStream= new ByteArrayInputStream(src);//���ַ��������뵽�ļ���
			
			os=new FileOutputStream(filePath);
			
			//�ֶζ�ȡ
			byte[] flush=new byte[5];
			int len=-1;
			while((len=isInputStream.read(flush))!=-1) {
				os.write(flush,0,len);
			}
			os.flush();
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(null!=os) {
					
					os.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
