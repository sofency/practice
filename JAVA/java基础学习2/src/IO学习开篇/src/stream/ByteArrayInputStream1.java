package stream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ByteArrayInputStream1 {
	public static void main(String[] args) throws IOException {
		//创建源
		byte[] array="talk is cheap show me the code".getBytes();//"废话少说 多敲代码"
		
		//选择流
		InputStream is=null;
		//操作
		is=new ByteArrayInputStream(array);//字节数组输入流
		byte[] flush=new byte[5];//设施缓冲区  不易过大
		
		int len=-1;
		
		while((len=is.read(flush))!=-1) {
			//获取字符
			String string=new String(flush,0,len);
			System.out.println(string);
			
		}
		is.close();
		
	}

}
