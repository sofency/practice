#map函数的基本用法  map(function,item),item根据function进行调用函数
x=map(lambda x:x*x,range(1,9))#1-8调用lambda的匿名函数
for i in x:
    print(i,end=' ')
print()


y=map(lambda x,y:x+y,[1,2,3,4,5,6],[4,3,2,1,2,4])#参数可以是元素也可以是列表
for i in y:
    print(i,end=' ')
print()


y=map(lambda x:x*x if x%2==0 else x*x*x,range(1,7))
for i in y:
    print(i,end=' ')