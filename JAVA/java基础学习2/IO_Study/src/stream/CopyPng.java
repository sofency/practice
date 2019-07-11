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
 * 目的将图片转化为字节数组
 * 再将字节数组转化为图片  适用于网上图片的传送
 * @author sofency
 *
 */


public class CopyPng {
	
	public static void main(String[] args) throws IOException {
		byte[] array=fileToByte("copy.jpg");//将文件转化为字节数组
		byteTofile(array, "copy-byte.jpg");//将字节组转化为文件
	}
	
	
	public static byte[] fileToByte(String filePath) throws IOException {
		/**
		 * 1.图片到程序  使用FileInputStream 流
		 * 2.程序到字节数组  使用ByteArrayOutStream  
		 */
		
		//创建源
		File src=new File(filePath);
		//选择流  将文件通过FIleInputStream 转化为字节数组  再传送给字节输出流
		
		InputStream in=null;//使用多态
		ByteArrayOutputStream baos=null;
		
		
		//操作
		try {
			in=new FileInputStream(src);
			baos=new ByteArrayOutputStream();
			
			int len=-1;
			byte[] flush=new byte[1024*10];//设置缓冲区
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
		//将字节数组通过程序
		//程序转化为图片 
		//1.创建源
		
		File file=new File(filePath);
		//选择流
		InputStream isInputStream=null;
		OutputStream os=null;
		
		try {
			isInputStream= new ByteArrayInputStream(src);//将字符数组输入到文件中
			
			os=new FileOutputStream(filePath);
			
			//分段读取
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
