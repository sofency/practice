package java��ѧϰ;

import java.io.Console;

public class testConsole {
	public static void main(String[] args) {
		Console conn=System.console();//����̨���� 
		//ʹ��cmdʱ���в���  
		/**
		 * ���ͣ�JavaҪ��console���н������������ܵõ����õ�console �࣬һ��jvm �Ƿ��п��õ�console,�����ڵײ�ƽ̨
		 * ��jvm��α����ã����jvm�ǽ���ʽ������(����window��cmd)������,�����������û���ض�������ĵط�
		 * ������ eclipse��jvm���ǽ���ʽ������������
		 */
		String usernameString=conn.readLine("user name:");
		char[] passwd=conn.readPassword("Password");
		
		System.out.println(usernameString);
		System.out.println(passwd);
		
	}

}
