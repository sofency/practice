---数据的增删改&数据备份
----增加数据
  ---在部门新增一个新的部门信息，信息内容为 编号50  名称LOL学院   地址 北京
  --f9之后数据是存在内存中的，不是立马存在数据库中,如果发现数据错误,可以点击回滚，将数据从内存中清除
  insert into dept values(50,'LOL学院','北京');---全字段插入可以省略字段名
  insert into dept(deptno,dname) values(60,'上海');---加入部分数据
  select *from dept order by deptno;
  
  ---主键
    ---在一张表中，某个属性的值不能重复（非空唯一）
    ---唯一的标识数据，一个主键表示一条数据
    
    ---删除数据
      --- 删除表 delete from 表名
          ---truncate table 表名 删除表名
      --- 删除数据  delete from 表名 where 条件
    delete from dept where deptno=10;---违反完整性约束-因为在表emp中使用了deptno(是dept表的主码，deptno是emp表的外码)
    --select *from emp;
    
    ----更新数据
    --update 表名 set 字段名=新的值,字段名=新的值·····where 条件
    select *from dept;
    update dept set dname=null,loc='上海' where deptno=60;
    update dept set dname='JAVA学院' where deptno=50;
    
    
    ---数据备份
      ---表级别备份
        --全部备份： create table 新的表名 as select *from 备份表名
        --部分备份： create table 新的表名 as select 字段名1,字段名2·····from 表名
        create table deptBak as select *from dept;---全部备份
        select *from deptBak;
        insert into deptBak values(50,'11','11');--不会将主键备份，不会存在完整性约束问题。
        --多行插入
        insert into deptBak select *from dept;---多行插入
