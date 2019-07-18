package ÔÚÏß×ÉÑ¯;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class TalkSend implements Runnable{
	
	private DatagramSocket client;
	private BufferedReader reader;
	private String toIp;
	private int toPort;
	
	public TalkSend(int port,String toIp,int toPort) {
		
		this.toIp=toIp;
		this.toPort=toPort;
		try {
			client=new DatagramSocket(port);
			reader=new BufferedReader(new InputStreamReader(System.in));
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			String string = null;
			try {
				string = this.reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			byte[] by=string.getBytes();
			DatagramPacket packet=new DatagramPacket(by,0,by.length,
					new InetSocketAddress(this.toIp,this.toPort));			
			try {
				client.send(packet);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(string.equals("bye")) {
				break;
			}
		}
		client.close();
	}
}
