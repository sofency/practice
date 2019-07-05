--查询不同部门的最高工资
--使用group by 分组
---使用分组后,在select语句中只允许出现分组字段和多行函数
select deptno,max(sal)
-------分组字段,多行函数
from emp 
group by deptno
order by deptno;--按部门号查询
--按部门分成三组，求出每组的最高工资
select *from emp;
select job, max(sal),count(*) from emp group by job; --count(*)表示该工作的人数

--根据多个条件进行分组
--查询不同部门的不同工作岗位的人数
--多字段进行分组,西安按照第一字段分组,然后每个小组继续按照第二个字段继续分组，一次类推
select deptno,job,count(*) from emp group by deptno,job order by deptno;---先按照deptno进行分组,在按照job进行分组


---分组筛选查询关键字HAVING having 
--查询不同部门的不同工作岗位人数大于1的信息

select deptno,lower(job),count(*) from emp group by deptno,job having count(*)>1 order by deptno;---关键字优先原则
--针对分组后的数据筛选，允许使用多行函数
---having 必须和分组结合使用不允许单独使用

---查询部门号大于10的不同部门的不同工作岗位的人数
select deptno,lower(job),count(*),max(sal) from emp group by deptno,job having deptno>10;--最大薪水是在每一行的分组的基础上面的
select deptno,lower(job),count(*),max(sal)from emp where deptno>10 group by deptno,job;--查询效率高
--执行的顺序  
--from emp                                    2.--from emp
--group by deptno,job                           --where deptno>10 ---缩小了范围
--select deptno,job,count(*),max(sal)           --group by deptno,job
--having count(*)>1                             --select deptno,lower(job)
                                                --having count(*)>1
--先在emp中按照deptno分组,再按照job在deptno分组的基础上进行分组建虚表，然后查询deptno大于10的信息


