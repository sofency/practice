import datetime#导入日期时间类
mot=["坚持下去不是因为我坚强，而是因为我别无选择",
  "含泪播种的人一定含笑收获",
  "做对的事情比把事情做对重要",
  "命运给我们的不是失望之酒，而是希望之杯",
  "明日永远新鲜如初,纤尘不染",
  "求知若渴，虚心若愚",
  "成功永远属于那些从不说'不可能'的人"]
day=datetime.datetime.now().weekday()
print(mot[day])


##包装成函数
def function_tips():
    mot = ["坚持下去不是因为我坚强，而是因为我别无选择",
           "含泪播种的人一定含笑收获",
           "做对的事情比把事情做对重要",
           "命运给我们的不是失望之酒，而是希望之杯",
           "明日永远新鲜如初,纤尘不染",
           "求知若渴，虚心若愚",
           "成功永远属于那些从不说'不可能'的人"]
    day = datetime.datetime.now().weekday()
    print(mot[day])

function_tips()