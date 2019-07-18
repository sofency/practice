package Web;

//获取http协议
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server01 {
	private ServerSocket serverSocket;
	public static void main(String[] args) {
		Server01 server01=new Server01();
		server01.start();
		
	}
	
	//启动服务
	public void start() {
		try {
			serverSocket=new ServerSocket(8888);
			receive();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("启动服务失败");
		}//指定端口
	}
	
	//接受连接处理
	public void receive() {
		try {
			Socket client=serverSocket.accept();
			System.out.println("一个客户端建立联系");
			
			BufferedReader br=new BufferedReader(new InputStreamReader(client.getInputStream()));
			String msg="";
			while(!(msg=br.readLine()).equals("")) {
				System.out.println(msg);
			}
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("客户端连接失败");
			e.printStackTrace();
		}
	}
}
