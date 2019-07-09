package stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *  文件字节输出流
 *  @author sofency
 *  1.创建源
 *  2.选择流
 *  3 操作
 *  4.关闭
 */
public class ByteOutputStream1 {
	public static void main(String[] args) {
		//创建源
		File file=new File("hha.txt");//  没有这个文件的话会自动进行创建
		
		//2.选择流
		OutputStream out=null;
		
		try {
			out =new FileOutputStream(file);//如果再加参数 true 就表示在文件中追加内容  不然的话就是刷新输入
			
			String message="sofency will be the IT 大牛";
			
			byte[] datas=message.getBytes();//转化字节数组进行输入   字符串--->字节数组（编码）
			
			out.write(datas, 0, datas.length);//将内容写入file文件中

			out.flush();//刷新输出的字节
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			 if(null!=out) {
				 try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
		}
		
		
		
	}
}
