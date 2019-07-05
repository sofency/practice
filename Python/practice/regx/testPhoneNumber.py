import re
pattern=r'(13[4-9]\d{8})$|(15[01289]\d{8})$'# [4-9]\d表示4-9中的任意一个数字
mobile='13634891791'
match=re.match(pattern,mobile)
if match==None:
    print(mobile,"不是有效的中国移动手机。")
else:
    print(mobile,"是有效的中国移动手机")

mobile='13128918189'
match=re.match(pattern,mobile)
if match==None:
    print(mobile,"不是有效的中国移动手机")
else:
    print(mobile,"是有效的中国移动手机")
    