--Oracle�Դ��˻�
--- system �����˻�  19980120
---�ص㣺�߱��󲿷�Oracle�Ĳ���Ȩ�ޣ���Ҫ����������ͨ�˻���Oracle������
---ʹ���ˣ� Oracle ����ά��������Ա
create user alice identified by 1234;

grant connect to user;--���û������¼Ȩ��
grant resource to user;--�����û���Դ����Ȩ��
grant dba to user;--�����û�dbaȨ��
---role�ؼ��� һϵ��Ȩ�޵ļ���
create role c1;--����Ȩ�޾���
grant select,delete,update on ���� to c1;--����Щ���߸�����ɫc1
grant c1 to c2;--������c1��ֵ������c2
--����������Ȩ
select * from emp;

--�޸��ֶ���
--alter table ���� rename column �ֶ��� to �µ��ֶ���
--ɾ���ֶ���
--alter table student drop column �ֶ���

create table student(
   sid int primary key,--��������
   sname char(8)  not null,--�����������ʹ��constraints ck_����_�ֶ��� check(sname is ot null),
   sage int check(sage>=0 and sage<=100),--����Լ��
   ssex char(4) check(ssex in ('male','female')),
   ssal int
);
--alter table student  add constraint Լ���� Լ��  ����Լ��
alter table student modify ssex char(6) check(ssex in ('male','female'));--�޸�Լ��
alter table student add  sdpet char(4);--����һ��

insert into student values(1,'sofency',18,'male',15000);
--insert into student values(2,'sofency',18,'mle',15000); Υ���Ա�Լ��

insert into student values(2,'',18,'female',5000);--��ֵҲ��Ϊnull����ֵ����null����Υ��Լ������

insert into student values(3,'sofency',18,'male',15000);
update student set sdpet = 'CS' where sid=1;
update student set sdpet = 'MA' where sid =2;
select * from student;

create table Course(
  Cno int primary key,
  Cname char(10) not null,
  Ccredit int
);

insert into Course values(11,'���ݽṹ',4);
insert into Course values(12,'�㷨',5);

select * from Course;

create table grade(
  sid int,
  Cno int,
  score int,
  primary key(sid,Cno),--�����ֶι�ͬ����������
  foreign key(sid) references student(sid),--����sid������
  --������������þ��Ƿ���ͬʱ�޸�����
  foreign key(Cno) references Course(Cno)--����Cno������
);

insert into grade values(1,11,99);
insert into grade values(1,12,98);
insert into grade values(2,11,89);
insert into grade values(2,12,88);
--insert into grade values(3,11,99);Υ��Լ������ ��Ϊ�ڲ���student ��ʱ������sid=3


--Լ�������Ĺ���
 -- contraints pk_����_�ֶ��� primary key(�ֶ���)
 --alter table ���� drop constraints Լ����
select * from grade;
--Ҫ���ҳɼ�Ϊ99�ֵ�ѧ��������
select sname from student,grade where score=99 and student.sid=grade.sid;--��Ȼ����
select sname from student inner join grade on student.sid=grade.sid where score=99;--SQL 99��ʽ�Ĳ�ѯ
--Ҫ��ѯ�ɼ�Ϊ99�ֵĿ�Ŀ��ѧ������

select sname,Cname from student
  inner join grade on student.sid=grade.sid
  inner join Course on grade.Cno=Course.cno
  where grade.score=99;


