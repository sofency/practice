def fab(n):#斐波那契函数
    if n==1 or n==2:
        return 1
    else:
        return fab(n-2)+fab(n-1)
#定义第二个递归函数 f(n+2)=2*f(n+1)+f(n)
def fn(n):
    if n==0:
        return 1
    elif n==1:
        return 4
    else:
        return 2*fn(n-1)+fn(n-2)
#执行斐波那契函数
sum=fab(10)
print(sum)
#执行第二个函数
total=fn(10)
print(total)


