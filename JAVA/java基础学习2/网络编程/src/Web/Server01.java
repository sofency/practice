package Web;

//��ȡhttpЭ��
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
	
	//��������
	public void start() {
		try {
			serverSocket=new ServerSocket(8888);
			receive();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("��������ʧ��");
		}//ָ���˿�
	}
	
	//�������Ӵ���
	public void receive() {
		try {
			Socket client=serverSocket.accept();
			System.out.println("һ���ͻ��˽�����ϵ");
			
			BufferedReader br=new BufferedReader(new InputStreamReader(client.getInputStream()));
			String msg="";
			while(!(msg=br.readLine()).equals("")) {
				System.out.println(msg);
			}
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("�ͻ�������ʧ��");
			e.printStackTrace();
		}
	}
}
