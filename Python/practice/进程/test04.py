#使用进程池的方式创建进程
#_*_ encoding=utf-8 _*_
from multiprocessing import Pool
import os,time

def task(name):
    print("子进程（%s）执行task %s"%(os.getpid(),name))
    time.sleep(5)

if __name__=="__main__":
    print("父进程（%s）"%os.getpid())
    p= Pool(3)  #定义进程池
    for i in range(10):
        p.apply_async(task,args=(i,)) #apply是异步式的进行执行任务

    print("等待所有子进程结束")
    p.close() #关闭进程池  关闭后 p不再接收新的请求
    p.join()
    print("所有子进程执行完毕")
