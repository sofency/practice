#sort函数的用法listname.sort
#而sorted函数的用法是 sorted(listname)并且将排序好的列表赋值给其他的列表
num=[12,34,5,1,34,6,7,8]

number=sorted(num)
print(number)

num.sort()#排序之后原来数组会发生变化
print(num)

string=['Sofency','Alice','ahoj','Hello']
string.sort()
print(string)

string1=sorted(string)
print(string1)