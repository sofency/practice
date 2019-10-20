# class TVshow:
#     def __init__(self,show):
#         self.__show=show
#     @property    ##将方法转化为属性 ??
#     def show(self):
#         return self.__show;   ##返回私有属性的值??
#     #k可以理解为在show的属性
#
# tvshow=TVshow("正在播放《战狼2》")  ##创建类的实例
# print("默认：",tvshow.show)

# tvshow.show ="sasa" 无法设置属性
#设置setter
class Tvshow:
    list_film = ["战狼2","红海行动","女儿国"]
    def __init__(self,show):#构造函数
        self.__show = show
    @property
    def show(self):
        return self.__show
    @show.setter #设置让方法可修改
    def show(self,value):
        if value in Tvshow.list_film:
            self.__show = "你选择了《"+value+"》，稍后播放"
        else:
            self.__show ="暂时没有节目"

tv = Tvshow("战狼2")
print(tv.show)

#修改show  执行修改之后的方法
tv.show="女儿国"
print(tv.show)

