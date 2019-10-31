_width =100
_height =70
def change(w,h):
    global _width #全局变量（宽度）
    _width = w  #重新给宽度赋值
    global _height
    _height = h

def getWidth():
    global _width
    return _width

def getHeight():
    global _height
    return _height



