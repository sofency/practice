package com.sofency.stuDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sofency.DBUtil.DBUtil;
import com.sofency.entries.student;

//数据访问层 增删改查
public class studentDaoImpl implements studentDao{

	//判断是否存在该学生
	public int isExit(String sno) {
		student stu = checkStudent(sno);
		return stu == null?1:0;
	}
	
	//根据学号查找信息
	public student checkStudent(String sno) {
		student  stu=null;
		ResultSet rSet =null;
		try {
			String  sql ="select * from student where sno=?";
			Object[] obj= {sno};
			rSet = DBUtil.executeQuery(sql, obj);//执行查询
			if(rSet!=null) {
				while(rSet.next()) {
					String snameString = rSet.getString("sname");
					String snoString = rSet.getString("sno");
					int age =rSet.getInt("sage");
					stu = new student(snameString, snoString, age);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.Close(rSet, DBUtil.pre, DBUtil.connection);
	    }
 	   return stu;
    }
	
	//添加学生信息
	public int  addstu(student stu) {
		
		String  sql ="insert into student values(?,?,?)";
		Object[] obj= {stu.getNameString(),stu.getSnoString(),stu.getAge()};
		int count =DBUtil.executeUpdate(sql, obj);
		return count;//返回1添加成功  返回0添加失败
	    
	}

	//根据删除学生信息
	public int deleteStu(String sno) {
		String  sql ="delete student where sno = ?";
		Object[] obj= {sno};
		return  DBUtil.executeUpdate(sql, obj);
	}
	//查询所有学生的信息
	public ArrayList<student> queryAllStudents(){
		ArrayList<student> list = new ArrayList<student>();
		ResultSet rSet =null;
		try {
			String  sql ="select * from student";
			rSet = DBUtil.executeQuery(sql, null);//执行查询
			if(rSet!=null) {
				while(rSet.next()) {
					String snameString = rSet.getString("sname");
					String snoString = rSet.getString("sno");
					int age =rSet.getInt("sage");
					student stu = new student(snameString, snoString, age);
					list.add(stu);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.Close(rSet, null, null);
	    }
		return list;
	}

	@Override
	//根据页数显示学生
	public ArrayList<student> quaryStudentsByPage(int currentPage, int pageSize) {
		ArrayList<student> list =new ArrayList<student>();
		String sql= "select * from "
				+"("
				+"select rownum r,t.* from"
				+"(select s.* from student s order by sno asc) t "
				+" where "
				+" rownum<=? "
				+" )"
				+" where r>=?";
		Object[] obj = {currentPage*pageSize,(currentPage-1)*pageSize+1};
		try {
			ResultSet rSet = DBUtil.executeQuery(sql, obj);
			while(rSet.next()) {
				String snameString = rSet.getString("sname");
				String snoString = rSet.getString("sno");
				int age =rSet.getInt("sage");
				student stu=new student(snameString, snoString, age);
				list.add(stu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(list+"sofnecy");
		return list;
	}

	@Override
	public int countStu() {
		String  sql= "select count(*) from student";
		
		int count=-1;
		try {
			ResultSet resultSet = DBUtil.executeQuery(sql, null);
			while(resultSet.next()) {
				count = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(count);
		return count;
	}

	
	//更改学生信息
	public int changeStudentInfo(student stu) {
		//更新的sql语句
		String sql="update student set sname="
					+"?"+","
					+"sage="
					+"?"
					+" where sno="
					+"?";
		//对象数组
		System.out.println(sql);
		Object[] obj= {stu.getNameString(),stu.getAge(),stu.getSnoString()};
		return DBUtil.executeUpdate(sql, obj);
	}
	
}
