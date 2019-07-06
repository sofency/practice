package pathDemo;

import java.io.File;

/**
 * 相对路径和绝对路径的区别 ： 存在盘符 绝对路径
 * @author sofency
 *
 */
public class PathDemo2 {
	public static void main(String[] args) {
		String path="D:\\Pictures\\plane.png";//转义法
		//或者使用  /进行写  路径分割符  FIle.separator
		String path1="D:"+File.separator+"Pictures"+File.separator+"plane.png";//拼接法
		System.out.println(path1);
		System.out.println(path);
		
		File src2=new File(new File("D:\\Pictures"),"plane.png");//父对象 子名称
		
		System.out.println(src2.length());
		
		System.out.println(src2.getPath());//返回绝对路径
		System.out.println(src2.isDirectory());//判断是否是文件夹
		System.out.println(src2.isFile());//判断是否是文件
		System.out.println(src2.getName());//返回文件的 名字
		System.out.println(src2.getParentFile().getName());
		System.out.println(src2.getParent());//显示的父级目录的绝对路径
		//创建文件
		
	}

}
