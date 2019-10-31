import pymysql
#打开数据库连接
db = pymysql.connect("localhost","root","19980120","studyPython") #使用connect方法时 可以设置参数charset=utf8避免插入中文出错
cursor = db.cursor()
data=[("python","python","100","2018-5-20"),
      ("php菜鸡","php","20","2019-8-10"),
    ("javase","java","199","2019-9-12")]
try:
    cursor.executemany("insert into books(name,category,price,publish_time) values(%s,%s,%s,%s)",data)
    print("1")
    db.commit()
except:
    print("2")
    db.rollback()

db.close()