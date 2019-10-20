import re
pattern=r'(黑客)|(抓包)|(监听)|(Trojan)'
about='我是一名程序员，我喜欢黑客方面的图书，向研究下Trojan。'
match=re.search(pattern,about)
if match==None:
    print(about,"@ 安全。")
else:
    print(about,"@ 出现危险词汇!")

about='我是一名程序员，我喜欢看计算机网络方面的图书，喜欢开发网站。'
match=re.search(pattern,about)
if match==None:
    print(about,"@ 安全。")
else:
    print(about,"@ 出现危险词汇!")