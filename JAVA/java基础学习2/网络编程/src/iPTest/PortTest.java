package iPTest;

import java.net.InetSocketAddress;

/**
 * �˿�  �������
 * �����ֽ�  0-65535  UDP  TCP
 * ͬһ��Э��˿ڲ��ܳ�ͻ
 * ����˿�Խ��Խ��
 * @author sofency
 *
 */
public class PortTest {
	public static void main(String[] args) {
		InetSocketAddress socketAddress=new InetSocketAddress("127.0.0.1",8080);//ͨ���˿�
		InetSocketAddress socketAddress1=new InetSocketAddress("localhost",9999);//ͨ������  ָ���˿�
		System.out.println(socketAddress.getAddress());
		System.out.println(socketAddress1.getAddress());
		System.out.println(socketAddress1.getPort());
	}

}
