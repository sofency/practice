from multiprocessing import Process  #不能写成小写的process
#导入进行的包
#z执行子进程代码
def child(interval):
    print("我是子进程",interval)

#执行主进程
def main():
    print("主进程开始执行")
    p = Process(target=child,args=(1,)) #参数说明target 是进程执行的目标代码, args 是进行需要的参数  name是当前进程的实例名
    p.start()
    print("主进程结束")

if __name__ == '__main__':
    main()

