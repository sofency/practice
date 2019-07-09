package stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 1.文件字节输入流  分段读取
 * @author sofency
 * 1.创建源
 * 2.选择流
 * 3.操作
 * 4.释放资源
 * 5.将要读取的字符串成组成组的读  
 */
public class ImageStream2 {
	public static void main(String[] args) throws FileNotFoundException {
		//创建源
		File src=new File("test.txt");
		File test=new File("H:\\\\eclipse_workspace\\\\IO学习开篇");
		System.out.println(test.getParent().substring(3));
		//选择流
		InputStream  is=null;
		//操作(分段读取)
		
		try {
			is=new FileInputStream(src);//输入流
			
			//1K  1k的读取
			byte[] flush=new byte[1024];//卡车的容量是30  即每回读取30个字符  即下面一下子就接受完毕了
			int len=-1;//接受的长度
			while((len=is.read(flush))!=-1) {//先将is.read()赋值给temp 然后temp和-1进行比较
				//字节数组--->字符串  解码
				String string=new String(flush,0,len,"GBK");//证明汉字是三个字符
				System.out.println(string);
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
