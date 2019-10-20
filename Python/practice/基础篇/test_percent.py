#字符串的格式化输出
num = -28
print("num is : %6i"% num)#转化为带符号的十进制形式的整数
print("num is : %6d"% num)#转化为带符号的十进制形式的整数
print("num is : %6x"% num)#转化为带符号的十六进制的整数
print("num is : %6o"% num)#转化为带符号的八进制形式的整数
print("num is : %-2e"% num)#转化为科学计数法的浮点数
print("num is : %6s"% num)#转化为字符串
#默认情况下转换出来的字符串是右对齐的不够宽度时补充空格

num2=30
print("num2 is %6d"%num2)
print("num2 is %-6d"%num2)

print("num2 is %06d"%num2)#0表示补充0 不写默认用空格补充
print("num2 is %-6d"%num2)#左对齐