def swap(number1,number2):
    number1,number2=number2,number1
    print("函数里面转化后的两个数是",number1,number2)

number1=19
number2=17
swap(number1,number2)
print("函数外面转化后的里的两个数是",number1,number2)#未发生变化


def swap(number):#包装成列表ok
    number[0],number[1]=number[1],number[0]#交换数字
    print("函数里面转化后的两个数是", number[0], number[1])

number=[19,17]
print(len(number))
swap(number)
print("函数外面转化后的两个数是", number[0], number[1])

#将数组进行交换
def swap(number0):
    for i in range(len(number0)//2):#/的结果是float类型的，
        number0[i],number0[len(number0)-1-i]=number0[len(number0)-1-i],number0[i]

number0=[1,2,3,4,5,6]
print(len(number0))
swap(number0)
for i in range(len(number0)):
    print(number0[i],end=' ')

print()#起换行作用
#用字典进行交换
def swap(number3):
    number3['a'],number3['b']=number3['b'],number3['a']

number3={'a':6,'b':9}
swap(number3)
print(number3['a'],number3['b'])

#本次练习还知道了swap函数值传递时根据参数的类型进行匹配的,如果传入的参数是列表,匹配列表的swap函数,如果传入的参数是字典，就字典的swap函数