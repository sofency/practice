#测试数组
arr1=[[1,2,3,4],[1,2,3,4],[1,2,3,4],[1,2,3,4]]
arr2=[[1,2,3,4],[1,2,3,4],[1,2,3,4],[1,2,3,4]]
list=[[0 for col in range(4)]for i in range(4)]#创建二维数组
for i in range(4):
    for j in range(4):
        for k in range(4):
            list[i][j]+=arr1[i][k]*arr2[k][j]
for i in range(4):#输出结果
    print(list[i])
