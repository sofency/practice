package tCPTest;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * �����ͻ���
 * 1.�������� ʹ��Socket�����ͻ��� +����ĵ�ַ�Ͷ˿�
 * 2.�������������������
 * 3.�ͷ���Դ
 * @author sofency
 *
 */
public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		
		System.out.println("------Client------");
		//ʹ��Socket�����ͻ���  ���Ϸ������ĵ�ַ��˿�
		Socket client=new Socket("localhost",12306);
		
		//�ͻ�����Ҫ��������������Ҫʹ��DataOutputStream��������з�������
		DataOutputStream  doS=new  DataOutputStream(client.getOutputStream());
		
		String data="hello";
		doS.writeUTF(data);
		doS.flush();
		client.close();
		
		
	}

}
