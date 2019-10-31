import pymysql
#打开数据库连接
db = pymysql.connect("localhost","root","19980120","studyPython")
#创建游标
cursor  = db.cursor()

#使用execute方法  如果表存在 则删除表
cursor.execute("drop table if EXISTS books")
sql ="""
create table books(
  id INT (8) not NULL  auto_increment,
  name VARCHAR (20)not NULL ,
  category varchar(20) not null,
  price DECIMAL(10,2) default NULL ,
  publish_time DATE  default null,
  primary key(id)
)engine=MyISAM auto_increment =1 default charset =UTF8MB4;
"""

##执行SQL语句
cursor.execute(sql)
db.close()