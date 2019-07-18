package tCPTest;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.omg.PortableInterceptor.DISCARDING;

/**
 * ����������
 * 1.ָ���˿�  ʹ��serverSocket����������
 * 2.����ʽ�ȴ����� accept
 * 3.������������������
 * 4
 * @author sofency
 *
 */

public class LoginMultiWayServer {
	public static void main(String[] args) throws IOException {
		//1.ָ���˿�  ʹ��serverSocket����������
		System.out.println("------Server------");
		@SuppressWarnings("resource")
		ServerSocket server=new ServerSocket(12306);
		//2.����ʽ�ȴ�����
		while (true) {
			Socket client=server.accept();
			System.out.println("һ���ͻ��˽�������");
			new Thread(new Channel(client)).start();
		}
		
	}
	
	static class Channel implements Runnable{

		private String uname;
		private String upwd;
		private DataOutputStream dos = null;
		private DataInputStream dis = null;
		
		public Channel(Socket client) {
			try {
				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	
		@Override
		public void run() {
			//3.���� �������������  ��������
			this.get();//�Ի�ȡ�����ݽ��з���
			this.send();//����������ظ��ͻ���
			
		}
		
		public void get() {//��������  ��ȡ�û���������
			String[] Info=receive().split("&");
			for(String str1:Info) {
				String[] usrInfo=str1.split("=");
				System.out.println();
				if(usrInfo[0].equals("uname")) {
					System.out.println("�û���:"+usrInfo[1]);
					this.uname=usrInfo[1];
				}else if(usrInfo[0].equals("upwd")){
					System.out.println("����:"+usrInfo[1]);
					this.upwd=usrInfo[1];
				}
			}
		}
	
		public String receive() {//�ӿͻ��˻�ȡ����
			String str = null;
			try {
				str = dis.readUTF();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
		
		private void send() {//���ͷ���
			if(this.uname.equals("sofency")&&this.upwd.equals("12345")) {
				try {
					dos.writeUTF("������ȷ ��¼�ɹ�");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else {
				try {
					dos.writeUTF("������˻�����");
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println(uname+"--"+upwd);
			}
		}
		
		//�ر���Դ
		
		public void release(){
			try {
				if(null!=dis) {					
					dis.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				if(null!=dos) {					
					dos.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
