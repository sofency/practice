package java��ѧϰ;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class testInputAndOutput {
	public static void main(String[] args) {
		try {
			Scanner in=new Scanner(Paths.get("C:\\Users\\sofency\\Desktop\\xml����.txt"),"GBK");
			//��������  Paths.get(����1)//�÷����ǻ�ȡ�ļ����ݵ� ����1�Ǿ���·�� Scanner �ĵڶ���������������ļ��ı����ʽ
			while(in.hasNext()) {
				System.out.println(in.nextLine());//��ȡ�ļ�������
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
