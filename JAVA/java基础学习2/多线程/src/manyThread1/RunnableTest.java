package manyThread1;


/**
 * 1.实现Runnable接口  创建目标对象
 * 2. 创建线程对象 关联目标对象
 * 3.启动线程
 * @author sofency
 */
public class RunnableTest implements Runnable{

	public static void main(String[] args) {
//		1.创建目标对象
		RunnableTest  rTest=new RunnableTest();
//		2.创建线程  关联目标对象
		Thread t=new Thread(rTest);
//		3.执行线程
		t.start();
		
//		如果线程只使用一次的话可以使用匿名
//		new  Thread(new RunnableTest()).start();
		
		
		for (int i=0;i<20;i++) {
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
