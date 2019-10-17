package com.sofency.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sofency.entry.img;

public class getImg {
	
	public  static img getimgmsg(int imgid) {
		Connection connection =null;
		PreparedStatement pre =null;
		ResultSet rset =null;
		img  imgtest = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "sofency", "19980120");
			String  sql  = "select * from img where imgid =?";
			pre = connection.prepareStatement(sql);
			pre.setInt(1, imgid);//�����±��Ǵ�1��ʼ
			
			rset = pre.executeQuery();
			System.out.println("rset---");
			while(rset.next()) {
				int picid = rset.getInt("imgid");
				String imgurl = rset.getString("imgurl");//��ȡ���ݿ�洢��·��
				System.out.println(picid+"--"+imgurl);
				imgtest = new img(picid, imgurl);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rset!=null)rset.close();
				if(pre!=null) pre.close();
				if(connection!=null) connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("\n��ȡ��ͼƬ��--"+imgtest);
		return imgtest;
	} 
}
