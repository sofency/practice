package test1;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//jdbc 其实就是数据库厂商对外提供的能够对自己的数据进行数据操作的驱动包也就是jar包

/***
 * 
 * @author sofency
 * 
 * 1.导入jar包 ojdbc6.jar
 * 2.加载驱动 Class.forName("oracle.jdbc.driver.OracleDriver"")； 初始化加载jdbc类到java虚拟机
 * 3.获取数据库连接对象  import java.sql.Connection 创建连接对象
 *  DriverManager.getConnection(url,"账户",密码"") url  jdbc:oracle:thin:@localhost:1521:orcl
 * 4.获取数据库命令对象 import java.sql.Statement
 * 5.指定命令 
 * 6.执行命令 对象.executeUpdate()
 */

public class test1 {
	public static void main(String[] args) {
		//jdbc 变量声明
		Connection conn=null;
		Statement stmt=null;
		
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String DataUser="scott";
		String DataPasword="tiger";
		
		try {
			//1.加载驱动类
			Class.forName(driver);
			//2.获取数据库连接对象（连接制定的数据库）
			conn=DriverManager.getConnection(url, DataUser, DataPasword);
			//3.获取sql命令对象
			stmt=conn.createStatement();
			//4.创建sql命令 注意单引号和双引号的包含关系
			String sql="insert into stu values(125,'吴婷','女','MA','18','01-9月-2001')";
			//5.指定sql命令
			int i= stmt.executeUpdate(sql);
			System.out.println("执行结果:"+i);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			//关闭资源
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}


//jdbc 是我们程序员一种常见的数据操作语言它的主要功能就是通过Java对Oracle数据库进行数据操作
