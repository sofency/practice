class TVshow:
    def __init__(self,show):
        self.__show=show
    @property    ##将方法转化为属性 ??
    def show(self):
        return self.__show;   ##返回私有属性的值??

tvshow=TVshow("正在播放《战狼2》")  ##创建类的实例
print("默认：",tvshow.show)