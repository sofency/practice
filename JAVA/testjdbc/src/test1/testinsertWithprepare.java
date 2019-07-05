package test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;//若有返回对象则使用该包
import java.sql.SQLException;

public class testinsertWithprepare {
	
	public static void deleteUserInfo(int ud) throws ClassNotFoundException, SQLException {
		
		//连接驱动
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//创建连接对象
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
		
		//创建sql指令
		String sql="delete Us where ud=?";
		//虚拟执行sql语句
		PreparedStatement ps=conn.prepareStatement(sql);
		//给占位符赋值
		ps.setInt(1, 125);
		
		//执行操作
		
		int i=ps.executeUpdate();
		if(i!=0) {
			System.out.println("删除成功");
		}else {
			System.out.println("删除失败");
		}
		ps.close();
		conn.close();
		
	}
	
	public  static void insertUserInfo(int ud,String uname) throws ClassNotFoundException, SQLException {
		
		//连接驱动
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//创建连接对象
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
		//先写SQL语句
		String sql="insert into Us values(?,?)"; //用？进行占位
		PreparedStatement ps=conn.prepareStatement(sql);
		//然后给占位符赋值
		ps.setInt(1, ud);
		ps.setString(2, uname);
		
		//执行sql语句
		int i=ps.executeUpdate();//执行完之后自动提交事物
		if(i!=0) {
			System.out.println("插入成功");
		}else {
			System.out.println("插入失败");
		}
		//关闭资源
		ps.close();
		conn.close();
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//insertUserInfo(126, "hello");
		deleteUserInfo(126);
	}

}
