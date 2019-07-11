package stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 实现copy文件夹  使用递归
 * @author sofency
 *
 */

public class CopyDirec {
	public static void main(String[] args) {
		try {
			copyDir("test","test1");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		File file=new File("12.txt");
//		System.out.println(file.isFile());
	}
	
	
	public static void copy(String source,String destination) {
		//创建两个源文件
		//选择流
		File sourceFile=new File(source);
		File destinationFile=new File(destination);
		
		InputStream in=null;
		OutputStream out=null;
		//操作
	
		try {
			//从原文件读取文字
			in=new FileInputStream(sourceFile);//输入流
			out=new FileOutputStream(destinationFile,true);//输出流
			byte[] flush=new byte[1024*1024];//缓冲大小
			int len=-1;
			while((len=in.read(flush))!=-1) {
				System.out.println(len);
				out.write(flush,0,len);
			}
			out.flush();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(out!=null) {
				  out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if(in!=null) {
				  in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
				
		}
	}
	
	public static void copyDir(String src,String dest) throws IOException {
		
		File srcFile=new File(src);
		
		dest=dest+"\\"+srcFile.getName();//将src归在dest目录下  
		
		File destFile=new File(dest);
		
		if(srcFile.isFile()) {//如果是文件则创建文件 否则创建文件夹
			destFile.createNewFile();
		
			copy(srcFile.getAbsolutePath(),destFile.getAbsolutePath());
			return;
			
		}else if(srcFile.isDirectory()){
			destFile.mkdirs();//创建文件
			
			for (File f : srcFile.listFiles()) {
				
				copyDir(f.getAbsolutePath(), destFile.getAbsolutePath());
			}
		}
	}
}
/**
 * 思路整理
 * 目标：指定一个源文件夹 和目标文件夹  将源文件夹中的内容copy到目标文件夹中
 * 遍历的过程中  
 * 如果src是文件夹则在   dest=dest+"\\"+src.getNames() 创建文件夹  destFile.mkdir()  并继续递归
 * 如果src是文件   destFile.createNewFile()   创建文件后 copy文件   注意要使用绝对路径
 * 
 */
