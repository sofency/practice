# ip地址解析
# http://m.ip138.com/ip.asp?ip=address
import requests
url = "http://m.ip138.com/ip.asp?ip="
try:
    r= requests.get(url+"10.147.194.226")
    r.raise_for_status
    r.encoding = r.apparent_encoding
    print(r.text[-1000:])
except:
    print("爬取失败")
