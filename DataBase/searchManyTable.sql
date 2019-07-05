--多表查询

--查询员工姓名，工作，薪资，部门名称
--笛卡尔积 
select * from emp,dept; --emp表和dept表全排列
--等值连接
---先做表的笛卡尔积，然后筛选，筛选条件为等值筛选
---如果是两表的公共字段，需要声明表名 比如下面的筛选 deptno要声明是emp.deptno
select ename,job,sal ,dname from emp,dept where emp.deptno=dept.deptno; 
select e.ename,e.empno,e.sal from emp e;--给表使用别名

--不等值连接
select * from emp;
select * from emp e,salgrade s where e.sal>s.losal and e.sal<s.hisal;
select * from salgrade;
--自身连接
--查询员工姓名，工作，薪资，及上级领导姓名
select e1.*,e2.ename from emp e1,emp e2 where e1.mgr=e2.empno;--自身连接
select e1.empno,e1.ename,e1.job,e1.sal,e2.ename from emp e1,emp e2 where e1.mgr=e2.empno;

---外连接
    --左外连接
       --查询员工姓名，工作，薪资，部门名称及没有员工的部门信息
       select * from emp e,dept d where e.deptno(+)=d.deptno;--表示左边的数据可能不完整，(+)加到右边表示右边的数据可能不完整
       
    --右外连接
    --查询员工姓名，工作，薪资，部门名称及没有部门的员工信息
     select * from emp e,dept d where e.deptno=d.deptno(+);
     
---SQL99多表查询
      ---自然连接
        ---特点1：底层先笛卡尔积，然后按照所有的同名同值字段自动进行等值筛选
        ---缺点1：如果想按照字段名不同，但是值相同进行等值筛选怎么办？就比如上面SQL的查询上级老板的姓名
        ---缺点2：如果指向按照部分字段进行筛选怎么办？
        select * from emp cross join dept;
        select * from emp natural join dept;
      ---缺点解决方案
        ---解决1：使用using关键字
            --作用1：指明使用指定的字段对联合查询的结果进行等值查询 注意：指明的字段必须是两表共有的同名同值字段
            select * from emp inner join dept using(deptno)--指明的字段写在前面
            --作用2：使用on关键字进行自定义连接条件筛选(等值筛选，不等值筛选)
            ---注意：普通筛选条件使用where进行筛选，不要使用on关键字 好处：SQL语句的阅读性变强
            --select 内容 from 表名 inner join 表名 on 连接条件 where 普通筛选条件
            select * from emp inner join dept on emp.deptno=dept.deptno where sal>2000;
            
        --外连接
          ---左外链接 left join
          select * from emp e left join dept d on d.deptno=e.deptno order by e.empno;
          ---右外连接 right join
           select * from emp e right join dept d on d.deptno=e.deptno order by e.empno;
          ---全外连接 full outer join
           select * from emp e  full outer join dept d on d.deptno=e.deptno;
           --select * from emp;
          --update emp set deptno=null where empno=7369;
          
          --自连接
          select e1.*,e2.ename from emp e1 inner join emp e2 on e1.mgr=e2.empno;
          
          ---用法总结
               ---select 内容 (别名，连接符，去重，oracle函数，逻辑运算)
               ---from 表名1，表名2，表名3······
               --where 条件(连接,连接条件，普通筛选条件，)
               ---group by 分组 字段
               ---having 多行函数筛选
               ---order  by 排序字段
               
        ---SQL99总结
        --筛选条件
        select * from emp 
        inner join dept 
        on emp.deptno=dept.deptno 
        inner join city 
        on dept.loc=city.cid;--city未创建  查询效率高，而且结构清晰
        where emp.sal>2000 or e.comm is not null;
     
     