package 群聊5Thread;

import java.io.BufferedReader;

/**
 * 多用户发送接收多次消息
 * 问题是  
 * 加入多线程
 */

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient5 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		System.out.println("------Client------");
		//使用Socket创建客户端  加上服务器的地址与端口
		Socket client=new Socket("localhost",12306);
		System.out.println("请输入用户名");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String name=br.readLine();//注册姓名后建立连接
		new Thread(new Send(client,name)).start();
		new Thread(new Receive(client)).start();
	}
}
