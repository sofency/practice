package state;
/**
 * �����߳� yield
 * @author sofency
 *
 */
public class YieldThread {
	public static void main(String[] args) {	
		//��������
		myYield my=new myYield();
		//�������Դ
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
