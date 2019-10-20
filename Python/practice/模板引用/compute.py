import rectangfle as r
import circular as c
import re
#from rectangle import *
# from circular import * 因为导入了相同的方法 编译器难以区别所以使用上述的导入方法
if __name__=="__main__":
    template ="原型的周长是：{:s}"
    print("原型的周长是"+str(c.grith(10)))
    print("原型的周长是%.2f"%c.grith(10))
    print(template.format(str(c.grith(10))))
    print("矩形的周长是",r.girth(10,20))