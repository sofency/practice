package changeStream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * ת���� :InputStreamReader 
 *         OutputStreamWriter
 * 1.���ַ�������ʽ�����ֽ���
 * 2.ָ���ַ���
 * 3.���ֽ���ת��Ϊ�ַ���  ����ȡ�ֽ� ���ƶ�charset�������Ϊ�ַ�
 * @author sofency
 *
 */
public class ConventTest {
	public static void main(String[] args) {
		//	System.in  ������Ǵ��ı� 	
//		InputStreamReader isr=new InputStreamReader(System.in);
//		OutputStreamWriter osw=new OutputStreamWriter(System.out);
		
		//����BufferedReader ��Ϊ�˼ӿ��ȡ�ٶ�
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	String msgString="";
    	while(!msgString.equals("exit")) {
    		try {
				msgString=reader.readLine();
				writer.write(msgString);//ѭ��д��
				writer.newLine();
				writer.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	
    	
    	try {
			writer.close();
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}

}
