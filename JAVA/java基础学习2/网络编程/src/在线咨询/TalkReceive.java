package ������ѯ;

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
			//׼������
			byte[] receive=new byte[1024];
			DatagramPacket packet=new DatagramPacket(receive,0,receive.length);
			
			try {
				server.receive(packet);//�򿪰���
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			//��������
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
