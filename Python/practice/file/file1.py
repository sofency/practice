# file =open("message.txt","w+")
# file.write("sofency+吴婷")
# file.flush()
# file = open("message.txt","r")
# String = file.readline() #在文件里面是二进制 但是读出来是汉字  readLines()  读取所有的行
# print(String)

# with open("message.txt","w+") as file:
#     file.write("1234567788")
#     file.close()

with open("message.txt","r") as file:
    file.seek(2);##一个汉字两个字节    所以读汉字的时候整数的进行读取
    str = file.read(4)
    print(str)
file = open("message.txt","r")
print(file.readline())