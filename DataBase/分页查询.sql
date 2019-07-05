---对于视图的增删改动作会被更新到新表中

--可以开启只对表的读模式  使用关键字with read
create view emp1 as select empno,ename,job from emp where sal<5000 with read only;
select * from emp1;
update emp1 set ename='alice' where empno=7499;--无法修改

--分页查询
  --问题： 当一个表中的数据量特别大时，如果一次性全部显示给哟用户，则造成页面过于庞大，体验极差
  ---解决；分页查询
  --使用rownum关键字：oracle对外界提供的自动给查询结果编号的关键字，与每行数据没有关系
  --rownum只能用< 或<=来查询
  select rownum,e.* from emp e;--需要重新命名emp e
  --查询第二页数据
  select rownum,e.* from emp e where rownum<=5;
  select * from (select rownum r,e.* from emp e where rownum<=10) t where r>5;
  --查询第三页数据
  select * from (select rownum r,e.* from emp e where rownum<=15) s where r>10;
  --分页查询员工信息按照工资排序
 select * from(select rownum r,e.* from (select * from emp order by sal) e where rownum<=10) where r>5;