package 群聊4Thread;

/**
 * 多用户发送接收多次消息
 * 问题是  会造成阻塞
 * 加入多线程
 */
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient4 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		System.out.println("------Client------");
		//使用Socket创建客户端  加上服务器的地址与端口
		Socket client=new Socket("localhost",12306);
		BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
		DataOutputStream doS = new  DataOutputStream(client.getOutputStream());
		DataInputStream dis =  new DataInputStream(client.getInputStream());
		boolean flag=true;
		while (flag) {
			String msg=buf.readLine();
			if(msg.equals("bye")) {
				flag=false;
			}
			//发送信息
			doS.writeUTF(msg);
			doS.flush();
			//接收信息
			String str=dis.readUTF();
			System.out.println(str);
		}
		dis.close();
		doS.close();
		
	}
}
