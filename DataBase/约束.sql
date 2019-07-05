--序列的学习
create sequence cc;--设置序列名字
select cc.currval from dual;---查询当前序列
select cc.nextval from dual;--动态值向下递增9

--创建自定义序列
create sequence aa start with 5 --以5开始
increment by 2--设置步长

--创建测试表
create table teacher(
   tid number(10) primary key,
   tname varchar(100) not null
);
insert into teacher values(cc.nextval,'张三');
select * from teacher order by tid;

--创建索引  
--只需要使用以下命令进行设置 oracle在底层已经创建索引了
--oracle 自动为主键创建索引
 create index 索引名 on 表名(字段名)
 
 create index index_teacher_tname on teacher(tname);--给name创建索引
 --不需要知道如何创建的索引 直接用该语句创建即可
 drop index index_teacher_tname;--删除索引
 
 
 