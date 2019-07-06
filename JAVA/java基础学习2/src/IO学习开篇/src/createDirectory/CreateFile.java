package createDirectory;

import java.io.File;

/**
 * mkdir() 确保上级目录存在
 * mkdirs() 上级目录不存在  先创建上级目录
 * @author sofency
 *
 */
public class CreateFile {
	public static void main(String[] args) {
		
		File file =new File("H:\\eclipse_workspace\\IO学习开篇\\dir\\test");
		
		boolean flag=file.mkdir();//创建失败
		System.out.println(flag);
		
		flag=file.mkdirs();//创建成功
		System.out.println(flag);
	}

}
