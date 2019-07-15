package 并发;

/**
 * 线程安全的理解  数据有负数  数据出现相同
 * 锁的范围越大性能越差  锁的范围小  可能锁不住    因此锁住合理的范围（数据的完整性
 * ）
 * @author sofency
 *
 */
public class SynTest001 {
	public static void main(String[] args) {
		SynTestFirst web=new  SynTestFirst();
		
		Thread t=new Thread(web, "sofency");
		Thread t1=new Thread(web, "alice");
		Thread t2=new Thread(web, "hello");
			
		t.start();
		t1.start();
		t2.start();	
	}
}


class SynTestFirst implements Runnable{
	private int ticketsNum=10;
	private boolean flag=true; 
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//双重检测
		if(ticketsNum<=0) {
			flag=false;
			return;
		}
		synchronized (this) {
			test();
		}
	}
	
	
	public  void  test() {
		while (flag) {
			if(ticketsNum<=0) {
				flag=false;
				return;
			}
			//模拟延迟
			try {
				Thread.sleep(200);//在延迟的过程中资源也被其他的给复制了  所以导致不安全
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"--->"+ticketsNum--);			
		}
	}
	
}
