#行定位符  是用来描述字符串的边界。^ 表示行的开始 $ 表示行的结尾

# import re##导入正则表示式包
# pattern ="^tm"
# string = "tmsofency"
'''
常用元字符
\w  匹配字母或数字或下划线
\s 匹配任意的空白符
\d 匹配数字
\b 匹配单词的开始或结束
^  匹配字符串的开始
$  匹配字符串的结束


重复
? 匹配前面的字符0次或一次
+ 匹配前面的字符一次或多次
* 匹配前面的字符0次或多次
{n} 匹配前面的字符n次
{n,} 匹配前面的字符至少n次
{n,m} 匹配前面的字符至少n 次 最多m次

排除字符
[^a-zA-Z] 匹配一个不是字目的字符

选择字符
筛选身份证
(^\d{15})|(^\d{18})|(^\d{17})(\d|X|x)$
解释 筛选15位数字  或者18为数字的  或者 17位数字 并以一位数字或X或x结束的身份证号

分组
(thir|four)th  匹配thirth或者fourth
'''

#示例1 匹配mr_开头的字符串

import re
pattern = r'mr_\w+\s\w+' #匹配 以mr_开头之后若干个字符（字母数字下划线汉字） 然后空格  然后若干个字符
string = 'MR_SHOP mr_shop'
match = re.match(pattern,string,re.I) #re.I不区分大小写
print(match)

print("匹配值开始的位置",match.start())
print("匹配值结束的位置",match.end())
print("匹配位置的元组",match.span())
print("要匹配的字符串",match.string)
print("匹配到的数据",match.group())




