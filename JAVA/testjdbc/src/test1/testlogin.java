package test1;

import java.sql.SQLException;
import java.util.Scanner;

public class testlogin {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		user u=null;
		Scanner input=new Scanner(System.in);
		System.out.println("�������û���");
		String unameString=input.nextLine();
		System.out.println("����������");
		int pwd=input.nextInt();
		
		
		//�������ݿ��������
		testPrepareStatement login=new testPrepareStatement();
		u=login.getUserInfo(pwd, unameString);
		
		//�жϷ���ֵ
		if(u!=null) {
			System.out.println("��½�ɹ�");
		}else {
			System.out.println("��¼ʧ��");
		}
		
	}
}
