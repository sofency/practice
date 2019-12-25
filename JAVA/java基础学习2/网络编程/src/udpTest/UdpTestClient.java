package udpTest;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 发送端
 * 1.使用DatagramSocket  指定端口  创建发送端
 * 2.准备数据  一定要转化为字节数组
 * 3.封装成DatagramPacket 包裹   需要指定目的地
 * 4.发送包裹  send(DatagramPacket p)
 * byte[]  getData()  
 *       getLength()
 * 5. 释放资源
 * @author sofency
 *
 */

public class UdpTestClient {
	public static void main(String[] args) throws IOException {
		System.out.println("发送方启动中");
//		1.使用DatagramSocket  指定端口  创建发送端
		DatagramSocket client=new DatagramSocket(9999);
//		2.准备数据  一定要转化为字节数组
		String string="sofency  love";
		byte[] by=string.getBytes();
//		3.封装成DatagramPacket 包裹   需要指定目的地
		DatagramPacket packet=new DatagramPacket(by,0,by.length,new InetSocketAddress("localhost",8888));
//		4.发送包裹  send(DatagramPacket p)
		client.send(packet);
//		5. 释放资源
		client.close();
	}
}
