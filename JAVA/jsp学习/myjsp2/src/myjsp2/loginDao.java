package myjsp2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginDao {
	
    public boolean  login(String uname,String upwd) {
    	String realPwd=null;//�洢��ȷ������
    	Boolean flag=false;		
    	Connection connection =null;
    	PreparedStatement pre = null;
    	ResultSet rset = null;
		//�������ݿ������
		try{
			//��Ҫ��jar�����뵽webI-INF��
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//��������
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","sofency","19980120");
			connection.setAutoCommit(false);
			String sql ="select upwd from login where uname = ? ";
			pre = connection.prepareStatement(sql);
			pre.setString(1, uname);
			rset = pre.executeQuery();// ִ�в�ѯ
			connection.commit();
			while(rset.next()){
				realPwd = rset.getString("upwd"); 
			}
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			try{
				connection.rollback();
			}catch(SQLException e1){
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally{
			if(rset!=null){
				try {
					rset.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pre!=null){
				try {
					pre.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(connection!=null){
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
    	}
		
		if(realPwd!=null){
			 if(realPwd.equals(upwd)){
				 flag=true;
			 }
		 }
		return flag;
		
    }
}
