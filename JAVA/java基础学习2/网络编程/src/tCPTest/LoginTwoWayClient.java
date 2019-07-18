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
public class LoginTwoWayClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		
		System.out.println("------Client------");
		BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("�������˺�:");
		String uname=buf.readLine();
		System.out.print("����������:");
		String upwd=buf.readLine();
		//ʹ��Socket�����ͻ���  ���Ϸ������ĵ�ַ��˿�
		Socket client=new Socket("localhost",12306);
		
		//�ͻ�����Ҫ��������������Ҫʹ��DataOutputStream��������з�������
		DataOutputStream  doS=new  DataOutputStream(client.getOutputStream());
		doS.writeUTF("uname="+uname+"&"+"upwd="+upwd);
		
		DataInputStream dis=new DataInputStream(client.getInputStream());
		String str=dis.readUTF();
		System.out.println(str);
		doS.flush();
		client.close();
		
		
	}

}
