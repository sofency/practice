--子查询
--查询工资高于雇员为CLARK的员工工资和名字
select sal,ename from emp where sal>(select sal from emp where ename='CLARK');
--查询工资高于平均工资的员工的工资和姓名
select avg(sal) from emp;
select sal,ename from emp where sal>(select avg(sal) from emp);

--查询和scott属于同一部门且工资比他低的员工资料
select count(*) from emp where job='ANALYST';
select job  from emp where ename='SCOTT';
update emp set sal=4500 where empno=7902;--改下工资
select * from emp 
where deptno =
       (select deptno from emp where ename='SCOTT')
       and sal<(select sal from emp where ename='SCOTT');
--查询员工最高的员工资料
select * from emp where sal>=all(select sal from emp);
select * from emp where sal =(select max(sal) from emp);
--查询职务和Scott相同雇佣时间早的员工信息
select hiredate from emp where ename='SCOTT';
select job,ename,hiredate from emp where job='ANALYST';
select * from emp where job=(select job from emp where ename='SCOTT') and hiredate<(select hiredate from emp where ename='SCOTT');
--多行子查询
--查询工资高于任意一个CLERK的所有员工的信息
select sal from emp;
select * from emp where sal >any(select sal from emp);
--查询工资高于所有SALESMAN的员工信息
select * from emp where sal>all(select max(sal) from emp where job='SALESMAN');
--查询部门20中同部门10的员工工作一样的雇员信息
select * from emp where deptno=20;
select * from emp e1,emp e2 where (e1.deptno=20 and e2.deptno=10) and (e1.job=e2.job);

select * from emp where deptno=20 and job=any(select job from emp where deptno=10); --部门20中的员工的工作与部门10的任意一个工作一样就OK
select * from emp where deptno=20 and job in (select job from emp where deptno=10); 