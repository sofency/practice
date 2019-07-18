package iPTest;

import java.net.InetSocketAddress;

/**
 * 端口  区分软件
 * 两个字节  0-65535  UDP  TCP
 * 同一个协议端口不能冲突
 * 定义端口越大越好
 * @author sofency
 *
 */
public class PortTest {
	public static void main(String[] args) {
		InetSocketAddress socketAddress=new InetSocketAddress("127.0.0.1",8080);//通过端口
		InetSocketAddress socketAddress1=new InetSocketAddress("localhost",9999);//通过域名  指定端口
		System.out.println(socketAddress.getAddress());
		System.out.println(socketAddress1.getAddress());
		System.out.println(socketAddress1.getPort());
	}

}
