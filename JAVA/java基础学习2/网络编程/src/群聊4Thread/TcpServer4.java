package 群聊4Thread;

//在服务器上加上多线程
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;



public class TcpServer4 {
	public static void main(String[] args) throws IOException {
		System.out.println("------Server------");
		ServerSocket server=new ServerSocket(12306);
		while (true) {//循环的建立连接  不然只能排队
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
		System.out.println("一个客户端建立了连接");
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
	//接收信息
	public String receive() {
		String string = null;
		try {
			string = dis.readUTF();
		} catch (IOException e) {
			System.out.println("----2-------");
		}
		return string;
		
	}
	
	//发送消息
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
