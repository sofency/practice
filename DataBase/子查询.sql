--�Ӳ�ѯ
--��ѯ���ʸ��ڹ�ԱΪCLARK��Ա�����ʺ�����
select sal,ename from emp where sal>(select sal from emp where ename='CLARK');
--��ѯ���ʸ���ƽ�����ʵ�Ա���Ĺ��ʺ�����
select avg(sal) from emp;
select sal,ename from emp where sal>(select avg(sal) from emp);

--��ѯ��scott����ͬһ�����ҹ��ʱ����͵�Ա������
select count(*) from emp where job='ANALYST';
select job  from emp where ename='SCOTT';
update emp set sal=4500 where empno=7902;--���¹���
select * from emp 
where deptno =
       (select deptno from emp where ename='SCOTT')
       and sal<(select sal from emp where ename='SCOTT');
--��ѯԱ����ߵ�Ա������
select * from emp where sal>=all(select sal from emp);
select * from emp where sal =(select max(sal) from emp);
--��ѯְ���Scott��ͬ��Ӷʱ�����Ա����Ϣ
select hiredate from emp where ename='SCOTT';
select job,ename,hiredate from emp where job='ANALYST';
select * from emp where job=(select job from emp where ename='SCOTT') and hiredate<(select hiredate from emp where ename='SCOTT');
--�����Ӳ�ѯ
--��ѯ���ʸ�������һ��CLERK������Ա������Ϣ
select sal from emp;
select * from emp where sal >any(select sal from emp);
--��ѯ���ʸ�������SALESMAN��Ա����Ϣ
select * from emp where sal>all(select max(sal) from emp where job='SALESMAN');
--��ѯ����20��ͬ����10��Ա������һ���Ĺ�Ա��Ϣ
select * from emp where deptno=20;
select * from emp e1,emp e2 where (e1.deptno=20 and e2.deptno=10) and (e1.job=e2.job);

select * from emp where deptno=20 and job=any(select job from emp where deptno=10); --����20�е�Ա���Ĺ����벿��10������һ������һ����OK
select * from emp where deptno=20 and job in (select job from emp where deptno=10); 