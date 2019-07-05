str="sofency.blog is at www.sofency.top"
myList=str.split()#默认有空格的时候分隔字符串
myList1=str.split('.')# 根据 . 进行分割
print(str.split(None,2))#意思是根据空格进行分割，最多只能分前两个单词
print('/'.join(myList1))
print(','.join(myList))