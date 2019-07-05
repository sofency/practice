--Oracle自带账户
--- system 管理账户  19980120
---特点：具备大部分Oracle的操作权限，主要用来管理普通账户及Oracle的数据
---使用人： Oracle 数据维护工作人员
create user alice identified by 1234;

grant connect to user;--给用户赋予登录权限
grant resource to user;--授予用户资源操作权限
grant dba to user;--授予用户dba权限
---role关键字 一系列权限的集合
create role c1;--创建权限决策
grant select,delete,update on 表名 to c1;--将这些决策赋给角色c1
grant c1 to c2;--将决策c1赋值给决策c2
--自主进行授权
select * from emp;

--修改字段名
--alter table 表名 rename column 字段名 to 新的字段名
--删除字段名
--alter table student drop column 字段名

create table student(
   sid int primary key,--设置主码
   sname char(8)  not null,--在语句的最后面使用constraints ck_表名_字段名 check(sname is ot null),
   sage int check(sage>=0 and sage<=100),--定义约束
   ssex char(4) check(ssex in ('male','female')),
   ssal int
);
--alter table student  add constraint 约束名 约束  增加约束
alter table student modify ssex char(6) check(ssex in ('male','female'));--修改约束
alter table student add  sdpet char(4);--增加一列

insert into student values(1,'sofency',18,'male',15000);
--insert into student values(2,'sofency',18,'mle',15000); 违反性别约束

insert into student values(2,'',18,'female',5000);--无值也是为null，无值当做null处理，违反约束条件

insert into student values(3,'sofency',18,'male',15000);
update student set sdpet = 'CS' where sid=1;
update student set sdpet = 'MA' where sid =2;
select * from student;

create table Course(
  Cno int primary key,
  Cname char(10) not null,
  Ccredit int
);

insert into Course values(11,'数据结构',4);
insert into Course values(12,'算法',5);

select * from Course;

create table grade(
  sid int,
  Cno int,
  score int,
  primary key(sid,Cno),--两个字段共同决定了主码
  foreign key(sid) references student(sid),--设置sid的外码
  --设置外码的作用就是方便同时修改数据
  foreign key(Cno) references Course(Cno)--设置Cno的外码
);

insert into grade values(1,11,99);
insert into grade values(1,12,98);
insert into grade values(2,11,89);
insert into grade values(2,12,88);
--insert into grade values(3,11,99);违反约束条件 因为在参照student 表时发现无sid=3


--约束创建的规则
 -- contraints pk_表名_字段名 primary key(字段名)
 --alter table 表名 drop constraints 约束名
select * from grade;
--要查找成绩为99分的学生的姓名
select sname from student,grade where score=99 and student.sid=grade.sid;--自然连接
select sname from student inner join grade on student.sid=grade.sid where score=99;--SQL 99格式的查询
--要查询成绩为99分的科目和学生姓名

select sname,Cname from student
  inner join grade on student.sid=grade.sid
  inner join Course on grade.Cno=Course.cno
  where grade.score=99;


