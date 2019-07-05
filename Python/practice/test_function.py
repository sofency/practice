#用函数作变量  就好比把使用函数的权利分配给别人
#定义乘方的函数
def pow(base,exponent):
    result=1
    for i in range(1,exponent+1):
        result*=base
    return result

my_result=pow#把使用pow的权利分配给my_result
print(my_result(2,5))

#定义一个求矩形面积的函数
def area(width,height):
    return width*height

my_area=area#将使用area的权利分配给my_area
print(my_area(10,12))

#使用函数作为函数形参
def map(data,fn):#data是列表,fn是函数
    result=[]
    for e in data:
        result.append(fn(e))#append是扩展列表的函数
    return result

def square(n):
    return n*n
def cube(n):
    return n*n*n
def factorial(n):
    result=1
    for index in range(2,n+1):
        result*=index
    return result

data=[3,4,9,5,8]

print(type(square))
print(type(cube))
print(type(factorial))

print("原数据：",data)
print("计算数组的平方:",map(data,square))
print("计算数组元素的立方:",map(data,cube))
print(data)
print("计算数组元素的阶乘:",map(data,factorial))

#使用函数做返回值
def get_math_func(type):
    def square(n):
        return n*n
    def cube(n):
        return n*n*n
    def factorial(n):
        result=1
        for index in range(2,n+1):
            result*=index
        return result
    if type=="square":
        return square#返回square函数
    elif type=="cube":
        return cube#返回cube函数
    else:
        return factorial#返回factorial

print("原数据",data)
my_func=get_math_func("square")
print(my_func(5))
my_func=get_math_func("cube")
print(my_func(5))
my_func=get_math_func("factorial")
print(my_func(5))