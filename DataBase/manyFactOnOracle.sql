---多行函数的处理
--聚集函数
select sal from emp;
select max(sal),min(sal) from emp;--多行函数不能和字段直接混用，除非分组

select ename,sal from emp where sal=(select max(sal) from emp);--查询最高薪水的姓名和薪水

select avg(sal) from emp;---查询平均数
select count(*) from emp;--查询元组个数
select distinct job from emp;--查询工作的种类并显示
select count(distinct job) from emp;--查询员工的种类
--多行函数可以混用，显示在一行
select count(*),max(sal),min(sal),avg(sal),sum(sal) from emp;
------------------------------------------------------------------------







