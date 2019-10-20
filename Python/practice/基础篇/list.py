##test 元组
tuple=(12,'sofency',20)
print(tuple)
##del tuple[1]不支持删除操作
##tuple.append('30')不支持增加操作
## 列表示元组的增强版  元组能进行的操作 列表都能进行 元组不支持对元素的修改 而列表支持  某种角度上来说 元组比列表安全性高
print(tuple)

##列表的创建 下面就是简单的列表
list=['sofency',10,20,'alice']
print(list)
##列表的加法
list1=[10,20,'ahoj']
list2=list+list1
print(list2)
##访问特定下标的元素
print(list[1])
print(list[2])
list.append('hello')
print(list)
#删除某个元素
del list2[1]
print(list2)
##in运算符来判断元素是否是列表内的内容
print(20 in list2)##True在
print(len(list2))
print(len(list))

##上面进行的操作可以看出 使用append进行增加元素会假如到一个整体中

 ##使用extend()方法进行多个元素添加

blist=['hanno','lie']
list.extend(blist)
print(list)

##使用insert方法进行插入
clist=list(range(1,6))
print(clist)

#在索引3处插入字符串
clist.insert(3,'sofency')
print(clist)


clist.insert(3,tuple("alice"))##向列表中插入元组
print(clist)




