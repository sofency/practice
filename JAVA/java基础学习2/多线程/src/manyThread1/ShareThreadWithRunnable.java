package manyThread1;

/**
 * 共享资源会发生并发问题 导致拿到的数据可能不准确
 * @author sofency
 *
 */
public class ShareThreadWithRunnable implements Runnable{

	private int ticketsNum=99;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			if(ticketsNum<0) {
				break;
			}else {
				System.out.println(Thread.currentThread().getName()+"----"+ticketsNum--);
			}
		}
	}
	public static void main(String[] args) {
		//创建对象
		ShareThreadWithRunnable  share=new ShareThreadWithRunnable();
		//创建线程 多个共享源
		new Thread(share, "test1").start();
		new Thread(share, "test2").start();
		new Thread(share, "test3").start();
	}
}
