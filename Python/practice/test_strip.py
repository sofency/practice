#test strip lstrip rstrip函数的用法  strip除去的意思
str="   Sofencys'blog   "
print(str.lstrip())#删除左边的字符串
print(str)#执行函数后年原来的字符串未发生变化
print(str.rstrip())#删除右空格
print(str.strip())#删除两边的字符串

str2="hello world,sofency"
print(str2.lstrip("hecy"))
print(str2.rstrip("hecy"))#删除的规则就是从右边起开始找与hecy一样的字符进行删除操作 直到不相同为止
print(str2.strip("hecy"))

'''
输出的结果
llo world,sofency
hello world,sofen
llo world,sofen
'''
