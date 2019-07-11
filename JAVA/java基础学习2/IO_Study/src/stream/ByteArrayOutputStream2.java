package stream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 
 * @author sofency
 * 1.创建源 内部维护 不用创建
 * 2.选择流不关联源  就是只在write的时候进行写入就可以了
 * 3.操作
 * 4.不用释放资源
 * 
 */
public class ByteArrayOutputStream2 {
	public static void main(String[] args) throws IOException {
		//创建源
		byte[] array=null;//"废话少说 多敲代码"

		//选择流
		ByteArrayOutputStream baos=null;
		
		//操作
		baos=new ByteArrayOutputStream();//字节数组输入流
		
		String msgString="talk is cheap show me the code";
		byte[] datas=msgString.getBytes();//转化为字节数组
		
		baos.write(datas,0,datas.length);  
		
		//写的是字节  网络编程得话先将字节数组传送过去 然后在进行解码处理字符
		
		baos.flush();
		
		//获取数据
		
		array=baos.toByteArray();//将传送的字节转化过来
		
		
		System.out.println(array);
		//还原字符
		System.out.println(new String(array));
		
		
	}

}
