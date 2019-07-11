package createDirectory;

import java.io.File;

import javax.naming.directory.DirContext;

/**
 * 递归查看文件的大小
 * @author sofency
 *
 */
public class CreateFile4 {
	public static void main(String[] args) {
		//递归打印所有文件
		
		File file=new File("H:\\eclipse_workspace\\IO学习开篇");
		Count(file);
		System.out.println(size);
	}
	private static long size=0;
	public static void Count(File file) {
		//获取大小
		if(file.exists()&&file!=null) {
			if(file.isFile()) {//如果是文件的话则将文件的大小和size累加
				size+=file.length();
			}else {
				for (File src : file.listFiles()) {//
					Count(src);
				}
			}
		}
	}

}
