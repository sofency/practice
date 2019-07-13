package state;
/**
 * 礼让线程 yield
 * @author sofency
 *
 */
public class YieldThread {
	public static void main(String[] args) {	
		//创建对象
		myYield my=new myYield();
		//创建多个源
		new Thread(my,"sofency").start();
		new Thread(my,"alice").start();	
	}
}
class myYield implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName()+"-->start");
		Thread.yield();
		System.out.println(Thread.currentThread().getName()+"-->end");
	}
	
}
