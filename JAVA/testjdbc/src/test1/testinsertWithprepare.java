package test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;//���з��ض�����ʹ�øð�
import java.sql.SQLException;

public class testinsertWithprepare {
	
	public static void deleteUserInfo(int ud) throws ClassNotFoundException, SQLException {
		
		//��������
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//�������Ӷ���
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
		
		//����sqlָ��
		String sql="delete Us where ud=?";
		//����ִ��sql���
		PreparedStatement ps=conn.prepareStatement(sql);
		//��ռλ����ֵ
		ps.setInt(1, 125);
		
		//ִ�в���
		
		int i=ps.executeUpdate();
		if(i!=0) {
			System.out.println("ɾ���ɹ�");
		}else {
			System.out.println("ɾ��ʧ��");
		}
		ps.close();
		conn.close();
		
	}
	
	public  static void insertUserInfo(int ud,String uname) throws ClassNotFoundException, SQLException {
		
		//��������
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//�������Ӷ���
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
		//��дSQL���
		String sql="insert into Us values(?,?)"; //�ã�����ռλ
		PreparedStatement ps=conn.prepareStatement(sql);
		//Ȼ���ռλ����ֵ
		ps.setInt(1, ud);
		ps.setString(2, uname);
		
		//ִ��sql���
		int i=ps.executeUpdate();//ִ����֮���Զ��ύ����
		if(i!=0) {
			System.out.println("����ɹ�");
		}else {
			System.out.println("����ʧ��");
		}
		//�ر���Դ
		ps.close();
		conn.close();
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//insertUserInfo(126, "hello");
		deleteUserInfo(126);
	}

}
