package java再学习;

import java.io.Console;

public class testConsole {
	public static void main(String[] args) {
		Console conn=System.console();//控制台输入 
		//使用cmd时进行操作  
		/**
		 * 解释：Java要与console进行交互，不总是能得到可用的console 类，一个jvm 是否有可用的console,依赖于底层平台
		 * 和jvm如何被调用，如果jvm是交互式命令行(比如window的cmd)中启动,并且输入输出没有重定向到另外的地方
		 * 很明显 eclipse的jvm不是交互式命令行启动的
		 */
		String usernameString=conn.readLine("user name:");
		char[] passwd=conn.readPassword("Password");
		
		System.out.println(usernameString);
		System.out.println(passwd);
		
	}

}
