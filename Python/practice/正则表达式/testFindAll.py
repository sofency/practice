## findall方法用于在整个字符串中查找所有符号正则表达式的字符串，并以列表的形式返回
import re
pattern=r'mr_\w+'
string='MR_SHOP mr_shop'
match=re.findall(pattern,string,re.I)
print(match)  #以列表的形式展示出

match=re.findall(pattern,string)
print(match)

pattern=r'([0-9]{3})'
string='121 343 56'##找出3位的数字
match=re.findall(pattern,string,re.I)
print(match)

pattern=r'([0-9]{1,3})'##数字出现1次或3次
string='1 23 346'
match=re.findall(pattern,string)
print(match)


pattern=r'([1-9]{1,3}(\.[0-9]{1,3}){3})'
string='127.0.0.1 192.198.1.1'
match=re.findall(pattern,string)
print(match)
##将列表打印出
for items in match:
    print(items[0])