#集合的创建
coll ={"sofency"}

#向集合中添加元素  向集合中添加元素的时候集合不能是空的
coll.add("alice")
print(coll)
#元组列表转化为集合
tuple=("sophia","hello")
list=["sofency","alice","test"]
collect = set(tuple)#将元组转化为集合
print(collect)
collect1 = set(list)#将列表转化
print(collect1)

#删除元素
coll.remove("alice")
print(coll)

#或者使用pop删除顶部
collect1.pop()
print(collect1)

#使用clear进行删除整个集合
collect.clear()
print(collect)#返回的是set()集合

