--and的查询级别高于or,小括号的级别是最高的
select *from emp where (job='SALESMAN' or job='MANAGER') and sal>2500;
--单行函数

--1.字符函数
----查询所有员工信息，员工姓名,工作小写显示lower(属性)
----首字母大写 INITCAP(属性)
----LTRIM(左裁剪)  ltrim('acbdcd',acb)  结果dcd
----replace('jack and jue','j','bl')在'jack and jue'中将j用bl代替

select ltrim('sofency','so') from dual;
select trim('sofency','of') from dual;
select empno,lower(ename),lower(job) from emp;
select empno,INITCAP(ename),lower(job) from emp;
---oracle函数：
--概念：是oracle用来处理并且进一步修饰字
---查询的表示伪表而不是真实存在的表

---数值函数建立的伪表
---dual是真是存在的表,是为了方便进行数据的验证而临时存在的表
--2.数值函数：
select abs(-1),ceil(2.2),floor(3.3),power(2,3),mod(5,2),round(100.256),trunc(2.332,1) from dual;
---3.日期函数：
select months_between('01-1月-2018','24-6月-2017') from dual;--判断该月份是否到达一年--查询两个日期相差了几个月
select add_months('01-2月-1998',11) from dual;--加月份  比如说三个月后的时间是多少
select next_day('17-4月-2019','星期二') from dual;--返回时间向下最近的星期二的日期
select last_day('06-4月-19') from dual;--返回该月的最后一天

select round(to_date('01-6月-03'),'YEAR') from dual;--按月的一半来四舍五入,01-7月-04
select round(to_date('15-7月-03'),'MONTH') from dual;--按日的一半来四舍五入,01-8月-03
select round(to_date('18-4月-19'),'DAY') from dual;--显示就近的周日





