#多进程队列的使用
from multiprocessing import Queue

if  __name__ =="__main__":
    q =Queue(3)
    q.put("消息1")
    q.put("消息2")
    print(q.full())
    q.put("消息3")
    print(q.full())

    try:
        q.put("消息4",True,2) #等待两秒看是否可以将消息插进去 如果插不进去则抛出异常
        print("1")
    except:
        print("消息对列已满 现有消息数量%s"%q.qsize())

    try:
        print("2")
        q.put_nowait("消息4")
    except:
        print("消息嘟咧已满现有消息数量 %s"%q.qsize())


    #读取消息
    if not q.empty():
        print("从对列里面获取消息")
        for i in range(q.qsize()):
            print(q.get_nowait())

    # #先判断消息对列是否已满 再写入
    if not q.full():
        q.put_nowait("消息4")