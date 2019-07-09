package stream;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


/**
 *  使用字符数组输出流  FileWriter  进行输入
 *  @author sofency
 *  1.创建源
 *  2.选择流
 *  3 操作
 *  4.关闭
 */
public class FileWriter1 {
	public static void main(String[] args) {
		//创建源
		File file=new File("hha.txt");//  没有这个文件的话会自动进行创建
		
		//2.选择流
		FileWriter writer=null;
		
		try {
			writer =new FileWriter(file);//如果再加参数 true 就表示在文件中追加内容  不然的话就是刷新输入
			
			String message="sofency will be the IT 大牛";
			char[] datas=message.toCharArray();//转化字节数组进行输入   字符串--->字符数组
			writer.write(datas, 0, datas.length);//将内容写入file文件中

			writer.flush();//刷新输出的字节
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			 if(null!=writer) {
				 try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
		}
		
		
		
	}
}
