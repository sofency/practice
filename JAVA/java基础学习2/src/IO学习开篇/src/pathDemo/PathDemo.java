package pathDemo;

import java.io.File;

/**
 * ���ִ����ļ��ĵķ�ʽ
 * @author sofency
 *
 */
public class PathDemo {
	public static void main(String[] args) {
		String path="D:\\Pictures\\plane.png";//ת�巨
		//����ʹ��  /����д  ·���ָ��  FIle.separator
		String path1="D:"+File.separator+"Pictures"+File.separator+"plane.png";//ƴ�ӷ�
		System.out.println(path1);
		System.out.println(path);
		
		File src=new File(path);//����File����1
		System.out.println(src.length());
		
		File src1=new File("D:\\Pictures","plane.png"); //���ӹ���
		System.out.println(src1.length());
		
		File src2=new File(new File("D:\\Pictures"),"plane.png");//������ ������
		
		System.out.println(src2.length());
		
		
	}

}
