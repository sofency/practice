package udpTest;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UdpTypeTestClient {

	public static void main(String[] args) throws IOException {
		System.out.println("发送方启动中");
//		1.使用DatagramSocket  指定端口  创建发送端
		DatagramSocket client=new DatagramSocket(9999);///指定9999客户端端口
//		2.准备数据  一定要转化为字节数组  固定的框架
	
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		DataOutputStream dos=new DataOutputStream(baos);//数据类型数据输出流
		
		byte[] datas=null;
		dos.writeUTF("sofency hello world");
		dos.writeBoolean(false);
		dos.writeInt(18);
		dos.writeChar('a');
		dos.flush();
		datas=baos.toByteArray();
		
//		3.将数据封装成DatagramPacket包裹packet   需要指定目的地InetSocketAddress()
		DatagramPacket packet=new DatagramPacket(datas,0,datas.length,new InetSocketAddress("localhost",8888));
//		4.发送包裹  send(DatagramPacket p)
		client.send(packet);//发送包裹
		
//		5. 释放资源
		client.close();
	}
}
