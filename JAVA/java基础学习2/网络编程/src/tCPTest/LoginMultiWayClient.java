package tCPTest;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * �����ͻ���
 * 1.�������� ʹ��Socket�����ͻ��� +����ĵ�ַ�Ͷ˿�
 * 2.�������������������
 * 3.�ͷ���Դ
 * @author sofency
 *
 */
public class LoginMultiWayClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		
		System.out.println("------Client------");
		BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("�������˺�:");
		String uname=buf.readLine();
		System.out.print("����������:");
		String upwd=buf.readLine();
		//ʹ��Socket�����ͻ���  ���Ϸ������ĵ�ַ��˿�
		Socket client=new Socket("localhost",12306);
		
		Send(client, uname, upwd);
		//�ͻ�����Ҫ��������������Ҫʹ��DataOutputStream��������з�������
		
		receive(client);
		
		//�ر���Դ
		buf.close();
		client.close();
	}
	
	public static void Send(Socket client,String uname,String upwd) {
		DataOutputStream doS = null;
		try {
			doS = new  DataOutputStream(client.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			doS.writeUTF("uname="+uname+"&"+"upwd="+upwd);
			doS.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void receive(Socket client) {
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(client.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String str = null;
		try {
			str = dis.readUTF();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(str);
	}

}
