package DBUtil;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;

public class DBUtil {

	public static final String DRIVER="oracle.jdbc.driver.OracleDriver";
	public static Connection connection =null;
	public static PreparedStatement pre =null;
	public static ResultSet rSet =null;
	
	//
	public static ResultSet executeQuery(String sql,Object[] obj) {
		try {
			createPrepareStatement(sql, obj);//
			rSet = pre.executeQuery();//ִ
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rSet;
	}

	
	public static void Close(ResultSet rs,PreparedStatement pstm,Connection conn) {
		try {
			if(rs!=null)  rs.close();
		    if(pstm!=null)  pstm.close();
		    if(conn!=null) conn.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public  static  void createPrepareStatement(String sql,Object[] obj) throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);//加载驱动类
		//将访问数据库的连接指向数据源
		try {
			Context ctx = new InitialContext();
			DataSource data = (DataSource)ctx.lookup("java:comp/env/student");//数据源
			connection = data.getConnection();//connection就指向了数据库
		} catch (NamingException e) {
			e.printStackTrace();
		}
		pre = connection.prepareStatement(sql);
		if(obj!=null) {
			for(int i=0;i<obj.length;i++) {
				pre.setObject(i+1, obj[i]);
			}
		}
	}
	
	public static int executeUpdate(String sql,Object[] obj) {
		int count=0;
		try {
			createPrepareStatement(sql, obj);
			count = pre.executeUpdate();//ִ
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			Close(rSet, pre, connection);
		}
		return count;
	}
		
}