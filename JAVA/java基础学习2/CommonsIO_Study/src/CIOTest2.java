import java.io.File;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.apache.commons.io.filefilter.FileFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;

/**
 * �г����Ｖ
 * @author sofency
 *
 */
public class CIOTest2 {

	public static void main(String[] args) {
		
		Collection<File> files=FileUtils.listFiles(new File("H:\\eclipse_workspace\\IO_Study_Common"), 
				EmptyFileFilter.NOT_EMPTY, DirectoryFileFilter.INSTANCE);//�������Ｖ
		
		for(File file:files) {
			System.out.println(file.getAbsolutePath());//����ɸѡ�˿յ��ļ�
		}
		
		
		//ɸѡ�ض����ļ�
		System.out.println("ɸѡ��.java��β���ļ�");
		files=FileUtils.listFiles(new File("H:\\eclipse_workspace\\IOѧϰ��ƪ"), new SuffixFileFilter("java"),
				DirectoryFileFilter.INSTANCE);
		for(File file:files) {
			System.out.println(file.getAbsolutePath());//����ɸѡ�˿յ��ļ�
		}
		
		//���ɸѡ����
		
		System.out.println("���ɸѡ����");
		files=FileUtils.listFiles(new File("H:\\\\eclipse_workspace\\\\IOѧϰ��ƪ"), FileFilterUtils.or(new SuffixFileFilter("java"),new SuffixFileFilter("class")), DirectoryFileFilter.INSTANCE);
		for(File file:files) {
			System.out.println(file.getAbsolutePath());//����ɸѡ�˿յ��ļ�
		}
		
		
		
	}
}
