package Ⱥ��1;

/**
 * ֻ�ܵ��û����з��͵�����Ϣ
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
		//ʹ��Socket�����ͻ���  ���Ϸ������ĵ�ַ��˿�
		Socket client=new Socket("localhost",12306);
		BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
		String msg=buf.readLine();
		
		//������Ϣ
		DataOutputStream doS = new  DataOutputStream(client.getOutputStream());
		doS.writeUTF(msg);
		doS.flush();
		
		
		//������Ϣ
		DataInputStream dis =  new DataInputStream(client.getInputStream());
		String str=dis.readUTF();
		System.out.println(str);
		
	}
}
