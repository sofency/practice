package tCPTest;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 创建客户端
 * 1.建立连接 使用Socket创建客户端 +服务的地址和端口
 * 2.操作：输入输出流操作
 * 3.释放资源
 * @author sofency
 *
 */
public class LoginMultiWayClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		
		System.out.println("------Client------");
		BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("请输入账号:");
		String uname=buf.readLine();
		System.out.print("请输入密码:");
		String upwd=buf.readLine();
		//使用Socket创建客户端  加上服务器的地址与端口
		Socket client=new Socket("localhost",12306);
		
		Send(client, uname, upwd);
		//客户端需要发送数据所以需要使用DataOutputStream输出流进行发送数据
		
		receive(client);
		
		//关闭资源
		buf.close();
		client.close();
	}
	
	public static void Send(Socket client,String uname,String upwd) {
		DataOutputStream doS = null;
		try {
			doS = new  DataOutputStream(client.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			doS.writeUTF("uname="+uname+"&"+"upwd="+upwd);
			doS.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void receive(Socket client) {
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(client.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String str = null;
		try {
			str = dis.readUTF();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(str);
	}

}
