package tCPTest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建服务器
 * 1.指定端口  使用serverSocket创建服务器
 * 2.阻塞式等待连接 accept
 * 3.操作输出流输出流操作
 * 4
 * @author sofency
 *
 */

public class LoginTwoWayServer {
	public static void main(String[] args) throws IOException {
		//1.指定端口  使用serverSocket创建服务器
		System.out.println("------Server------");
		@SuppressWarnings("resource")
		ServerSocket server=new ServerSocket(12306);
		//2.阻塞式等待连接
		Socket client=server.accept();
		System.out.println("一个客户端建立连接");
		//3.操作 输入输出流操作
		DataInputStream dis=new DataInputStream(client.getInputStream());
		
		String str=dis.readUTF();
		System.out.println(str);
		//处理数据
		String uname="";
		String upwd="";
		String[] Info=str.split("&");
		for(String str1:Info) {
			
			String[] usrInfo=str1.split("=");
			System.out.println();
			if(usrInfo[0].equals("uname")) {
				System.out.println("用户名:"+usrInfo[1]);
				uname=usrInfo[1];
			}else if(usrInfo[0].equals("upwd")){
				System.out.println("密码:"+usrInfo[1]);
				upwd=usrInfo[1];
			}
		}
		
		DataOutputStream dos=new DataOutputStream(client.getOutputStream());
		if(uname.equals("sofency")&&upwd.equals("12345")) {
			dos.writeUTF("密码正确 登录成功");
		}else {
			dos.writeUTF("密码或账户错误");
			System.out.println(uname+"--"+upwd);
		}
		dos.flush();
		dos.close();
		dis.close();
		server.close();
		
	}

}
