package ����;

/**
 * �̲߳���ȫ�����  �����и���  ���ݳ�����ͬ
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
		synchronized (this) {
			while (flag) {
				if(ticketsNum<0) {
					flag=false;
					break;
				}
				//ģ���ӳ�
				try {
					Thread.sleep(200);//���ӳٵĹ�������ԴҲ�������ĸ�������  ���Ե��²���ȫ
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"--->"+ticketsNum--);			
			}
		}
		
	}
	
}
