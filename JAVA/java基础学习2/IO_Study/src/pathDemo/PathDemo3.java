package pathDemo;

import java.io.File;

/**
 * length() ���ļ��Ĵ�С
 * @author sofency
 *
 */
public class PathDemo3 {
	public static void main(String[] args) {
		String path="D:\\Pictures\\plane.png";//ת�巨
		
		File file=new File(path);//�����ļ�
		System.out.println(file.length());//��ʾ�ļ��ĳ���
		
		
		File file2=new File("D:\\Picture");
		System.out.println(file2.length());//��ʾ�ļ��еĳ���  Ϊ0
		//��������  length()��ʾ�����ļ��Ĵ�С �������ļ��еĴ�С 
		
		
	}

}
