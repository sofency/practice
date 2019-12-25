package udpTest;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * ���Ͷ�
 * 1.ʹ��DatagramSocket  ָ���˿�  �������Ͷ�
 * 2.׼������  һ��Ҫת��Ϊ�ֽ�����
 * 3.��װ��DatagramPacket ����   ��Ҫָ��Ŀ�ĵ�
 * 4.���Ͱ���  send(DatagramPacket p)
 * byte[]  getData()  
 *       getLength()
 * 5. �ͷ���Դ
 * @author sofency
 *
 */

public class UdpTestClient {
	public static void main(String[] args) throws IOException {
		System.out.println("���ͷ�������");
//		1.ʹ��DatagramSocket  ָ���˿�  �������Ͷ�
		DatagramSocket client=new DatagramSocket(9999);
//		2.׼������  һ��Ҫת��Ϊ�ֽ�����
		String string="sofency  love";
		byte[] by=string.getBytes();
//		3.��װ��DatagramPacket ����   ��Ҫָ��Ŀ�ĵ�
		DatagramPacket packet=new DatagramPacket(by,0,by.length,new InetSocketAddress("localhost",8888));
//		4.���Ͱ���  send(DatagramPacket p)
		client.send(packet);
//		5. �ͷ���Դ
		client.close();
	}
}
