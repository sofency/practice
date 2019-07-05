def avg_sum(list):#求列表中的平均值和总和
    sum=0
    count=0
    for e in list:
        sum=sum+e
        count+=1
    return sum/count,sum
num=[12,14,5,6,7,9,16]
avg,sum=avg_sum(num)
print(int(avg))
print(sum)

