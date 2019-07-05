select * from p;
select * from s order by sno;--按sno升序排列
create table J(
JNO int primary key,
JANME char(8),
CITY char(4)
);
insert into J values(1,'三建','北京');
insert into J values(2,'一汽','长春');
insert into J values(3,'弹簧厂','天津');
insert into J values(4,'造船厂','天津');
insert into J values(5,'机车厂','唐山');
insert into J values(6,'无线电厂','常州');
insert into J values(7,'半导体厂','南京');
select *from J;

create table SPJ(
SNO int,
PNO int,
JNO int,
QTY int,
foreign key(SNO) references S(SNO) on delete cascade,
--foreign key(SNO) references S(SNO) on update no action,
foreign key(PNO) references P(PNO) on delete cascade,
--foreign key(PNO) references P(PNO)on update no action,
foreign key(JNO) references J(JNO) on delete cascade
--foreign key(JNO) references J(JNO)on update no action
);
select *from SPJ;
insert into SPJ values(1,1,1,200);
insert into SPJ values(1,1,3,100);
insert into SPJ values(1,1,4,700);
insert into SPJ values(1,2,2,100);
insert into SPJ values(2,3,1,400);
insert into SPJ values(2,3,2,200);
insert into SPJ values(2,3,4,500);
insert into SPJ values(2,3,5,400);
insert into SPJ values(2,5,1,400);
insert into SPJ values(2,5,2,100);
insert into SPJ values(3,1,1,200);
insert into SPJ values(3,3,1,200);
insert into SPJ values(4,5,1,100);
insert into SPJ values(4,6,3,300);
insert into SPJ values(4,6,4,200);
insert into SPJ values(5,2,4,100);
insert into SPJ values(5,3,1,200);
insert into SPJ values(5,6,2,200);
insert into SPJ values(5,6,4,500);

select *from S;
insert into S values(5,'丰泰盛',20,'天津');

select *from SPJ;--级联删除
delete from SPJ where sno=2;
select *from SPJ;
select *from S;
delete from S where sno=1;

