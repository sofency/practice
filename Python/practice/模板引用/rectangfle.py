def girth(width,height):
    """计算周长
        参数  width宽度  height 高度
    """
    return (width+height)*2
def area(width,height):
    """
    :param width:宽度 
    :param height: 高度
    :return: 面积
    """
    return width*height

if __name__ == '__main__':
    print(area(10,6))
