--其他函数
--nvl()
--nvl2()
--decode()
---查询员工的工资信息
select ename,job,sal,comm from emp;
select ename,job,sal+comm from emp;--数据加null变为null
--查询薪水,sal+comm
select ename, job,sal+nvl(comm,0),sal+comm,sal,comm from emp;--nvl判断,如果comm为null 返回0(第二个参数),否则返回本身-单分支的if
select ename,job,sal,comm,nvl2(comm,sal+comm,sal) from emp;--如果comm为null的话执行,sal,不为null执行sal+comm
select ename ,job,decode(job,'MANAGER','经理','PRESIDENT','董事长','SALESMAN','销售员','普通员工') career from emp;
-------------------------条件, 条件1,  处理1,   条件2,      处理2,   条件3,   处理3     ,都不满足事件     