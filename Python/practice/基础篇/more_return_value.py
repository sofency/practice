def sum_avg(list):
    sum=0
    count=0
    for e in list:
        if isinstance(e,int) or isinstance(e,float):#用来判断是否属于后面类型的数据
            sum+=e
            count+=1
    return sum,sum/count
my_list=[12,3.9,67,23,56.3]
sum,avg=sum_avg(my_list)
print(sum)
print(avg)
'''
另一种写法
tp=sum_avg(my_list)
print(tp)
'''

