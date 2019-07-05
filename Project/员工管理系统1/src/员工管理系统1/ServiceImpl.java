package 员工管理系统1;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class ServiceImpl implements Service{
	
	ManageEmpSystemimpl ma=new ManageEmpSystemimpl();
	Scanner input=new Scanner(System.in);
	int choice=input.nextInt();
	
	//显示功能选择
	public void showChoice() {
		System.out.println("***************************************");
		System.out.println("*功能如下                             *");
		System.out.println("*1.查询表中所有信息                   *");
		System.out.println("*2.根据员工编号查询信息               *");
		System.out.println("*3.向表中插入信息                     *");
		System.out.println("***************************************");
	}
	public int ChooseChoice() {
		Scanner input=new Scanner(System.in);
		int choice=input.nextInt();
		return choice;
	}
	
	
	//业务层处理相应的业务
	public void resultAllSearch() {
		
		ArrayList<Emp> list=new ArrayList<>();
		list=ma.getAllEmpInfo();
		
		//查询的结果如下
		System.out.println("emp 表中的信息是");
		for (Emp em : list) {
			System.out.println(em);
		}
	}
	//根据员工编号查询结果
	public void ResultSearch() {
		System.out.println("请输入查询员工的编号");
		int number=input.nextInt();
		Emp e=new Emp();
		e=ma.getEmpInfo(number);
		System.out.println("员工编号\t\t员工姓名\t\t员工工作\t\t领导编号\t\t入职日期\t\t工资\t\t奖金\t\t部门编号");
		System.out.println(e.getEmpno()+"\t\t"+e.getEname()+"\t\t"+e.getJob()+"\t\t"+e.getMgr()+"\t\t"+e.getDate()+"\t\t"+e.getSal()+"\t\t"+e.getComm()+"\t\t"+e.getDeptno());

	}
	
	//向表中插入数据
	public void ResultInsert() {
		System.out.println("请输入员工编号");
		int empno=input.nextInt();
		System.out.println("请输入员工姓名");
		String ename=input.next();
		System.out.println("请输入员工工作");
		String job=input.next();
		System.out.println("请输入领导编号");
		int mgr=input.nextInt();
		System.out.println("请输入入职日期");
		String date=input.next();
		Date hireDate=Date.valueOf(date);//将字符串类型的时期转化为java.sql类型中
		
		System.out.println("请输入员工工资");
		double sal=input.nextDouble();
		System.out.println("请输入员工奖金");
		double comm=input.nextDouble();
		System.out.println("请输入部门编号");
		int deptno=input.nextInt();
		
		int i=ma.insertEmpInfo(empno, ename, job, mgr, hireDate, sal, comm, deptno);
		if(i!=0) {
			System.out.println("插入成功");
		}else {
			System.out.println("插入失败");
		}
	}
}
