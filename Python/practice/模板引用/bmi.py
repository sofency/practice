def fun_bmi(person,height,weight):
    '''
    根据身高和体重计算bmi指数
    :param person:姓名 
    :param height: 身高
    :param weight: 体重
    :return: 
    '''
    print(person+"的身高是"+str(height)+"米,体重是"+str(weight)+"千克")
    bmi=weight/(height*height)
    print(person+"的bmi指数是"+str(bmi))
    ##判断身材是否合理
    if bmi<18.5:
        print("你的体重过轻")
    if bmi>=18.5 and bmi<24.9:
        print("正常范围,继续保持")
    if bmi>=24.9 and bmi<29.9:
        print("你的体重过重")
    if bmi>=29.9:
        print("肥胖")
if __name__ =='__main__':#每个模块的定义中都包括一个记录模块名称的变量__name__
    # 程序可以检查该变量已确定它在那个模块执行 没有这个函数则会在导入的过程中将该函数的print(fun_bmi())方法执行
     print(fun_bmi("sofnecy",1.85,81.2))