--创建数据库的表
create table trainItem(
  itemId int PRIMARY KEY,
  itemName VARCHAR(20) NOT NULL
);

--创建课程表
create table course1(
  courseId int PRIMARY KEY ,
  courseName VARCHAR(50) NOT NULL ,
  periodTime int,
  itemId int REFERENCES trainItem(itemId),
  detail VARCHAR(2000)
);

--插入测试数据  varChar数据不能使用双引号
insert into trainItem VALUES (1,'java开发');
insert into trainItem values(2,'Android开发');
insert into trainItem values(3,'前端开发');

insert  into course1 values(1,'javaSE',90,1,'学习java基础知识');
insert  into course1 values(2,'javaWeb',40,1,'学习javaWeb知识');
insert  into course1 values(3,'MySQL',20,1,'学习MySQL数据库知识');
insert  into course1 values(4,'Oracle',25,1,'学习Oracle数据库知识');
insert  into course1 values(5,'Spring',42,1,'学习Spring框架知识');

insert  into course1 values(6,'javaSE',90,2,'学习java基础知识');
insert  into course1 values(7,'Activity',20,2,'学习Activity知识');
insert  into course1 values(8,'ListView',30,2,'学习ListView组件知识');

insert  into course1 values(9,'PS',60,3,'学习PhotoShop知识');
insert  into course1 values(10,'JQuery',40,3,'学习jQuery知识');
insert  into course1 values(11,'AngularJS',30,3,'学习AngularJS框架知识');

select * from course1;