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
			 * 1.��������
			 * 2.�����˻�
			 * 3.��ȡsqlָ��
			 * 4.��дsql���
			 * 5.ִ��sql���
			 * 6.�ر���Դ
			 */
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection =DriverManager.getConnection(driverString,"scott","tiger");
			//��ȡsql ��ָ��
			statement=connection.createStatement();
			//дsql���
			String sqlString="update stu set sname='alice' where sno=125";
			int i=statement.executeUpdate(sqlString);
			System.out.println("ִ�н���ǣ�"+i);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//�ر���Դ
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
