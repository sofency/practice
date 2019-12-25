package udpTest;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UdpTypeTestClient {

	public static void main(String[] args) throws IOException {
		System.out.println("���ͷ�������");
//		1.ʹ��DatagramSocket  ָ���˿�  �������Ͷ�
		DatagramSocket client=new DatagramSocket(9999);///ָ��9999�ͻ��˶˿�
//		2.׼������  һ��Ҫת��Ϊ�ֽ�����  �̶��Ŀ��
	
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		DataOutputStream dos=new DataOutputStream(baos);//�����������������
		
		byte[] datas=null;
		dos.writeUTF("sofency hello world");
		dos.writeBoolean(false);
		dos.writeInt(18);
		dos.writeChar('a');
		dos.flush();
		datas=baos.toByteArray();
		
//		3.�����ݷ�װ��DatagramPacket����packet   ��Ҫָ��Ŀ�ĵ�InetSocketAddress()
		DatagramPacket packet=new DatagramPacket(datas,0,datas.length,new InetSocketAddress("localhost",8888));
//		4.���Ͱ���  send(DatagramPacket p)
		client.send(packet);//���Ͱ���
		
//		5. �ͷ���Դ
		client.close();
	}
}
