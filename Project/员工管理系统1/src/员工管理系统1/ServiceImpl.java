package Ա������ϵͳ1;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class ServiceImpl implements Service{
	
	ManageEmpSystemimpl ma=new ManageEmpSystemimpl();
	Scanner input=new Scanner(System.in);
	int choice=input.nextInt();
	
	//��ʾ����ѡ��
	public void showChoice() {
		System.out.println("***************************************");
		System.out.println("*��������                             *");
		System.out.println("*1.��ѯ����������Ϣ                   *");
		System.out.println("*2.����Ա����Ų�ѯ��Ϣ               *");
		System.out.println("*3.����в�����Ϣ                     *");
		System.out.println("***************************************");
	}
	public int ChooseChoice() {
		Scanner input=new Scanner(System.in);
		int choice=input.nextInt();
		return choice;
	}
	
	
	//ҵ��㴦����Ӧ��ҵ��
	public void resultAllSearch() {
		
		ArrayList<Emp> list=new ArrayList<>();
		list=ma.getAllEmpInfo();
		
		//��ѯ�Ľ������
		System.out.println("emp ���е���Ϣ��");
		for (Emp em : list) {
			System.out.println(em);
		}
	}
	//����Ա����Ų�ѯ���
	public void ResultSearch() {
		System.out.println("�������ѯԱ���ı��");
		int number=input.nextInt();
		Emp e=new Emp();
		e=ma.getEmpInfo(number);
		System.out.println("Ա�����\t\tԱ������\t\tԱ������\t\t�쵼���\t\t��ְ����\t\t����\t\t����\t\t���ű��");
		System.out.println(e.getEmpno()+"\t\t"+e.getEname()+"\t\t"+e.getJob()+"\t\t"+e.getMgr()+"\t\t"+e.getDate()+"\t\t"+e.getSal()+"\t\t"+e.getComm()+"\t\t"+e.getDeptno());

	}
	
	//����в�������
	public void ResultInsert() {
		System.out.println("������Ա�����");
		int empno=input.nextInt();
		System.out.println("������Ա������");
		String ename=input.next();
		System.out.println("������Ա������");
		String job=input.next();
		System.out.println("�������쵼���");
		int mgr=input.nextInt();
		System.out.println("��������ְ����");
		String date=input.next();
		Date hireDate=Date.valueOf(date);//���ַ������͵�ʱ��ת��Ϊjava.sql������
		
		System.out.println("������Ա������");
		double sal=input.nextDouble();
		System.out.println("������Ա������");
		double comm=input.nextDouble();
		System.out.println("�����벿�ű��");
		int deptno=input.nextInt();
		
		int i=ma.insertEmpInfo(empno, ename, job, mgr, hireDate, sal, comm, deptno);
		if(i!=0) {
			System.out.println("����ɹ�");
		}else {
			System.out.println("����ʧ��");
		}
	}
}
