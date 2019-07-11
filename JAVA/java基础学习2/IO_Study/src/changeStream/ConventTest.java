package changeStream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 转换流 :InputStreamReader 
 *         OutputStreamWriter
 * 1.以字符流的形式操作字节流
 * 2.指定字符集
 * 3.将字节流转化为字符流  它读取字节 并制定charset将其解码为字符
 * @author sofency
 *
 */
public class ConventTest {
	public static void main(String[] args) {
		//	System.in  输入的是纯文本 	
//		InputStreamReader isr=new InputStreamReader(System.in);
//		OutputStreamWriter osw=new OutputStreamWriter(System.out);
		
		//加上BufferedReader 是为了加快读取速度
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	String msgString="";
    	while(!msgString.equals("exit")) {
    		try {
				msgString=reader.readLine();
				writer.write(msgString);//循环写入
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
