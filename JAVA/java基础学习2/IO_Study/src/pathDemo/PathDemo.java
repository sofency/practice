package pathDemo;

import java.io.File;

/**
 * 三种创建文件的的方式
 * @author sofency
 *
 */
public class PathDemo {
	public static void main(String[] args) {
		String path="D:\\Pictures\\plane.png";//转义法
		//或者使用  /进行写  路径分割符  FIle.separator
		String path1="D:"+File.separator+"Pictures"+File.separator+"plane.png";//拼接法
		System.out.println(path1);
		System.out.println(path);
		
		File src=new File(path);//构建File对象1
		System.out.println(src.length());
		
		File src1=new File("D:\\Pictures","plane.png"); //父子构建
		System.out.println(src1.length());
		
		File src2=new File(new File("D:\\Pictures"),"plane.png");//父对象 子名称
		
		System.out.println(src2.length());
		
		
	}

}
