package pathDemo;

import java.io.File;
import java.io.IOException;

/**
 * createNewFile()
 * delete()
 * @author sofency
 *
 */
public class PathDemo4 {
	public static void main(String[] args) throws IOException {
		
		File file=new File("sofency.txt");//Ŀ¼��������һ�������ڵ��ļ������ļ���������д����ļ�
		boolean flag=file.createNewFile();
		System.out.println(flag);
		System.out.println(file.getAbsolutePath());//������
		
		
		file=new File("alice.txt");//����д����·��  �������´��������ٽ��в��� ���ܻ��������߳����⣨���룩
		flag=file.createNewFile();
		System.out.println(flag);
		System.out.println(file.getAbsolutePath());
		
		//ɾ���ļ�
		flag=file.delete();
		System.out.println("�ļ��Ƿ�ɾ���ɹ�"+flag);//ɾ���ɹ�
		System.out.println(file.exists());//������
		
		//���� �� ����ϵͳ�Ĺؼ���
		file =new  File("H:\\eclipse_workspace\\IOѧϰ��ƪ\\con");//�Ƿ���con ���� com3
		file.createNewFile();
		
		
		
	}

}
