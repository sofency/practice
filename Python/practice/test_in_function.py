def get_math_function(type,nn):
    #定义一个计算平方的局部函数
    def square(n):
        return n*n
    #定义一个计算立方的局部函数
    def cube(n):
        return n*n*n
    #定义一个计算阶乘的局部函数
    def factorial(n):
        result=1
        for index in range(2,n+1):
            result*=index
        return result

    #调用函数
    if type=="square":
        return square(nn)
    elif type=="cube":
        return cube(nn)
    else:
        return factorial(nn)

print(get_math_function("square",3))
print(get_math_function("cube",3))
print(get_math_function("factorial",9))


def foo ():
    # 局部变量name
    name = 'Charlie'
    def bar ():
     nonlocal name#删除之后不能再使用foo函数里面的变量了
        #要想使用外层函数的变量使用 nonlocal 标记,
    print(name) # Charlie
    name = '孙悟空'

    bar()#执行局部函数
    print(name)#name已改变名字
#执行函数
foo()