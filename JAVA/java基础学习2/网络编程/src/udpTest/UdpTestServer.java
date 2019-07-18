package udpTest;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * ���ܶ�
 * 1.ʹ��DatagramSocket  ָ���˿�  �������ܶ�
 * 2.ָ������   ��װ��DatagramPacket ����
 * 3.����ʽ���ܰ���  receive(DatagramPacket p)
 * 4.��������
 * byte[]  getData()  
 *       getLength()
 * 5. �ͷ���Դ
 * @author sofency
 *
 */
public class UdpTestServer {
	public static void main(String[] args) throws IOException {
		System.out.println("���շ������С�����");
//		1.ʹ��DatagramSocket  ָ���˿�  �������ܶ�
		DatagramSocket server=new DatagramSocket(8888);
//		2.ָ������   ��װ��DatagramPacket ����
		byte[] receive=new byte[1024*60];
		DatagramPacket packet=new DatagramPacket(receive,0,receive.length);
//		3.����ʽ���ܰ���  receive(DatagramPacket p)
		server.receive(packet);
//		4.��������
//		 byte[]  getData()  
//		       getLength()
		byte[] datas=packet.getData();
		
		System.out.println(new String(datas,0,datas.length));
		
	}
}
