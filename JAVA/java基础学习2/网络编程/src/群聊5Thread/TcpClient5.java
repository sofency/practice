package Ⱥ��5Thread;

import java.io.BufferedReader;

/**
 * ���û����ͽ��ն����Ϣ
 * ������  
 * ������߳�
 */

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient5 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		System.out.println("------Client------");
		//ʹ��Socket�����ͻ���  ���Ϸ������ĵ�ַ��˿�
		Socket client=new Socket("localhost",12306);
		System.out.println("�������û���");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String name=br.readLine();//ע��������������
		new Thread(new Send(client,name)).start();
		new Thread(new Receive(client)).start();
	}
}
