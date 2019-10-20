def my_max(x,y):#定义函数
    """
    获取两个数值之间较大的函数
    定义一个z,该变量等于x和y中较大的那个
    三目运算符的书写方法   a if a>b else b
    """
    z=x if x>y else y
    return z

def say_hi(name):#定义say_hi函数
    print("正在执行say_hi()函数")
    return name+",你好!"

a=6
b=9
result=my_max(a,b)
help(my_max)#和下面的一句都可以显示函数说明文档
print(my_max.__doc__)
print(result)
print(say_hi("孙悟空"))