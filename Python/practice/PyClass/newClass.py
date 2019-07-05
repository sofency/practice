#python的类与对象与java的不同之处还是很多的
"""
1.对于对象的创建不需要用new
2.在类中的方法参数中必须要有self 参数用来绑定之后创建的对象
3.可以使用del 删除对象的实例变量
4.可以自由为对象添加实例变量
5.可以为对象动态添加方法 使用lambda表达式  注意动态增加方法不会讲调用者绑定到第一个参数,即不会将方法绑定到对象
需要用函数指向该方法  然后使用 对象.方法(对象),进行绑定
6.动态绑定2,,对象.方法=lambda self:表达式   然后使用 对象.方法(对象)进行绑定
7.动态绑定3. 导入MethodType   from types import MethodType   对象.方法=MethodType(函数名,对象)
"""
class Person:
    __face='cool'
    _hair='block'#类变量
    def __init__(self,name='sofency',age=18):  ##相当于JAVA的构造方法
        ##访问外部属性
        ##print(Person.__face) ##在实例方法内调用私有属性
        self.name=name
        self.age=age

    def say(self,content):
        print(content)

p=Person()#设置类实例化
print(p._Person__face)## 调用成功  访问私有属性的正确姿势
#print(p.__face)
##print(Person.__face)
##print(p.Person__face) ## 错误的写法
print(p.name,p.age)
print(p._hair)##单下划线是通过实例进行访问属性  如果在类内用 __进行修饰的变量的话 只能用过类名进行调用
p.name='Alice'#修改实例的变量

p.say('学习很容易，只要不放弃')#调用实例方法

print(p.name,p.age)

#为对象增加实例常量
p.subject='English'
p.score=100
print(p.subject,p.score)

#删除实例变量
del p.age

#动态添加方法
def info(self):
    print("init函数",self)
#动态绑定方法1
#p.foo是新定义的函数名
p.foo=info
p.foo(p)
#动态绑定方法2
# #通过lambda进行定义函数 lambda self :
p.bar=lambda self:print("hello world",self)#后面self打印位置说明
p.bar(p)

#使用MethodType方法进行绑定对象

def info_func(self,content):
    print("我的颜值信息是%s"% content)

from types import MethodType
p.intro=MethodType(info_func,p)
p.intro("帅")