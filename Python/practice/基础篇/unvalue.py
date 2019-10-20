# 定义了支持参数收集的函数
#不能使用test作为函数名
def tet(a, *books) :
    print(books)
    # books被当成元组处理
    for b in books :
        print(b)
    # 输出整数变量a的值
    print(a)
# 调用tet()函数
tet(5 , "C语言中文网" , "Python教程")
'''
将自己程序中def的函数名test()修改，pycharm中若检测到函数名是test则不会进入正常的运行模式
'''

#  **  两个星号表示可以接受关键字和值类型的参数  key-value
def get(x,y,z=3,*book,**scores): #一个*号表示你传入的是元组之类的  **表示传入的是字典
    print(x,y,z)
    print(book)
    score=scores#接收数据后存储到字典里面
    print(score)
get(1,2,3,"C语言学习网","Python 教程",语文=89,英语=98)