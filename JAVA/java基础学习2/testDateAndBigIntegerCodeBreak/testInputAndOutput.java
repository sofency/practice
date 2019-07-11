package java再学习;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class testInputAndOutput {
	public static void main(String[] args) {
		try {
			Scanner in=new Scanner(Paths.get("C:\\Users\\sofency\\Desktop\\xml解析.txt"),"GBK");
			//参数介绍  Paths.get(参数1)//该方法是获取文件内容的 参数1是绝对路径 Scanner 的第二个参数是输出和文件的编码格式
			while(in.hasNext()) {
				System.out.println(in.nextLine());//获取文件的内容
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
