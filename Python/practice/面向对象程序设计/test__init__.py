##派生类中调用基类的__init__()方法
class Fruit:##基类
    def __init__(self,color="绿色"):
        Fruit.color=color
    def harvest(self):
        print("水果原来是："+Fruit.color+"的！")

class Apple(Fruit):  ##派生类
    def __init__(self):
        super().__init__(); ##在java中是省略的在python中不能省略
        print("我是苹果")

apple=Apple()
apple.harvest();#继承父亲的方法