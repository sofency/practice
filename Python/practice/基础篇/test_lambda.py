#使用lambda表达式代替局部函数
def get_math_func(type):
    result=1
    if type=="square":
        return lambda n:n*n
    elif type=="cube":
        return lambda n:n*n*n
    else:
        return lambda n:(n+1)*n//2

data=[1,2,3,4,5]
my_function=get_math_func("square")#lambda 前面的参数传递给my_function 表达式赋值给my_function(参数)
for i in data:
    print(my_function(i),end=' ')
print()

my_function=get_math_func("cube")
for i in data:
    print(my_function(i),end=' ')
print()

my_function=get_math_func("other")
for i in data:
    print(my_function(i),end=' ')

#总结lambda实现的功能有限


