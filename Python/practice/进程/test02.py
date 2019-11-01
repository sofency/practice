#_*_ coding:utf-8 _*_
from multiprocessing import Process
import time
import os

def child_1(interval):
    print("子进程（%s）开始执行，父进程为（%s）"%(os.getpid(),os.getppid())) #getpid 是获取当前进程的进程号  getppid是获取父进程的进程号
    t_start = time.time() #计时开始
    time.sleep(interval) #程序会被挂起interval秒
    t_end = time.time() #计时结束
    print("子进程：（%s）执行时间是'%0.2f'秒"%(os.getpid(),(t_end-t_start)))


def child_2(interval):
    print("子进程（%s）开始执行，父进程为（%s）" % (os.getpid(), os.getppid()))  # getpid 是获取当前进程的进程号  getppid是获取父进程的进程号
    t_start = time.time()  # 计时开始
    time.sleep(interval)  # 程序会被挂起interval秒
    t_end = time.time()  # 计时结束
    print("子进程：（%s）执行时间是'%0.2f'秒" % (os.getpid(), (t_end - t_start)))

if __name__=="__main__":
    print("------父进程开始执行------");
    print("父进程pid是:%s" %  os.getpid())
    p1 = Process(target=child_1,name="sofency",args=(1,))
    p2 = Process(target=child_2,name="alice",args=(2,))
    p1.start()
    p2.start()

    #通知父进程依然往下移动
    print("p1 现在存活状态%s" % p1.is_alive())
    print("p2 现在存活状态%s" % p2.is_alive())

    print("p1的pid是:%s"%p1.pid)
    print("p1的name是:%s"%p1.name)

    print("p2的pid是:%s" % p2.pid)
    print("p2的name是:%s"%p2.name)

    p1.join()
    print("p1进程结束")
    p2.join()
    print("p2进程结束")
    print("父进程执行完毕")