class Fruit:
    color='绿色'
    def harves(self,color):
        print("水果是： "+color+"的！")
        print("水果已经收获。。。")
        print("水果原来是："+Fruit.color+"的"); #使用类的内部变量
class Apple(Fruit):
    color="红色"
    def __init__(self):
        print("我是苹果")

class Orange(Fruit):
    color = "橙色"
    def __init__(self):
        print("\n 我是橘子")

    def harves(self,color):  #类的重写
        print("橘子是："+color+"的！")
        print("橘子已经收获.....")
        print("橘子原来是："+Fruit.color+"的！") #输出的是类属性

apple=Apple()
apple.harves(apple.color)
orange=Orange()
orange.harves(orange.color)



