def division():
    """分苹果"""
    print("\n+++++++++++++++++分苹果了++++++++++++++++++++++++")
    apple = int(input("请输入苹果的个数"))
    child = int(input("请输入来的学生的个数"))
    if apple < child:
        raise ValueError("苹果太少了")#抛出异常
    result = apple//child
    remain = apple - result * child
    if(remain>0):
        print("还剩余"+str(result)+"个苹果")
    else:
        print("苹果正好分完")

if __name__ == "__main__":
    try:
        division()
    except ZeroDivisionError:
        print("\n苹果不能被0个小伙伴分配")
    except ValueError as e:
        print("\n出错了"+str(e))
