package tCPTest;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.omg.PortableInterceptor.DISCARDING;

/**
 * 创建服务器
 * 1.指定端口  使用serverSocket创建服务器
 * 2.阻塞式等待连接 accept
 * 3.操作输出流输出流操作
 * 4
 * @author sofency
 *
 */

public class LoginMultiWayServer {
	public static void main(String[] args) throws IOException {
		//1.指定端口  使用serverSocket创建服务器
		System.out.println("------Server------");
		@SuppressWarnings("resource")
		ServerSocket server=new ServerSocket(12306);
		//2.阻塞式等待连接
		while (true) {
			Socket client=server.accept();
			System.out.println("一个客户端建立连接");
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
			//3.操作 输入输出流操作  处理数据
			this.get();//对获取的数据进行分析
			this.send();//分析结果返回给客户端
			
		}
		
		public void get() {//处理数据  获取用户名和密码
			String[] Info=receive().split("&");
			for(String str1:Info) {
				String[] usrInfo=str1.split("=");
				System.out.println();
				if(usrInfo[0].equals("uname")) {
					System.out.println("用户名:"+usrInfo[1]);
					this.uname=usrInfo[1];
				}else if(usrInfo[0].equals("upwd")){
					System.out.println("密码:"+usrInfo[1]);
					this.upwd=usrInfo[1];
				}
			}
		}
	
		public String receive() {//从客户端获取数据
			String str = null;
			try {
				str = dis.readUTF();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
		
		private void send() {//发送反馈
			if(this.uname.equals("sofency")&&this.upwd.equals("12345")) {
				try {
					dos.writeUTF("密码正确 登录成功");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else {
				try {
					dos.writeUTF("密码或账户错误");
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println(uname+"--"+upwd);
			}
		}
		
		//关闭资源
		
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
