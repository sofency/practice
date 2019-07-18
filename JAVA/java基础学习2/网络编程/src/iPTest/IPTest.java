package iPTest;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * IP 定位一个结点
 * @author sofency
 *
 */
public class IPTest {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress addr=InetAddress.getLocalHost();
		System.out.println(addr.getHostAddress());//返回主机的IP
		System.out.println(addr.getHostName());//输出计算机名
		
		
		
		//根据域名得到InetAddress对象   解析IP地址
		addr=InetAddress.getByName("www.ahoj.cc");
		System.out.println(addr.getHostAddress());//返回主机的IP
		System.out.println(addr.getHostName());//输出计算机名
		
		
	}

}
