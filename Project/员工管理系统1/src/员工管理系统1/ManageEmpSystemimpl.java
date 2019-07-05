package Ա������ϵͳ1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import test1.jdbcUtil;

public class ManageEmpSystemimpl implements ManageEmpSystem{
	
	//��ѯ����Ա����Ϣ
	public ArrayList<Emp> getAllEmpInfo(){
		
		ArrayList<Emp> list=new ArrayList<>();
		//����jdbcUtil����
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			//��������
			conn=jdbcUtil.getConnection();
			//дSQL���
			String sql="select * from emp";
			//����ִ��sql���
			ps=jdbcUtil.getPreparedStatement(conn, sql);
			
			
			rs=ps.executeQuery();//ִ�в�ѯ
			
			while(rs.next()) {
				Emp e=new Emp();
				e.setEmpno(rs.getInt(1));
				e.setEname(rs.getString(2));
				e.setJob(rs.getString(3));
				e.setMgr(rs.getInt(4));
				e.setDate(rs.getDate(5));
				e.setSal(rs.getDouble(6));
				e.setComm(rs.getDouble(7));
				e.setDeptno(rs.getInt(8));
				
				list.add(e);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			jdbcUtil.closeall(ps, conn);
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	//���ݱ�Ų�ѯԱ����Ϣ
	public Emp getEmpInfo(int empno) {
		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Emp e=null;
		try {
			
			conn=jdbcUtil.getConnection();//�������Ӷ���
			String sql="select * from emp where empno = ?";
			ps=jdbcUtil.getPreparedStatement(conn, sql);
			ps.setInt(1, empno);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				e=new Emp();
				
				e.setEmpno(rs.getInt(1));
				e.setEname(rs.getString(2));
				e.setJob(rs.getString(3));
				e.setMgr(rs.getInt(4));
				e.setDate(rs.getDate(5));
				e.setSal(rs.getDouble(6));
				e.setComm(rs.getDouble(7));
				e.setDeptno(rs.getInt(8));
			}
		}catch (Exception e1) {
			// TODO: handle exception
		}finally {
			jdbcUtil.closeall(ps, conn);
			try {
				rs.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return e;
	}
	
	//�����ݿ��������
	public int insertEmpInfo(int empno,String ename,String job,int mgr,Date hireDate,double sal,double comm,int deptno ) {
		
		Connection conn=null;
		PreparedStatement ps=null;
		
		int rs=0;
		try {
			conn=jdbcUtil.getConnection();
			String sql="insert into emp values(?,?,?,?,?,?,?,?)";
			ps=jdbcUtil.getPreparedStatement(conn, sql);
			ps.setInt(1, empno);
			ps.setString(2, ename);
			ps.setString(3, job);
			ps.setInt(4, mgr);
			ps.setDate(5, hireDate);
			ps.setDouble(6, sal);
			ps.setDouble(7, comm);
			ps.setInt(8, deptno);
			
		    rs=ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			jdbcUtil.closeall(ps, conn);
		}
	
		return rs;
	}
}
