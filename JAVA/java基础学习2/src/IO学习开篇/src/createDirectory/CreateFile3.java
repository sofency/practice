package createDirectory;

import java.io.File;

import javax.naming.directory.DirContext;

/**
 * 递归查看文件
 * 递归： 方法自己调用自己
 * 递归头：合适结束递归
 * @author sofency
 *
 */
public class CreateFile3 {
	public static void main(String[] args) {
		//递归打印所有文件
		
		File file=new File("H:\\eclipse_workspace\\IO学习开篇");
		Print(file,0);
	}
	public static void Print(File file,int deep) {
		for(int i=0;i<deep;i++) {
			System.out.print("-");
		}
		System.out.println(file.getName());
		if(null==file||(!file.exists())) {
			return ;
		}else if(file.isDirectory()) {
			for (File f : file.listFiles()) {
				Print(f,deep+1);
			}
		}
		
		
		
	}

}
