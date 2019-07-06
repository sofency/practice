package pathDemo;

import java.io.File;

/**
 * ���·���;���·�������� �� �����̷� ����·��
 * @author sofency
 *
 */
public class PathDemo2 {
	public static void main(String[] args) {
		String path="D:\\Pictures\\plane.png";//ת�巨
		//����ʹ��  /����д  ·���ָ��  FIle.separator
		String path1="D:"+File.separator+"Pictures"+File.separator+"plane.png";//ƴ�ӷ�
		System.out.println(path1);
		System.out.println(path);
		
		File src2=new File(new File("D:\\Pictures"),"plane.png");//������ ������
		
		System.out.println(src2.length());
		
		System.out.println(src2.getPath());//���ؾ���·��
		System.out.println(src2.isDirectory());//�ж��Ƿ����ļ���
		System.out.println(src2.isFile());//�ж��Ƿ����ļ�
		System.out.println(src2.getName());//�����ļ��� ����
		System.out.println(src2.getParentFile().getName());
		System.out.println(src2.getParent());//��ʾ�ĸ���Ŀ¼�ľ���·��
		//�����ļ�
		
	}

}
