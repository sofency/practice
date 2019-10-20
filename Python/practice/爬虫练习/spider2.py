import requests
url="https://www.amazon.com/dp/B07QZ4W4BM"
try:
    kv ={"user-agent":"Mozilla/5.0"}
    r = request.get(url,headers=kv)
    r.raise_for_status
    r.encoding = r.apparent_encoding
    print(r.text[:1000])
except:
    print("爬取失败")
    
