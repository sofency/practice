package test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/***
 * 
 * @author sofency
 *  问题： 使用resultSet时不方便对数据进行针对性查找
 *  解决： 将数据转换到ArrayList中进行存储
 *  
 */

public class testSelect {
	
	
	public ArrayList<stu> getStudentInfo() {
		
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String user="scott";
		String password="tiger";
		Connection conn=null;
		Statement stmt=null;
		
		//创建数组列表
		ArrayList<stu> list=new ArrayList<stu>();
		
		//加载驱动类
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//创建连接对象
			conn=DriverManager.getConnection(url, user, password);
			
			//获取数据库命令
			stmt=conn.createStatement();
			
			//写sql命令
			String sql="select * from stu";
			
			//执行sql命令   alt+shift+L快捷键
			ResultSet rSet=stmt.executeQuery(sql);
			
			
			System.out.println("学号"+"\t"+"姓名"+"\t"+"性别"+"\t"+"系别"+"\t"+"年龄"+"\t"+"出生日期");
			
			while(rSet.next()) {
				//获取全部数据
				//System.out.print(rSet.getInt("sno")+"\t"+rSet.getString("sname")+"\t"+rSet.getString("ssex")+"\t"+rSet.getString("sdept")+"\t"+rSet.getInt("sage")+"\t"+rSet.getDate("sdate"));
				//System.out.println();
				
				//获取指定数据
				 stu Stu=new stu();
				 
				 Stu.setSno(rSet.getInt("sno"));
				 Stu.setSname(rSet.getString("sname"));
				 Stu.setSsex(rSet.getString("ssex"));
				 Stu.setSdept(rSet.getString("sdept"));
				 Stu.setSage(rSet.getInt("sage"));
				 Stu.setDate(rSet.getDate("sdate"));
				 
				 list.add(Stu);//加入数组列表
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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
		return list;
	}
}
