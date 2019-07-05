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
 *  ���⣺ ʹ��resultSetʱ����������ݽ�������Բ���
 *  ����� ������ת����ArrayList�н��д洢
 *  
 */

public class testSelect {
	
	
	public ArrayList<stu> getStudentInfo() {
		
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String user="scott";
		String password="tiger";
		Connection conn=null;
		Statement stmt=null;
		
		//���������б�
		ArrayList<stu> list=new ArrayList<stu>();
		
		//����������
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//�������Ӷ���
			conn=DriverManager.getConnection(url, user, password);
			
			//��ȡ���ݿ�����
			stmt=conn.createStatement();
			
			//дsql����
			String sql="select * from stu";
			
			//ִ��sql����   alt+shift+L��ݼ�
			ResultSet rSet=stmt.executeQuery(sql);
			
			
			System.out.println("ѧ��"+"\t"+"����"+"\t"+"�Ա�"+"\t"+"ϵ��"+"\t"+"����"+"\t"+"��������");
			
			while(rSet.next()) {
				//��ȡȫ������
				//System.out.print(rSet.getInt("sno")+"\t"+rSet.getString("sname")+"\t"+rSet.getString("ssex")+"\t"+rSet.getString("sdept")+"\t"+rSet.getInt("sage")+"\t"+rSet.getDate("sdate"));
				//System.out.println();
				
				//��ȡָ������
				 stu Stu=new stu();
				 
				 Stu.setSno(rSet.getInt("sno"));
				 Stu.setSname(rSet.getString("sname"));
				 Stu.setSsex(rSet.getString("ssex"));
				 Stu.setSdept(rSet.getString("sdept"));
				 Stu.setSage(rSet.getInt("sage"));
				 Stu.setDate(rSet.getDate("sdate"));
				 
				 list.add(Stu);//���������б�
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
