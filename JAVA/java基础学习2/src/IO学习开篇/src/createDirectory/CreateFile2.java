package createDirectory;

import java.io.File;

import javax.naming.directory.DirContext;

/**
 * 列出下一级
 * 1.list()
 * 2.listFiles()  列出下级File对象
 * @author sofency
 *
 */
public class CreateFile2 {
	public static void main(String[] args) {
		
		File file =new File("H:\\eclipse_workspace\\IO学习开篇");
		
		//下级目录
		String[] subNameStrings=file.list();
		for (String string : subNameStrings) {
			System.out.println(string);//显示该文件下级目录
		}
		
		//下级对象
		File[] subFileStrings=file.listFiles();
		for (File string : subFileStrings) {
			System.out.println(string);//显示该文件下级目录
		}
		
		
		//所有的盘符
		File[] roots=file.listRoots();//显示根目录
		for (File file2 : roots) {
			System.out.println(file2);
		}
	
	}

}
