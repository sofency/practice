package stream;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 文件的拷贝
 * @author sofency
 * 就是将字符输入流和字符输出流进行合并  
 * 加上BufferedReader 和BufferedWriter后传输时间大大变少
 *  
 */
public class CopyFile2 {
	
	public static void main(String[] args)  {
		copy("hha.txt", "hha-copy2.txt");//实现copy功能
	}
	
	public static void copy(String srcPath,String destPath) {
		//创建两个源文件
		File source=new File(srcPath);//原文件
		File destination=new File(destPath);//拷贝的文件
		//选择流
		BufferedReader reader=null;
		BufferedWriter writer=null;
	    //操作
		try {
			//从原文件读取文字  //加上BufferedInput
			reader=new BufferedReader(new  FileReader(source));//输入流
			writer=new BufferedWriter(new FileWriter(destination));//输出流
			
			String line=null;
			while((line=reader.readLine())!=null) {
				writer.append(line);//写入writer
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
