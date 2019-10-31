import pymysql
#打开数据库连接  参数1 主机名或者ip 用户名  参数3 密码  参数4  数据库名称
db = pymysql.connect("localhost","root","19980120","studyPython")

##使用cursor创建一个游标对象
cursor = db.cursor()
#使用SQL执行SQL 查询
cursor.execute("select version()")
#获取单个数据
data = cursor.fetchone()
print("DataBase version:%s"%data)
#数据库连接
db.close()