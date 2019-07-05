'''
将浮点数换成两个整数，小数点前面的和小数点后面的
'''
def divide(num):
    integer=int(num)
    fraction=round((num-integer)*100)#取浮点数
    return (str(integer),str(fraction))#返回两个参数
'''
用0-9的索引找到对应的汉字
'''

han_list=["零","壹","贰","叁","肆","伍","陆","柒","捌","玖"]
four_read=["十","百","千"]

#将四个数字转化为汉字读法
def four_to_hanstr(num_str):
    
    # 用来存储四位数的读数结果列表
    result=""
    cnt=0
    # 获取数字字符的长度
    num_len=len(num_str)
    # 遍历四位数
    for i in range(num_len):
        # 存储转化后的数字
        num=int(num_str[i])
        if i!=num_len-1 and num!=0:
            # 如果不是到达最后一位且不是零的话不读four_read
            result+=han_list[num]+four_read[num_len-2-i]

        elif i==num_len-1 and num!=0:
            result += han_list[num]
        elif i==num_len-1 and num==0:#如果最后一位为零则跳过
            pass
            # 将零连接起来
        else:#只允许0读一次
            if cnt>=1:
                continue
            else:
               result+=han_list[num]
               cnt=cnt+1
    return result

def integer_to_str(num_str):

    #读取数字的长度
    str_len=len(num_str)
    if str_len>12:
        print('数字太大，翻译不了')
        return
    
    elif str_len>8:
        return four_to_hanstr(num_str[:-8])+"亿"+\
               four_to_hanstr(num_str[-8:-4])+"万"+\
               four_to_hanstr(num_str[-4:])
    
    elif str_len>4:
        return four_to_hanstr(num_str[:-4])+"万"+four_to_hanstr(num_str[-4:])
    else:
        return four_to_hanstr(num_str)
        
num=float(input("请输入一个浮点数"))
integer,fraction=divide(num)
print(integer_to_str(integer))
print(fraction)

                                    
        
