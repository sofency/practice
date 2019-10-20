
num=10,20,30,40,50#序列封包
a,b,c,d,e=num#序列解包
print(a,b,c,d,e)

#可以用*代表一个序列用来存储数据
first,second,*last=range(10)#序列封包
print(first)
print(second)
print(last)