package Ⱥ��5Thread;

//�ڷ������ϼ��϶��߳�
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;



public class TcpServer5 {
	private static CopyOnWriteArrayList<Channel> all=new CopyOnWriteArrayList<Channel>();
	public static void main(String[] args) throws IOException {
		
		System.out.println("------Server------");
		ServerSocket server=new ServerSocket(12306);
		while (true) {//ѭ���Ľ�������  ��Ȼֻ���Ŷ�
			Socket client=server.accept();
			Channel c=new Channel(client);
			all.add(c);
			new Thread(c).start();	
		}
	}	
	
	static class Channel implements Runnable{
		private DataInputStream dis;
		private DataOutputStream dos;
		private Socket client;
		private boolean flag=true;
		private String name;
		public Channel(Socket client) {
			this.client=client;
			try {
				dis = new DataInputStream(this.client.getInputStream());
				dos = new DataOutputStream(this.client.getOutputStream());
				
				this.name=receive();//��������
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			System.out.println("һ���ͻ��˽���������");
			while(flag) {
				String string=receive();
				System.out.println(string);
				if(!string.equals("")) {
					sendOther(string);				
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
		//Ⱥ��
		public void sendOther(String string) {
			for (Channel c:all) {
				if(c==this) continue;
				c.send(name+":"+string);//���͵��Լ��̵߳Ŀͻ�����
			}
		}
		
	}
}

