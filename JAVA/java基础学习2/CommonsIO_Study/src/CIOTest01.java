import java.io.File;

import org.apache.commons.io.FileUtils;

public class CIOTest01 {

	public static void main(String[] args) {
		
		//文件的大小
		long len=FileUtils.sizeOf(new File("sofency.java"));
		System.out.println(len);
		
		//目录的大小  之前要使用递归
		len=FileUtils.sizeOf(new  File("H:\\eclipse_workspace"));
		System.out.println(len);
	}
}
