package createDirectory;

import java.io.File;

import javax.naming.directory.DirContext;

/**
 * �ݹ�鿴�ļ��Ĵ�С
 * @author sofency
 *
 */
public class CreateFile4 {
	public static void main(String[] args) {
		//�ݹ��ӡ�����ļ�
		
		File file=new File("H:\\eclipse_workspace\\IOѧϰ��ƪ");
		Count(file);
		System.out.println(size);
	}
	private static long size=0;
	public static void Count(File file) {
		//��ȡ��С
		if(file.exists()&&file!=null) {
			if(file.isFile()) {//������ļ��Ļ����ļ��Ĵ�С��size�ۼ�
				size+=file.length();
			}else {
				for (File src : file.listFiles()) {//
					Count(src);
				}
			}
		}
	}

}
