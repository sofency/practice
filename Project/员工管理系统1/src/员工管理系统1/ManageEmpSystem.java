package 员工管理系统1;

import java.sql.Date;
import java.util.ArrayList;

public interface ManageEmpSystem {
//查询所有员工信息
	public ArrayList<Emp> getAllEmpInfo();
//根据编号查询员工信息
	public Emp getEmpInfo(int empno);
//向数据库插入数据
	public int insertEmpInfo(int empno,String ename,String job,int mgr,Date hireDate,double sal,double comm,int deptno );

}
