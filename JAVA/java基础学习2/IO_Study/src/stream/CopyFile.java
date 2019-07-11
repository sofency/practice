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
 * 文件的拷贝
 * @author sofency
 * 就是将字节输入流和输出流进行合并  加上BufferedInputStream 和BufferedOutputStream后传输时间大大变少
 *  只能存五个文件
 */
public class CopyFile {
	public static void main(String[] args)  {
		long t1=System.currentTimeMillis();
		copy("test001.mp4", "test002.mp4");//实现copy功能
		long t2=System.currentTimeMillis();
		System.out.println(t2-t1);
	}
	
	public static void copy(String srcPath,String destPath) {
		//创建两个源文件
		File source=new File(srcPath);//原文件
		File destination=new File(destPath);//拷贝的文件
		
		//选择流
		InputStream in=null;
		OutputStream out=null;
	    //操作
		try {
			//从原文件读取文字  //加上BufferedInput
			in=new BufferedInputStream(new FileInputStream(source));//输入流
			out=new BufferedOutputStream(new FileOutputStream(destination));//输出流
			
			byte[] flush=new byte[1024];//缓冲大小
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
