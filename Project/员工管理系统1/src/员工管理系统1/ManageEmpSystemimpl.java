package 员工管理系统1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import test1.jdbcUtil;

public class ManageEmpSystemimpl implements ManageEmpSystem{
	
	//查询所有员工信息
	public ArrayList<Emp> getAllEmpInfo(){
		
		ArrayList<Emp> list=new ArrayList<>();
		//声明jdbcUtil变量
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			//创建连接
			conn=jdbcUtil.getConnection();
			//写SQL语句
			String sql="select * from emp";
			//虚拟执行sql语句
			ps=jdbcUtil.getPreparedStatement(conn, sql);
			
			
			rs=ps.executeQuery();//执行查询
			
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
	
	//根据编号查询员工信息
	public Emp getEmpInfo(int empno) {
		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Emp e=null;
		try {
			
			conn=jdbcUtil.getConnection();//创建连接对象
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
	
	//向数据库插入数据
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
