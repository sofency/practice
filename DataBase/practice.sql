---选择部门30中的所有员工
select *from emp where deptno=30;
---列出所有办事员的姓名，编号和部门编号
select ename,empno,deptno from emp where job='CLERK';
---找出佣金高于薪金的员工
select *from emp where comm>sal;
---找出佣金高于薪金60%的员工
select * from emp where comm>sal*0.4;
---找出部门10中所有经理(MANAGER)和部门20中所有办事员(CLERK)的详细资料
select *from emp where (deptno=10 and job='MANAGER') or (deptno=20 and job='CLERK');--不用阔括号也行and的级别高于or
---找出部门10中所有经理(MANAGER)和部门20中所有办事员(CLERK),既不是经理又不是办事员但其薪金大于等于2000的所有员工的详细资料
select *from emp where (job='MANAGER' and deptno=10) or (deptno=20 and job='CLERK') or (job <>'MANAGER' and job<>'CLERK' and sal>4000);
---找出收取佣金的员工的不同工作
select distinct job from emp where comm is not null and comm<>0;--当遇到null时不能用comm<>null 只能用comm is not null
select *from emp;
---找出不收佣金或者佣金低于100的员工的不同工作
select distinct job from emp where comm is null or comm<100;
---找出各月倒数第三天受雇的员工
select * from emp where hiredate=last_day(hiredate)-2;--hiredate查询受雇的月份中满足hiredate =last_day(hiredate)-2的雇佣时间关系
---找出早于38年前受雇的员工
select * from emp where months_between('20-4月-2019',hiredate)>12*38;
---以首字母大写的方式显示所有员工的姓名
select INITCAP(ename) from emp;
---显示正好为5个字符的员工姓名
select ename from emp where length(ename)=5;
---显示不带S或s的员工的姓名
select ename from emp where ename not like '%S%' and ename not like '%s%';
---显示所有员工姓名的前三个字符
--取子字符串substr(字符串,起始位置，终止位置) 注意位置是从1开始算的
select substr(ename,1,3)  from emp ;
--显示所有员工的姓名，用a代替所有A
select replace(ename,'A','a') from emp;
---显示满35年服务年限的员工的姓名和受雇日期
select sysdate from dual;--显示当前日期
--使用months_between
select ename,hiredate from emp where months_between(sysdate, hiredate)>12*35;
---使用天数
select ename,hiredate from emp where (sysdate-hiredate)/365>35;
---显示员工的详细资料，按姓名排序
select *from emp order by ename;
---显示员工的姓名和受雇日期，根据服务年限将最老的员工排在最前面
select ename,hiredate from emp order by (sysdate-hiredate) desc;--desc降序
---显示所有员工的姓名、工作和薪金，按工作的降序排列，若工作相同按薪金排序
select ename,job,sal from emp order by job,sal desc;
--- 显示所有员工的姓名，加入公司的年份和月份，按受雇日期所在月排序，若月份相同将最早年份的员工排在前面
select ename,substr(to_char(hiredate,'yyyy-mm-dd'),1,4) 年份,substr(to_char(hiredate,'yyyy-mm-dd'),6,7) 月份  from emp order by substr(to_char(hiredate,'yyyy-mm-dd'),6,7),substr(to_char(hiredate,'yyyy-mm-dd'),1,4);
--update emp set hiredate=to_char(hiredate,'yyyy-mm-dd');--无法更新因为原来修饰的是string类型的
select ename,to_char(hiredate,'yyyy') 年份,to_char(hiredate,'mm') 月份 from emp order by to_char(hiredate,'mm');
--- 显示一个月为30天的情况所有员工的日薪金
select floor((sal+nvl(comm,0))/30) avgerage from emp;
--- 找出在（任意年份）2月受聘的所有员工
select * from emp where to_char(hiredate,'mm')=2;
---查询所有员工假如公司的天数
select ename,hiredate,floor(sysdate- hiredate) days from emp;
---以年月日显示所有员工服务的年限
select ename,floor(floor(months_between(sysdate,hiredate))/12) 年份,mod(floor(months_between(sysdate,hiredate)),12) 月份 ,floor(mod(sysdate-hiredate,30)) 日 from emp;


