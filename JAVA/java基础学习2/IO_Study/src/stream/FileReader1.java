package stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.io.Reader;

/**
 * 1.使用字符流进行读取文件   不用考虑是否中文的问题
 * @author sofency
 * 1.创建源
 * 2.选择流
 * 3.操作
 * 4.释放资源
 * 5.将要读取的字符串成组成组的读  
 */
public class FileReader1 {
	public static void main(String[] args) throws FileNotFoundException {
		//创建源
		File src=new File("destination.txt");
		
		//选择流
		Reader reader=null;
		//操作(分段读取)
		
		try {
			reader=new FileReader(src);//输入流
			
			//1K  1k的读取
			char[] flush=new char[1024];//卡车的容量是30  即每回读取30个字符  即下面一下子就接受完毕了
			int len=-1;//接受的长度
			while((len=reader.read(flush))!=-1) {//先将is.read()赋值给temp 然后temp和-1进行比较
				//字符数组--->字符串  解码
				String string=new String(flush,0,len);//证明汉字是三个字符
				System.out.println(string);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(null!=reader) {
					reader.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
