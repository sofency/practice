package tCPTest;

import java.io.DataInputStream;
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

public class Server {
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
		
		dis.close();
		server.close();
		
	}

}
