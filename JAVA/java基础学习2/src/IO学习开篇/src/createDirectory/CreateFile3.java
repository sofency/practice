package createDirectory;

import java.io.File;

import javax.naming.directory.DirContext;

/**
 * �ݹ�鿴�ļ�
 * �ݹ飺 �����Լ������Լ�
 * �ݹ�ͷ�����ʽ����ݹ�
 * @author sofency
 *
 */
public class CreateFile3 {
	public static void main(String[] args) {
		//�ݹ��ӡ�����ļ�
		
		File file=new File("H:\\eclipse_workspace\\IOѧϰ��ƪ");
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
