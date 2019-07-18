package ÈºÁÄ5Thread;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Receive implements Runnable{
	
	private DataInputStream dis; 
	private boolean flag=true;
	
	public Receive(Socket client) {
		try {
			dis = new DataInputStream(client.getInputStream());
		} catch (IOException e) {
			System.out.println("------4------");
			e.printStackTrace();
		}
	}
	
	
	public String receive() {
		String str = "";
		try {
			str = dis.readUTF();
		} catch (IOException e) {
			System.out.println("------5------");
			flag=false;//ÍË³öÑ­»·
			try {
				dis.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return str;
	}
	@Override
	public void run() {
		while(flag) {
			String str=receive();
			if(!str.equals("")) {
				System.out.println(str);
			}
		}
	}

}
