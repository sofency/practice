package 群聊1;

/**
 * 只能单用户进行发送单条消息
 */
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		System.out.println("------Client------");
		//使用Socket创建客户端  加上服务器的地址与端口
		Socket client=new Socket("localhost",12306);
		BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
		String msg=buf.readLine();
		
		//发送信息
		DataOutputStream doS = new  DataOutputStream(client.getOutputStream());
		doS.writeUTF(msg);
		doS.flush();
		
		
		//接收信息
		DataInputStream dis =  new DataInputStream(client.getInputStream());
		String str=dis.readUTF();
		System.out.println(str);
		
	}
}
