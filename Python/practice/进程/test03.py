from multiprocessing import Process
import time
import os
#继承 Process类
class SubProcess(Process):   # 由于父进程也有__init__的方法   这个子类相当于重写
    def __init__(self,interval,name=""):
        Process.__init__(self)
        self.interval = interval
        if name:
            self.name = name
    def run(self):
        print("子进程（%s）开始执行，父进程为（%s）"%(os.getpid(),os.getppid()))
        t_start = time.time()
        time.sleep(self.interval)
        t_stop = time.time()
        print("子进程（%s）执行结束耗时（%.2f秒）"%(os.getpid(),t_stop-t_start))

if __name__ =="__main__":
    print("父进程开始执行")
    print("父进程的进程号是%s"%os.getpid())
    p1 = SubProcess(interval=1,name="sofency")
    p2 = SubProcess(interval=2,name="alice")
    p1.start()
    p2.start()
    print("p1.is_alive=%s"%p1.is_alive())
    print("p2.is_alive=%s"%p2.is_alive())

    print("p1.name=%s,p1.pid=%s"%(p1.name,p1.pid))
    print("p2.name=%s,p2.pid=%s"%(p2.name,p2.pid))

    print("等待子进程结束")
    p1.join()
    p2.join()
    print("父进程结束")
