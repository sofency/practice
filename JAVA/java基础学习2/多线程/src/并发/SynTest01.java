package ����;

/**
 * �̰߳�ȫ�����  
 * @author sofency
 *
 */
public class SynTest01 {
	public static void main(String[] args) {
		SafeWebTicket web=new  SafeWebTicket();
		
		Thread t=new Thread(web, "sofency");
		Thread t1=new Thread(web, "alice");
		Thread t2=new Thread(web, "hello");
			
		t.start();
		t1.start();
		t2.start();	
	}
}



class SafeWebTicket implements Runnable{
	private int ticketsNum=10;
	private boolean flag=true; 
	@Override
	public  void run() {
		// TODO Auto-generated method stub
		while (flag) {
			//ģ���ӳ�
			try {
				Thread.sleep(200);//���ӳٵĹ�������ԴҲ�������ĸ�������  ���Ե��²���ȫ
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			test();			
		}
	}
	
	//��ʵ�ʵ�ȡƱ����
	public synchronized void  test() {
		if(ticketsNum<=0) {
			flag=false;
			return ;
		}
		
		try {
			Thread.sleep(200);//���ӳٵĹ�������ԴҲ�������ĸ�������  ���Ե��²���ȫ
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"--->"+ticketsNum--);
	}
	
}
