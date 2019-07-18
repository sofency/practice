package udpTest;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpTypeTestServer {

	public static void main(String[] args) throws IOException {
		System.out.println("接收方接收中。。。");
//		1.使用DatagramSocket  指定端口  创建接受端
		@SuppressWarnings("resource")
		DatagramSocket server=new DatagramSocket(8888);//使用8888端口进行接收
//		2.指定容器   封装成DatagramPacket 包裹
		byte[] receive=new byte[1024*60];
		DatagramPacket packet=new DatagramPacket(receive,0,receive.length);
//		3.阻塞式接受包裹  receive(DatagramPacket p)
		server.receive(packet);//阻塞式解包
//		4.分析数据
//		 byte[]  getData()  
//		       getLength()
		
		byte[] datas=packet.getData();//解包
		DataInputStream dis=new DataInputStream(new ByteArrayInputStream(datas));
		String msg=dis.readUTF();
		Boolean flag=dis.readBoolean();
		int age=dis.readInt();
		char ch=dis.readChar();
		System.out.println(msg+","+flag+","+age+","+ch);
		
	}
}
