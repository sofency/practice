package tCPTest;

import java.io.DataInputStream;
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

public class Server {
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
		
		dis.close();
		server.close();
		
	}

}
