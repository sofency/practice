--select *from table_one;
create table S (
SNO int primary key,
SNAME char(6),
STATUS int,
CITY char(6)
);
select *from S;
insert into S values(1,'alice',20,'���');
insert into S values(2,'ʢ��',20,'����');
insert into S values(3,'������',20,'�Ϻ�');
insert into S values(4,'Ϊ��',20,'�Ĵ�');
select *from S;
update  S set SNAME='����' where sno=1;
update S set STATUS=17 where sno=2;
select *from S;

create table P (
PNO int primary key,
PNAME char(6),
COLOR char(2),
WEIGHT int
);
insert into P values(1,'��ĸ','��',12);
insert into P values(2,'��˨','��',17);

insert into P values(3,'��˿��','��',14);
insert into P values(4,'��˿��','��',14);
insert into P values(5,'͹��','��',40);
insert into P values(6,'����','��',30);
select *from P;

