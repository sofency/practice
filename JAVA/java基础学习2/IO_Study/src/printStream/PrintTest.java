package printStream;

import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintTest {
	public static void main(String[] args) {
		
		//打印流
		
		PrintStream ps=System.out;
		ps.println("打印流");
		ps.println("sofency");
		
		try {// 输入流  发送流         输出流  接收流
			ps=new PrintStream(new BufferedOutputStream(new FileOutputStream("file.txt")),true);
			
			ps.println("hello world");
			ps.println("sofency");
			
			
            //重定向输出端
			System.setOut(ps);//将输出端设置到ps上面
			System.out.println("change");
			
			//重定向会输出端
			System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)),true));
			System.out.println("i am backing..");
			
			
			ps.flush();
			ps.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
