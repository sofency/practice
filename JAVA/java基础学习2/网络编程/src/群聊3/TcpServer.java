package Ⱥ��3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
	public static void main(String[] args) throws IOException {
		System.out.println("------Server------");
		ServerSocket server=new ServerSocket(12306);
		while(true) {
			Socket client=server.accept();
			System.out.println("һ���ͻ��˽�������");
			//��ȡ����
			DataInputStream dis = new DataInputStream(client.getInputStream());
			DataOutputStream dos = new DataOutputStream(client.getOutputStream());
			boolean flag=true;
			while(flag) {
				
				String string=dis.readUTF();
				//��������
				if(string.equals("bye")) {
					flag=false;
				}
				dos.writeUTF(string);
				
			}
			
			dos.close();
			dis.close();
		}
		
	}
}
