package iPTest;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * IP ��λһ�����
 * @author sofency
 *
 */
public class IPTest {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress addr=InetAddress.getLocalHost();
		System.out.println(addr.getHostAddress());//����������IP
		System.out.println(addr.getHostName());//����������
		
		
		
		//���������õ�InetAddress����   ����IP��ַ
		addr=InetAddress.getByName("www.ahoj.cc");
		System.out.println(addr.getHostAddress());//����������IP
		System.out.println(addr.getHostName());//����������
		
		
	}

}
