import os
print(os.getcwd()) #获取当前路径
print(os.path.abspath("message.txt"))  #获取文件的绝对路径
#在join 函数中 如果拼接的路径中存在多个绝对路径吧那么从左到右最后出现的为准
print(os.path.exists("D:\Documents"))  ## 判断路径是否存在
#创建目录
# os.mkdir("D:\demo")  #在当前目录下创建目录  在d盘下创建一个demo文件夹
# 创建多级目录  os.makedirs(path)

# 删除目录
# os.rmdir(path)
# 遍历目录  os.walk()

tuples = os.walk("E:\python37\project")
for tuple in tuples: #递归输出每一级的目录
    print(tuple)