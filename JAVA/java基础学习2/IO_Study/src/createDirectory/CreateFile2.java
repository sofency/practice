package createDirectory;

import java.io.File;

import javax.naming.directory.DirContext;

/**
 * �г���һ��
 * 1.list()
 * 2.listFiles()  �г��¼�File����
 * @author sofency
 *
 */
public class CreateFile2 {
	public static void main(String[] args) {
		
		File file =new File("H:\\eclipse_workspace\\IOѧϰ��ƪ");
		
		//�¼�Ŀ¼
		String[] subNameStrings=file.list();
		for (String string : subNameStrings) {
			System.out.println(string);//��ʾ���ļ��¼�Ŀ¼
		}
		
		//�¼�����
		File[] subFileStrings=file.listFiles();
		for (File string : subFileStrings) {
			System.out.println(string);//��ʾ���ļ��¼�Ŀ¼
		}
		
		
		//���е��̷�
		File[] roots=file.listRoots();//��ʾ��Ŀ¼
		for (File file2 : roots) {
			System.out.println(file2);
		}
	
	}

}
