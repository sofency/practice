#回文字符串的比较
def huiwen_str(string):
    size=len(string)
    for i in range(size//2):
        if string[i]!=string[size-1-i]:
            return False
    return True
num=input("请输入要判断的字符串或者数字:"+"\n")#输入的数字会被转化为字符串
if huiwen_str(num):
    print("回文字符串")
else:
    print("不是回文字符串")