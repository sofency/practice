package Ⱥ��4Thread;

/**
 * ���û����ͽ��ն����Ϣ
 * ������  ���������
 * ������߳�
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
		//ʹ��Socket�����ͻ���  ���Ϸ������ĵ�ַ��˿�
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
			//������Ϣ
			doS.writeUTF(msg);
			doS.flush();
			//������Ϣ
			String str=dis.readUTF();
			System.out.println(str);
		}
		dis.close();
		doS.close();
		
	}
}
