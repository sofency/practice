
##查找字符串的位置 返回匹配对象
import re
pattern=r'mr_\w+'
string='MR_SHOP mr_shop'
match=re.search(pattern,string,re.I) ##查询第一次找到的结果
print(match)

match=re.search(pattern,string)
print(match)

