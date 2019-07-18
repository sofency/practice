package Ⱥ��4Thread;

//�ڷ������ϼ��϶��߳�
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;



public class TcpServer4 {
	public static void main(String[] args) throws IOException {
		System.out.println("------Server------");
		ServerSocket server=new ServerSocket(12306);
		while (true) {//ѭ���Ľ�������  ��Ȼֻ���Ŷ�
			Socket client=server.accept();
			new Thread(new Channel(client)).start();	
		}
	}	
}

class Channel implements Runnable{
	private DataInputStream dis;
	private DataOutputStream dos;
	private Socket client;
	private boolean flag=true;
	public Channel(Socket client) {
		this.client=client;
		try {
			dis = new DataInputStream(this.client.getInputStream());
			dos = new DataOutputStream(this.client.getOutputStream());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		System.out.println("һ���ͻ��˽���������");
		while(flag) {
			String string=receive();
			if(!string.equals("")) {
				send(string);				
			}
		}
		try {
			dos.close();
			dis.close();
			client.close();
		} catch (IOException e) {
			System.out.println("----1-------");
		}
		
	}
	//������Ϣ
	public String receive() {
		String string = null;
		try {
			string = dis.readUTF();
		} catch (IOException e) {
			System.out.println("----2-------");
		}
		return string;
		
	}
	
	//������Ϣ
	public  void send(String string) {
		try {
			dos.writeUTF(string);
			dos.flush();
			if(string.equals("bye")) {
				flag=false;
			}
		} catch (IOException e) {
		  System.out.println("----3-------");
		}
	}
	
}
