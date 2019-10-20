import  math
PI = math.pi
def grith(radius):
     """
     :param radius: 
     :return:周长 
     """
     return PI*2*radius

def area(radius):
    """
    :param radius: 
    :return: 面积 
    """
    return PI*radius*radius

if __name__=="__main__": #判断是否为当前项目执行
    print(grith(10))