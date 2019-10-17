package com.sofency.stuDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sofency.DBUtil.DBUtil;
import com.sofency.entries.student;

//���ݷ��ʲ� ��ɾ�Ĳ�
public class studentDaoImpl implements studentDao{

	//�ж��Ƿ���ڸ�ѧ��
	public int isExit(String sno) {
		student stu = checkStudent(sno);
		return stu == null?1:0;
	}
	
	//����ѧ�Ų�����Ϣ
	public student checkStudent(String sno) {
		student  stu=null;
		ResultSet rSet =null;
		try {
			String  sql ="select * from student where sno=?";
			Object[] obj= {sno};
			rSet = DBUtil.executeQuery(sql, obj);//ִ�в�ѯ
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
	
	//���ѧ����Ϣ
	public int  addstu(student stu) {
		
		String  sql ="insert into student values(?,?,?)";
		Object[] obj= {stu.getNameString(),stu.getSnoString(),stu.getAge()};
		int count =DBUtil.executeUpdate(sql, obj);
		return count;//����1��ӳɹ�  ����0���ʧ��
	    
	}

	//����ɾ��ѧ����Ϣ
	public int deleteStu(String sno) {
		String  sql ="delete student where sno = ?";
		Object[] obj= {sno};
		return  DBUtil.executeUpdate(sql, obj);
	}
	//��ѯ����ѧ������Ϣ
	public ArrayList<student> queryAllStudents(){
		ArrayList<student> list = new ArrayList<student>();
		ResultSet rSet =null;
		try {
			String  sql ="select * from student";
			rSet = DBUtil.executeQuery(sql, null);//ִ�в�ѯ
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
	//����ҳ����ʾѧ��
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

	
	//����ѧ����Ϣ
	public int changeStudentInfo(student stu) {
		//���µ�sql���
		String sql="update student set sname="
					+"?"+","
					+"sage="
					+"?"
					+" where sno="
					+"?";
		//��������
		System.out.println(sql);
		Object[] obj= {stu.getNameString(),stu.getAge(),stu.getSnoString()};
		return DBUtil.executeUpdate(sql, obj);
	}
	
}
