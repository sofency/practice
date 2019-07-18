package udpTest;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 接受端
 * 1.使用DatagramSocket  指定端口  创建接受端
 * 2.指定容器   封装成DatagramPacket 包裹
 * 3.阻塞式接受包裹  receive(DatagramPacket p)
 * 4.分析数据
 * byte[]  getData()  
 *       getLength()
 * 5. 释放资源
 * @author sofency
 *
 */
public class UdpTestServer {
	public static void main(String[] args) throws IOException {
		System.out.println("接收方接收中。。。");
//		1.使用DatagramSocket  指定端口  创建接受端
		DatagramSocket server=new DatagramSocket(8888);
//		2.指定容器   封装成DatagramPacket 包裹
		byte[] receive=new byte[1024*60];
		DatagramPacket packet=new DatagramPacket(receive,0,receive.length);
//		3.阻塞式接受包裹  receive(DatagramPacket p)
		server.receive(packet);
//		4.分析数据
//		 byte[]  getData()  
//		       getLength()
		byte[] datas=packet.getData();
		
		System.out.println(new String(datas,0,datas.length));
		
	}
}
