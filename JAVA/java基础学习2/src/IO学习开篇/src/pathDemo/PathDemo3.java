package pathDemo;

import java.io.File;

/**
 * length() 是文件的大小
 * @author sofency
 *
 */
public class PathDemo3 {
	public static void main(String[] args) {
		String path="D:\\Pictures\\plane.png";//转义法
		
		File file=new File(path);//创建文件
		System.out.println(file.length());//显示文件的长度
		
		
		File file2=new File("D:\\Picture");
		System.out.println(file2.length());//显示文件夹的长度  为0
		//综上所述  length()显示的是文件的大小 而不是文件夹的大小 
		
		
	}

}
