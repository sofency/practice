# 删除文件 操作
import os
# os.remove(path)  path值要删除的目录  一般删除前首先判断该文件是否存在 然后再进行删除操作

# 重命名文件和内容
# os.rename(src,dest)  src是指源文件的地址加名字    dest  是修改之后的名字

 # 获取文件的基本信息
 # os.stat(文件路径)
path = "os.py"
file = os.path.abspath(path)
print(file)
fileinfo = os.stat(path)
print("索引号",fileinfo.st_ino)
print("设备名",fileinfo.st_dev)
print("文件大小",fileinfo.st_size)
print("最后一次访问时间",fileinfo.st_atime)
print("最后一欧辰修改时间",fileinfo.st_mtime)

import time
print(time.localtime(fileinfo.st_atime))
def formatTime(longtime): #格式化时间
    return time.strftime('%Y-%m-%d %H:%M:%S',time.localtime(longtime))


def formatByte(number):
    for(scale,label) in[(1024*1024*1024,"GB"),(1024*1024,"MB"),(1024,"KB")]:
        if(number>=scale):  #处理大于1kb的
            return "%.2f %s" % (number*1.0/scale,label)
        elif number =='1':
            return "1字节"
        else:
            byte="%.2f" %(number or 0)

#去掉结尾的.00  并且加上字节
    return (byte[:-3] if byte.endswith('.00') else byte)  +" 字节"

print("索引号",fileinfo.st_ino)
print("设备名",fileinfo.st_dev)
print("文件大小",formatByte(fileinfo.st_size))
print("最后一次访问时间",formatTime(fileinfo.st_atime))
print("最后一欧辰修改时间",formatTime(fileinfo.st_mtime))

