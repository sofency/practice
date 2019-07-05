package test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;//解决sql注入的风险
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class testPrepareStatement {
	
	
	/**
	 * @param originString
	 * @param length
	 * Oracle数据库本身有一个数据类型是NCHAR(50) ，
	 * 对于输入的字符串参数长度如果达不到数据库定义的长度，
	 * 使用PrepareStatement 则会出现无效，
	 * 比如：上面的例子中如果 name 字段的长度设定为NCHAR(20) 
	 * 那么如果传入参数值为 "hello" 则无效，
	 * 需要自动转化成相应的长度才能预编译成功。 网络解释
	 */
	
	public static String convert2Nchar(String originString,int length) {//解决preparedStatement从数据库拿不出数据的原因代码
         StringBuffer stringBuffer= new StringBuffer(originString);
		 int size= originString.length();
		 if ( size< length) {
			 for( int i=1; i<= length - size; i++){
				 stringBuffer.append(" ");
			 	}
			 originString= stringBuffer.toString();
		 	}
       return originString;
	}
		
	
	public user getUserInfo(int ud,String uname) throws ClassNotFoundException, SQLException {
	    //创建对象
		user u=null;
		//连接驱动器
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//创建连接对象
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott","tiger");
		//创建sql指令
		//Statement stmtStatement=connection.createStatement();
		
//		String sql="select * from Us where Ud='"+ud+"'and Uname='"+uname+"'";
		String sql="select * from Us where Ud = ? and Uname = ?";
		//创建sql命令对象
		PreparedStatement ps=connection.prepareStatement(sql);
		
		//给占位符赋值（占位符从左往右角标从1开始）
		
		ps.setInt(1, ud);
		uname=convert2Nchar(uname, 6);//处理数据大小
		ps.setString(2, uname);
		
		
		ResultSet rSet=ps.executeQuery();
		
		//执行sql语句
		//ResultSet rSet=stmtStatement.executeQuery(sql);//不能再写sql了
		//System.out.println(rSet.getInt("ud"));
		
		
		while(rSet.next()) {
			u=new user();
			u.setUid(rSet.getInt(1));
			//System.out.println(rSet.getInt(1));
			u.setName(rSet.getString(2));
			//System.out.println(rSet.getString(2));
		}
		//关闭资源
		rSet.close();
		ps.close();
		//stmtStatement.close();
		connection.close();
		//返回执行结果
		return u;
	}
	
	public boolean insertIntoUs(int ud,String uname) {//向数据库中插入数据
		
		
		
		
		
		
		return true;
	}
	
	
	
}
