package test1;

import java.sql.SQLException;
import java.util.Scanner;

public class testlogin {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		user u=null;
		Scanner input=new Scanner(System.in);
		System.out.println("请输入用户名");
		String unameString=input.nextLine();
		System.out.println("请输入密码");
		int pwd=input.nextInt();
		
		
		//创建数据库操作对象
		testPrepareStatement login=new testPrepareStatement();
		u=login.getUserInfo(pwd, unameString);
		
		//判断返回值
		if(u!=null) {
			System.out.println("登陆成功");
		}else {
			System.out.println("登录失败");
		}
		
	}
}
