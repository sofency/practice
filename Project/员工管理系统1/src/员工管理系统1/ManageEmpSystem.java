package Ա������ϵͳ1;

import java.sql.Date;
import java.util.ArrayList;

public interface ManageEmpSystem {
//��ѯ����Ա����Ϣ
	public ArrayList<Emp> getAllEmpInfo();
//���ݱ�Ų�ѯԱ����Ϣ
	public Emp getEmpInfo(int empno);
//�����ݿ��������
	public int insertEmpInfo(int empno,String ename,String job,int mgr,Date hireDate,double sal,double comm,int deptno );

}
