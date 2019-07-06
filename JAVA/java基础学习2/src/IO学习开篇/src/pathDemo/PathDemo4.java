package pathDemo;

import java.io.File;
import java.io.IOException;

/**
 * createNewFile()
 * delete()
 * @author sofency
 *
 */
public class PathDemo4 {
	public static void main(String[] args) throws IOException {
		
		File file=new File("sofency.txt");//目录不能跳过一个不存在的文件夹在文件夹里面进行创建文件
		boolean flag=file.createNewFile();
		System.out.println(flag);
		System.out.println(file.getAbsolutePath());//创建了
		
		
		file=new File("alice.txt");//可以写绝对路径  不能再新创建对象再进行操作 可能会引发多线程问题（猜想）
		flag=file.createNewFile();
		System.out.println(flag);
		System.out.println(file.getAbsolutePath());
		
		//删除文件
		flag=file.delete();
		System.out.println("文件是否删除成功"+flag);//删除成功
		System.out.println(file.exists());//不存在
		
		//补充 ： 操作系统的关键字
		file =new  File("H:\\eclipse_workspace\\IO学习开篇\\con");//非法的con 名字 com3
		file.createNewFile();
		
		
		
	}

}
