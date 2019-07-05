#字典的用法
scores={'语文':89,'数学':100,'英语':88}
print(scores['语文'])
print(scores['英语'])
print(scores)#打印出字典

#向字典里面增加内容
scores['化学']=99
scores['物理']=100
print(scores)#打印添加后的字典

#删除字典中的一个元素连同成绩一起删除
del scores['数学']
print(scores)#打印删除后的成绩表

#修改字典中的value 可能原因是因为信息过时
scores['英语']=99
print(scores)#打印修改后的成绩表

#字典中的成绩表不知是否包含了所有的学科可以使用 in 或者not in 指令
print('英语'in scores) # 打印True 表示英语存在这个字典中

#字典变成废纸需要回收需要使用 clear指令
# scores.clear()  这里就不清除了，毕竟刚`买`的字典

#查字典除了用上面的方法还可以用get 函数
print(scores.get('英语'))# 99获得英语的成绩

#更新字典 下一版本 会出现很多新的学科，如果像上面的一样的话，更新速度太慢
scores.update({'政治':77,'大物':98,'JAVA':120})
print(scores)#更新后的字典

#items函数返回所有的key-value
item=scores.items()
print(list(item))
print(list(item)[1])#打印出('英语',99)

#keys()函数返回自字典key值
key=scores.keys()
print(list(key))
print(list(key)[1])

#value函数返回字典中索引的解释
value=scores.values()
print(list(value))
print(list(value)[1])

#pop函数类似于出栈将数据传送出去，顺便清楚在内存中占的位置 通过key显示values
print(scores.pop('英语'))
print(scores)#删除了字典中英语的成绩

#popitem()函数弹出底层存储的最后一个key-value对
print(scores.popitem())
print(scores)

#fromkeys()函数的使用  用于给多个key创建字典,这些key的默认值都是None,也可以额外传入一个参数作为默认值
cars=dict.fromkeys(['BWM','H'])#关键字用列表存储
print(cars)
food=dict.fromkeys(['vegetable','tomato','watermelen'],'fresh')#默认是新鲜的
print(food)

#setdefault 神奇的二用性，当关键字存在时返回value,不会改变之前的值，当关键字不存在时，会将默认的关键字复制给不存在的关键字
name_age={'sofency':18,'Alice':30,'robin':21}
print(name_age.setdefault('sofency',20))#用，隔开年龄未发生改变
print(name_age)
print(name_age.setdefault('hanno',18))
print(name_age)





