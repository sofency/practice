#locals()返回局部范围内所有变量组成的的变量字典
#globals()返回全局范围内的所有变量组成的变量字典

def tst():#函数体
    age=20
    print(age)#打印局部变量

    print(locals())#打印当前局部变量中组成的变量字典

    print(locals()['age'])#打印字典索引age的年纪 20

    locals()['age']=12#修改局部变量
    print(locals()['age'])#20 未发生变化locals函数不会修改局部变量的值
    globals()['x']=40

x=3
y=4
print(globals())#打印全局变量

print(locals())#打印局部变量

print(globals()['x'])

tst()
print(x)#改成40了说明globals()指向了x的变量修改了x的值
