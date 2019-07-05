# zip函数可以将两个列表压缩成一个zip对象，这样就可以用一个循环并行遍历两个列表
a=['a','b','c']
b=[1,2,3]
c=[0.6,0.7]
var = [c for c in zip(a, b)]#c的作用就是用来遍历的索引
print(var)#将双列表打印出来

var1=[x for x in zip(a,c)]# 以下标最短的为基准
print(var1)

# 可以压缩多个列表 然后用一个循环进行输出
var2=[x for x in zip(a,b,c)]
print(var2)

#并行遍历的效果
books=["Python","JAVA","C#","JavaScript"]
prices=[88,99,11,22]
for books,prices in zip(books,prices):
    print("%s的价格是：%5.2f"%(books,prices))#5代表5位,包括小数点,2代表小数的个数 必须加%