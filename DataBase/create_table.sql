--select *from table_one;
create table S (
SNO int primary key,
SNAME char(6),
STATUS int,
CITY char(6)
);
select *from S;
insert into S values(1,'alice',20,'Ìì½ò');
insert into S values(2,'Ê¢Îý',20,'Î÷°²');
insert into S values(3,'¶«·½ºì',20,'ÉÏº£');
insert into S values(4,'ÎªÃñ',20,'ËÄ´¨');
select *from S;
update  S set SNAME='¾«Òæ' where sno=1;
update S set STATUS=17 where sno=2;
select *from S;

create table P (
PNO int primary key,
PNAME char(6),
COLOR char(2),
WEIGHT int
);
insert into P values(1,'ÂÝÄ¸','ºì',12);
insert into P values(2,'ÂÝË¨','ÂÌ',17);

insert into P values(3,'ÂÝË¿µ¶','À¶',14);
insert into P values(4,'ÂÝË¿µ¶','ºì',14);
insert into P values(5,'Í¹ÂÖ','À¶',40);
insert into P values(6,'³ÝÂÖ','ºì',30);
select *from P;

