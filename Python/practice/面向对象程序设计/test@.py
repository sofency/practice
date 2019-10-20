##测试函数装饰器

##被修饰的函数总是被替换成 ＠ 符号所引用的函数的返回值，
# 因此被修饰的函数会变成什么，完全由于 ＠ 符号所引用的函数的返回值决定，
# 换句话说，如果 ＠ 符号所引用的函数的返回值是函数，
# 那么被修饰的函数在替换之后还是函数。
def funA(fn):
    print('A')
    fn()
    return 'fkit'

@funA
def funB():
    print('B')

print(funB)

def foo(fn):
    ##定义一个嵌套函数
    def bar(*args): #接受的参数是从fn(my_test中传入的)
        print("==1==",args)
        n=args[0]
        print("==2==",n*(n-1))

        #查看传给foo函数的fn函数
        print(fn.__name__)
        fn(n*(n-1))
        print("*" * 15)##打印15 个*
        return fn(n*(n-1))
    return bar

@foo
def my_test(a):
    print("==my_test函数==",a)

print(my_test)
my_test(10)
my_test(6,5)


def fun1(fn1):  #通过fun1对后续的功能进行添加
    def inner(args):
        print(args)
        fn1(args)
    return inner

@fun1
def fun2(num):
    print("-----18")

fun2(3)