str3="sofency.blog is at www.sofency.top"
myList=str3.split()#默认有空格的时候分隔字符串
myList1=str3.split('.')# 根据 . 进行分割
print(str3.split(None,2))#意思是根据空格进行分割，最多只能分前两个单词
print(str3.split(None,3))#意思是根据空格进行分割，最多只能分前三个单词
print('/'.join(myList1))
print(','.join(myList))

#encoding
verse ="野渡无人舟自横"
#将汉字转化为编码
byte = verse.encode("UTF-8")
print(byte)

#解码
printByte = byte.decode("UTF-8")
print(printByte)


#字符串的连接 str是函数名字一般不要用它来定义变量
str1 = "sofency"
num = 123
print(str1 + str(num))
#字符串长度
print(len(str1))
#截取字符串
# string[strat,end,step]
print(str1[:6])
#分割字符串
# str.split(sep,maxsplit) sep表示分割符  即包括所有空字符  \n 空格  制表符  \t

#count
print(str1.count('of'))#查询字符串的长度
print(str1.find("so"))#找字符串

#index
print(str1.index("cy"))#查询第一次出现cy的下标

#startwith endwith
print(str1.startswith("o"))#bool性
print(str1.endswith("y"))

#大小写转化
print(str1.upper())
print(str1.lower())

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