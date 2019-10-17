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
			pre.setInt(1, imgid);//参数下标是从1开始
			
			rset = pre.executeQuery();
			System.out.println("rset---");
			while(rset.next()) {
				int picid = rset.getInt("imgid");
				String imgurl = rset.getString("imgurl");//获取数据库存储的路径
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
		System.out.println("\n获取的图片是--"+imgtest);
		return imgtest;
	} 
}
