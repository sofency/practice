package udpTest;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpTypeTestServer {

	public static void main(String[] args) throws IOException {
		System.out.println("���շ������С�����");
//		1.ʹ��DatagramSocket  ָ���˿�  �������ܶ�
		@SuppressWarnings("resource")
		DatagramSocket server=new DatagramSocket(8888);//ʹ��8888�˿ڽ��н���
//		2.ָ������   ��װ��DatagramPacket ����
		byte[] receive=new byte[1024*60];
		DatagramPacket packet=new DatagramPacket(receive,0,receive.length);
//		3.����ʽ���ܰ���  receive(DatagramPacket p)
		server.receive(packet);//����ʽ���
//		4.��������
//		 byte[]  getData()  
//		       getLength()
		
		byte[] datas=packet.getData();//���
		DataInputStream dis=new DataInputStream(new ByteArrayInputStream(datas));
		String msg=dis.readUTF();
		Boolean flag=dis.readBoolean();
		int age=dis.readInt();
		char ch=dis.readChar();
		System.out.println(msg+","+flag+","+age+","+ch);
		
	}
}
