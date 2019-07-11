package stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 1.第一个程序；理解操作步骤
 * @author sofency
 * 1.创建源
 * 2.选择流
 * 3.操作
 * 4.释放资源
 */
public class IOStream {
	public static void main(String[] args) throws FileNotFoundException {
		//创建源
		File src=new File("test.txt");
		//选择流
		InputStream  is=null;
		//操作
		int temp;
		try {
			is=new FileInputStream(src);
			while((temp=is.read())!=-1) {//先将is.read()赋值给temp 然后temp和-1进行比较
				System.out.print((char)temp);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(null!=is) {
					is.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
