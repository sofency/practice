import re
##隐藏手机号码
pattern=r'1[345678]\d{9}'
string='中奖号码为：84978981  联系电话为： 13462583774'
result=re.sub(pattern,'1**********',string)
print(result)

#隐藏危险词汇
pattern=r'(黑客)|(抓包)|(监听)|(Trojan)'
string='我是一名程序员，我喜欢看黑客方面的书籍,想研究下Trojan'
sub=re.sub(pattern,'@_@',string)
print(sub)

#使用正则表达式分割字符串
pattern=r'[?&]'##中括号表示里面取里面的一个元素
url='http://www.mingrisoft.com/login.jsp?username="mr"&pwd="mrsoft"'
result=re.split(pattern,url)
print(result)
for item in result:
    print(item)


#输出通讯录被@的好友

pattern=r'\s*@'
string='@明日科技  @扎克伯格  @比尔盖茨'
list=re.split(pattern,string)
print("你@的好友有：")
for item in list:
    print(item)