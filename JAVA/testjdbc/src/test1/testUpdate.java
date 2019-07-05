package test1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class testUpdate {
	public  static void main(String[] args) {
	
		Statement statement=null;
		Connection connection=null;
		String driverString="jdbc:oracle:thin:@localhost:1521:orcl";
		
		try {
			/***
			 * 1.连接驱动
			 * 2.链接账户
			 * 3.获取sql指令
			 * 4.编写sql语句
			 * 5.执行sql语句
			 * 6.关闭资源
			 */
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection =DriverManager.getConnection(driverString,"scott","tiger");
			//获取sql 的指令
			statement=connection.createStatement();
			//写sql语句
			String sqlString="update stu set sname='alice' where sno=125";
			int i=statement.executeUpdate(sqlString);
			System.out.println("执行结果是："+i);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//关闭资源
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
