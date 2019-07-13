package 并发;

/**
 * 线程不安全的理解  数据有负数  数据出现相同
 * @author sofency
 *
 */
public class UnsafeTest01 {
	public static void main(String[] args) {
		WebTicket web=new  WebTicket();
		
		Thread t=new Thread(web, "sofency");
		Thread t1=new Thread(web, "alice");
		Thread t2=new Thread(web, "hello");
			
		t.start();
		t1.start();
		t2.start();	
	}
}



class WebTicket implements Runnable{
	private int ticketsNum=10;
	private boolean flag=true; 
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (flag) {
			if(ticketsNum<0) {
				flag=false;
				break;
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
