class Bird:
    @classmethod  ##修饰的是类方法
    def fly(cls):
        print('类方法fly:',cls)

    #staticmethod 修饰的方法是静态方法
    @staticmethod
    def info(p):
        print('静态方法info:',p)

#调用类方法,bird类会自动绑定到第一个参数
Bird.fly()
#调用静态方法 不会自动绑定，因此程序必须手动绑定第一个参数
Bird.info('sofency')

##创建Bird对象
b=Bird()
b.fly()
b.info('alice')


