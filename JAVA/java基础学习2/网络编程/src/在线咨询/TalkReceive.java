package 在线咨询;

import java.io.IOException;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TalkReceive implements Runnable{
	
	private DatagramSocket server;
	private String from;
	public TalkReceive(int port,String from) {
		this.from=from;
		try {
			server= new DatagramSocket(port);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while(true) {
			//准备包裹
			byte[] receive=new byte[1024];
			DatagramPacket packet=new DatagramPacket(receive,0,receive.length);
			
			try {
				server.receive(packet);//打开包裹
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			//分析数据
			byte[] datas=packet.getData();
			String string= new String(datas,0,datas.length);
			System.out.println(from+":"+string);
			if(string.equals("bye")) {
				break;
			}
		}
		server.close();
	}
}
