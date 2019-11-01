from multiprocessing import Process,Queue
import time
##向消息队列写入数据
def write_task(q):
    if not q.full():
        for i in range(100):
            message ="消息"+str(i)
            q.put(message)
            print("写入消息：%s"%message)

#向消息队列读取数据
def read_task(q):
    time.sleep(2) #休眠一下 放置写操作读操作先执行时是空的
    while not q.empty():
        print("读取数据%s"%q.get())


if __name__=="__main__":
    print("父进程开启")
    q = Queue()
    pw = Process(target=write_task,args=(q,))
    pr = Process(target=read_task,args=(q,))

    pw.start()
    pr.start()
    pw.join()
    pr.join()
    print("---父进程结束---")