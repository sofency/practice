#行定位符  是用来描述字符串的边界。^ 表示行的开始 $ 表示行的结尾

import re##导入正则表示式包
##使用match()方法进行匹配
pattern=r'mr_\w+'#表示匹配以mr_开头的字符串 \w表示匹配所有的数字或字符或下划线或汉字 + 表示前面的字符串出现一次或多次
string='MR_SHOP mr_shop'
match=re.match(pattern,string,re.I)  #re.I表示忽略字母的大小写
print(match)# 返回匹配的对象  匹配对象只是对于一个单词而言的
print('匹配的起始位置:',match.start())
print('匹配的结束位置:',match.end())
print('匹配位置的元组:',match.span())#即匹配的字符串在其中的下标位置集合
print('要匹配的字符串:',match.string)
print('匹配数据:',match.group())

string='项目名称 MR_SHOP mr_shop'
match=re.match(pattern,string,re.I)
print(match)#返回None 表示不是以mr_开头的



