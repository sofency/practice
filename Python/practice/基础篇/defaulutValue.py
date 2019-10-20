#函数的参数可以直接写上默认值
def say_hi(name="孙悟空",message="欢迎来到C语言学习网"):
    print(name,",你好")
    print("消息是：",message)

# 定义一个打印三角形的函数，有默认值的参数必须放在后面
def printTriangle(char, height = 5) :
    for i in range(1, height + 1) :
        # 先打印一排空格
        for j in range(height - i) :
            print(' ', end = '')
        # 再打印一排特殊字符
        for j in range(2 * i - 1) :
            print(char, end = '')#将char字符传进去
        print()
printTriangle('@', 6)
printTriangle('#', height=7)
printTriangle(char = '*')
#python规定带默认值的参数放在后面
#全部使用默认值
say_hi()
#只有message使用默认值,同时也说明如果穿参进去的话,默认的值会被改变
say_hi("白骨精")
#两个都不使用默认值
say_hi("白骨精","欢迎来到博客王国")
#只有name使用默认值
say_hi(message="欢迎学习Python")