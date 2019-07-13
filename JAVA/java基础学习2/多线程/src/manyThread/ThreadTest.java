package manyThread;
/**
 * 创建线程方式一   继承Thread 重写run
 * @author sofency
 *
 */
public class ThreadTest extends Thread {
	
	public static void main(String[] args) {
		
		//创建线程
		ThreadTest test=new ThreadTest();
		//启动线程  run方法只是简单的调用方法 不会创建线程
		test.start();  //在此处开辟一个线程  下面的程序继续执行
		
		for(int i=0;i<20;i++) {
			System.out.println("hello world");
		}
		
	}
	
	@Override
		public void run() {
			// TODO Auto-generated method stub
			for(int i=0;i<20;i++) {
				System.out.println("sofency");
			}
		}

}
