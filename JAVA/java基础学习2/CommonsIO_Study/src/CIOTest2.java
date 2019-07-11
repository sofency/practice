import java.io.File;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.apache.commons.io.filefilter.FileFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;

/**
 * 列出子孙级
 * @author sofency
 *
 */
public class CIOTest2 {

	public static void main(String[] args) {
		
		Collection<File> files=FileUtils.listFiles(new File("H:\\eclipse_workspace\\IO_Study_Common"), 
				EmptyFileFilter.NOT_EMPTY, DirectoryFileFilter.INSTANCE);//操作子孙级
		
		for(File file:files) {
			System.out.println(file.getAbsolutePath());//上述筛选了空的文件
		}
		
		
		//筛选特定的文件
		System.out.println("筛选以.java结尾的文件");
		files=FileUtils.listFiles(new File("H:\\eclipse_workspace\\IO学习开篇"), new SuffixFileFilter("java"),
				DirectoryFileFilter.INSTANCE);
		for(File file:files) {
			System.out.println(file.getAbsolutePath());//上述筛选了空的文件
		}
		
		//多个筛选条件
		
		System.out.println("多个筛选条件");
		files=FileUtils.listFiles(new File("H:\\\\eclipse_workspace\\\\IO学习开篇"), FileFilterUtils.or(new SuffixFileFilter("java"),new SuffixFileFilter("class")), DirectoryFileFilter.INSTANCE);
		for(File file:files) {
			System.out.println(file.getAbsolutePath());//上述筛选了空的文件
		}
		
		
		
	}
}
