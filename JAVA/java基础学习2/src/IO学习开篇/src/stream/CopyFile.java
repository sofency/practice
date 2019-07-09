package stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 文件的拷贝
 * @author sofency
 * 就是将输入流和输出流进行合并
 *  只能存五个文件
 */
public class CopyFile {
	public static void main(String[] args)  {
		
		copy("test.txt", "test1.txt");//实现copy功能
			
	}
	
	public static void copy(String srcPath,String destPath) {
		//创建两个源文件
				File source=new File(srcPath);//原文件
				File destination=new File(destPath);//拷贝的文件
				
				//选择流
				InputStream in=null;
				OutputStream out=null;
				int temp=0;
				//操作
				try {
					//从原文件读取文字
					in=new FileInputStream(source);//输入流
					out=new FileOutputStream(destination);//输出流
					
					byte[] flush=new byte[1024*1024];//缓冲大小
					int len=-1;//
					while((len=in.read(flush))!=-1) {
//						String string=new String(flush,0,len);//读取字符串
//						
//						byte[] src=string.getBytes();//转化为字节数组
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
