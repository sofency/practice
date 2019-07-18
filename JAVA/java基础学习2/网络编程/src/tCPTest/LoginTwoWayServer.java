package tCPTest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ����������
 * 1.ָ���˿�  ʹ��serverSocket����������
 * 2.����ʽ�ȴ����� accept
 * 3.������������������
 * 4
 * @author sofency
 *
 */

public class LoginTwoWayServer {
	public static void main(String[] args) throws IOException {
		//1.ָ���˿�  ʹ��serverSocket����������
		System.out.println("------Server------");
		@SuppressWarnings("resource")
		ServerSocket server=new ServerSocket(12306);
		//2.����ʽ�ȴ�����
		Socket client=server.accept();
		System.out.println("һ���ͻ��˽�������");
		//3.���� �������������
		DataInputStream dis=new DataInputStream(client.getInputStream());
		
		String str=dis.readUTF();
		System.out.println(str);
		//��������
		String uname="";
		String upwd="";
		String[] Info=str.split("&");
		for(String str1:Info) {
			
			String[] usrInfo=str1.split("=");
			System.out.println();
			if(usrInfo[0].equals("uname")) {
				System.out.println("�û���:"+usrInfo[1]);
				uname=usrInfo[1];
			}else if(usrInfo[0].equals("upwd")){
				System.out.println("����:"+usrInfo[1]);
				upwd=usrInfo[1];
			}
		}
		
		DataOutputStream dos=new DataOutputStream(client.getOutputStream());
		if(uname.equals("sofency")&&upwd.equals("12345")) {
			dos.writeUTF("������ȷ ��¼�ɹ�");
		}else {
			dos.writeUTF("������˻�����");
			System.out.println(uname+"--"+upwd);
		}
		dos.flush();
		dos.close();
		dis.close();
		server.close();
		
	}

}
