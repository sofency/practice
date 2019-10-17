package com.sofency.DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdk.internal.dynalink.beans.StaticClass;

public class DBUtil {
	
	public static final String URL="jdbc:oracle:thin:@localhost:1521:ORCL";
	public static final String  USENAME="sofency";
	public static final String  UPWD="19980120";
	public static Connection connection =null;
	public static PreparedStatement pre =null;
	public static ResultSet rSet =null;
	
	//��ɾ��
	public static ResultSet executeQuery(String sql,Object[] obj) {
		try {
            pre=connection2(sql).prepareStatement(sql);
			createPrepareStatement(sql, obj);// ��ȡ��������Ԥ����sql
			rSet = pre.executeQuery();//ִ�в�ѯ
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rSet;
	}
	
	
	public  static  Connection connection2(String sql) throws SQLException, ClassNotFoundException {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			return  DriverManager.getConnection(URL,USENAME,UPWD);
	}
	
	public static void Close(ResultSet rs,PreparedStatement pstm,Connection conn) {
		try {
			if(rs!=null)  rs.close();
		    if(pstm!=null)  pstm.close();
		    if(conn!=null) conn.close();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public  static  void createPrepareStatement(String sql,Object[] obj) throws ClassNotFoundException, SQLException {
		pre=connection2(sql).prepareStatement(sql);
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
			count = pre.executeUpdate();//ִ��
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