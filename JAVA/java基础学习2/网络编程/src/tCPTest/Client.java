package tCPTest;

import java.io.DataOutputStream;
import java.io.IOException;
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
public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		
		System.out.println("------Client------");
		//使用Socket创建客户端  加上服务器的地址与端口
		Socket client=new Socket("localhost",12306);
		
		//客户端需要发送数据所以需要使用DataOutputStream输出流进行发送数据
		DataOutputStream  doS=new  DataOutputStream(client.getOutputStream());
		
		String data="hello";
		doS.writeUTF(data);
		doS.flush();
		client.close();
		
		
	}

}
