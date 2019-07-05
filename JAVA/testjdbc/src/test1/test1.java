package test1;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//jdbc ��ʵ�������ݿ⳧�̶����ṩ���ܹ����Լ������ݽ������ݲ�����������Ҳ����jar��

/***
 * 
 * @author sofency
 * 
 * 1.����jar�� ojdbc6.jar
 * 2.�������� Class.forName("oracle.jdbc.driver.OracleDriver"")�� ��ʼ������jdbc�ൽjava�����
 * 3.��ȡ���ݿ����Ӷ���  import java.sql.Connection �������Ӷ���
 *  DriverManager.getConnection(url,"�˻�",����"") url  jdbc:oracle:thin:@localhost:1521:orcl
 * 4.��ȡ���ݿ�������� import java.sql.Statement
 * 5.ָ������ 
 * 6.ִ������ ����.executeUpdate()
 */

public class test1 {
	public static void main(String[] args) {
		//jdbc ��������
		Connection conn=null;
		Statement stmt=null;
		
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String DataUser="scott";
		String DataPasword="tiger";
		
		try {
			//1.����������
			Class.forName(driver);
			//2.��ȡ���ݿ����Ӷ��������ƶ������ݿ⣩
			conn=DriverManager.getConnection(url, DataUser, DataPasword);
			//3.��ȡsql�������
			stmt=conn.createStatement();
			//4.����sql���� ע�ⵥ���ź�˫���ŵİ�����ϵ
			String sql="insert into stu values(125,'����','Ů','MA','18','01-9��-2001')";
			//5.ָ��sql����
			int i= stmt.executeUpdate(sql);
			System.out.println("ִ�н��:"+i);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			//�ر���Դ
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


//jdbc �����ǳ���Աһ�ֳ��������ݲ�������������Ҫ���ܾ���ͨ��Java��Oracle���ݿ�������ݲ���
