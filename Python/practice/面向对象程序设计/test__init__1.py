class Fruit:
    def __init__(self,color="绿色"):
        Fruit.color=color
    def harvest(self,color):
        print("水果是："+self.color+"的！")
        print("水果已经收获.....")
        print("水果原来是: "+Fruit.color+"的！")
class Apple(Fruit):
    color="红色"
    def __init__(self):
        print("我是水果")
        super().__init__() ##调用基类的__init__()方法

class Sapodilla(Fruit):
    def __init__(self,color):
        print("\n我是人身果")
        super().__init__(color)
     ##重写harvest()方法的代码
    def harvest(self,color):
        print("人身果是：" + color + "的！")
        print("人身果已经收获.....")
        print("人身果原来是: " + Fruit.color + "的！")


apple=Apple()
apple.harvest(apple.color)
sapodilla=Sapodilla("白色") ##创建 类的实例
sapodilla.harvest("金黄色带紫色条纹") ##调用harvest()方法
